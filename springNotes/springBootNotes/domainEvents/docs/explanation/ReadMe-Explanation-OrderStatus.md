# OrderStatus Enum Documentation

## Overview
The OrderStatus enum represents the various states an order can be in throughout its lifecycle. It manages the valid state transitions and provides utility methods for status validation.

## Structure

```java
public enum OrderStatus {
    CREATED(EnumSet.of(CONFIRMED, CANCELLED)),
    CONFIRMED(EnumSet.of(PAID, CANCELLED)),
    PAID(EnumSet.of(PROCESSING, REFUNDED)),
    PROCESSING(EnumSet.of(SHIPPED, CANCELLED)),
    SHIPPED(EnumSet.of(DELIVERED, CANCELLED)),
    DELIVERED(EnumSet.of(REFUNDED)),
    CANCELLED(EnumSet.noneOf(OrderStatus.class)),
    REFUNDED(EnumSet.noneOf(OrderStatus.class));

    private final Set<OrderStatus> allowedTransitions;

    OrderStatus(Set<OrderStatus> allowedTransitions) {
        this.allowedTransitions = allowedTransitions;
    }

    public boolean canTransitionTo(OrderStatus newStatus) {
        return allowedTransitions.contains(newStatus);
    }
}
```

## Status Definitions

1. **CREATED**
   - Initial state when an order is first created
   - Customer has added items but hasn't confirmed
   - Can transition to: CONFIRMED, CANCELLED

2. **CONFIRMED**
   - Order has been confirmed by the customer
   - Awaiting payment
   - Can transition to: PAID, CANCELLED

3. **PAID**
   - Payment has been successfully processed
   - Ready for order processing
   - Can transition to: PROCESSING, REFUNDED

4. **PROCESSING**
   - Order is being prepared for shipment
   - Items are being picked and packed
   - Can transition to: SHIPPED, CANCELLED

5. **SHIPPED**
   - Order has been handed over to shipping carrier
   - Contains tracking information
   - Can transition to: DELIVERED, CANCELLED

6. **DELIVERED**
   - Order has been successfully delivered to customer
   - Final successful state
   - Can transition to: REFUNDED

7. **CANCELLED**
   - Order has been cancelled
   - Terminal state
   - No further transitions allowed

8. **REFUNDED**
   - Payment has been refunded to customer
   - Terminal state
   - No further transitions allowed

## State Transition Rules

### Valid Transitions
```
CREATED → CONFIRMED → PAID → PROCESSING → SHIPPED → DELIVERED
   ↓         ↓         ↓         ↓           ↓           ↓
CANCELLED  CANCELLED  REFUNDED  CANCELLED  CANCELLED   REFUNDED
```

### Usage Example

```java
// Checking if transition is valid
if (currentStatus.canTransitionTo(newStatus)) {
    order.setStatus(newStatus);
} else {
    throw new IllegalStateException("Invalid status transition");
}

// Example transitions
OrderStatus.CREATED.canTransitionTo(OrderStatus.CONFIRMED);    // true
OrderStatus.CREATED.canTransitionTo(OrderStatus.SHIPPED);      // false
OrderStatus.DELIVERED.canTransitionTo(OrderStatus.CANCELLED);  // false
```

## Best Practices

1. **Status Validation**
   - Always check if transition is valid before updating
   - Use canTransitionTo() method for validation
   - Handle invalid transitions gracefully

2. **Event Publishing**
   - Publish events on status changes
   - Include both old and new status in events
   - Consider async event processing

3. **Auditing**
   - Log all status changes
   - Include timestamp and user information
   - Maintain status change history

4. **Error Handling**
   - Use custom exceptions for invalid transitions
   - Provide clear error messages
   - Consider recovery strategies

## Common Scenarios

1. **Normal Flow**
   ```java
   CREATED → CONFIRMED → PAID → PROCESSING → SHIPPED → DELIVERED
   ```

2. **Cancellation Flow**
   ```java
   // Can be cancelled before shipping
   CREATED → CANCELLED
   CONFIRMED → CANCELLED
   PROCESSING → CANCELLED
   ```

3. **Refund Flow**
   ```java
   // Can be refunded after payment or delivery
   PAID → REFUNDED
   DELIVERED → REFUNDED
   ```

## Error Cases to Handle

1. **Invalid Transitions**
   - Attempting to skip states
   - Moving backwards in the flow
   - Transitioning from terminal states

2. **External System Failures**
   - Payment system issues
   - Shipping system problems
   - Inventory system errors

3. **Concurrent Modifications**
   - Multiple status updates at same time
   - Race conditions in distributed systems
   - Optimistic locking conflicts

