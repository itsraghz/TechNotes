# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 85 \
11 Feb 2022 Fri \
7 15 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringCloud Gateway

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5MDU4Mzc3NDQ0/details

```
						Date : 11-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Security
https://www.youtube.com/watch?v=XTyQIrlyWfQ
https://www.youtube.com/watch?v=7wA46kRh2u8
https://www.youtube.com/watch?v=oLlSs-p6OEs
https://www.youtube.com/watch?v=cnrJ-Nnvoik
https://www.youtube.com/watch?v=rgG2_T-OB8g

JWT Security
https://www.youtube.com/watch?v=feETfZbvu-k
https://www.youtube.com/watch?v=Hzkw846jIOU
https://www.youtube.com/watch?v=bJAsHOH4lMk


			*Spring Cloud Gateway*

Cloud Gateway : This is common entry and exit point to full MS# setup
 here we can handle Routing, Filters, Security.


1. Routing : Identify MS# and execute it based on request PATH.

Static Routing:
  Execute Directly MS# (need not to goto Eureka) incase of single instance.

ex:
`uri= http://localhost:9696/`

Dynamic Routing:
  Goto Eureka, Get an instance that has less load factor,
  get ServiceInstance data, now make call to MS#.

ex:
`uri= lb://EMPLOYEE-SERVICE`

2. Filters: Add/Modify/Validate Request/Response Headers, Body..etc

3. Security : Token based[JWT] or Oauth 2.x

Q) What is old gateway name?
A) Netfilx Zuul (it is removed).
   New Gateway is Spring Cloud Gateway

*) Routing Configuration
    id         : anyOne Unique value for configuration
    Path       : What is common path conatins by URL
    Filters    : Modification/Validation
    Uri        : Location (static, dynamic)

*) Even Gateway also one type of MS# application, it needs to be register
	with Eureka Server.

==Full Example=======================================================

1. Eureka Server
Name : *SpringCloudCGEurekaServer*
Dep  : Eureka Server

> At main clas: `@EnableEurekaServer`

application.properties
```java
server.port=8761

eureka.client.fetch-registry=false
eureka.client.register-with-eureka=false
```
------------------------------------
2. MS# Application

Name : *SpringCloudCGEmployeeService*
Dep  : Spring Web, Eureka Discovery Client

> At Main class: `@EnableEurekaClient`

application.properties
```java
server.port=9960
#ServiceId
spring.application.name=EMPLOYEE-SERVICE
#Eureka Location
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
#InstanceId
eureka.instance.instance-id=${spring.application.name}:${random.value}
```

*RestController*
```java
package in.nareshit.raghu.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Value("${server.port}")
	private String port;

	@GetMapping("/show")
	public ResponseEntity<String> showData() {
		return ResponseEntity.ok("HELLO DATA!"+port);
	}
}
```
--------------------
3. Cloud Gateway

Name : *SpringCloudCGGatewayService*
Dep  : Cloud Gateway, Eureka Discovery Client

> at main class : `@EnableEurekaClient`

application.properties
```java
#Server port
server.port=80

#ServiceId
spring.application.name=GATEWAY-SERVICE

#Eureka Location
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

>**** Configuration class for Routing
```java
package in.nareshit.raghu.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//For which URL, Where to Go?
@Configuration
public class GatewayCloudConfig {
	@Bean
	public RouteLocator configure(RouteLocatorBuilder builder) {
		return builder.routes()

				.route(
						"employeeServiceId", //ID
						r->r.path("/employee/**") //PATH
						//.uri("http://localhost:9960") //URI-static
						.uri("lb://EMPLOYEE-SERVICE") //URI-dynamic
						)

				/*.route(
						"productServiceId", //ID
						r->r.path("/product/**") //PATH
						.uri("lb://PRODUCT-SERVICE") //URI-dynamic
						)*/


				.build();
	}
}
```
==========Test application================
```
1. Run Eureka Server

2. Run MS# application 3 times

3. Run Gateway

4.  Enter URL: http://localhost:8761/

   Click on Gateway service and Modify URL as

   http://localhost/actuator/info
   To
   http://localhost/employee/show

   http://IPofGateway:PORTofGateway/MS#Path/MS#Path


