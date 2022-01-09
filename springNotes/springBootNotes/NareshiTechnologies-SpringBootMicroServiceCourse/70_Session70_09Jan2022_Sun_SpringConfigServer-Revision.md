# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 70 \
09 Jan 2022 Sun \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Server (Revision)

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDMxOTkwNjgzODQ1/details

```
						Date : 09-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Spring Cloud - Config Server*

*) Multiple Miroservices exist in our Project .
	ex: UserService, ProfileService, Settings..etc

*) Every MS# internally Spring Boot ReST Application.
*) So, Every MS# contains one properties file to store KEY=VALs
*) Multiple/All MS# can have common KEY=VALs
*) Such common keys-vals, We can place outside of All MS# ie called as Config Server.
  [Shared Properties file for all MS#]

---Eureka Server---------------------------
```
#1. We can create and Run Eureka Server
```

---Config Server (CS)-----------------------------
```
#1 Config server Recomanded port number is : 8888
   [We can even modify]

#2 CS even contains application.properties that holds location of Github properties

#3 CS makes request to Load data

#4 Github validates it and find that application.properties

#5 Response is given back to CS Application

#6 CS Stores all KEY=VALs as container Memory Known as "Environment"
```
---------MS# Application-------------------------
```
**** Before Running MS#, First Run Eureka and Config Server (in any order).

#1 Code and Run MS# application

#2 Config Client is added to MS# Application

#3 Client makes request to Config Server to get data

#4 Environment is found and copied at CS

#5 Same data is Returned as Response to Config Client.

#6 Update with MS# Propeties data.

#7 After finishing all MS# setup, finally Register with Eureka.
```
