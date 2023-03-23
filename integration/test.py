import requests


BASE_URL = "https://collecteverything.fr"


route = "/api/v1/order/save/1/3"
payload = [{"price": 15, "productId": 2}]
headers = {
    "Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhQGEuZnIiLCJyb2xlcyI6WyJVU0VSIl0sImV4cCI6NzY3OTUyMzc2NCwic3RvcmVJZCI6MX0.DpHIZt71SgnHACeig21E8Tfg3c5tts6ysEzs-cDOIAA"
}
resp = requests.put(f"{BASE_URL}{route}", json=payload)
print(resp)
print(resp.content)
