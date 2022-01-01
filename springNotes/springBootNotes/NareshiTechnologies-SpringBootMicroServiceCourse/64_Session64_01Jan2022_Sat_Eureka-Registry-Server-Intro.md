# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 64 \
01 Jan 2022 Sat \
7 30 AM IST - 07 55 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Netflix Eureka Server Intro

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwNDI0MzE4NDc5/details

```
						Date : 01-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Microservice Component : Register and Discovery

*) Register and Discovery [R&D]:-
=> It is a server that holds all detils of Microservice.
 Like applicatioName(serviceId), randomValue For Instance(InstanceId),
			Location(IP/HOST), PORT , Load Details (LoadFactor)...

=> R&D will never make HTTP request to any MS#.
=> R&D will store data of MS# only.
=> If any MS# wants another MS# data then it will share based on serviceId.
=> PUBLISH : Provide MS# details to R&D Server
	FIND    : Get Other MS# data based on ServiceId

=> R&D Server : Netflix Eureka Server.

=> In simple Eureka Server stores all MS# ServiceInstance details

	 ServiceInstance = serviceId + instanceId + HOST + PORT + LF

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
