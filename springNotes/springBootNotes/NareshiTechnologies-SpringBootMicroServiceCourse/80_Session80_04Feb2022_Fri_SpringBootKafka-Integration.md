# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 80 \
04 Feb 2022 Fri \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

> Reason for delay in the past 1 week or so : Facutly got impacted with COVID.

# Agenda

* SpringBoot Kafka Integration

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDY1MTU3MDgwMTA4/details

```
						Date : 04-02-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Boot + Apache kafka Integration

=> Spring Boot supports Integration with Apache Kafka.
ie We can write Producer (or) Consumer [Even Both] using Spring Boot.

=> We must pass connection details to write Producer/Consumer.
=> KafkaTemplate<K,V> [K=TopicName , V=data] is used at Producer
that will send data to Kafka s/w.
=> @KafkaListener(topicName) is used at Consumer, that reads data from kafka s/w.

=> Spring For Apache Kafka must be added in application.
--- pom.xml -------
```xml
<dependency>
	<groupId>org.springframework.kafka</groupId>
	<artifactId>spring-kafka</artifactId>
</dependency>
```
---Connection keys-------------------------
```java
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer


spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.group-id=sample

my.tpc.name=nit-one-test
```
-----------------------------------------------
