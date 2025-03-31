package com.learning.springbatch.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public record Product(
    @Id String id,
    String name,
    String description,
    String category,
    Double price,
    Integer stockQuantity,
    String manufacturer,
    String sku,
    Boolean active,
    String createdDate,
    String lastModifiedDate
) {}

