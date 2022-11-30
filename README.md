# E-Commerce-API

## Introduction
A REST-Full Web Services API's for an Online Shopping App based on Spring Boot. All functionalities of an online shopping app such as Login, Signup, Add product, Add to cart, remove from cart and Place order are provide which is fully connected with database.

## Details : 🔭
My project performs fundamental operations of an e-commerce website, where our customer's data is validated, mapped, processed with business logic & persisted in the database.

## ER Diagram
![Online Food Order App](https://user-images.githubusercontent.com/76105799/204780173-c8ff9d18-53e5-4f13-b58f-53fd9e1e3ddf.png)

## Used Tech Stack & Tools:

- Java
- Spring
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- MySQL
- Postman
- Swagger UI

[![](https://skillicons.dev/icons?i=java,spring,hibernate,mysql,git,github)]()

## Modules
1. Login Module
2. Customer Module
3. Order Module
4. Bill Module
5. Product Module
6. Cart Module

## Installation & Run

1. clone our Project into your local machine.
      - open any terminal
      - git clone `https://github.com/sanajitjana/E-Commerce-API.git`
2. Open Your STS
3. Goto File -> Import -> Select Maven -> Choose Existing Maven -> Click on browse -> Choose the project location -> Select the project -> Finish
4. All done, good to go!

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/sanajitjana/E-Commerce-API/blob/master/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.
* Run your application and hit this url on browser - `http://localhost:8888/swagger-ui/`

```
    #db specific properties
    server.port=8888
    
    spring.datasource.url=jdbc:mysql://localhost:3306/online_shopping_db;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username="Your SQL username"
    spring.datasource.password="Your SQL Password"
    
    #ORM s/w specific properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    
    #validation exception activate
    spring.mvc.throw-exception-if-no-handler-found=true
    spring.web.resources.add-mappings=false
    
    #enable swagger
    spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```
