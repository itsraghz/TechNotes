# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 66 \
04 Jan 2022 Tue \
7 30 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud LoadBalancerClient

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwNzA4MDM0NDY1/details

```
						Date : 04-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Eureka Server : it is a Register, Stores MS# Data.
> MS# must have Eureka Client Dependency
> Location of Eureka Server
> ServiceId (applicationName), instanceId(random value)

====================================================================
Intra communication:
> if one MS# wants to communicate with another MS# to send/receive data
  then use any one of below client.

  a. DiscoveryClient (Legacy Client)
  b. LoadBalancerClient (Latest)
  c. ****Open Feign (Abstract Client)

=> Do not hardcode URL to make HTTP call.

==Example======================================
*) We are developing 2 MS# those are Stock and OrderServices
*) Stock is running as multiple instances to handle lots of orders.
*) Now Order wants to make request to Stock Service (multiple instance)
*) For every instance IP/PORT combination is different.
   So, never hard code URI Details in Request call.

**** Fetch URI Details from Eureka and add path ie URL, finally make a call.
**** To fetch Data use LoadBalancerClient(I), every time it will fetch different
     instance(an instance that has Less Load Factor)

Q) Why Consumer or LoadBalancerClient(I) is used?
A) To fetch MS# data (URI=HOST+PORT) to make http call to another MS#
   by adding path we can get URL and use RestTemplate.

Q) What is ServiceInstance ?
A) Instance - Application running under service successfully after deployment.
   ServiceInstance = All Details of MS# Stored at Eureka Server

    ServiceInstance = serviceId + instanceId + HOST + PORT + LF

    serviceId   => Application Name
    instanceId  => One ID for Instance
    HOST        => Domain Name/IP
    PORT        => Port Number
    LF          => Load Factor (Current Load/Max Load)

========(coding)============================================================================
1. Eureka Server

S#1 Create Project
Name : *SpringCloudEurekaServer*
Dep  : Eureka Server

[ pom.xml : `spring-cloud-starter-netflix-eureka-server` ]

S#2 AT Main class
```
@EnableEurekaServer (It converts normal Cloud Application into a Register)
```

S#3 at properties files
```
server.port=8761
eureka.client.register-with-eureka=false
```
----------------------------------
2. MS# application-1

S#1 Create Project
Name : *SpringCloudStockService*
Dep  : Spring Web, Eureka Discovery Client

S#2 AT Main class
```java
@EnableEurekaClient
```

S#3 at properties files
```
server.port=9904
spring.application.name=STOCK-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.instance.instance-id=${spring.application.name}:${random.value}
```

S#4 REstController
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/show")
	public ResponseEntity<String> showMessage() {
		return ResponseEntity.ok("FROM STOCK SERVICE => " + port);
	}
}
```
----------------------------------------------------
3. MS# application-2

S#1 Create Project
Name : *SpringCloudOrderService*
Dep  : Spring Web, Eureka Discovery Client, Cloud Load balancer

S#2 AT Main class
```java
@EnableEurekaClient
```

S#3 at properties files
```
server.port=8600
spring.application.name=ORDER-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
#eureka.instance.instance-id=${spring.application.name}:${random.value}
```
S#4 RestController
```java
package in.nareshit.raghu.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@GetMapping("/data")
	public ResponseEntity<String> findOrder() {
		return ResponseEntity.ok("FROM ORDER!");
	}
}
```
=======***** WRITING CONSUMER **********========================
```java
package in.nareshit.raghu.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockConsumer {

	//1. Autowire LoadBalancerClient
	@Autowired
	private LoadBalancerClient client;

	public String getDataFromStock() {
		//2. Goto Eureka to get one SI using one serviceId
		ServiceInstance si = client.choose("STOCK-SERVICE");

		//3. read URI and add path (=URL)
		String url = si.getUri() + "/stock/show";

		//4. Use RestTemplate
		RestTemplate rt = new RestTemplate();

		//5. make call and get Response
		ResponseEntity<String> response = rt.getForEntity(url, String.class);

		//6. return response body
		return response.getBody();
	}
}
```
============Modified RestController================
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.consumer.StockConsumer;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private StockConsumer consumer;

	@GetMapping("/data")
	public ResponseEntity<String> findOrder() {
		String msg = consumer.getDataFromStock();
		return ResponseEntity.ok("FROM ORDER! ==> " + msg);
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
  http://localhost:8600/order/data
```
