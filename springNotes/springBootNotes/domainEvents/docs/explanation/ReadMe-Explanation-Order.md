# Order Entity Documentation

## Overview
The Order entity represents a customer's order in our e-commerce system. It serves as the root aggregate for order-related operations and maintains relationships with OrderItems and tracks the order's status throughout its lifecycle.

## Structure

```java
@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String customerEmail;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Valid
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @NotNull
    @Positive
    private BigDecimal totalAmount;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

## Fields Explanation
- `id`: Unique identifier for the order
- `customerEmail`: Email address of the customer who placed the order
- `status`: Current status of the order (see OrderStatus documentation)
- `items`: List of items in the order
- `totalAmount`: Total monetary value of the order
- `createdAt`: Timestamp when the order was created
- `updatedAt`: Timestamp when the order was last modified

## Relationships
1. **One-to-Many with OrderItem**
   - One order can have multiple order items
   - Cascade all operations to order items
   - Orphan removal enabled to automatically delete items when removed from the order

## Validation Rules
1. Customer email must be:
   - Not null
   - Valid email format
2. Status must be:
   - Not null
   - A valid OrderStatus enum value
3. Total amount must be:
   - Not null
   - Positive value
4. Items must be:
   - Valid (each item must pass its own validation)

## Business Methods

```java
public void addItem(OrderItem item) {
    items.add(item);
    item.setOrder(this);
    recalculateTotalAmount();
}

public void removeItem(OrderItem item) {
    items.remove(item);
    item.setOrder(null);
    recalculateTotalAmount();
}

private void recalculateTotalAmount() {
    this.totalAmount = items.stream()
        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
}

public boolean canTransitionTo(OrderStatus newStatus) {
    return status.canTransitionTo(newStatus);
}

public void updateStatus(OrderStatus newStatus) {
    if (!canTransitionTo(newStatus)) {
        throw new IllegalStateException(
            String.format("Cannot transition from %s to %s", status, newStatus)
        );
    }
    this.status = newStatus;
}
```

## Best Practices
1. **Aggregate Root**
   - Order acts as an aggregate root for OrderItems
   - All modifications to OrderItems should go through the Order entity
   - Use proper cascade types to maintain data consistency

2. **Validation**
   - Use Bean Validation annotations to enforce constraints
   - Implement business-level validation in service layer
   - Validate status transitions before updating

3. **Auditing**
   - Use JPA auditing for automatic timestamp management
   - Track order modifications using updatedAt field
   - Consider adding user auditing for who modified the order

4. **Money Handling**
   - Use BigDecimal for monetary values
   - Never use float or double for money
   - Consider using a Money value object for more complex applications

## Example Usage

```java
// Creating a new order
Order order = Order.builder()
    .customerEmail("customer@example.com")
    .status(OrderStatus.CREATED)
    .build();

// Adding items
OrderItem item1 = OrderItem.builder()
    .productId("PROD-1")
    .productName("Widget")
    .quantity(2)
    .price(new BigDecimal("19.99"))
    .build();
order.addItem(item1);

// Updating status
if (order.canTransitionTo(OrderStatus.CONFIRMED)) {
    order.updateStatus(OrderStatus.CONFIRMED);
}
```

## Common Pitfalls to Avoid
1. Don't modify OrderItems directly; always go through the Order entity
2. Don't forget to recalculate totalAmount when items change
3. Don't bypass status transition validation
4. Don't use primitive doubles for money calculations

# Order Domain Model Documentation

## Overview

The Order Management System implements a robust domain model for handling e-commerce orders using Spring Boot and JPA. This implementation follows Domain-Driven Design (DDD) principles and provides comprehensive event publishing capabilities through Kafka integration.

### Key Features

- Complete Order lifecycle management
- Automatic audit trail for order changes
- Event-driven architecture with Kafka integration
- Transactional integrity
- Validation and error handling
- Scalable and maintainable design

## Domain Entities

### Order Entity

The `Order` entity represents a customer order in the system:

```java
@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String customerEmail;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

### OrderItem Entity

`OrderItem` represents individual items within an order:

```java
@Entity
@Table(name = "order_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    private String productId;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal unitPrice;
}
```

## Order Status Lifecycle

The `OrderStatus` enum defines all possible states an order can be in and manages valid state transitions:

```java
public enum OrderStatus {
    CREATED,
    CONFIRMED,
    PAID,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    REFUNDED;

    public boolean canTransitionTo(OrderStatus newStatus) {
        return switch (this) {
            case CREATED -> newStatus == CONFIRMED || newStatus == CANCELLED;
            case CONFIRMED -> newStatus == PAID || newStatus == CANCELLED;
            case PAID -> newStatus == PROCESSING || newStatus == REFUNDED;
            case PROCESSING -> newStatus == SHIPPED || newStatus == CANCELLED;
            case SHIPPED -> newStatus == DELIVERED;
            case DELIVERED -> newStatus == REFUNDED;
            case CANCELLED, REFUNDED -> false;
        };
    }
}
```

