# payment-service

### trabalho materia microservices FIAP

#### endpoints

#####POST - localhost:8080/payment

{
    "idTransaction": "aaaa-das23-343243-12345677",
    "cardExpirationDate": "2019-03-23",
    "cardNumber": 1232132145,
    "cardFlag": "VISA"
}



#####PUT - localhost:8080/payment/1

{
    "id": 1,
    "idTransaction": "aaaa-das23-343243-12345677",
    "cardExpirationDate": "2019-03-23",
    "cardNumber": 1232132145,
    "cardFlag": "VISA"
}

#####GET - localhost:8080/payment/1

#####DELETE - localhost:8080/payment/1