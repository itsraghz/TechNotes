# OrderItem Entity Documentation

## Overview
The OrderItem entity represents individual items within an order. It contains detailed information about the product, quantity, and pricing of each item in an order.

## Structure

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

    @NotNull
    private String productId;

    @NotNull
    @Size(min = 1, max = 255)
    private String productName;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @Positive
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
```

## Fields Explanation
- `id`: Unique identifier for the order item
- `productId`: Reference to the product in the catalog
- `productName`: Name of the product (denormalized for order history)
- `quantity`: Number of units ordered
- `price`: Price per unit at the time of order
- `order`: Reference to the parent order

## Relationship with Order
1. **Many-to-One with Order**
   - Multiple items can belong to one order
   - Lazy fetching for better performance
   - Bidirectional relationship managed by the Order entity

## Validation Rules
1. Product ID must be:
   - Not null
   - Valid reference to existing product
2. Product name must be:
   - Not null
   - Between 1 and 255 characters
3. Quantity must be:
   - Not null
   - Minimum value of 1
4. Price must be:
   - Not null
   - Positive value

## Best Practices

1. **Price Management**
   - Store the price at the time of order
   - Use BigDecimal for monetary values
   - Consider price history for audit purposes

2. **Product Information**
   - Denormalize product name for historical accuracy
   - Consider denormalizing other important product attributes
   - Maintain reference to product ID for tracking

3. **Performance**
   - Use lazy loading for the Order relationship
   - Consider fetch joins when querying with Order
   - Index the order_id foreign key

4. **Validation**
   - Validate at both entity and service levels
   - Check inventory availability before creating
   - Ensure price matches current product price

## Example Usage

```java
// Creating a new order item
OrderItem item = OrderItem.builder()
    .productId("PROD-1")
    .productName("Premium Widget")
    .quantity(2)
    .price(new BigDecimal("29.99"))
    .build();

// Calculating total for item
BigDecimal total = item.getPrice()
    .multiply(BigDecimal.valueOf(item.getQuantity()));

// Adding to order
order.addItem(item);
```

## Common Pitfalls to Avoid
1. Don't modify price or quantity directly; use Order methods
2. Don't create orphaned OrderItems without an Order
3. Don't use floating-point types for price
4. Don't forget to validate inventory availability

