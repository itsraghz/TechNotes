# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 61 \
28 Dec 2021 Tue \
7 30 AM IST - 08 25 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Monolithic Vs MicroServices

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwMjQyMzU3MDk2/details

```
						Date : 28-12-2021
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Monolithic Application: All Services code together as a single application
			(single .jar/.war Build file is created)
Advantages:
a. Easy to develop, compile and build as it is one application.
b. Testing and Modification of code is easy process.
c. Service Integration can be done in easy way.
d. Follows one standard F/w or Technologies.

Limitations:
a. While Deployment, if one service is failed(some exception) then it may effect
   complete Deployment (or) other services functionality.

b. If code modifiation is done, then re-build and re-deploy is required.
c. As no.of services gets increased then build and deployment time is increased.
d. We can not add/enhance/Integrate other technologies not is such a easy way
   some time re-design is required.
e. Services Depenendency is very high (Tightly coupled Services = High cohesion)
f. In case of LoadBalancing all Services gets memory, we can not do only for
   specific services.
g. Resource utilization may not be done in effective manner.
===================================================================================
Microservices:-
=> An Independent Deployable components
=> A De-coupled Architecture
=> One Service as one application that supports less cohesion (and loose coupled)
   and more effective Resource utilization.
=> Microservices are implemented using Webservice concept, ie integrate applications
   using HTTP and Global Data Format.
================================================================================
Q) What is cohesion and coupling?
A)

Q) What is the diff b/w Webservices and Microservices?
A)
Webservices : Connecting two applications running at diff servers
```
		(App#1 --------------- App#2)
		  Java                  .net
```			
Microservices : 1 Application implemented as multiple Applications internally
		ie 1 Service as 1 Application and finally implement and
		connect using Webservices

1 Amazon App => 1 Search Project +(WS)+ 1 Cart Project +(WS)+ 1 Payment Project
-------------------------------------------------------------------------------
Q) Cloud Computing? Example Cloud Providers?
A) using services for rental

=> To deploy we need high configuration servers and OS with S/w
   those are provided for rental known as Cloud Computing
```
   Hardware = N/w, HDD, RAM ==> IaaS
   Virtual OS= Windows Server, Linux ..=> PaaS
   Software  = JRE, Tomcat, Database, Docker, ..etc=> SaaS

   AWS, Google (GCP), MS-Azure, PCF, Heroku..etc
```
Q) Spring Cloud?
A) Spring Cloud is not "Cloud Computing", it is a API (Classes/Interface-->JAR)
   used to implement Java application with Microservices Design.

     OOPs     Core Java
     ORM      Hibernate
     Microservices -- Spring Cloud
     (Theory/Design)   (Coding)

====================================================================================
