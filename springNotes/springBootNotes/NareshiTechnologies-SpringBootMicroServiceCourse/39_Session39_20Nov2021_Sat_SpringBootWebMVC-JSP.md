# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 39 \
20 Nov 2021 Sat \
8 AM IST - 8 20 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - JSP Page

# Lecture Notes - downloaded from Google Classroom

```
					Date : 20-11-2021
				 	Spring Boot 7AM
				   Mr. RAGHU
	--------------------------------------------------------------
```
		Model : To send data from Controller to View(UI)

=> To send data from Contoller class # method to ViewPage(UI),
    spring container has given one shared memory ie 'Model(I)'.
    	[org.springframework.ui]

=> Model Creation/destory/share is taken care by Spring container
   [works only in web application]

=> We need to take Model as "method Parameter" and call method
	addAttribute(key:String,val:Object):void

=> same key name must be used at UI and read data using EL
	(Expression Language)
    Syntax: ${key}

------------coding ------------------------------------------
1. Name : SpringBoot2WebMvcModelEx
   Dep  : Devtools, Spring Web

2. pom.xml (For JSP)
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
</dependency>

3. Controller
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/data")
	public String showData(Model model)
	{
		String title="NareshIT";
		model.addAttribute("msg", title);
		return "EmpData";
	}
}

4. UI : EmpData.jsp
<!DOCTYPE html>
<%@page isELIgnored="false"%>
<html lang="en">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>WELCOME TO DATA PAGE</h3>
  Data is : ${msg}
 </body>
</html>
