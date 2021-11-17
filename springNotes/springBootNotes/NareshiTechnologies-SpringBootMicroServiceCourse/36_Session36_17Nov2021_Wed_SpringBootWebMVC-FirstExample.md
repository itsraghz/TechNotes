# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 36 \
17 Nov 2021 Wed \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - First Example

# Lecture Notes - downloaded from Google Classroom

```
							Date : 17/11/2021
							Spring Boot 7AM
			  				Mr. RAGHU
	------------------------------------------------
```
		      Spring Boot WEB MVC

*) Web MVC Application, files:
  a. View File (HTML/JSP) [Tomcat Embedded JASPER]
  b. Controller (Class) [ @Controller = @Component + HTTP ]
  c. View Resolver details in properties (prefix/suffix)
  d. Folder System src>main>webapp>WEB-INF>pages>FileName.ext

*) Folder : webapp is called as Root Folder (symbols - /)

*) In Controller class we use two annotations mainly
  a. @Controller = Creating Object + Support Protocol
  b. @RequestMapping = Link a PATH with Class/Method

*) Controller#Method ReturnType is String(ViewName).
   So, that prefix and suffix added later

====Coding Steps==================================
1. Create Application
Name : SpringBoot2WebMvcFirstEx
Dep  : Spring Web

2. For JSPs only
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

3. application.properties
server.port=8686
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp

4. Folder System and File
   src
    |-main
       |-webapp             (root folder - / )
           |-WEB-INF
	       |-pages
	           |-StudentHome.jsp

5. View File
-----StudentHome.jsp-------------------------
<HTML>
	<HEAD>
		<TITLE>SAMPLE </TITLE>
	</HEAD>
	<BODY>
	    <H3>WELCOME TO STUDENT PAGE</H3>
	</BODY>
</HTML>
----------------------------------------------
6. Controller
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/std")
public class StudentController {

	public StudentController() {
		System.out.println("OBJ CREATED!");
	}

	@RequestMapping("/home")
	public String showHome() {
		System.out.println("METHOD IS CALLED!!");
		return "StudentHome";
	}
}

----------------------------------------------
7. Open main class and run
8. Enter URL in addressbar
  http://localhost:8686/std/home

*)Note:
=> Spring container : ServletWebServerApplicationContext
   is used by Spring Web applications.

=> Controller(Service/Repository/Component) all these
    objects created when we start application.

=> Controller#method is executed once per request.

=> You may get WhiteLabel Error Page, type=Not Found, status=404
   a. Spaces in Properties file
   b. Missing @Controller at class
   c. Controller#method ReturnType and fileName, not matching
      [spell or case is wrong]
      ex: return "home", Home.jsp
   d. Folder System not created properly.
   e. URL is case-sensitive.
      /show, /SHOW, /Show are different.

===========================================================
		  Controller Rules
===========================================================
1. Class must have @Controller (creates obj + HTTP Protocol )

2. Every method in controller must be linked with:
	PATH + HTTP METHOD(GET/POST)

   using annotation : @RequestMapping

  @RequestMapping(value="/path",method=RequestMethod.GET)
  @RequestMapping(value="/path") // default is GET
  @RequestMapping("/path")

    (RequestMethod is a enum)

  @RequestMapping(value="/path",method=RequestMethod.POST)

3. Class Level @RequestMapping is optional. But recomanded to
   provide.

4. URL/Path is case-sensitive.
   @RequestMapping("/show")
   @RequestMapping("/SHOW")  are different.

5. Duplicate Paths allowed at multiple methods but combination
   (PATH + HTTP Method) must be unique

ex:-
@Controller
class Sample {
  @RequestMapping(value="/show",method=RequestMethod.GET)
  String m1(){}
  @RequestMapping(value="/show",method=RequestMethod.POST)
  String m2(){}
}

6. We can define multiple PATHs at one Method level.
   @RequestMapping(value={ "/path1","/path2","/path3",.. })

ex:-
@Controller
class Sample {
   @RequestMapping(value= { "/login", "/home", "/logout" } )
   String showLogin(){}
}

7. We can add multiple Http Methods to one Controller#method
   @RequestMapping(
            value ="/path",
	    method = {
	       RequestMethod.GET,
	       RequestMethod.POST
	    })

EX:-
@Controller
class Sample {
  @RequestMapping(
       value= "/login",
       method = {
	       RequestMethod.GET,
	       RequestMethod.POST
	    })
   String showLogin(){}
}

8. Combination of Multiple Paths and Http Methods even allowed
   @RequestMapping(
            value = { "/path1", "/path2", "/path3",...}
	    method = {
	       RequestMethod.GET,
	       RequestMethod.POST
	    })

9. We can provide PATH as /
   (Called as Welcome page or Default Path)

   @RequestMapping(value="/",method=RequestMethod.GET)
   @RequestMapping(value="/")  //default is GET
   @RequestMapping("/")
   @RequestMapping            //default is /
      (above all are same)

10. if @RequestMapping is not provided at method level
    then it is a simple java method, Never be called by FC.
    Must be called manually.


11. We can define multiple controllers in application
   ex: EmployeeController, UserController, SettingsController..etc

 => Recomanded to provide @RequestMapping at class level,
   there can be duplicate PATHs in multiple controllers.

ex:
@Controller
@RequestMapping("/emp")
class EmployeeController {
  @RequestMapping("/show")
  String showEmp() {}
}

@Controller
@RequestMapping("/user")
class UserController {
  @RequestMapping("/show")
  String showUser() {}
}

12. Latest Annotations Given
  Spring 2.5 ===> @RequestMapping

  Spring 4.3 ===> @GetMapping, @PostMapping, @PutMapping..etc

@GetMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.GET)
@PostMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.POST)
@PutMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.PUT)
@DeleteMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.DELETE)
@PatchMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.PATCH)

>> all above Annotations are at method level only.

13. We can even define @RequestMapping without path at class
  level (default is /) but Http method can not be given.


ex:
@Controller
@RequestMapping          //valid, default is /
class UserController {
  @RequestMapping("/show")
  String showUser() {}
}

14. Default HTTP port number is : 80
    Default Web Server Port Number is : 8080

  if we set server.port=80 then no need to enter port number
  in addressbar/URL

http://localhost:80/std/show
==> http://localhost/std/show
==> http://192.168.1.38/std/show

15. We can define even normal java methods ie without
    @RequestMapping. To have common logic of multiple
    controller methods

@Controller
class UserController {
  @RequestMapping("/show")
  String showUser() {
    setup(); //3...
  }
  @RequestMapping("/remove")
  String removeUser() {
    setup();, //4...
  }
  //normal java method
  void setup() {
    //1,//2.
  }
}

*) DRY ! - Do Not Repeate Yourself {dont write duplicate code}

----------------------------------------------------------
* Keep It Simple, Stupid (KISS) ...
* Write DRY Code. ...
* Open/Closed. ...
* Composition Over Inheritance. ...
* Single Responsibility. ...
* Separation of Concerns. ...
* You Aren't Going to Need It (YAGNI) ...
* Document Your Code.
----------------------------------------------------------
