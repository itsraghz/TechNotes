# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 71 \
10 Jan 2022 Mon \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Server - Demo

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUxODYwMzEyMTk0/details

```
						Date : 10-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Spring Cloud - Config Server*

*) Config Server : Place all Common KEY=VALs of all MS# at one shared location (Github)

Git:
https://www.youtube.com/watch?v=T2UHpsxJ-2o
https://www.youtube.com/watch?v=38UGVeXuj3Q

-----Coding Part----------------------------------------------------------------
Stage#1 Create one Repository(with properties file) at Github.
a. Goto Register Page
  https://github.com/signup

b. Login using same details
```
un: sample2025nit
pwd: Test2025nit!
```
c. Create new Repository
```
> Click on + Symbol > New Repository > Enter name ex: nit-config-test > Create Repository
```

d. Create Properties file
```
> create a new file > Enter file name ex: application.properties
> enter key=vals > scroll down > click on COMMIT NEW FILE
```
e. Copy Github location of your repository
```
> Click on CODE > Click on Clone (Copy Symbol)
```
Ex:
https://github.com/sample2025nit/nit-config-test.git

--------------------------------------------------------------------------------
Stage#2 Create Config Server

a. Create a project
```
> File > new > Starter Project > Enter name Ex: SpringCloudConfigServer
> Next > Select Config Server Dependency
```
b. At main class : `@EnableConfigServer`

c. At application.properties
---
```java
server.port=8888

spring.cloud.config.server.git.uri=https://github.com/sample2025nit/nit-config-test.git
spring.cloud.config.server.git.username=sample2025nit
spring.cloud.config.server.git.password=Test2025nit!
spring.cloud.config.server.git.default-label=main
```
----
--------------------------------------------------------------------------------
Stage#3 Link Config Server with MS# Application.

a) Add Config Client Dependency in pom.xml (at existed MS# application)

pom.xml
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
(or)
```
> Right click on Project > Add Starters > Config Client > Next > pom.xml > finish
```
b) Add Location of Config Server at MS# application using Properties file
ex: at application.properties
```java
spring.config.import=optional:configserver:http://localhost:8888
```

c) Read key at RestContoller code
```java
package in.nareshit.raghu.rest;
//ctrl+shift+O
@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Value("${my.app.title}")
	private String title;

	@GetMapping("/show")
	public ResponseEntity<String> showMessage() {
		return ResponseEntity.ok("FROM STOCK SERVICE => " + title);
	}
}
```
===Execution Order=============================
```
1. Run eureka server

2. Run Config server

3. Run MS# application

http://localhost:9906/stock/show
```

*) Note:
a. You can use this Config Client at MS# application
b. But must provide Config Server location using key

```
spring.config.import=optional:configserver:http://localhost:8888
```

c. Config server is called first by MS# then at last MS# Register with Eureka Server
