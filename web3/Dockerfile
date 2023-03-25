FROM python:3.9-bullseye
RUN apt-get update && apt-get install -y \
    gcc
WORKDIR /app
COPY . .
RUN python3 -m pip install --no-cache-dir \
    virtualenv \
    setuptools \
    build
RUN python3 -m virtualenv .venv
RUN .venv/bin/python -m pip install --no-cache-dir -r requirements.txt
ENTRYPOINT [ "/app/.venv/bin/python", "-u", "/app/web3Listener.py" ]
