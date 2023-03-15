import time
import os

import requests


stage = os.getenv("STAGE")
if not stage:
    raise Exception("STAGE is not defined")

if stage == "prod":
    BASE_URL = "https://collecteverything.fr"
elif stage == "staging":
    BASE_URL = "http://gateway:8080"
elif stage == "dev":
    BASE_URL = "http://localhost:8080"
else:
    raise Exception(f"Invalid stage: {stage}")


SUCCESS = "\033[32;1;1mSUCCESS\033[0m"
FAILED = "\033[31;1;1mFAILED\033[0m"


def healthcheck(uri: str) -> bool:
    return requests.get(f"{BASE_URL}/api/v1/{uri}").status_code == 200


def login(email: str, password: str) -> str:
    # status: 200
    return requests.post(
        f"{BASE_URL}/api/v1/authentication/login",
        json={
            "email": email,
            "password": password,
        },
    ).content.decode("utf-8")


while 1:
    try:
        resp = requests.get(f"{BASE_URL}/api/v1")
    except requests.exceptions.ConnectionError:
        print("Connection refused")
        time.sleep(60)
    else:
        print("Gateway is accessible, proceeding")
        break

while 1:
    # resp = requests.get(f"{BASE_URL}/api/v1/authentication/login")
    resp = requests.get(f"{BASE_URL}/api/v1/store/all")
    if resp.status_code == 200:
        print("System is UP, executing tests")
        break
    else:
        print("System is NOT UP, sleeping...")
        time.sleep(60)


# healthcheck("store/all")
### création compte


payload = {
    "email": "azerty@gmail.com",
    "password": "passeeeword",
    "firstName": "ademeeine",
    "lastName": "lasteeeNamee",
    "phoneNumber": "+33 7 70 17 98 11",
    "ethAddress": "0x000000",
    "storeId": 1,
    "role": "ADMIN",
    "siret": "89e0987ee8e098790",
    "storeName": "aeeez",
    "sector": "updeate",
    "subscriptionId": 1,
}

resp = requests.put(f"{BASE_URL}/api/v1/authentication/save", json=payload)
msg = "{}: /api/v1/authentication/save"
assert resp.status_code == 200, print(
    msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
)
print(msg.format(SUCCESS))
#

### login
resp = requests.post(
    f"{BASE_URL}/api/v1/authentication/login",
    json={
        "email": "azerty@gmail.com",
        "password": "passeeeword",
    },
)
msg = "{}: /api/v1/authentication/login"
assert resp.status_code == 200, print(
    msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
)
print(msg.format(SUCCESS))
token = resp.content.decode("utf-8")

resp = requests.get(f"{BASE_URL}/api/v1/store/all", headers={"Authorization": token})
msg = "{}: /api/v1/store/all"
assert resp.status_code == 200, print(
    msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
)
print(msg.format(SUCCESS))

resp = requests.get(f"{BASE_URL}/api/v1/product/product/all/1")
assert resp.status_code == 200, print(
    msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
)
print(msg.format(SUCCESS))
