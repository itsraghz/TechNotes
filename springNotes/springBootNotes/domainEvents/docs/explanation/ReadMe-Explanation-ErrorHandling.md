# Error Handling in Domain Events Application

This document explains the error handling strategy implemented in our Domain Events application using Spring Boot's global exception handling capabilities.

## Components

### 1. ErrorResponse DTO

The `ErrorResponse` class provides a consistent error response format across the application:

```java
public class ErrorResponse {
    private LocalDateTime timestamp;  // When the error occurred
    private int status;              // HTTP status code
    private String error;            // Error type
    private String message;          // Error message
    private String path;             // Request path
    private List<ValidationError> validationErrors; // For validation failures
}
```

### 2. GlobalExceptionHandler

The `@RestControllerAdvice`-annotated class that provides centralized exception handling:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Exception handlers for different types of exceptions
}
```

## Exception Handling Strategy

### 1. Domain-Specific Exceptions

- `OrderNotFoundException`: Returns 404 NOT_FOUND
- Custom error message and logging

### 2. Validation Errors

Handles two types of validation errors:

1. `MethodArgumentNotValidException`:
   - Triggered by `@Valid` annotation violations
   - Returns 400 BAD_REQUEST
   - Includes field-level validation errors

2. `ConstraintViolationException`:
   - Triggered by Java Bean Validation constraints
   - Returns 400 BAD_REQUEST
   - Includes constraint violation details

### 3. Unexpected Errors

- Catches all unhandled exceptions
- Returns 500 INTERNAL_SERVER_ERROR
- Logs full stack trace
- Returns safe error message to client

## Error Response Format

Example validation error response:
```json
{
    "timestamp": "2024-02-22T10:15:30",
    "status": 400,
    "error": "Bad Request",
    "message": "Validation failed",
    "path": "/api/orders",
    "validationErrors": [
        {
            "field": "customerEmail",
            "message": "must be a valid email"
        }
    ]
}
```

## Best Practices

1. **Consistent Error Format**: All errors follow the same response structure
2. **Secure Error Messages**: Internal error details are logged but not exposed to clients
3. **Proper HTTP Status Codes**: Each error type maps to appropriate HTTP status
4. **Comprehensive Logging**: All errors are logged with appropriate detail level
5. **Validation Details**: Detailed feedback for validation errors without exposing internals

## Usage in Controllers

Controllers should use `@Valid` annotation for request validation:

```java
@PostMapping
public ResponseEntity<OrderResponse> createOrder(
    @Valid @RequestBody OrderRequest request) {
    // Method implementation
}
```

## Adding New Exception Handlers

To add handling for new exception types:

1. Create a new exception class if needed
2. Add a new handler method in GlobalExceptionHandler:

```java
@ExceptionHandler(NewCustomException.class)
public ResponseEntity<ErrorResponse> handleNewCustomException(
        NewCustomException ex, WebRequest request) {
    // Handler implementation
}
```

