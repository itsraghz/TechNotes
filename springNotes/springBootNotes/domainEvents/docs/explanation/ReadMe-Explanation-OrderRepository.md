# Order Repository Implementation Guide

## Table of Contents
1. [Overview](#overview)
2. [Repository Pattern Implementation](#repository-pattern-implementation)
3. [Custom Query Methods](#custom-query-methods)
4. [Pagination Implementation](#pagination-implementation)
5. [Query Optimization](#query-optimization)
6. [Common Operations](#common-operations)
7. [Best Practices](#best-practices)

## Overview

The `OrderRepository` interface extends Spring Data JPA's `JpaRepository` to provide data access capabilities for the Order domain model. It implements the Repository pattern, offering a clean separation between the domain model and data mapping layers.

```java
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    // Custom query methods defined here
}
```

## Repository Pattern Implementation

### Key Benefits
- **Separation of Concerns**: Isolates data access logic from business logic
- **Domain-Driven Design**: Aligns with DDD principles by focusing on the domain model
- **Testability**: Easier to mock for unit testing
- **Maintenance**: Centralizes data access logic

### Implementation Details
```java
// Basic CRUD operations inherited from JpaRepository
- save(Order order)
- findById(UUID id)
- findAll()
- delete(Order order)
```

## Custom Query Methods

### Customer-Based Queries
```java
// Find orders by customer email
List<Order> findByCustomerEmail(String email);

// Find orders by customer email and status
List<Order> findByCustomerEmailAndStatus(String email, OrderStatus status);
```

### Status-Based Queries
```java
// Find orders by status
List<Order> findByStatus(OrderStatus status);

// Count orders by status
long countByStatus(OrderStatus status);
```

### Date-Based Queries
```java
// Find orders created between dates
List<Order> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

// Find orders updated after date
List<Order> findByUpdatedAtAfter(LocalDateTime date);
```

## Pagination Implementation

### Page-Based Pagination
```java
// Fetch paginated orders
Page<Order> findAll(Pageable pageable);

// Usage example
Pageable pageable = PageRequest.of(0, 20, Sort.by("createdAt").descending());
Page<Order> orderPage = orderRepository.findAll(pageable);
```

### Slice-Based Pagination
```java
// Fetch orders with slice
Slice<Order> findByStatus(OrderStatus status, Pageable pageable);

// Usage example
Pageable pageable = PageRequest.of(0, 20);
Slice<Order> orderSlice = orderRepository.findByStatus(OrderStatus.PENDING, pageable);
```

## Query Optimization

### Indexing Strategy
```sql
-- Recommended indexes for Order table
CREATE INDEX idx_order_customer_email ON orders(customer_email);
CREATE INDEX idx_order_status ON orders(status);
CREATE INDEX idx_order_created_at ON orders(created_at);
```

### Fetch Optimization
```java
// Fetch order with items in a single query
@Query("SELECT o FROM Order o LEFT JOIN FETCH o.items WHERE o.id = :id")
Optional<Order> findByIdWithItems(@Param("id") UUID id);
```

### Batch Operations
```java
// Batch update status
@Modifying
@Query("UPDATE Order o SET o.status = :status WHERE o.id IN :ids")
int updateOrderStatus(@Param("status") OrderStatus status, @Param("ids") List<UUID> ids);
```

## Common Operations

### Create Order
```java
Order order = new Order(/* ... */);
Order savedOrder = orderRepository.save(order);
```

### Update Order
```java
Optional<Order> orderOpt = orderRepository.findById(orderId);
orderOpt.ifPresent(order -> {
    order.setStatus(OrderStatus.CONFIRMED);
    orderRepository.save(order);
});
```

### Delete Order
```java
orderRepository.deleteById(orderId);
```

### Find Orders with Criteria
```java
// Using Specification
Specification<Order> spec = (root, query, cb) -> {
    List<Predicate> predicates = new ArrayList<>();
    if (status != null) {
        predicates.add(cb.equal(root.get("status"), status));
    }
    if (startDate != null) {
        predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), startDate));
    }
    return cb.and(predicates.toArray(new Predicate[0]));
};
List<Order> orders = orderRepository.findAll(spec);
```

## Best Practices

### 1. Transaction Management
```java
@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, UUID> {
    // Read operations use readOnly=true
    
    @Transactional
    @Modifying
    // Write operations explicitly declare @Transactional
    int updateOrderStatus(@Param("status") OrderStatus status, @Param("id") UUID id);
}
```

### 2. Exception Handling
```java
try {
    orderRepository.save(order);
} catch (DataIntegrityViolationException e) {
    // Handle constraint violations
} catch (OptimisticLockingFailureException e) {
    // Handle concurrent modifications
}
```

### 3. Audit Trail
```java
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

### 4. Performance Considerations
- Use appropriate fetch types (LAZY/EAGER)
- Implement batch processing for bulk operations
- Use database indexes strategically
- Implement caching where appropriate
- Use projections for specific use cases

### 5. Testing
```java
@DataJpaTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    
    @Test
    void whenFindByStatus_thenReturnMatchingOrders() {
        // Test implementation
    }
}
```

### 6. Query Method Naming Conventions
- Use meaningful and consistent naming
- Follow Spring Data JPA query method naming patterns
- Document complex query methods

For example:
```java
// Good
List<Order> findByStatusAndCreatedAtAfter(OrderStatus status, LocalDateTime date);

// Avoid
List<Order> getByStatusAndDate(OrderStatus status, LocalDateTime date);
```

### 7. Pagination Best Practices
- Always paginate large result sets
- Use appropriate page sizes
- Include sorting capabilities
- Handle empty results gracefully

### 8. Repository Interface Segregation
- Split large repositories into smaller, focused interfaces
- Use repository composition when needed
- Create custom repositories for complex queries

Example:
```java
public interface CustomOrderRepository {
    List<Order> findOrdersRequiringAttention();
}

public interface OrderRepository extends 
    JpaRepository<Order, UUID>, 
    CustomOrderRepository {
}
```

