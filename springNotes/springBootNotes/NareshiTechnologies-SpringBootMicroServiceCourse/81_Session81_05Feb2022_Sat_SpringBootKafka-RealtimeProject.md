# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 81 \
05 Feb 2022 Sat \
7 30 AM IST - 08 20 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot Kafka Realtime Project

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDY1NDU4Njc3ODg4/details

```
						Date : 05-02-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring boot + Apache Kafka Integration Example


Coding Steps:-

a. Create Spring Boot application
Name: SpringBootKafkaAppEx
Dep : Web, Data JPA, MySQL, Lombok, Spring For Apache Kafka
----------------------
b. application.properties
```java
# server
server.port=9988

# topic name
my.topic.name=my-tpc

# Producer keys
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer

# Consumer keys
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.group-id=sample-id

#Database connection keys
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

# ORM Keys
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```
-----------------------------------

c. Entity
```java
package in.nareshit.raghu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="stock_quote")
public class StockQuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	private Long id;

	@Column(name="stock_code")
	private String code;

	@Column(name="stock_uprice")
	private Double unitPrice;

	@Column(name="stock_dtetime")
	private Date dateTime;
}
```
----------------
d. Repository
```java
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.StockQuote;

public interface StockQuoteRepository extends JpaRepository<StockQuote, Long> {

}
```
-------------------------------------
e. MessageStore
```java
package in.nareshit.raghu.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.StockQuote;
import in.nareshit.raghu.repo.StockQuoteRepository;

@Component
public class MessageStore {

	@Autowired
	private StockQuoteRepository repo;

	public void create(StockQuote quote) {
	repo.save(quote);
	}

	public List<StockQuote> fetchAll() {
	return repo.findAll();
	}
}
```
-----------------------------
f. JsonUtil

```java
package in.nareshit.raghu.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nareshit.raghu.entity.StockQuote;

@Component
public class JsonUtil {

	public String toJson(StockQuote quote) {
		try {
			return new ObjectMapper().writeValueAsString(quote);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public StockQuote fromJson(String json) {
		try {
			return new ObjectMapper().readValue(json, StockQuote.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
```
---------------------------------
g. Producer Service

```java
package in.nareshit.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.StockQuote;
import in.nareshit.raghu.util.JsonUtil;

@Component
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> template;

	@Value("${my.topic.name}")
	private String destination;

	@Autowired
	private JsonUtil jsonUtil;

	public void sendData(StockQuote quote) {
		String data = jsonUtil.toJson(quote);
		template.send(destination, data);
	}
}
```
--------------------------------
h. Consumer Service
```java
package in.nareshit.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.StockQuote;
import in.nareshit.raghu.store.MessageStore;
import in.nareshit.raghu.util.JsonUtil;

@Component
public class Consumerservice {

	@Autowired
	private MessageStore store;

	@Autowired
	private JsonUtil jsonUtil;

	@KafkaListener(topics = "${my.topic.name}")
	public void readData(String message) {
	StockQuote obj = jsonUtil.fromJson(message);
	store.create(obj);
	}
}
```
-----------------------------
i. RestController
```java
package in.nareshit.raghu.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.StockQuote;
import in.nareshit.raghu.service.ProducerService;
import in.nareshit.raghu.store.MessageStore;

@RestController
public class MyKafkaRestController {

	@Autowired
	private MessageStore store;

	@Autowired
	private ProducerService service;

	//1. send data .../send?code=__&up=___
	@GetMapping("/send")
	public ResponseEntity<String> send(
		@RequestParam String code,
		@RequestParam Double up
		)
	{
		StockQuote quote = new StockQuote();
		quote.setCode(code);
		quote.setUnitPrice(up);
		quote.setDateTime(new Date());

		service.sendData(quote);

		return ResponseEntity.ok("DATA IS SENT");
	}

	//2. view data
	@GetMapping("/all")
	public ResponseEntity<List<StockQuote>> fetchData() {
		List<StockQuote> list = store.fetchAll();
		return ResponseEntity.ok(list);
	}

}
```
====================Execution Order====================
1. run zookeeper
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

2. run kafka server setup
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

3. Run your Spring boot main class

4. Enter URLs for testing

```
http://localhost:9988/send?code=NIT&up=120.36
http://localhost:9988/send?code=NIT&up=265.12
http://localhost:9988/all
```
