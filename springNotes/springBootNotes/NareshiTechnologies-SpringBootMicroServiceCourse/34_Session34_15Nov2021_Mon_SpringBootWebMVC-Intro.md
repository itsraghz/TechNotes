# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 34 \
15 Nov 2021 Mon \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC

# Lecture Notes - downloaded from Google Classroom

```
							Date : 15-11-2021
				 			Spring Boot 7AM
				   			Mr. RAGHU
	-----------------------------------------------------------------
```

Web MVC:-
https://www.youtube.com/watch?v=O8MtjB0Ru0E
ALL PDFs:
https://www.mediafire.com/file/w5x9w5vcmkwkkdv/RaghuSirNareshITJavaPdfs.zip/file

			  Spring Boot - WEB MVC

=> MVC is a design pattern used implement web applications.

M - Model (Data)
V - View  (User Interface-UI)
C - Controller (Class/Request Processing Logic)

=> Web Browser is operated by Enduser (ex: Chrome, Firefox..etc)
  that makes request to web server which process request and gives response.

=> Both Machines are communicated using HTTP Protocol.

=> **** as-per Java Design Servlets API must be used
       to implement any web application.

=> Spring F/w has created one Servlet (Pre-defined code) named as :
 DispatcherServlet(C). It is called as Entry and exit point to our application.

=> It is named as FrontController, need to be configured in web.xml or AppInit
    [in Spring Boot, not required]

=> One Application(Project) is a collection of Services(Modules)
   ex: Gmail Applications:
        User(Register/login), Inbox, Sent, Compose, Setting, Spam..etc

   **********************************************************************
    		One Module  ===== One Controller
   **********************************************************************

=>  Controller is a class that contains methods to process request and executed
    when request comes, based on Path and HttpMethods they are selected.

=> Web Browser can understand only : HTML, CSS, JS and HTTP protocol.


Q) In how many ways end user can make request using web browser?
A)
   3 ways.
   a. Enter URL in Addressbar  [GET]
   b. Click on HyperLink(<a>)  [GET]
   c. Form Submit              [GET/POST]

  GET : Fetch Data from server to browser
  POST : Provide data from browser to server.

=> HandlerMapping is a Map created at runtime that store all details of our
	controller classes and methods

   ------------------------HandlerMapping--------------------
   	     KEY                             VALUE
       (Path + HttpMethod)             (class + method)
   ----------------------------------------------------------
        /emp/show + GET            EmployeeController#showData()


        /admin/save + POST         AdminController#saveAdmin()
   -----------------------------------------------------------

 >> Who will write Controller class (Code) ??         Programmer
 >> Who will create Object to class (Instance)??      Container
 >> Who will execute Controller#methods (execution)?? FrontController (per request)

*) Controller returns ViewName (UI FileName) without any location and extension details
    Why???? To become independent of UI Technologies.
    (Here only Java UI Technologies)

*) FrontController is reading Viewname from Controller and taking help of
    ViewResolver to add prefix(file location) and suffix (file extension)


      ViewPage  =   prefix         +  viewName   +   suffix
                /WEB-INF/mypages/      Home          .html


*) To share data from Controller to View(UI), Model(KEY=VAL) is used.
   UI can read data using EL (Expression Language)

   UI pattern : Welcome To ${user}
   Ex:        : Welcome To SAM

====================================================================
Spring Boot has given AutoConfiguration for
>> FrontController using Java based configuration (in Boot)
>> HandlerMapping using Spring 5.x Configuration
>> ViewResolver using Java based configuration (in Boot)

*) Here, we need to code for Controller, View and Model only.

=====================================================================
*) Spring Boot has given Embedded Servers:
   Apache Tomcat
   JBoss Undertow
   Eclipse Jetty

*) We can run our web application as JAR/WAR in case of Embedded Servers.
*) Default port number is : 8080  [ server.port=9696 ]
