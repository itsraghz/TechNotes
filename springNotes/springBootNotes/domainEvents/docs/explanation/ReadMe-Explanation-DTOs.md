# Data Transfer Objects (DTOs) Documentation

## Overview
This document explains the DTO (Data Transfer Object) design and implementation in our order management system. DTOs are used to transfer data between processes, particularly in API requests and responses.

## DTO Classes

### OrderRequest
- **Purpose**: Handles incoming order creation and update requests
- **Key Features**:
  - Email validation for customer
  - Validation for non-empty order items
  - Optional notes field
  - Custom validation for order total

### OrderResponse
- **Purpose**: Returns order information in API responses
- **Key Features**:
  - Complete order details including status
  - Calculated total amount
  - Timestamps for creation and modification
  - Static factory method for entity conversion

### OrderItemRequest
- **Purpose**: Handles item details in order requests
- **Key Features**:
  - Product identification
  - Price and quantity validation
  - Optional notes for each item

### OrderItemResponse
- **Purpose**: Returns item details in API responses
- **Key Features**:
  - Complete item information
  - Calculated subtotal
  - Static factory method for entity conversion

## Validation Rules

### Order Level
- Customer email must be valid
- Order must contain at least one item
- Notes are optional
- Total amount must be positive (validated at service layer)

### Order Item Level
- Product ID and name are required
- Price must be non-negative
- Quantity must be at least 1
- Notes are optional

## Usage Examples

### Creating a New Order
```java
OrderRequest orderRequest = OrderRequest.builder()
    .customerEmail("customer@example.com")
    .items(List.of(
        OrderItemRequest.builder()
            .productId("PROD-123")
            .productName("Wireless Mouse")
            .price(BigDecimal.valueOf(29.99))
            .quantity(2)
            .build()
    ))
    .notes("Deliver after 6 PM")
    .build();
```

### Processing Order Response
```java
OrderResponse response = OrderResponse.from(order);
BigDecimal totalAmount = response.getTotalAmount();
List<OrderItemResponse> items = response.getItems();
```

## Best Practices

1. **Validation Annotations**
   - Use Jakarta Validation annotations
   - Provide clear error messages
   - Implement custom validations where needed

2. **Documentation**
   - Use OpenAPI/Swagger annotations
   - Include examples in schema descriptions
   - Document all fields and their purposes

3. **Builder Pattern**
   - Use Lombok @Builder for flexible object creation
   - Maintain immutability where possible

4. **Mapping Methods**
   - Use static factory methods for entity conversion
   - Keep mapping logic centralized
   - Handle null cases appropriately

## Exception Handling
DTOs work in conjunction with GlobalExceptionHandler to provide:
- Validation error responses
- Format error messages
- HTTP status code mapping

## Security Considerations
- DTOs help prevent over-posting vulnerabilities
- Sensitive data is filtered out in responses
- Input validation helps prevent injection attacks

