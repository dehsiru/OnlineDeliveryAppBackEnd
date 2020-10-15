# OnlineDeliveryAppBackEnd

OnlineDeliveryAppBackEnd is a Java based API of an back-end order application, using an online API currency,
with Spring Boot and MongoDB.



## Installation

Create database with name "order" in MongoDB.
On your IDE navigate to Maven Project, and
import project from external model value.
Select JDK 8.
Build the project and run it.


## Usage

I used a Spring plugin(Swagger), that does automatically the documentation.
I strongly advise to check the interface of Swagger (http://localhost:8080/api/swagger-ui/), so you can fully understand how to send the HTTP requests to the server.


The API has a main menu with 4 categories: Appetizers, Salads, Main Dishes, Drinks, and every category has 4 products.
The menu is initialized when the server start.
The orders-entities are maped to DTOs and after that, via services classes, are stored to DB. 

The are 5 options:
                    
1.View the menu (EURO):                                                   localhost:8080/api/menu

2.View the menu to other currencies(CAD,HKD,PHP,USD):                     localhost:8080/api/menu/{currency}
         
         Create orders via Postman or Swagger interface.


3.Create an order:                                                        localhost:8080/api/orders

4.View all the orders (EURO):                                             localhost:8080/api/orders/admin

5.View all the orders to other currencies (CAD,HKD,PHP,USD):              localhost:8080/api/orders/admin/{currency}