*) Note:
a. Gateway main usage is Routing that can be configured using
   RouteLocatorBuilder

b. One RouteLocatorBuilder contains List<Route>

c. One Route Contains id(any Unique name), PATH(Common Path of MS#)
	Filter (optional), URI(static/Dynamic)

d. *** Mostly used one is Dynamic Routing
      lb://SERVICE-ID  (of MS# application)

e. One Routing Configuration for One MS# application

.route(
	"employeeServiceId", //ID
	r->r.path("/employee/**") //PATH
	.uri("lb://EMPLOYEE-SERVICE") //URI
)

f. Execution Flow

 Browser ---> Request ---> Gateway ---> Read URL Path ---> Select URI
 --> Goto Eureka --> select an Instance which has less load Factor
 ---> one ServiceInstance is selected by Gateway ---> Call MS#
 ---> Get Response Back ---> Send it to client.

g. By Default Cloud gateway having LoadBalancer, need not to implement
   anything manually.
```
=======================================================
Filters:- Validate/Modify Request/Response data by default

>> These are optional to use.
>> Generally to check Headers, Modify Headers, Request Params,
   ..etc
     Authorization =__________ is this exist or not?

     MyAppToken = ABCD123 (to add this)

--Example : add Request/Response Headers ------------------

*) Code Modifications at GatewayConfiguration class
```java
package in.nareshit.raghu.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//For which URL, Where to Go?
@Configuration
public class GatewayCloudConfig {

	//Input : RouteLocatorBuilder
	//Output: RouteLocator
	@Bean
	public RouteLocator configure(RouteLocatorBuilder builder) {
		return builder.routes()

			//1 Route = 1 Id, 1 Path, 1-n Filters , 1 URI
			.route("employeeServiceId",
				r->r.path("/employee/**")
				.filters(
					f->f.addRequestHeader("sample", "test-reqHeader")
					.addResponseHeader("abcd", "test-responseHeader")
					)
				.uri("lb://EMPLOYEE-SERVICE")
				)


			.build();
	}
}
```

*) Code Modifications at EmployeeRestController
```java
package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/show")
	public ResponseEntity<String> showData(
			@RequestHeader String sample
			)
	{
		return ResponseEntity.ok(sample+"HELLO DATA!"+port);
	}
}
```
======================================================================
			 (Todays Task)
			Distributed Tracing
		    Spring Cloud Sleuth & Zipkin

Video Link:
https://www.youtube.com/watch?v=dkLsuDhDo_g

Code , Image and Notes:
https://gitlab.com/javabyraghu/springcloudzipkinandsleuth


*) In general if Request is made by client and execution (calling MS#)
   is done by Gateway.

*) Some times more then one MS# is called, in such case we want to find

  >> How Many MS# are executed for current request
  >> What is the Execution Path
  >> What are controllers and methods called
  >> What is the time take for a method and total.

*) For this Spring cloud has provided tools : Sleuth & Zipkin

=============================================================

sleuth and zipkin
-------------------
spring-cloud-starter-sleuth, spring-cloud-starter-zipkin
Download Link:
https://www.mediafire.com/file/jmpqrenm0yudehy/ZipkinExecutable.zip/file
Cmd : java -jar zipkin-server-2.12.9-exec.jar
URL : http://localhost:9411/zipkin/
---Microservices Sample Code-----
#1. application.properties
-----------------------
server.port=8081
spring.application.name=SAMPLE-APP-ONE
logging.file.name=d:/myapp.log
-------------------------
#2. Java Config File
package in.nit.raghu;
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
---------------------------------
#3 RestController
package in.nit.raghu;
@RestController
public class AppOneRestController {

	private static Logger log=LoggerFactory.getLogger(AppOneRestController.class);
	@Autowired
	private RestTemplate rt;

	@GetMapping("/showA")
	public String showA() {
	   log.info("WELCOME TO SERVICE#1");
	  String msg=rt.getForObject("http://localhost:8082/showB", String.class);
	  log.info("BACK TO SERVICE #1,Msg"+msg);
	  return "DONE";
	}
}
-----------------------------------------
