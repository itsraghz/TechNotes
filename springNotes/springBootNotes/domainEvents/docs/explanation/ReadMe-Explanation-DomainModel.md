# Domain Model Explanation

## Overview
This document explains the core domain model classes related to the Order management system. The model follows Domain-Driven Design (DDD) principles and is designed to work seamlessly with domain events.

## Order Class
The `Order` class represents a customer order in the system and serves as an Aggregate Root.

### Key Components

```java
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerEmail;
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> items;
    
    private LocalDateTime createdAt;
    
    @Version
    private Long version;
}
```

### Key Responsibilities
1. **Order Management**
   - Tracks order lifecycle from creation to completion
   - Manages order items and total amount
   - Ensures order consistency

2. **Event Generation**
   - Generates OrderCreatedEvent when a new order is created
   - Produces OrderStatusChangedEvent when status changes
   - Maintains event-sourcing compatibility

### Best Practices
1. **Immutability**
   - Use final fields where possible
   - Provide builders or factory methods for creation
   - Implement defensive copying for collections

2. **Validation**
   ```java
   public void validateState() {
       if (customerEmail == null || customerEmail.isEmpty()) {
           throw new IllegalStateException("Customer email is required");
       }
       if (items == null || items.isEmpty()) {
           throw new IllegalStateException("Order must contain items");
       }
       if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
           throw new IllegalStateException("Total amount must be positive");
       }
   }
   ```

## OrderStatus Enum
The `OrderStatus` enum represents the possible states of an order.

```java
public enum OrderStatus {
    CREATED,
    CONFIRMED,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELLED;
    
    public boolean canTransitionTo(OrderStatus newStatus) {
        // Define valid state transitions
        switch (this) {
            case CREATED:
                return newStatus == CONFIRMED || newStatus == CANCELLED;
            case CONFIRMED:
                return newStatus == PAID || newStatus == CANCELLED;
            case PAID:
                return newStatus == SHIPPED || newStatus == CANCELLED;
            case SHIPPED:
                return newStatus == DELIVERED;
            default:
                return false;
        }
    }
}
```

### State Transitions
- CREATED → CONFIRMED | CANCELLED
- CONFIRMED → PAID | CANCELLED
- PAID → SHIPPED | CANCELLED
- SHIPPED → DELIVERED
- DELIVERED (Terminal State)
- CANCELLED (Terminal State)

### Usage Example
```java
@Service
public class OrderService {
    public void updateOrderStatus(Order order, OrderStatus newStatus) {
        if (!order.getStatus().canTransitionTo(newStatus)) {
            throw new IllegalStateException(
                "Invalid status transition from " + order.getStatus() + " to " + newStatus
            );
        }
        OrderStatus oldStatus = order.getStatus();
        order.setStatus(newStatus);
        
        // Publish domain event
        eventPublisher.publish(new OrderStatusChangedEvent(
            order.getId(), oldStatus, newStatus
        ));
    }
}
```

## Integration with Domain Events
The Order domain model integrates with the event system in several ways:

1. **Event Generation Points**
   - Order creation
   - Status changes
   - Significant updates (e.g., price changes)

2. **Event Handling**
   ```java
   @DomainEvents
   Collection<DomainEvent> domainEvents() {
       // Return accumulated events
       ArrayList<DomainEvent> events = new ArrayList<>(this.domainEvents);
       this.domainEvents.clear();
       return events;
   }
   ```

3. **Event Storage**
   ```java
   @Transient
   private final List<DomainEvent> domainEvents = new ArrayList<>();
   
   protected void registerEvent(DomainEvent event) {
       this.domainEvents.add(event);
   }
   ```

## Best Practices and Patterns

### 1. Aggregate Consistency
- Maintain transactional consistency within the Order aggregate
- Use version field for optimistic locking
- Validate state transitions

### 2. Rich Domain Model
- Encapsulate business rules within the domain
- Use value objects for complex attributes
- Implement domain-specific validation

### 3. Event Publishing
- Use domain events for cross-aggregate communication
- Maintain event ordering
- Ensure event idempotency

