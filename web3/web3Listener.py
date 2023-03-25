from web3 import Web3
from web3.contract import ConciseContract
import json
import requests
import time

w3 = Web3(Web3.HTTPProvider('https://sepolia.infura.io/v3/b60d6525d6be46cca8f81116525ec963'))

with open('CollectEverythingABI.json', 'r') as abi_definition:
    abi = json.load(abi_definition)

contract_address = '0x4F0d7ADE7C2806DEAf1Dc7499c9EDbD2f558b282'
contract = w3.eth.contract(address=contract_address, abi=abi)

event_filter = contract.events.PaymentReceived.createFilter(fromBlock='latest')
API_ORDER_SAVE = "https://collecteverything.fr/api/v1/order/status"


while True:
    time.sleep(10)
    try:
        events = event_filter.get_new_entries()

        for event in events:
            print('PaymentReceived event received:')
            print(vars(event.args))
            payer = event.args.payer
            amount = event.args.amount
            orderId = event.args.orderId
            auth_token = event.args.token
            payload = {
                "orderId": orderId,
                "status": "payed",
                "orderPayed": True
            }
            headers = {
                "Authorization": f"Bearer {auth_token}",
                "Content-Type": "application/json"
            }

            requests.post(API_ORDER_SAVE, data=json.dumps(payload), headers=headers)

    except KeyboardInterrupt:
        break
