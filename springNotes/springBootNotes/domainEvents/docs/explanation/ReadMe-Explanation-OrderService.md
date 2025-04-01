# OrderService Documentation

## Overview
The `OrderService` class is a core component of the order management system that handles CRUD operations for orders and publishes domain events for significant state changes. It implements transactional boundaries and includes comprehensive error handling and validation.

## Key Features
1. CRUD Operations for Orders
2. Event Publishing for Order State Changes
3. Transaction Management
4. Status Transition Validation
5. Comprehensive Logging
6. Error Handling

## Service Methods

### createOrder
```java
@Transactional
public Order createOrder(@Valid @NotNull Order order)
```
Creates a new order and publishes an `OrderCreatedEvent`.

**Features:**
- Generates UUID for new orders
- Sets initial status to CREATED
- Records creation timestamp
- Validates order data using Bean Validation
- Publishes OrderCreatedEvent asynchronously
- Includes transaction management

### updateOrderStatus
```java
@Transactional
public Order updateOrderStatus(@NotNull UUID orderId, @NotNull OrderStatus newStatus)
```
Updates an order's status and publishes an `OrderStatusChangedEvent`.

**Features:**
- Validates status transition
- Records modification timestamp
- Publishes OrderStatusChangedEvent asynchronously
- Maintains transaction integrity

### getOrder
```java
@Transactional(readOnly = true)
public Order getOrder(@NotNull UUID orderId)
```
Retrieves a single order by ID.

**Features:**
- Read-only transaction
- Throws OrderNotFoundException if not found
- Includes proper logging

### getAllOrders
```java
@Transactional(readOnly = true)
public Page<Order> getAllOrders(Pageable pageable)
```
Retrieves all orders with pagination support.

**Features:**
- Read-only transaction
- Pagination support
- Efficient query execution

### deleteOrder
```java
@Transactional
public void deleteOrder(@NotNull UUID orderId)
```
Deletes an order by ID.

**Features:**
- Verifies existence before deletion
- Transactional execution
- Proper logging

## Event Publishing
The service publishes two types of events:
1. OrderCreatedEvent: When a new order is created
2. OrderStatusChangedEvent: When an order's status changes

Events are published asynchronously using CompletableFuture for non-blocking operation.

## Error Handling
1. OrderNotFoundException: When requested order doesn't exist
2. IllegalStateException: For invalid status transitions
3. ValidationException: For invalid order data
4. Event Publishing Failures: Logged but not propagated (configurable)

## Transaction Management
- Write operations (create, update, delete) use @Transactional
- Read operations use @Transactional(readOnly = true)
- Event publishing is handled after successful transaction commit

## Logging
- INFO level for significant business events
- DEBUG level for technical details
- ERROR level for exceptions and failures
- Includes relevant context (orderId, status, etc.)

## Best Practices
1. Use @Valid annotation for input validation
2. Implement idempotent operations
3. Handle event publishing failures gracefully
4. Follow proper transaction boundaries
5. Include comprehensive logging
6. Use proper null checking and validation

## Usage Example
```java
@Autowired
private OrderService orderService;

// Create Order
Order newOrder = Order.builder()
    .customerEmail("customer@example.com")
    .totalAmount(new BigDecimal("100.00"))
    .items(Arrays.asList(orderItem1, orderItem2))
    .build();
Order created = orderService.createOrder(newOrder);

// Update Status
Order updated = orderService.updateOrderStatus(
    created.getId(), 
    OrderStatus.CONFIRMED
);

// Retrieve Order
Order retrieved = orderService.getOrder(created.getId());

// Get All Orders
Page<Order> orders = orderService.getAllOrders(
    PageRequest.of(0, 10, Sort.by("createdAt").descending())
);

// Delete Order
orderService.deleteOrder(created.getId());
```

## Dependencies
- OrderRepository: For data persistence
- EventPublisher: For publishing domain events
- ValidationService: For business rule validation
- TransactionManager: For transaction handling

# Order Service Layer Documentation

## Overview
The Order Service layer manages the complete lifecycle of orders in the system, including creation, status updates, and deletion. It implements proper transaction handling, publishes domain events, and includes comprehensive error handling.

## Components

### OrderService
The main service class responsible for order management operations:

- **Creation**: Creates new orders and publishes OrderCreatedEvent
- **Retrieval**: Gets single or all orders
- **Status Updates**: Updates order status and publishes OrderStatusChangedEvent
- **Deletion**: Deletes orders in CREATED status

### DTOs
Data Transfer Objects for request/response handling:

#### OrderRequest
- Represents incoming order creation requests
- Contains customer email and list of items
- Each item includes productId, quantity, and unit price

#### OrderResponse
- Represents order data sent back to clients
- Includes order details, status, timestamps, and calculated totals
- Contains nested OrderItemResponse for order items

## Transaction Handling

The service uses Spring's `@Transactional` annotation for proper transaction management:

```java
@Transactional
public OrderResponse createOrder(OrderRequest request) {
    // Transaction ensures atomicity of order creation and event publishing
}

@Transactional(readOnly = true)
public OrderResponse getOrder(String orderId) {
    // Read-only transaction for queries
}
```

## Event Publishing

The service publishes domain events for significant state changes:

1. **OrderCreatedEvent**: Published when a new order is created
2. **OrderStatusChangedEvent**: Published when order status changes

Example:
```java
eventPublisher.publish(new OrderCreatedEvent(
    savedOrder.getId(),
    savedOrder.getCustomerEmail(),
    savedOrder.getTotalAmount(),
    savedOrder.getCreatedAt()
));
```

## Error Handling

The service includes comprehensive error handling:

1. **OrderNotFoundException**: Thrown when order is not found
2. **IllegalStateException**: Thrown for invalid state transitions
3. Validation errors for invalid input data

Example:
```java
Order order = orderRepository.findById(orderId)
    .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));
```

## Best Practices

1. **Immutable DTOs**: Using Lombok's `@Builder` pattern for immutable objects
2. **Separation of Concerns**: Clear separation between domain model and DTOs
3. **Proper Logging**: Comprehensive logging for tracking and debugging
4. **Transaction Boundaries**: Clearly defined transaction boundaries
5. **Event-Driven**: Using domain events for loose coupling
6. **Validation**: Input validation at service layer

## Integration Points

1. **OrderRepository**: For persistence operations
2. **EventPublisher**: For publishing domain events
3. **Controllers**: Interface with REST endpoints (not shown)

## Code Examples

### Creating an Order
```java
OrderRequest request = OrderRequest.builder()
    .customerEmail("customer@example.com")
    .items(List.of(
        OrderItemRequest.builder()
            .productId("PROD-1")
            .quantity(2)
            .unitPrice(new BigDecimal("29.99"))
            .build()
    ))
    .build();

OrderResponse response = orderService.createOrder(request);
```

### Updating Order Status
```java
OrderResponse response = orderService.updateOrderStatus(
    "order-123",
    OrderStatus.CONFIRMED
);
```

## Testing Considerations

1. Unit test individual components with mocked dependencies
2. Integration tests for transaction boundaries
3. Event publishing verification
4. Error handling scenarios
5. Edge cases for status transitions

## Monitoring and Metrics

Consider adding:
1. Transaction timing metrics
2. Event publishing success/failure rates
3. Order status distribution
4. Error rate monitoring

