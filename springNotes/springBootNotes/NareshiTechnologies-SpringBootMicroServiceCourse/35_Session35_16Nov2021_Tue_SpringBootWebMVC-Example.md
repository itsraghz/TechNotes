# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 35 \
16 Nov 2021 Tue \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC

# Lecture Notes - downloaded from Google Classroom

```
								Date : 16-11-2021
								Spring boot 7AM
				  				Mr. RAGHU									
	-------------------------------------------------------------------
```	
Task: Spring Boot Error and Exception Handling
https://www.youtube.com/watch?v=AFq9eK2OoGU
https://www.youtube.com/watch?v=tBVAybXMKzY
https://www.youtube.com/watch?v=M-LRfrYHWrk


			       Spring Boot Web MVC

=> Spring Web Dependency must be added to Project
=> Autoconfiguration for : DispatcherServlet, HandlerMapping and ViewResolver.
=> One Embedded server also added ie Apache Tomcat
=> CATALINA : Servlet container, JASPER: JSP Container.
=> Tomcat embeeded server comes only with CATALINA.
	ie JSP Pages not supported default.

=> We need to add below dependency to work with JSP Pages.
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

=> Port Number is default : 8080 (in Boot)
   [ server.port=____ ]

=> @Controller = @Component (object) + HTTP Protocol support

=> @RequestMapping : it is used to link a Path with Class/Method
           that is executed when such matching request comes.


=> Spring boot supports two packing types:
   JAR - Java Archive - Used for Standalone
   WAR - Web Archive  - Used for Web Applications

  If you want to run your web application with embedded server only
  then anything is fine (JAR/WAR). Even JAR Recomanded.

  To deploy in External Server, use WAR option only.

=========coding ======================================================
Step#1
  Name : SpringBoot2WebMvcEx
  Dep  : Spring web

Step#2 (If you want to work with JSP)
   in pom.xml

<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
</dependency>

Step#3 application.properties

   server.port=9696
   spring.mvc.view.prefix=/WEB-INF/pages/
   spring.mvc.view.suffix=.jsp

Step#4 Create Folder System and files like

   src
    |-main
       |-webapp   ( root folder == symbol / )
          |-WEB-INF
	     |-pages
                 |-EmpHome.jsp

> Expand src folder > Right click on main > new Folder > Enter name webapp > Finish
 (do same for WEB-INF and pages)
> Right click on pages > new File > Enter name EmpHome.jsp

---EmpHome.jsp-------------
<html>
	<head>
		<title>FIRST APP</title>
	</head>
	<body>
		<h3>WELCOME TO FIRST APPLICATION</h3>
	</body>
</html>
---------------------------

Step#5 Controller class
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@RequestMapping("/show")
	public String showPage() {
		return "EmpHome";
	}
}


Step#6 Run main class and Enter URL:
http://localhost:9696/emp/show
========================================================================
