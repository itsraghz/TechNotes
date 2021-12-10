# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 49 \
10 Dec 2021 Fri \
7 05 AM IST - 7 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Introduction

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ1NTU5OTA4OTM3/details

```
						Date : 10-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Boot ReST + Angular Crud Application
https://www.youtube.com/watch?v=LE3KvvhkUkM
https://www.youtube.com/watch?v=Do87D4TJ9M8
https://www.youtube.com/watch?v=gkp-Mhxuxjo
https://www.youtube.com/watch?v=lpPiM5MIAoQ
https://www.youtube.com/watch?v=Iax4vA4MEPU


				Webservices

*) Webservices is a process of creating communication link between two or more
   applications which are running at different/same servers.

*) By using Webservices we can code for IL(Integration Layer) not for PL/SL/DAL.

*) Two applications required at least,
   a. Producer (Which gives service)
   b. Consumer (Which reads service)

   ------------------------------------------------------------------------
   			  Spring Boot ReST

ReST - It is a design that uses HTTP protocol and Global Data Formats(XML/JSON)
	to link applications.

Re  = Representation     [in generic/global format]
S   = State              [Data]
T   = Trasfer            [Send/Receive]

*) ReST = It is a architectural design pattern used for communication/link.

*) Here, we have no UI in Webservices concept.
*) We work on RestController.
  Normal Controller (@Controller) is bounded to one UI (java technology)
   [ex: JSP, Thyemeleaf, JSF..etc]

  Where RestController is not bounded to any UI,
  it gives data as output: Text, JSON, XML ..etc
  and connected with another project (Consumer).

Note:
1) Spring ReST Producer never contains any UI.

2) Request is processed by RestController (Controller + ResponseBody)
   and returns output in Text, JSON, XML ..etc

3) It is also similer to MVC Design , but not View.
4) Final Output is ResponseEntity(Body/Data+Http Status)
5) Consumer can be Tool, Application or FrontEnd Technology.
  Tool        - POSTMAN, SWAGGER
  FrontEnd    - Angualr, ReactJS
  Application - RestTemplate, WebClient..etc

==============================================================================
