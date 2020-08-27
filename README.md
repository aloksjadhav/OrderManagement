# OrderManagement
Spring boot project for order management

There are two microservices namely:
1. OrderService - For creating Order
2. OrderItemService - For creating Order Items

API details: 
 - OrderService - 

1. Retrieve Order
 - URL : http://localhost:8080/retrieveOrder/{id}
 - For eg : http://localhost:8080/retrieveOrder/100
 - HTTP Method : GET

2. Create order
 - URL : http://localhost:8080/createOrder
 - HTTP Method : POST
 - Request Payload example -
`{
    "customerName":"Rajiv",
    "shippingAddress":"Pune India",
    "total":"876",
    "orderItem": {
        "productCode":"PC",
        "productName":"Router",
        "quantity":3
    }
}`

API details:
OrderItemService -

1. Retrieve Order Item
 - URL : http://localhost:8089/orderItem/retrieveOrderItem/{orderItemId}
 - For eg : http://localhost:8089/orderItem/retrieveOrderItem/200
 - HTTP Method : GET

2. Create Order Item
 - URL : http://localhost:8089/orderItem/createOrderItem
 - HTTP Method : POST
 - Request Payload example -
`{
    "productCode":"FHD",
    "productName":"Floppy Drive",
    "quantity":"45"
}`


