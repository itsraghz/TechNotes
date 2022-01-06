# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 67 \
06 Jan 2022 Thu \
7 30 AM IST - 08 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud FeignClient

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUxMjExOTYxNzcy/details

```
						Date : 06-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Intra Communication:-
 If one MS# wants to communicate with another MS# ie called as "Intra Communication".

Clients To fetch data from Eureka Server:-
a. DiscoveryClient(Legacy)
b. LoadBalancerClient
c. FeignClient (Abstract client).

--LoadBalancerClient(I) --------------
 This is interface given by Spring Cloud LoadBalancer,
 Impl class Name is : 'BlockingLoadBalancerClient'(C).

 choose(serviceId): It gets always an instance from Eureka which has Less Load Factor
    If all/multiple instances having same Load Factor, then choose any one Instance
    in random.

 Above Method Returns : ServiceInstance(I), Impl class is : EurekaServiceInstance(C)
 By using ServiceInstance object reference we can get details like:
   serviceId, instanceId, Host/PORT (URI), ..etc

======FeignClient================================================
=> It is a abstract class or declerative client.
=> Programmer you need to provide details, no coding is required.
   Code is generated at runtime (like Proxy)

=> Inputs/Details : serviceId, path, HttpMethod, Request and Response Formats.
=> it is also called as OPEN FEIGN. Just define one interface with above details.
   at runtime one class is generated with LoadBalancerClient(I) only (internally).

======Code Changes=====================================================
a. At OrderRestController
```
> Right click on Project > Spring > Add Starters > Select OpenFeign > next
> Choose pom.xml > finish
```
 (or add this manually)
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
----------------------------------------------
> Comment : loadbalancer in pom.xml
----------------------------------------------

b. At OrderService main class: `@EnableFeignClients`
-----------------------------------------------
c. Consumer Interface
```java
package in.nareshit.raghu.consumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("STOCK-SERVICE")
public interface IStockConsumerFeign {

	@GetMapping("/stock/show")
	public ResponseEntity<String> showMessage();
}
```
----------------------------------------------

d. Remove (or) comment LoadBalancerClient(I) Consumer code.

e. Modified RestController at OrderService
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.consumer.IStockConsumerFeign;

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
}
```
f.*** No code changes at "StockService". (or producer code remains same).

============Execution Order====================================
1. Eureka Server

2. Run MS#1 StockService (3 times by changing port number)

3. Run MS#2 OrderService (1 time)

4. Goto Eureka and check at dashboard

5. Enter URL like
  http://localhost:8600/order/data

*) Dynamic Proxy class using Reflection and Interface input using Templates.
https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
