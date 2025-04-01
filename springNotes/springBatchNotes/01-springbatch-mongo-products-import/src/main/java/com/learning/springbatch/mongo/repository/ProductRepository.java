package com.learning.springbatch.mongo.repository;

import com.learning.springbatch.mongo.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findBySku(String sku);
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByActiveTrue();
}

