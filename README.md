# Spring Boot Order Exception Handling POC

This is a Proof of Concept (POC) project demonstrating **clean exception handling** in a layered Spring Boot application.  
It shows how to **prevent raw database exceptions** from leaking to end users by properly handling exceptions across repository, service, and controller layers.

---

## ⚙️ Features
- Spring Boot 3+
- H2 in-memory database
- Repository → Service → Controller layered structure
- Global exception handler with `@RestControllerAdvice`
- Custom exceptions:
  - `OrderNotFoundException` → returns **404 Not Found**
  - `DatabaseException` → returns **500 Internal Server Error**
- Clean JSON error responses (no raw SQL errors)

---

## 📂 Project Structure
order-poc/
┣ src/main/java/com/example/orderpoc/
┃ ┣ controller/OrderController.java
┃ ┣ exception/DatabaseException.java
┃ ┣ exception/OrderNotFoundException.java
┃ ┣ exception/GlobalExceptionHandler.java
┃ ┣ model/Order.java
┃ ┣ repository/OrderRepository.java
┃ ┣ service/OrderService.java
┃ ┗ OrderPocApplication.java
┗ src/main/resources/
┣ application.properties
┗ data.sql