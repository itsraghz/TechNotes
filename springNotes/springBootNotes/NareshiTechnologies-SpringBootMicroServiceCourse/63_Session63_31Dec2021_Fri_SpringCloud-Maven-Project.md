# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 63 \
31 Dec 2021 Fri \
7 30 AM IST - 08 25 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Maven Project

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwMzgwOTY5MjQy/details

```
						Date : 31-12-2021
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*) Spring Boot is a common parent for All Spring Boot Application created by Developer
   which gives AutoConfiguration (reduces Coding) for concepts like Web Mvc, Rest,
    Data JPA..etc

*) But this time we have new Parent ie "SPRING CLOUD" that gives AutoConfiguration for
   Microservices components, Eureka Server, Config Server, Gateway..etc

*) Maven supports only one parent for one child project at a time.
  [Like Multiple Inheritance is not supported in Java]

*) So, Maven says use one as PARENT and another one as link "DEPENDENCY-MANAGEMENT"

*) BOM : Bill Of Materials :-
  Adding one parent maven project to our child project using <dependencyManagement> tag
  is called as BOM. (in simple 2nd parent as a link in Child).

=========================================================================
Java Version   : 8/11/Latest
Spring Version : 5.x [5.3]
Spring Boot Version : 2.6.2
Spring Cloud Version: 2021.0.0 (Old version names: Angel, Brixton, Camden ..etc)
https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-parent
