# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 69 \
08 Jan 2022 Sat \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Server

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUxNjg3MzgyODg0/details

```
						Date : 08-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Spring Cloud - Config Server*

*) Config Server: Common place where it contains all KEY-VALs for MS#.

=> Every MS# contains application.properties (it is a Spring Boot Rest application)
=> Multiple MS# may have some common key-vals repeated in Properties file
	ex: eureka server location.

=> Such common key-vals we can place outside of all MS# apps, ie Config Server.


====Config Server and MS# WorkFlow========================
```
S#1 Create one Github Account,
    Create a new Repository
    Create one application.properties file
    Place there all MS# Common KEY-VALs

S#2 Create one Mediator Server : Config Server
	(That runs on PORT : 8888)

S#3 create one application.properties file
  that JUST contains Location of Github properties file


S#4 When we start ConfigServer, it will request to
	Load data from Github Location

S#5 Once Data is loaded into ConfigServer.

S#6 CS(Config Server)creates one object to Environment,
    that holds all KEY-VALs

-------(for every MS# applicaion 1 time)-----
S#7 Now Create a MS# application with all required
    dependencies and properties file

S#8**** Add Config Client Dependency and provide
	Config Server location to fetch KEY-VALs

S#9 Request is made to Config Server to Load data
    and gets data Config Client back

S#10 MS# application merge both local + runtime keys
    and starts application

S#11 Finally Register with Eureka server.
```
