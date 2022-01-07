# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 68 \
07 Jan 2022 Fri \
7 30 AM IST - 08 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud FeignClient - Get, Post Methods

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUxNDU0NTkzMzU3/details

```
						Date : 07-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Open Feign [ Feign Client ]

=> Abstract class, just define interface with all inputs : Path, HttpMethod,
ReturnType and Parameter.

=> need not to match Interface and MethodNames.

=> In simple Feign Interface is a abstract format of ProducerRestcontroller.

=> Annotation at main class: @EnableFeignClients
=> At Interface Level: @FeignClient(serviceId)

========Examples using different HttpMethods===================================
S#1 Define one interface with any name
S#2 Provide serviceId using annotation : `@FeignClient(serviceId)`
S#3 Copy Entity/Model class if it is used in Method ReturnType/Parameter.
S#4 Create one abstract method for One RestController method.

S#5 At main class of Consumer application add : `@EnableFeignClients`
S$6 At pom.xml , add OpenFeign (or)
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

*) Note: need not to define all methods in Feign Client,
	just provide how many you want to access.



GET http://localhost:8600/order/data/999 POST

========(coding)============================================================================
1. Eureka Server

S#1 Create Project
Name : *SpringCloudEurekaServer*
Dep  : Eureka Server

[ pom.xml : `spring-cloud-starter-netflix-eureka-server` ]

S#2 AT Main class
`@EnableEurekaServer` (It converts normal Cloud Application into a Register)

S#3 at properties files
```
server.port=8761
eureka.client.register-with-eureka=false
```
----------------------------------
2. MS# application-1

S#1 Create Project
Name : *SpringCloudStockService*
Dep  : Spring Web, Eureka Discovery Client, Lombok

S#2 AT Main class
@EnableEurekaClient

S#3 at properties files

```
server.port=9904
spring.application.name=STOCK-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.instance.instance-id=${spring.application.name}:${random.value}
```
-------------------
S#4 Model class
```java
package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

private Long id;
private String code;
private Integer qty;
private Double cost;
}
```
-----------------

S#5 REstController
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Stock;

/***
* This is producer Micro services,
* adding different methods here.
*/
@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/show")
	public ResponseEntity<String> showMessage() {
			return ResponseEntity.ok("FROM STOCK SERVICE => " + port);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Stock> getOneStock(
			@PathVariable Long id
			)
	{
			return ResponseEntity.ok(new Stock(id,"ABC",150,200.0));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createStock(
				@RequestBody Stock stock
				)
	{
			return ResponseEntity.ok(stock.toString());
	}

}
```
----------------------------------------------------
3. MS# application-2

S#1 Create Project
Name : *SpringCloudOrderService*
Dep  : Spring Web, Eureka Discovery Client, Open Feign, Lombok

S#2 AT Main class
```java
@EnableEurekaClient
@EnableFeignClients
```

S#3 at properties files
```
server.port=8600
spring.application.name=ORDER-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
#eureka.instance.instance-id=${spring.application.name}:${random.value}
```
-------------------------------------
S#4 Consumer Interface
```java
package in.nareshit.raghu.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.nareshit.raghu.model.Stock;

@FeignClient("STOCK-SERVICE")
public interface IStockConsumerFeign {

	@GetMapping("/stock/show")
	public ResponseEntity<String> showMessage();

	@GetMapping("/stock/find/{id}")
	public ResponseEntity<Stock> getOneStock(
			@PathVariable Long id);

	@PostMapping("/stock/create")
	public ResponseEntity<String> createStock(
			@RequestBody Stock stock);
}
```
--------------------------
S#5 Model class
```java
package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

		private Long id;
		private String code;
		private Integer qty;
		private Double cost;
}
```
--------------------------
S#6 RestController
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.consumer.IStockConsumerFeign;
import in.nareshit.raghu.model.Stock;

@RestController
@RequestMapping("/order")
public class OrderRestController {

		@Autowired
		private IStockConsumerFeign consumer;

		@GetMapping("/data")
		public ResponseEntity<String> findOrder() {
			System.out.println(consumer.getClass().getName());
			String msg = consumer.showMessage().getBody();
			return ResponseEntity.ok("FROM ORDER! ==> " + msg);
		}

		@GetMapping("/data/{id}")
		public ResponseEntity<Stock> getStockById(
				@PathVariable Long id
				)
		{
			Stock stock = consumer.getOneStock(id).getBody();
			return ResponseEntity.ok(stock);
		}

		@PostMapping("/create")
		public ResponseEntity<String> placeOrderStock(
				@RequestBody Stock stock
				)
		{
			String message = consumer.createStock(stock).getBody();
			return ResponseEntity.ok(message);
		}
}
```
============Execution Order====================================
```
1. Eureka Server

2. Run MS#1 StockService (3 times by changing port number)

3. Run MS#2 OrderService (1 time)

4. Goto Eureka and check at dashboard

5. Enter URL like
GET http://localhost:8600/order/data/108 SEND
-----------------------------------------------------
POST http://localhost:8600/order/create SEND
{
"id"    : 6520,
"code"  : "MNO",
"qty"   : 250,
"cost"  : 300.25
}
-----------------------------------------------------
```
