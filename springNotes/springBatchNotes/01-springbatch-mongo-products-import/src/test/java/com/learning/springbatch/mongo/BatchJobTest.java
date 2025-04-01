package com.learning.springbatch.mongo;

import com.learning.springbatch.mongo.config.MongoTestConfig;
import com.learning.springbatch.mongo.domain.Product;
import com.learning.springbatch.mongo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringBatchTest
@Import(MongoTestConfig.class)
@ActiveProfiles("test")
class BatchJobTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testJobExecution() throws Exception {
        // Given
        JobParameters jobParameters = new JobParametersBuilder()
            .addLong("time", System.currentTimeMillis())
            .toJobParameters();

        // When
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
        
        // Then
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        assertTrue(productRepository.count() > 0);
        
        // Verify a sample product
        Product product = productRepository.findBySku("APL-IP13P-128GB").orElse(null);
        assertNotNull(product);
        assertEquals("iPhone 13 Pro", product.name());
        assertEquals("Apple", product.manufacturer());
    }
}

