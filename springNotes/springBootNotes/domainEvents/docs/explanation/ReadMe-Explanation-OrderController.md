# Order Controller Documentation

This document explains the Order Controller implementation, which provides REST endpoints for managing orders in the system.

## Overview

The `OrderController` class implements a RESTful API for order management, following best practices for API design, validation, documentation, and error handling.

## Features

1. **CRUD Operations**
   - Create new orders
   - Retrieve orders (single or all)
   - Update order status
   - Delete orders

2. **API Documentation**
   - Swagger/OpenAPI annotations for clear API documentation
   - Detailed operation descriptions
   - Parameter documentation
   - Response codes documentation

3. **Validation**
   - Input validation using `@Valid`
   - Request parameter validation
   - Custom error handling

## Endpoints

### 1. Create Order
```http
POST /api/v1/orders
```
- Creates a new order in the system
- Publishes `OrderCreatedEvent`
- Returns HTTP 201 on success

### 2. Get Order by ID
```http
GET /api/v1/orders/{orderId}
```
- Retrieves a specific order by its UUID
- Returns HTTP 404 if order not found

### 3. Get All Orders
```http
GET /api/v1/orders?status={status}
```
- Retrieves all orders
- Optional status filter
- Returns empty list if no orders found

### 4. Update Order Status
```http
PATCH /api/v1/orders/{orderId}/status?status={newStatus}
```
- Updates order status
- Publishes `OrderStatusChangedEvent`
- Validates status transitions
- Returns HTTP 400 for invalid transitions

### 5. Delete Order
```http
DELETE /api/v1/orders/{orderId}
```
- Deletes an order
- Publishes `OrderDeletedEvent`
- Returns HTTP 204 on success

## Error Handling

The controller implements global exception handling for common scenarios:

1. `OrderNotFoundException`
   - HTTP 404 Not Found
   - Occurs when requested order doesn't exist

2. `IllegalStateException`
   - HTTP 400 Bad Request
   - Occurs for invalid status transitions or business rule violations

## Best Practices Implemented

1. **API Versioning**
   - URL versioning (`/api/v1/`)
   - Allows for future API evolution

2. **RESTful Design**
   - Proper HTTP method usage
   - Consistent URL patterns
   - Appropriate status codes

3. **Documentation**
   - OpenAPI annotations
   - Clear operation descriptions
   - Parameter documentation

4. **Security Considerations**
   - Input validation
   - Error message handling
   - Rate limiting ready

## Integration Points

The controller integrates with:
- `OrderService` for business logic
- Event publishing system
- Global validation framework
- API documentation system

## Usage Example

### Creating an Order
```java
POST /api/v1/orders
Content-Type: application/json

{
  "customerEmail": "customer@example.com",
  "items": [
    {
      "productId": "123e4567-e89b-12d3-a456-426614174000",
      "quantity": 2,
      "price": 29.99
    }
  ]
}
```

### Response
```json
{
  "orderId": "123e4567-e89b-12d3-a456-426614174111",
  "status": "CREATED",
  "customerEmail": "customer@example.com",
  "items": [...],
  "totalAmount": 59.98,
  "createdAt": "2024-02-22T10:30:00Z"
}
```

## Dependencies
- Spring Web
- Spring Validation
- Swagger/OpenAPI
- Lombok
- Jakarta Validation API

