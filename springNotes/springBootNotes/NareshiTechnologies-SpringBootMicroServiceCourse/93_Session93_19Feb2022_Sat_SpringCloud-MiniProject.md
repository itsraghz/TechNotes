# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 93 \
19 Feb 2022 Sat \
7 00 AM IST - 07 55 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringCloud Mini Project

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5NjMzNDk3ODc2/details

## Contents

```
        Date : 19-02-2022
				 Spring Boot 7AM
				   Mr. RAGHU
	--------------------------------------------------------------
```
			*Mini Project (Spring Cloud)*

1. Eureka Server
  It holds all MS# Details including gateway.
  Details are stored as List<ServiceInstance>.
  ServiceInstance = serviceId + InstanceId + HOST + PORT +LF

Name: EurekaServer
Dep : Eureka Server

> At main class: @EnableEurekaServer

> application.properties
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false


http://localhost:8761
---------------------------------------------------------
2. Config Server :
>> To place common KEY=VAL pairs outside of all MS# application,
   we are using Git Account and Config server.

>> Config Client dependency must be added inside MS# application.


Name: ConfigServer
Dep : Config Server

* At main class: @EnableConfigServer

application.properties
```java
server.port=8888

spring.cloud.config.server.git.uri=https://github.com/sample2025nit/my-config-server-ex.git
spring.cloud.config.server.git.username=sample2025nit
spring.cloud.config.server.git.password=Test2025nit!
spring.cloud.config.server.git.default-label=main
```

http://localhost:8888/actuator/refresh
------------------------------------------------------------------

3. Admin Server:
   This is a central server, where it gathers all MS# Actuator Result using
   Admin Client dependency and makes Result as UI Format.

   Actuator : Production Ready Endpoints for a MS# Application  
     (Health, beans, env, cache, config-props, mapping...etc)

  *) Actuator is given by Spring Boot, Admin Server is from codecentrics

Name: *AdminServer*
Dep : Admin Server

* At main class: @EnableAdminServer

application.properties

```java
server.port=9999
```

http://localhost:9999/applications

-----------------------------------------------------------
4. Gateway Server :-

>> This is common entry and exit point to all MS# applications
>> There can be no direct call made by clientapp(Browser/mobile/3rd party)
  to any MS#.

>>** Even Gateway Server must be register with Eureka.
>> Configure Routing using RouteLocator and RouteLocatorBuilder
   input for 1 MS# : id, path, filters, uri(lb://SID)

Name : *CloudGateway*
Dep  : Gateway, Eureka Discovery Client, JJWT, JAX-B API


At main class:- @EnableEurekaClient

application.properties
```java
server.port=80
spring.application.name=GATEWAY-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
jwt.secret=nitraghu
```
---------------------------------------------------------------------
5. Create one MS# with all required dependencies.

Name : ProductService
Dep  : Spring Web, Data JPA, MySQL, Lombok, Config Client,
	     Eureka Discovery Client,  Actuator, admin client.

a. Entity, Repository, Service, RestController

b. At main class: @EnableEurekaClient

c. application.properties
```java
server.port=8084

#serviceId
spring.application.name=PRODUCT-SERVICE

#Config Server location
spring.config.import=optional:configserver:http://localhost:8888

#DB Connection details
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot9am
spring.datasource.username=root
spring.datasource.password=root

#Data JPA Details
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```
-----------------------------------------------------------------------

*) To execute a logic at Gateway like pre-processing can be done using
  GatewayFilter(I) and override filter() method
  Finally it should return Response with status code

  response.setStatusCode(HttpStatus.UNAUTHORIZED);

  response.setStatusCode(HttpStatus.BAD_REQUEST);

  If no respons status code is set, that is PASS, goes to Eureka for fetching
  ServiceInstance data.

=======Execution Order===============================================================
1. Eureka Server | Config Server | Admin Server
2. All MS# applications | Gateway Server

3. Test using POSTMAN

a)
```
POST  http://localhost/auth/register  SEND
     Body
       (*) raw  [JSON]
{
    "name" : "AJAY",
    "username":"ajay",
    "password": "ajay",
    "roles" : ["ADMIN","USER"]
}
```

b)
```
POST  http://localhost/auth/login  SEND
     Body
       (*) raw  [JSON]
{
    "username":"ajay",
    "password": "ajay"
}
```
c)
```
POST  http://localhost/api/product/create  SEND
     Body
       (*) raw  [JSON]
{
    "code" : "PEN",
    "cost" : 200.0,
    "vendor": "NIT"
}
    Head
 KEY           VALUE
Authorization   <token>
```
d)
```
GET http://localhost/api/product/all  SEND

Head
 KEY           VALUE
Authorization   <token>
```
