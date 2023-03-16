import subprocess
import os
import shutil
import threading
import queue
import time
import pathlib
import json
import sys
import signal


stage = os.getenv("STAGE")
if not stage or (stage != "prod" and stage != "staging" and stage != "dev"):
    raise Exception(f"Invalid stage: {stage}")

_timeout = os.getenv("TIMEOUT")
if not _timeout:
    timeout = 600
else:
    timeout = _timeout

docker = shutil.which("docker")
if not docker:
    raise Exception("docker binary not found")

path = pathlib.Path(__file__).parent.parent
if ".git" not in {p.name for p in path.iterdir()}:
    print([i for i in path.iterdir()])
    raise Exception(f"not a git repo {str(path)}")

events = subprocess.Popen(
    [docker, "compose", "--file", f"compose-{stage}.yaml", "events", "--json"],
    stdout=subprocess.PIPE,
    stderr=subprocess.PIPE,
    cwd=path,
    encoding="utf-8",
)


def status(events, mq: queue.Queue) -> None:
    while 1:
        if (msg := events.poll()) is not None:
            mq.put_nowait({"status": msg})
            raise SystemExit
        else:
            time.sleep(10)


def stdout(events, mq: queue.Queue) -> None:
    while 1:
        msg = events.stdout.readline()
        if msg == "":
            # probable process exit EOF
            ...
            # mq.put_nowait({"status": msg})
            # raise SystemExit
        try:
            mq.put_nowait({"event": json.loads(msg)})
        except json.decoder.JSONDecodeError:
            ...
            # raise Exception(msg)


def defer(timeout: int, mq: queue.Queue) -> None:
    time.sleep(timeout)
    mq.put_nowait({"timeout": timeout})
    raise SystemError


def sig_handler(mq: queue.Queue):
    def inner(signum, frame):
        return mq.put_nowait({"signal": signum})

    return inner


mq = queue.Queue()
threading.Thread(target=status, daemon=True, args=(events, mq)).start()
threading.Thread(target=stdout, daemon=True, args=(events, mq)).start()
threading.Thread(target=defer, daemon=True, args=(timeout, mq)).start()

signal.signal(signal.SIGINT, sig_handler(mq))
signal.signal(signal.SIGTERM, sig_handler(mq))


while 1:
    msg = mq.get()
    match msg:
        case {"signal": signum}:
            raise SystemExit(signum)

        case {"status": msg}:
            # process exited, probable failure
            raise Exception(f"{msg=}")

        case {"timeout": timeout}:
            subprocess.run(
                [docker, "compose", "--file", f"compose-{stage}.yaml", "ps"],
                cwd=path,
            )
            raise Exception(f"{timeout=}")

        case {
            "event": {
                "action": action,
                "attributes": attributes,
                "id": id,
                "service": service,
                "time": tm,
                "type": tp,
            }
        }:
            if service != "test-integration":
                continue
            if action == "die":
                rc = int(attributes.get("exitCode", 1))
                # subprocess.run(
                #     [docker, "compose", "--file", f"compose-{stage}.yaml", "down"],
                #     cwd=path,
                # )
                if rc == 0:
                    # integration test where successfull
                    sys.stdout.write("Integration tests where successfull\n")
                    raise SystemExit(0)
                else:
                    sys.stderr.write(json.dumps(msg) + "\n")
                    raise SystemExit(rc)
            elif action == "destroy":
                sys.stderr.write(json.dumps(msg) + "\n")
                raise SystemExit(0)
