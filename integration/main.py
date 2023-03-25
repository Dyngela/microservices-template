import time
import os

import requests


BASE_URL = os.getenv("API_URI")
if not BASE_URL:
    raise Exception("API_URI is not defined")


SUCCESS = "\033[32;1;1mSUCCESS\033[0m"
FAILED = "\033[31;1;1mFAILED\033[0m"


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


# healthcheck("store/all")
### création compte
# create ADMIN user
# payload = {
#    "email": "azerty@gmail.com",
#    "password": "passeeeword",
#    "firstName": "ademeeine",
#    "lastName": "lasteeeNamee",
#    "phoneNumber": "+33 7 70 17 98 11",
#    "ethAddress": "0x000000",
#    "storeId": 1,
#    "role": "ADMIN",
#    "siret": "89e0987ee8e098790",
#    "storeName": "aeeez",
#    "sector": "updeate",
#    "subscriptionId": 1,
# }

# resp = requests.put(f"{BASE_URL}/api/v1/authentication/save", json=payload)
# msg = "{}: /api/v1/authentication/save"
# assert resp.status_code == 200, msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
# print(msg.format(SUCCESS))
##

# payload = {
#    "email": "admeieene@gmail.com",
#    "password": "aedmein",
#    "firstName": "ademeeine",
#    "lastName": "lasteeeNamee",
#    "phoneNumber": "+33 7 70 17 98 11",
#    "ethAddress": "0x000000",
#    "storeId": 1,
#    "role": "USER",
#    "siret": "89e0987eee8e098790",
#    "storeName": "aeeez",
#    "sector": "updeate",
#    "subscriptionId": 1,
# }
# route = "/api/v1/authentication/save"
# resp = requests.put(f"{BASE_URL}{route}", json=payload)
# msg = "{}: {}"
# assert resp.status_code == 200, (
#    msg.format(FAILED, route) + "\n" + resp.content.decode("utf-8")
# )
# print(msg.format(SUCCESS, route))


#### login
# resp = requests.post(
#    f"{BASE_URL}/api/v1/authentication/login",
#    json={
#        "email": "azerty@gmail.com",
#        "password": "passeeeword",
#    },
# )
# msg = "{}: /api/v1/authentication/login"
# assert resp.status_code == 200, msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
# print(msg.format(SUCCESS))
# token = resp.content.decode("utf-8")


## list all stores
# resp = requests.get(f"{BASE_URL}/api/v1/store/all", headers={"Authorization": token})
# msg = "{}: /api/v1/store/all"
# assert resp.status_code == 200, msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
# print(msg.format(SUCCESS))


## list all products from store 1
# resp = requests.get(f"{BASE_URL}/api/v1/product/product/all/1")
# assert resp.status_code == 200, msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
# print(msg.format(SUCCESS))
