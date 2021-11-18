# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 37 \
18 Nov 2021 Thu \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - Controller Rules

# Lecture Notes - downloaded from Google Classroom

```
							Date : 18-11-2021
				 			Spring Boot 7AM
				  			Mr. RAGHU								
	------------------------------------------------------------
```	
Single PDF Link:-
https://www.mediafire.com/file/w5x9w5vcmkwkkdv/RaghuSirNareshITJavaPdfs.zip/file

*) SpringBoot Devtools:-

=> if we do any code modifications in web applications, we need to stop
   and start it again to see modifications.

=> To avoid such re-start use Devtools (used only for Development purpose only)

-----------Project Setup------------------------------------------
Name : SpringBoot2WebMvcControllerRulesEx
Dep  : Spring Web, Spring boot devtools

a. pom.xml
<dependency>
 <groupId>org.apache.tomcat.embed</groupId>
 <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

b. application.properties
#server.port=8080

spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp

c. Folder System
  src
   |-main
      |-webapp
         |-WEB-INF
            |-pages

===========================================================
		  Controller Rules
===========================================================
1. Class must have @Controller (creates obj + HTTP Protocol )

---code sample---------------------------
*) Controller:-
package in.nareshit.raghu.controller;

//ctrl+shift+O (imports)
@Controller
//@Component
public class StudentController {

	public StudentController() {
		System.out.println("OBJ CREATED!");
	}

	@RequestMapping("/show")
	public String showData() {
		System.out.println("METHOD IS CALLED!");
		return "StdHome";
	}
}

*) UI Page: StdHome.jsp
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1>  HELLO ALL </h1>
	</body>
</HTML>

*) Run app, enter URL: http://localhost:8080/show
----------------------------------------------------------
>> Enter URL in Addressbar (GET)
>> HyperLink/<a> TAG ( GET)
>> Form Submit (GET/POST)

---------------------------------------------------------------
2. Every method in controller must be linked with:
	PATH + HTTP METHOD(GET/POST)

   using annotation : @RequestMapping

  @RequestMapping(value="/path",method=RequestMethod.GET)
  @RequestMapping(value="/path") // default is GET
  @RequestMapping("/path")

    (RequestMethod is a enum)

  @RequestMapping(value="/path",method=RequestMethod.POST)

---code sample------------------------------------------
*) Controller:-
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	//@RequestMapping("/show") //default is GET
	public String showData() {
		System.out.println("GET IS CALLED");
		return "StdHome";
	}

	@RequestMapping(value = "/profile",method = RequestMethod.POST)
	public String showProfile() {
		System.out.println("POST IS CALLED");
		return "StdProfile";
	}
}

*) UI pages:-
------StdHome.jsp--------------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1>  HELLO ALL </h1>
	   <form action="profile" method="POST">
	   		<button type="submit"> Goto Profile Page </button>
	   </form>
	</body>
</HTML>

---------------StdProfile.jsp---------------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1> FROM PROFILE </h1>
	   <a href="data"> GOTO DATA PAGE </a>
	</body>
</HTML>


*) Run app, enter URL: http://localhost:8080/data
---------------------------------------------------------------------------
3. Class Level @RequestMapping is optional. But recomanded to
   provide.

--code sample------------------
@Controller
@RequestMapping("/std")
public class StudentController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showData() {
		System.out.println("GET IS CALLED");
		return "StdHome";
	}
}
-------------------------------------------------------------------------
4. URL/Path is case-sensitive.
   @RequestMapping("/show")
   @RequestMapping("/SHOW")  are different.



--code sample------------------
@Controller
@RequestMapping("/std")
public class StudentController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showData() {
		System.out.println("GET IS CALLED");
		return "StdHome";
	}
}

*) URL: http://localhost:8080/std/DATA
   Output : 404 - Not Found

>> Even multiple methods can have same URL with different case

---code sample--------------------------------
@Controller
@RequestMapping("/std")
public class StudentController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showData() { }

	@RequestMapping(value = "/DATA",method = RequestMethod.POST)
	public String showProfile() {}
}

