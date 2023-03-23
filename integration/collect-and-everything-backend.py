import pytest
import requests


params = [
    pytest.param(, , , , id=""),
]


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

@pytest.mark.parametrize(
    ("route", "payload", "headers", "expected"),
    (
        (2021, 12, 31, 5),
        (1986, 3, 6, 4),
        (2024, 12, 31, 2),
        (2024, 7, 25, 4),
        (2024, 1, 1, 1),
        (2024, 2, 29, 4),
    ),
)
def test_day_of_week(year, month, day, expected):
    assert DateTime.day_of_week(year, month, day) == expected
    dt = DateTime.extrapolate(year, month, day, 0, 0, 0)
    assert dt._day_of_week() == expected


resp = requests.put(f"{BASE_URL}/api/v1/authentication/save", json=payload)
msg = "{}: /api/v1/authentication/save"
assert resp.status_code == 200, msg.format(FAILED) + "\n" + resp.content.decode("utf-8")
print(msg.format(SUCCESS))
