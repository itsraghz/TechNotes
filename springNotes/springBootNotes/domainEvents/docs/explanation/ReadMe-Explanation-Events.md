# Event Infrastructure Documentation

## Overview

This document explains the event infrastructure implementation using Apache Kafka for the order management system. The implementation follows event-driven architecture principles to achieve loose coupling and scalability.

## Components

### 1. Kafka Configuration (`KafkaConfig.java`)

The Kafka configuration sets up both producers and consumers with the following features:

#### Producer Configuration
- Idempotent delivery with `enable.idempotence=true`
- Strong durability with `acks=all`
- Automatic retries (3 attempts)
- JSON serialization for event objects

#### Consumer Configuration
- Manual acknowledgment mode
- Dead Letter Topic (DLT) for failed messages
- Error handling with retry mechanism (3 attempts, 1-second intervals)
- JSON deserialization with trusted package scanning

### 2. Domain Events

#### OrderCreatedEvent
- Represents a new order creation
- Contains complete order information including:
  - Order ID
  - Customer email
  - Total amount
  - Order items
  - Created timestamp

#### OrderStatusChangedEvent
- Represents an order status transition
- Contains:
  - Order ID
  - Previous and new status
  - Timestamp
  - Reason for change

### 3. Event Publisher (`EventPublisher.java`)

The EventPublisher service provides:
- Asynchronous event publishing using KafkaTemplate
- Automatic retry mechanism
- Comprehensive error handling
- Logging of success/failure outcomes

## Usage Examples

### Publishing an Order Created Event

```java
@Service
public class OrderService {
    private final EventPublisher eventPublisher;

    public Order createOrder(OrderRequest request) {
        // Save order to database
        Order order = orderRepository.save(/* ... */);

        // Publish event
        OrderCreatedEvent event = OrderCreatedEvent.builder()
            .orderId(order.getId())
            .customerEmail(order.getCustomerEmail())
            .totalAmount(order.getTotalAmount())
            .status(order.getStatus())
            .items(mapToEventItems(order.getItems()))
            .createdAt(order.getCreatedAt())
            .build();

        eventPublisher.publishOrderCreatedEvent(event);
        return order;
    }
}
```

### Publishing a Status Change Event

```java
public void updateOrderStatus(String orderId, OrderStatus newStatus, String reason) {
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new OrderNotFoundException(orderId));

    OrderStatus previousStatus = order.getStatus();
    order.setStatus(newStatus);
    orderRepository.save(order);

    OrderStatusChangedEvent event = OrderStatusChangedEvent.builder()
        .orderId(orderId)
        .previousStatus(previousStatus)
        .newStatus(newStatus)
        .customerEmail(order.getCustomerEmail())
        .timestamp(LocalDateTime.now())
        .reason(reason)
        .build();

    eventPublisher.publishOrderStatusChangedEvent(event);
}
```

## Configuration Properties

Add the following properties to `application.properties`:

```properties
# Kafka Configuration
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=order-service
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.enable-auto-commit=false

# Topic Configuration
spring.kafka.topic.order-created=order.created
spring.kafka.topic.order-status-changed=order.status.changed
```

## Best Practices

1. **Event Versioning**: Include version information in event classes for future compatibility

2. **Idempotency**: Ensure consumers can handle duplicate events gracefully

3. **Error Handling**: 
   - Use Dead Letter Topics for failed messages
   - Implement proper retry mechanisms
   - Log detailed error information

4. **Monitoring**:
   - Monitor event publishing success rates
   - Track consumer lag
   - Set up alerts for failed events

5. **Testing**:
   - Unit test event serialization/deserialization
   - Integration test with embedded Kafka
   - Test error handling scenarios

