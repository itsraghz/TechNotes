package com.learning.springbatch.mongo.config;

import com.learning.springbatch.mongo.batch.JsonProductReader;
import com.learning.springbatch.mongo.batch.MongoProductWriter;
import com.learning.springbatch.mongo.batch.ProductProcessor;
import com.learning.springbatch.mongo.domain.Product;
import com.learning.springbatch.mongo.dto.ProductDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobConfig {

    @Autowired
    private JsonProductReader jsonProductReader;

    @Autowired
    private ProductProcessor productProcessor;

    @Autowired
    private MongoProductWriter mongoProductWriter;

    @Bean
    public Job importProductsJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importProductsJob", jobRepository)
            .start(step1)
            .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
            .<ProductDTO, Product>chunk(10, transactionManager)
            .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
            .processor(productProcessor)
            .writer(mongoProductWriter)
            .build();
    }
}