### Status Transition Rules

1. **CREATED**
   - Initial state when order is first created
   - Can transition to: CONFIRMED, CANCELLED

2. **CONFIRMED**
   - Order has been confirmed by the system
   - Can transition to: PAID, CANCELLED

3. **PAID**
   - Payment has been successfully processed
   - Can transition to: PROCESSING, REFUNDED

4. **PROCESSING**
   - Order is being prepared for shipment
   - Can transition to: SHIPPED, CANCELLED

5. **SHIPPED**
   - Order has been shipped to customer
   - Can transition to: DELIVERED only

6. **DELIVERED**
   - Order has been successfully delivered
   - Can transition to: REFUNDED only

7. **CANCELLED**
   - Order has been cancelled
   - Terminal state, no further transitions allowed

8. **REFUNDED**
   - Order has been refunded
   - Terminal state, no further transitions allowed

## JPA Auditing Implementation

The system uses Spring Data JPA's auditing capabilities to automatically track entity creation and modification timestamps:

```java
@Configuration
@EnableJpaAuditing
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("SYSTEM");
    }
}
```

Key auditing features:
- Automatic timestamp management using `@CreatedDate` and `@LastModifiedDate`
- Entity listener configuration for audit trail
- Support for tracking who made changes (optional)

## Usage Examples

### Creating a New Order

```java
Order order = Order.builder()
    .customerEmail("customer@example.com")
    .status(OrderStatus.CREATED)
    .totalAmount(BigDecimal.valueOf(99.99))
    .build();

OrderItem item = OrderItem.builder()
    .productId("PROD-123")
    .quantity(2)
    .unitPrice(BigDecimal.valueOf(49.99))
    .build();

order.getItems().add(item);
item.setOrder(order);

orderRepository.save(order);
```

### Updating Order Status

```java
Order order = orderRepository.findById(orderId)
    .orElseThrow(() -> new OrderNotFoundException(orderId));

OrderStatus newStatus = OrderStatus.CONFIRMED;
if (!order.getStatus().canTransitionTo(newStatus)) {
    throw new InvalidStatusTransitionException(order.getStatus(), newStatus);
}

order.setStatus(newStatus);
orderRepository.save(order);
```

## Best Practices and Considerations

1. **Entity Relationships**
   - Use lazy loading for @ManyToOne relationships
   - Implement proper cascading rules
   - Maintain bidirectional relationships carefully

2. **Validation**
   - Use Bean Validation annotations
   - Implement domain-specific validation rules
   - Validate status transitions explicitly

3. **Transaction Management**
   - Use @Transactional for service methods
   - Consider isolation levels for concurrent operations
   - Implement optimistic locking for conflict resolution

4. **Auditing**
   - Enable JPA auditing for all important entities
   - Consider adding user tracking for audit trail
   - Implement custom audit fields as needed

5. **Event Publishing**
   - Publish domain events after successful transactions
   - Use Spring's TransactionPhase.AFTER_COMMIT
   - Implement idempotent event handlers

6. **Performance Considerations**
   - Use indexed fields for frequent queries
   - Implement pagination for large result sets
   - Consider caching frequently accessed data

7. **Error Handling**
   - Define custom exceptions for domain-specific errors
   - Implement proper error response DTOs
   - Log errors with appropriate context

8. **Testing**
   - Write unit tests for entity methods
   - Test status transitions thoroughly
   - Implement integration tests for persistence
   - Test concurrent operations

## Common Pitfalls to Avoid

1. Skipping status transition validation
2. Not handling bidirectional relationships properly
3. Ignoring transaction boundaries
4. Missing proper error handling
5. Neglecting proper auditing setup
6. Not considering concurrency issues

## Maintenance and Evolution

1. **Schema Changes**
   - Use proper database migration tools
   - Plan for backward compatibility
   - Document all schema changes

2. **Status Additions**
   - Update transition rules when adding new statuses
   - Consider impact on existing orders
   - Update relevant documentation

3. **Performance Monitoring**
   - Monitor database query performance
   - Track common operation metrics
   - Implement proper logging for debugging

## Integration Points

1. **Event System**
   - Order creation events
   - Status change events
   - Cancellation/refund events

2. **External Systems**
   - Payment processing
   - Shipping management
   - Inventory system
   - Customer notification

3. **API Layer**
   - REST endpoints for order management
   - GraphQL queries (if implemented)
   - Webhook notifications

