package com.learning.springbatch.mongo.batch;

import com.learning.springbatch.mongo.domain.Product;
import com.learning.springbatch.mongo.dto.ProductDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProductProcessor implements ItemProcessor<ProductDTO, Product> {
    
    @Override
    public Product process(ProductDTO dto) {
        return new Product(
            UUID.randomUUID().toString(),
            dto.name(),
            dto.description(),
            dto.category(),
            dto.price(),
            dto.stockQuantity(),
            dto.manufacturer(),
            dto.sku(),
            true,
            LocalDateTime.now().toString(),
            LocalDateTime.now().toString()
        );
    }
}

