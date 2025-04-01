package com.learning.springbatch.mongo.batch;

import com.learning.springbatch.mongo.domain.Product;
import com.learning.springbatch.mongo.repository.ProductRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoProductWriter implements ItemWriter<Product> {

    private final ProductRepository productRepository;

    @Autowired
    public MongoProductWriter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void write(Chunk<? extends Product> products) {
        productRepository.saveAll(products.getItems());
    }
}

