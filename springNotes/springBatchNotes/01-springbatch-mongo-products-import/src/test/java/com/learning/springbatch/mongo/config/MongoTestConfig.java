package com.learning.springbatch.mongo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@TestConfiguration
public class MongoTestConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer(DockerImageName.parse("mongo:5.0.15"));
    }

    @Bean
    public MongoClient mongoClient(MongoDBContainer mongoDBContainer) {
        return MongoClients.create(mongoDBContainer.getReplicaSetUrl());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "test");
    }
}

