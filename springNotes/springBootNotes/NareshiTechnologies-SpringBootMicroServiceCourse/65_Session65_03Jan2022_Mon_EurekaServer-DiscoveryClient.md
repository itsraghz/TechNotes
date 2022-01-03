# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 65 \
03 Jan 2022 Mon \
7 30 AM IST - 08 20 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Netflix Eureka Server and Eureka Discovery Client

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwNTEzOTg0Njk5/details

```
						Date : 03-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Cloud : Eureka Server

=> R&D Server = Register and Discovery Server
=> It will JUST STORE DATA of all MS# Instances.
=> Such data is called as ServiceInstance.
=> ServiceInstance = ServiceId + InstanceId + HOST + PORT + LF
           ServiceId = Application-Name
	   InstanceId = Random value
	   HOST = Location/IP
	   PORT = PORT number
	   LF = Load Factor (Current Load/Max Load)

====FAQs==============================================================
Q) Will Eureka make any Http Request to MS# application?
A) NO. Used only for storing data of MS#

Q) What are PUBLISH and FIND Operations?
A)
   PUBLISH : Register a MS# with R&D Server is called as PUBLISH
   FIND    : Fetching other MS# data based on ServiceId

Q) What is ServiceInstance ?
A) Instance - Application running under service successfully after deployment.
   ServiceInstance = All Details of MS# Stored at Eureka Server

    ServiceInstance = serviceId + instanceId + HOST + PORT + LF

    serviceId   => Application Name
    instanceId  => One ID for Instance
    HOST        => Domain Name/IP
    PORT        => Port Number
    LF          => Load Factor (Current Load/Max Load)
========================================================================
Spring Cloud = Gateway + MS# + Eureka Server + Config Server....
-----------------------------------------------------------------------

1. For every MS# component Spring cloud is parent.
2. Spring Cloud has given code for Register with Eureka
3. Every MS# should have key 'register=true'
   But, no need to provide, this is also given by Spring Cloud.

4.*** Even for Eureka Server, Spring cloud is parent.
   So, code for register and 'register=true' also given to eureka

5. ** But Self Register (Eureka Register with Eureka) has no MEANING.
    So, just add register=false onetime.

Q) What if we did not write 'register=false' at Eureka Server?
A) No Error, No Exception, but it creates Object for ServiceInstance.
   which is not used by any MS# or Eureka (It is memory waste).


Q) How Erueka Register looks in Memory?

```
 ------------------Eureka Register-----------------------------------------
   ServiceId       InstanceId            HOST           PORT        LF
 --------------------------------------------------------------------------
  User             User:484210       192.168.0.10       8080       0/200
  User             User:748692       192.168.0.11       8080       0/200
  Inbox            Inbox:74896       192.168.0.14       9696       0/200
  .....
  ....
  ....
 ---------------------------------------------------------------------------
 ```

*) Two instances alwasy runs with combination unique of HOST and PORT
*) InstanceId is optional incase of Single Instance, else WE(Programmer)
   has to define one Number using 'instance-id=<someValue>'

==========Coding Part=================================================
1. Eureka Server

S#1 Create Project
Name : SpringCloudEurekaServer
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
===================================================================
2. MS# Coding

S#1 Create Application
Name : SpringCloudProductservice
Dep  : Spring Web, Eureka Discovery Client
----
S#2 At main class (to Register with Eureka)
```
@EnableEurekaClient
```
---
S#3 at Properties file
```java
 server.port=9096
 # ServiceId (any value is fine)
 spring.application.name=PRODUCT-SERVICE
 # Eureka Server Location (to register)
 eureka.client.service-url.defaultZone=http://localhost:8761/eureka
 # Instance Id (optional for one Instance)
 eureka.instance.instance-id=${spring.application.name}:${random.value}
```
----
S#4 Define one RestController

```java
package in.nareshit.raghu.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	public ResponseEntity<String> showMessage() {
		return ResponseEntity.ok("WELCOME TO PRODUCT SERVICE!");
	}
}
```
===================================================================
3. Create Multiple Instances (additional Work at MS#)

=> Just run application with different IP/PORT combination
=> Now I can not take another SySTEM so usin different PORT to run.

---Execution Order----------------------
1. Run Eureka Server
2. Run MS# (ProductService) main class
3. modify Port Number and run again
   (Repeate Same)

=====FAQs=========================================================
Q) What is default recomanded PORT number for Eureka Server?
A) 8761, we can even modify this using key 'eureka.client.service-url.defaultZone'
   ex:
   eureka.client.service-url.defaultZone=http://localhost:9696/eureka
   server.port=9696

Q)What is Eureka Dashboard? How can we see this?
A) Dashboard is HTML Generated File by eureka, we can view MS# Instance Details
   using URL: http://localhost:8761/

Q) What if we keep `'eureka.client.register-with-eureka=true'`
   and Run Eureka Server?

A) Eureka Creates itself ServiceInstance with UNKNOWN name which has no use
   and memory waste.

   Programmer has modify default value to 'false'
    `eureka.client.register-with-eureka=false`

Q) What is ${random.value} in properties?
A) It internally calls 'RandomValuePropertySource'(C) and generates one
   Random value as InstanceId using UUID internally
   [Universally Unique IDentifier --JDK 1.5]

Q) What is the valid input for Instanceid?
A) By using key `'eureka.instance.instance-id=<any-value>'`
   We can provide any String data, but Spring Cloud recomanded to use
   ApplicationName-RandomValue Syntax.
