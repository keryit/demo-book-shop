# Demo-book-shop app
___
## Description
Spring Boot web application
___
## Functions
- register new user 
- login as a registered user
- For testing you can use created using liquibase users
  -  ROLE_USER: bob@in.ua /pass: 1234
  -  ROLE_ADMIN: admin@in.ua /pass: 1234
#### Registered as USER role:
- find all books
- find book by Id
- search with parameter (title, author, isbn, price, description)

#### Registered as ADMIN role:
- create and find books
- update book
- find users
- create new role
___
## Project structure
- src/main/java/cinema/spring - Contains the Java source code for the project, organized according to a layered architecture.
    - ***config*** - classes for configuration of application operation
    - ***controller*** - Contains the controllers that handle incoming HTTP requests and delegate to the appropriate service layer.
    - ***repository*** - Contains the data access objects that handle interactions with the database.
    - ***dto*** - Data Transfer Objects are representing communication objects for customer requests and responses.
    - ***exception*** - custom exception.
    - ***validation*** - contains custom annotations and logic for email and password validation.
    - ***model*** - Contains the domain model objects representing the entities in the system.
    - ***service*** - Contains the business logic and serves as an intermediary between the controller and dao layers.
    - ***util*** - utility class used to determine Jwt.
    - ***src/main/resources*** - Contains the application configuration files.
    - ***pom.xml*** - The Maven project configuration file.
___
## Technologies
- JDK 17
- Maven
- H2 database for testing
- SpringBoot 3.1.2
- Hibernate-validator
- jsonwebtoken
- Lombok
- mapstruct
- liquibase
___
## How to run
1. Ensure that you have JDK, Maven installed on your system.
2. Clone the project from GitHub
3. Run the Maven command mvn clean package to make sure everything is fine.
4. Run application from IDEA
5. Access the api at localhost:8080 from Postman.
  - Register new user
    - POST: localhost:8080/api/auth/register
   ```
    {
     "email":"john@in.ua",
     "password":"123456",
     "repeatPassword":"123456",
     "firstName":"john"
     }
   ```
  - Login 
    - POST: localhost:8080/api/auth/login
    ```
    {
    "email":"admin@in.ua",
    "password":"1234"
     } 
    ```
  - Create a new book as admin
     - POST: localhost:8080/api/books
     ```
    {
    "title":"new_book",
    "author": "Author",
    "isbn":"1111_1",
    "price": 25.99,
    "description":"good book"
    }
    ```
  - Update a book by id as admin
    - PUT: localhost:8080/api/books/2
     ```
    {
    "title":"upd_book",
    "author": "upd Author",
    "isbn":"1111_1",
    "price": 25.99,
    "description":"good book"
    }
    ```
- Delete a book by id as admin
    - DELETE: localhost:8080/api/books/2  
  
- Get all books for authenticated users
    - GET: localhost:8080/api/books
- Get a book by Id for authenticated users
    - GET: localhost:8080/api/books/1

6. You can use password and login with tests users:
  - ROLE_USER: bob@in.ua /pass: 1234
  -  ROLE_ADMIN: admin@in.ua /pass: 1234
