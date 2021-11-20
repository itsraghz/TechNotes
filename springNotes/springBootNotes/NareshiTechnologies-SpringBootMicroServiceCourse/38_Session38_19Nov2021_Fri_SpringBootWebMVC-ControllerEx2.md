# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 38 \
19 Nov 2021 Fri \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - Controller Example 2

# Lecture Notes - downloaded from Google Classroom

```
					Date : 19-11-2021
 					Spring Boot 7AM
	 					Mr. RAGHU
-------------------------------------------------------
```
			Controller Rules -- PART-II


9. We can provide PATH as /  (at class and method level to)
(Called as Welcome page or Default Path)

@RequestMapping(value="/",method=RequestMethod.GET)
@RequestMapping(value="/")  //default is GET
@RequestMapping("/")
@RequestMapping            //default is /
(above all are same)

--sample code------------------------------------------
*) Controller code:-
package in.nareshit.raghu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class UserController {

//@RequestMapping("/")
@RequestMapping
public String showHome(HttpServletRequest request)
{
System.out.println("Req is => "
+ request.getRequestURI() + " "
+ request.getMethod());

return "UserLogin";
}
}

*) UI Page: "UserLogin.jsp"
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

*) URL: http://localhost:8080
--------------------------------------------------------
10. if @RequestMapping is not provided at method level
then it is a simple java method, Never be called by FC.
Must be called manually.

---sample code------------------------
*) Controller code:
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

@RequestMapping("/home")
public String showHome()
{
System.out.println("FROM HOME");
getAllLatestData();
return "UserLogin";
}


public void getAllLatestData() {
System.out.println("FROM SHOW DATA!!");
//return "UserData";
}
}

*) UI (same as before Example)
http://localhost:8080/home
========================================================================
11. We can define multiple controllers in application
ex: EmployeeController, UserController, SettingsController..etc

=> Recomanded to provide @RequestMapping at class level,
there can be no duplicate PATHs in multiple controllers.


IllegalStateException: Ambiguous mapping. Cannot map StudentController#saveStd()
to { [/save]}: There is already EmployeeController#saveEmp() mapped

----sample code------------
*) Controller:-
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

@RequestMapping("/save")
public String saveEmp() {
return "EmpSuccess";
}

}
----------
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/std")
public class StudentController {

@RequestMapping("/save")
public String saveStd() {
return "StdSuccess";
}
}

---EmpSuccess.jsp-----------------
<HTML>
<head>
<title>WELCOME </title>
</head>
<body>
<h1> EMPLOYEE SUCCESS PAGE </h1>

</body>
</HTML>
--StdSuccess.jsp----------------------
<HTML>
<head>
<title>WELCOME </title>
</head>
<body>
<h1> FROM STUDENT SUCCESS </h1>

</body>
</HTML>
====================================
URL:
http://localhost:8080/std/save
http://localhost:8080/emp/save
-----------------------------------------------------------------------------

12. Latest Annotations Given
Spring 2.5 ===> @RequestMapping

Spring 4.3 ===> @GetMapping, @PostMapping, @PutMapping..etc

@GetMapping("/path")    --> @RequestMapping(value="/path", method = RequestMethod.GET)
@PostMapping("/path")   --> @RequestMapping(value="/path", method = RequestMethod.POST)
@PutMapping("/path")    --> @RequestMapping(value="/path", method = RequestMethod.PUT)
@DeleteMapping("/path") --> @RequestMapping(value="/path", method = RequestMethod.DELETE)
@PatchMapping("/path")  --> @RequestMapping(value="/path", method = RequestMethod.PATCH)

>> @RequestMapping can be applied at class/method level. But new Annotations
are at method level only.

--sample code--------------------
*) Controller:-
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

@GetMapping("/login")
public String showLogin() {
System.out.println(" GET + /login is called!");
return "UserLogin";
}

@PostMapping("/process")
public String doCheck() {
return "UserHome";
}
}

*) UI: UserLogin.jsp
<HTML>
<head>
<title>WELCOME </title>
</head>
<body>
<h1> LOGIN PAGE</h1>
<form action="process" method="POST">
<button type="submit">Do Login Check</button>
</form>
</body>
</HTML>
-------------UserHome.jsp-----------
<HTML>
<head>
<title>WELCOME </title>
</head>
<body>
<h1> FROM USER HOME</h1>
</body>
</HTML>

URL: http://localhost:8080/user/login
------------------------------------
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
=====================================================================
16. Only one time @RequestMapping is allowed at one method level.
If we define it multiple times then it is a error.

--example--
@Controller
@RequestMapping("/emp")
public class EmployeeController {

@RequestMapping("/save")
@RequestMapping("/update")
public String saveEmp() {
return "EmpSuccess";
}

}
------------------
GET : Fetch data from Server
(getAllEmps())

Enter URL/HyperLink
------------------------------------------
POST : Give data to Server
(saveEmp(), updateEmp())

FORM (POST)
