# REST API for bank accounts
#### run docker-compose: docker-compose up -d


## GET http://localhost:8080/api/v1/wallets - get all wallets

## GET http://localhost:8080/api/v1/wallets/{WALLET_UUID} - check wallet balance

## POST http://localhost:8080/api/v1/addwallet - add wallet 

## PUT http://localhost:8080/api/v1/wallet - change account balance at JSON format

{
"uuid": "c302ea4b-5c88-413b-aa26-813baf374460",
"operationType": "DEPOSIT",
"amount": 3200
}