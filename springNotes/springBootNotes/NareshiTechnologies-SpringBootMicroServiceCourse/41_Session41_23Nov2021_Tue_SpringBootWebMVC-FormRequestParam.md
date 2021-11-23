# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 41 \
23 Nov 2021 Tue \
7 10 AM IST - 8 10 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - Form Example with Request Parameters

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDMwNTI0ODMzOTcx/details

```
						Date : 23-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Query Parameters / Request Parameters

Syntax:
URL ? key=val & key=val & key=val

Ex:
https://www.google.com/search
? q = india
& source = hp
& ei = 9UacYZ
& iflsig=ALs-wAMAAAAAYZxVBW


=> For a Request URL, Server(Application) has to do one task, for such task
   inputs are given using Request Parameters.

ex: http://localhost:8080/findEmp?eid=101
ex: http://localhost:8080/deleteStudent?sname=AJAY
ex: http://localhost:8080/editProduct?pcode=PEN

=> Here both key=val are String type default.
=> Later, value type conversion can be done (in code/controller)

----In Servlets-------------------
String val = request.getParameter("key");
//parse Data if Required
ex:
String val = request.getParameter("eid");
int id = Integer.parseInt(val);
----------------------------------

=> in WEB MVC (we can use below syntax)
   @RequestParam("key") DataType localVariable
   		(or)
   @RequestParam DataType key


=> We can send/read in any order incase of multiple key-val
   /show?sid=10&sname=A&sfee=3.3
   /show?sname=A&sfee=3.3&sid=10  (are same)


=> by Default RequestParam is required, if we do not send key=val along with URL,
   then FC give error : bad request - 400
   (internally MissingServletRequestParameterException)

expected:
  http://localhost:8080/show?pcode=PEN
Given:
  http://localhost:8080/show

=> We can make it optional parameters (default value is NULL)
  @RequestParam(value="key", required=false) DataType localVariable

ex:
@RequestParam(value = "pcode", required = false) String code

=> We can make it optional parameters and provide default value too
  @RequestParam(value="key", required=false, defaultValue="data")
	DataType localVariable

===Code#1===================================================================

Name : SpringBoot2WebMvcReqParamEx
Dep  : Web, Lombok, Devtools, Tomcat Embedded Jasper

a. application.properties
server.port=8080

spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp

b. Controller class
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	//...show?pcode=___

	@GetMapping("/show")
	public String readData(
			//@RequestParam("pcode") String code,
			//@RequestParam(value = "pcode", required = false) String code, //default is NULL
			@RequestParam(value = "pcode", required = false, defaultValue = "NONE") String code,
			Model model
			)
	{
		System.out.println("Data is  ===> " + code);
		model.addAttribute("code", code);
		return "ProductData";
	}
}


c. UI : ProductData.jsp
<html>
 <head>
  <title>Document</title>
 </head>
 <body>
	Data is : ${code}  
 </body>
</html>

d. Run App and enter URL
  http://localhost:8080/show?pcode=PEN
===========code#2================================================
	  >>>> Reading Multiple KEY=VALs <<<<

*) Controller code
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	//.. find?pid=10&pcode=PEN&pcost=300.0

	@GetMapping("/find")
	public String findData(
			@RequestParam("pid") Integer id,
			@RequestParam("pcode") String code,
			@RequestParam("pcost") Double cost,
			Model model
			)
	{
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("cost", cost);
		return "ProductInfo";
	}
}

*) UI Page : ProductInfo.jsp
<html>
 <head>
  <title>Document</title>
 </head>
 <body>
	Info is : ${id}, ${code}, ${cost}  
 </body>
</html>


*) Run App, Enter URL:
http://localhost:8080/find?pid=10&pcode=PEN&pcost=200.0
http://localhost:8080/find?pcode=TAB&pcost=500.0&pid=105
=====================================================================
Redirect:-  [response.sendRedirect(path)]


=> Redirection also a type of Http Request only.
=> This is used to execute multiple controller methods for a request.
=> use redirect:path to make HTTP CALL.
=> We can send Request Params from Redirect call using RedirectAttributes
   method : attributes.addAttribute("key", val);
   we can read this using @RequestParam.

--example code---
*) Controller
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

	@GetMapping("/remove")
	public String deleteProduct(
			RedirectAttributes attributes
			)
	{
		System.out.println("REMOVE ONE PRODUCT");
		String message = "Success!";
		//../show?key=val
		attributes.addAttribute("msg", message);
		return "redirect:show";
	}


	@GetMapping("/show")
	public String showProducts(
			@RequestParam("msg")String data
			)
	{
		System.out.println("FETCH LATEST PRODUCTS " + data);
		return "ProductData";
	}
}

*) UI Page:
 ------------ProductData.jsp----------------
 <html>
 <head>
  <title>Document</title>
 </head>
 <body>
	FROM DATA PAGE
 </body>
</html>
=======================================================================

# Task
Thymeleaf https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.pdf
