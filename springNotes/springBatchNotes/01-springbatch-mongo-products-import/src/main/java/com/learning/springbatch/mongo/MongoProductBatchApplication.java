package com.learning.springbatch.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoProductBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoProductBatchApplication.class, args);
    }
}

