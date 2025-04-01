package com.learning.springbatch.mongo.dto;

public record ProductDTO(
    String name,
    String description,
    String category,
    Double price,
    Integer stockQuantity,
    String manufacturer,
    String sku
) {}

