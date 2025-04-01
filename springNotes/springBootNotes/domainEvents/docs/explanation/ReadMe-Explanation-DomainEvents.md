# Domain Events Explanation

## Event Hierarchy
Our domain events follow a hierarchical structure that promotes code reuse and consistency.

```
DomainEvent (abstract base class)
├── OrderCreatedEvent
├── OrderStatusChangedEvent
├── OrderCancelledEvent
└── OrderItemsModifiedEvent
```

## Base Domain Event
The `DomainEvent` class serves as the foundation for all domain events.

```java
public abstract class DomainEvent implements Serializable {
    private final String eventId;
    private final LocalDateTime occurredOn;
    private final String eventType;
    
    protected DomainEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = LocalDateTime.now();
        this.eventType = this.getClass().getSimpleName();
    }
    
    // Getters and common functionality
}
```

### Key Features
1. **Event Identity**: Each event has a unique ID
2. **Timestamp**: Records when the event occurred
3. **Type Information**: Stores the event type for deserialization

## Specific Event Types

### 1. OrderCreatedEvent
```java
public class OrderCreatedEvent extends DomainEvent {
    private final Long orderId;
    private final String customerEmail;
    private final BigDecimal totalAmount;
    private final List<OrderItem> items;
    
    public OrderCreatedEvent(Order order) {
        super();
        this.orderId = order.getId();
        this.customerEmail = order.getCustomerEmail();
        this.totalAmount = order.getTotalAmount();
        this.items = new ArrayList<>(order.getItems());
    }
}
```

### 2. OrderStatusChangedEvent
```java
public class OrderStatusChangedEvent extends DomainEvent {
    private final Long orderId;
    private final OrderStatus oldStatus;
    private final OrderStatus newStatus;
    
    public OrderStatusChangedEvent(Long orderId, OrderStatus oldStatus, OrderStatus newStatus) {
        super();
        this.orderId = orderId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }
}
```

## Kafka Integration

### 1. Event Publishing
Events are published to Kafka topics using a dedicated publisher:

```java
@Service
public class KafkaEventPublisher implements EventPublisher {
    @Autowired
    private KafkaTemplate<String, DomainEvent> kafkaTemplate;
    
    @Override
    public void publish(DomainEvent event) {
        String topic = determineTopicForEvent(event);
        kafkaTemplate.send(topic, event.getEventId(), event);
    }
    
    private String determineTopicForEvent(DomainEvent event) {
        return switch (event.getClass().getSimpleName()) {
            case "OrderCreatedEvent" -> "order-created-events";
            case "OrderStatusChangedEvent" -> "order-status-events";
            default -> "default-events";
        };
    }
}
```

### 2. Event Consumption
Events are consumed by various services:

```java
@Service
@KafkaListener(topics = "order-created-events")
public class OrderCreatedEventHandler {
    @Autowired
    private NotificationService notificationService;
    
    @KafkaHandler
    public void handle(OrderCreatedEvent event) {
        // Send confirmation email
        notificationService.sendOrderConfirmation(
            event.getCustomerEmail(),
            event.getOrderId()
        );
    }
}
```

## Best Practices

### 1. Event Design
- Keep events immutable
- Include only necessary data
- Version events for schema evolution
- Use meaningful event names

### 2. Event Publishing
- Ensure at-least-once delivery
- Handle duplicate events (idempotency)
- Maintain event order when necessary
- Use appropriate serialization format

### 3. Error Handling
```java
@KafkaListener(topics = "order-events")
public class ResilientEventHandler {
    @KafkaHandler(isDefault = true)
    public void handle(DomainEvent event) {
        try {
            processEvent(event);
        } catch (Exception e) {
            // Log error and trigger retry mechanism
            handleEventProcessingFailure(event, e);
        }
    }
}
```

### 4. Monitoring and Tracing
- Include correlation IDs
- Log event processing
- Track event processing metrics
- Implement health checks

## Integration Examples

### 1. Publishing Events
```java
@Service
@Transactional
public class OrderService {
    @Autowired
    private EventPublisher eventPublisher;
    
    public Order createOrder(OrderRequest request) {
        Order order = orderFactory.createFrom(request);
        orderRepository.save(order);
        
        // Publish the event
        eventPublisher.publish(new OrderCreatedEvent(order));
        return order;
    }
}
```

### 2. Handling Events
```java
@Service
public class InventoryEventHandler {
    @KafkaListener(topics = "order-status-events")
    public void handleOrderStatusChange(OrderStatusChangedEvent event) {
        if (event.getNewStatus() == OrderStatus.PAID) {
            // Reserve inventory
            inventoryService.reserveItems(event.getOrderId());
        } else if (event.getNewStatus() == OrderStatus.CANCELLED) {
            // Release inventory
            inventoryService.releaseItems(event.getOrderId());
        }
    }
}
```

## Event Patterns and Anti-patterns

### Patterns
1. **Event Enrichment**
   - Add relevant context to events
   - Include referenced entity IDs

2. **Event Versioning**
   - Use schema versioning
   - Maintain backward compatibility

3. **Event Sourcing**
   - Rebuild state from events
   - Maintain event log

### Anti-patterns to Avoid
1. Including unnecessary data in events
2. Tight coupling between publishers and subscribers
3. Missing error handling
4. Ignoring event ordering when important