*) SAME PATH using multiple times not allowed.
IllegalStateException: Ambiguous mapping. Cannot map showProfile()
to {GET [/std/data]}: There is already showData() mapped.

_________________________________________________________________________
5. Duplicate Paths allowed at multiple methods but combination
   (PATH + HTTP Method) must be unique

------------code sample--------------------------------------
*) Controller:-
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/std")
public class StudentController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showData() {
		System.out.println("GET IS CALLED");
		return "StdHome";
	}

	@RequestMapping(value = "/data",method = RequestMethod.POST)
	public String showProfile() {
		System.out.println("POST IS CALLED");
		return "StdProfile";
	}
}

*) UI Pages:-
	-------StdHome.jsp-----------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1>  HELLO ALL </h1>
	   <form action="data" method="POST">
	   		<button type="submit"> Goto Profile Page </button>
	   </form>
	</body>
</HTML>
---------------------StdProfile.jsp--------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1> FROM PROFILE </h1>
	   <a href="data"> GOTO DATA PAGE </a>
	</body>
</HTML>
__________________________________________________________________________
6. We can define multiple PATHs at one Method level.
   @RequestMapping(value={ "/path1","/path2","/path3",.. })

   >>> All can be GET type OR POST type, mixing is not possible
      like /login + GET, /home + POST ..(not possible)

----code sample------------------------
*) Controller:-
package in.nareshit.raghu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping({"/login","/home","/logout"})
	public String showHome(HttpServletRequest request)
	{
		//TO KNOW THAT WHICH PATH IS CALLED FROM CLIENT
		System.out.println("PAGE IS LOADED => " + request.getRequestURI());
		return "UserLogin";
	}
}

*) UI page:-
 -----UserLogin.jsp------------------------
 <HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1> FROM USER LOGIN PAGE </h1>
	</body>
</HTML>
------------------------------

*) Run app and enter URL:
http://localhost:8080/login
http://localhost:8080/home
http://localhost:8080/logout

______________________________________________________________________
7. We can add multiple Http Methods to one Controller#method
   @RequestMapping(
            value ="/path",
	    method = {
	       RequestMethod.GET,
	       RequestMethod.POST
	    })

----------code sample-------------------------------------------
*) Controller:-
package in.nareshit.raghu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/login",
			method = {
					RequestMethod.GET,
					RequestMethod.POST
	})
	public String showHome(HttpServletRequest request)
	{
		System.out.println("Req is => "
				+ request.getRequestURI() + " "
				+ request.getMethod());

		return "UserLogin";
	}
}

*) UI Pages:-
 -------------UserLogin.jsp-------------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1> FROM USER LOGIN PAGE </h1>
	   <form action="login" method="POST">
	   	   <button type="submit"> CLICK FOR POST </button>
	   </form>
	  <hr/>
	  <a href="login"> CLICK FOR GET </a>
	</body>
</HTML>


*) Run App and enter URL: http://localhost:8080/login
__________________________________________________________________________
8. Combination of Multiple Paths and Http Methods even allowed
   @RequestMapping(
            value = { "/path1", "/path2", "/path3",...}
	    method = {
	       RequestMethod.GET,
	       RequestMethod.POST
	    })
----------sample code----------------------------
*) Controller:-
package in.nareshit.raghu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(
			value = {
					"/login",
					"/home"
			},
			method = {
					RequestMethod.GET,
					RequestMethod.POST
			})
	public String showHome(HttpServletRequest request)
	{
		System.out.println("Req is => "
				+ request.getRequestURI() + " "
				+ request.getMethod());

		return "UserLogin";
	}
}

*) UI Page:-

----UserLogin.jsp---------------------
<HTML>
	<head>
		<title>WELCOME </title>
	</head>
	<body>
	   <h1> FROM USER LOGIN PAGE </h1>
	   <form action="login" method="POST">
	   	   <button type="submit"> CLICK FOR POST </button>
	   </form>
	  <hr/>
	  <a href="login"> CLICK FOR GET </a>
	</body>
</HTML>

*) Run app, enter URL: http://localhost:8080/login
_____________________________________________________________________

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
