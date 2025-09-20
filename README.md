# Spring Boot Order Exception Handling POC

This is a Proof of Concept (POC) project demonstrating **clean exception handling** in a layered Spring Boot application.  
It shows how to **prevent raw database exceptions** from leaking to end users by properly handling exceptions across repository, service, and controller layers.

---

## Features
- Spring Boot 3+
- H2 in-memory database
- Repository → Service → Controller layered structure
- Global exception handler with `@RestControllerAdvice`
- Custom exceptions:
  - `OrderNotFoundException` → returns **404 Not Found**
  - `DatabaseException` → returns **500 Internal Server Error**
- Clean JSON error responses (no raw SQL errors)

---

## Getting Started

### Prerequisites
- Java 17+
- Maven or Gradle

### Steps
```bash
# clone the repo
git clone https://github.com/your-username/springboot-order-exception-poc.git

# move into project
cd springboot-order-exception-poc

# run with Maven
./mvnw spring-boot:run

#Testing the Endpoints

curl -X GET http://localhost:8080/orders/1

#Response
{
  "id": 1,
  "productName": "Laptop",
  "quantity": 2
}

#Get a non-existing order

curl -X GET http://localhost:8080/orders/999

#Response

{
  "error": "Order not found with id 999"
}


### Benefits


#1. User Experience

Without handling: User sees ugly SQL errors like
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "ORDERS" not found

With handling: User sees clean JSON:

{ "error": "Order not found with id 999" }


# 2. Security

Raw DB exceptions expose table names and SQL structure (bad for attackers).
Wrapping into custom exceptions prevents information leaks.

3. Consistency

All errors return in a single JSON format thanks to @RestControllerAdvice.





