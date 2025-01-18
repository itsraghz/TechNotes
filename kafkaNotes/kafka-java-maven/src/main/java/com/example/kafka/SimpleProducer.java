package com.example.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SimpleProducer {
    public static void main(String[] args) {
        // Create producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            // Send messages
            for (int i = 1; i <= 3; i++) {
                String message = "Message-" + i;
                ProducerRecord<String, String> record = 
                    new ProducerRecord<>("example-topic", message);

                // Send record and get metadata
                RecordMetadata metadata = producer.send(record).get();
                System.out.printf("Sent message: %s to topic: %s%n", 
                    message, metadata.topic());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

