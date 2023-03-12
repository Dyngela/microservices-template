import time
import datetime

import requests

BASE_URL = "https://collecteverything.fr"
# BASE_URL = "http://localhost"


def healthcheck(uri: str) -> bool:
    return requests.get(f"{BASE_URL}/api/v1/{uri}").status_code == 200


def login(email: str, password: str) -> str:
    return requests.post(
        f"{BASE_URL}/api/v1/authentication/login",
        json={
            "email": email,
            "password": password,
        },
    ).content.decode("utf-8")


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
print(resp)
print(resp.content)


### connexion

token = login(email="azerty@gmail.com", password="passeeeword")

# token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhemVydHlAZ21haWwuY29tIiwicm9sZXMiOlsiQURNSU4iXSwiZXhwIjo3Njc4NTcxMTM0LCJzdG9yZUlkIjoxfQ.FL4Ib5RY4aukMIri_SCE_DI3ImHGeLDQTXf-bx69UJk"
headers = {"Authorization": token}
resp = requests.get(f"{BASE_URL}/api/v1/store/all", headers=headers)
print(resp)
print(resp.content)

resp = requests.get(f"{BASE_URL}/api/v1/product/product/all/1")
print(resp)
print(resp.content)
