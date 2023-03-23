import time
import os

import requests

# BASE_URL = os.getenv("API_URI")
# if not BASE_URL:
#     raise Exception("API_URI is not defined")

BASE_URL = "http://localhost:8080"

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
    resp = requests.get(f"{BASE_URL}/api/v1/store/all")
    if resp.status_code == 200:
        print("System is UP, executing tests")
        break
    else:
        print("System is NOT UP, sleeping...")
        time.sleep(60)


# store id sync
payload = {
    "ethAddress": "0xbe16bea087fe2eefe59b41d0dc5d87dacaf3d19a",
    "email": "aaa@aaa.aaa",
    "firstName": "aaaaa",
    "lastName": "aaaaa",
    "password": "1234",
    "phoneNumber": "1234",
    "role": "OWNER",
    "sector": "charcutaille",
    "siret": "1234123412341234",
    "storeName": "AaA",
}
route = "/api/v1/authentication/save"
for _ in range(5):
    resp = requests.put(f"{BASE_URL}{route}", json=payload)
    if resp.status_code == 200:
        break

# resp = requests.put(f"{BASE_URL}{route}", json=payload)
# print(resp)
# print(resp.content)

# customer id sync
# todo

# orders id sync
# 1096
