import time

import requests

# BASE_URL = os.getenv("API_URI")
# if not BASE_URL:
#     raise Exception("API_URI is not defined")

BASE_URL = "http://localhost:8080"
BASE_URL = "https://collecteverything.fr"

route = "/api/v1"
while 1:
    try:
        resp = requests.get(f"{BASE_URL}{route}")
    except requests.exceptions.ConnectionError:
        print("Connection refused")
        time.sleep(60)
    else:
        print("Gateway is accessible, proceeding")
        break

route = "/api/v1/store/all"
while 1:
    resp = requests.get(f"{BASE_URL}{route}")
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
    "role": "ADMIN",
}
route = "/api/v1/authentication/save"
for _ in range(500):
    resp = requests.put(f"{BASE_URL}{route}", json=payload)
    if resp.status_code == 200:
        raise Exception(f"{route=} finished early")


# customer id sync
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
# shop id sync
route = "/api/v1/authentication/save"
for _ in range(5):
    resp = requests.put(f"{BASE_URL}{route}", json=payload)
    if resp.status_code == 200:
        raise Exception(f"{route=} finished early")


### création compte
# create ADMIN user
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
route = "/api/v1/authentication/save"
resp = requests.put(f"{BASE_URL}{route}", json=payload)
assert resp.status_code == 200
print(resp)
headers = {"Authorization": resp.content.decode("utf-8")}


# create normal user
payload = {
    "email": "admeieene@gmail.com",
    "password": "aedmein",
    "firstName": "ademeeine",
    "lastName": "lasteeeNamee",
    "phoneNumber": "+33 7 70 17 98 11",
    "ethAddress": "0x000000",
    "storeId": 1,
    "role": "USER",
    "siret": "89e0987eee8e098790",
    "storeName": "aeeez",
    "sector": "updeate",
    "subscriptionId": 1,
}
route = "/api/v1/authentication/save"
resp = requests.put(f"{BASE_URL}{route}", json=payload)
print(resp)
assert resp.status_code == 200


# orders id sync 1000
route = "/api/v1/order/save/1/1"
payload = [
    {"price": 74, "productId": 1},
    {"price": 74, "productId": 1},
    {"price": 15, "productId": 2},
    {"price": 1500, "productId": 4},
    {"price": 455.32, "productId": 3},
]
for _ in range(1000):
    resp = requests.put(url=f"{BASE_URL}{route}", json=payload, headers=headers)
    if resp.status_code == 200:
        raise Exception(f"{route=} finished early")
