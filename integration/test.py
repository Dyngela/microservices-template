import time
import datetime
import os

import requests


BASE_URL = "http://localhost:8080"
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

resp = requests.put(f"{BASE_URL}/api/v1/authentication/save", json=payload)
msg = "{}: /api/v1/authentication/save"
print(resp.content.decode("utf-8"))
