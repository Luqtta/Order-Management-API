# Order Management API

Simple fictional backend project built with **Java + Quarkus** to simulate a real-world order management system.

This project was created as a portfolio piece focused on backend development concepts commonly used in companies such as banks, fintechs, e-commerce and delivery platforms.

---

## Tech Stack

* Java 21
* Quarkus
* REST API (Jakarta REST)
* Hibernate ORM with Panache
* H2 Database (in-memory)
* Bean Validation
* Swagger / OpenAPI
* Maven

---

## Features

* Create orders with multiple items
* Automatic total calculation
* Order status with enum
* Get order by ID
* List orders with pagination
* Custom 404 error handling
* Input validation

---

## Project Structure

```
src/main/java/com/luqtta/
├── controller
├── domain
├── dto
├── entity
├── exception
└── service
```

---

## Running the Project

### 1. Clone the repository

```
git clone <your-repository-url>
cd order-management-api
```

### 2. Run in dev mode

Linux / Mac:

```
./mvnw quarkus:dev
```

Windows:

```
mvnw.cmd quarkus:dev
```

### 3. Open Swagger UI

```
http://localhost:8080/q/swagger-ui
```

---

## Database

Uses **H2 in-memory database** for development.

Important:

* Data is lost when the application restarts
* Schema is recreated automatically on startup

---

## API Endpoints

### Create Order

POST `/orders`

Example request body:

```
{
  "customerName": "Lucas Morais",
  "customerEmail": "lucas@email.com",
  "items": [
    {
      "productName": "Mouse Gamer",
      "quantity": 2,
      "unitPrice": 150.00
    },
    {
      "productName": "Teclado Mecânico",
      "quantity": 1,
      "unitPrice": 320.00
    }
  ]
}
```

Response: `201 Created`

---

### Get Order By ID

GET `/orders/{id}`

Example:

```
GET /orders/1
```

Responses:

* 200 OK
* 404 Not Found

---

### List Orders (Paginated)

GET `/orders?page=0&size=10`

Example:

```
GET /orders?page=0&size=5
```

Response: `200 OK`

---

## Error Response Example

```
{
  "error": "Not Found",
  "message": "Order with id 111 not found",
  "timestamp": "2026-03-19T02:49:24.352075",
  "status": 404
}
```

---

## What This Project Demonstrates

* REST API design
* Domain modeling
* One-to-many relationship mapping
* Transaction handling
* Input validation
* Exception mapping
* Pagination with Panache
* JSON serialization control

---

## Possible Future Improvements

* Update order status endpoint
* Cancel order endpoint
* Payment simulation
* Response DTOs
* PostgreSQL integration
* Docker support
* Automated tests
* Authentication / authorization

---

## Author

Lucas Morais Souza
