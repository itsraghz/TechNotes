# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 40 \
22 Nov 2021 Mon \
7 10 AM IST - 8 10 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - Form Example with Input Types

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

```
						Date : 22-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
HTML Form ( ModelAttribute )

*) HTML Forms :- To send data from EndUser(Browser) to Controller class(Server)
Like: Register, Login, Comment, Feedback, Payment, ...etc

*) Spring container creates one object when we click on Form Submit, in 4 steps

a. Create Object (using default constrcutor)
b. Read Form Data ( request.getParameter )
c. Parse Data if Required ( Integer.parseInt )
d. Set data to object ( object.set__(__) )

*) Programmer has to,
1. Create one class with default constructors

2. Define variables with set/get methods
No.of Variables = No.of Form Inputs

3. Variable Name must match with Form Input name
<input    name="variableName"  |
<select   name="variableName" |
<textarea name="variableName"

=> Then finally we can read object at controller#method param using below
syntax:

@ModelAttribute ClassName objectName
(or)
@ModelAttribute("objName")ClassName localVariable


======coding===========================================
1. Name : SpringBoot2WebMvcFormsEx
Dep  : Web, Lombok, Devtools

2. pom.xml
<dependency>
<groupId>org.apache.tomcat.embed</groupId>
<artifactId>tomcat-embed-jasper</artifactId>
</dependency>

3. Entity class

package in.nareshit.raghu.entity;

import lombok.Data;

@Data
public class Employee {

private Integer empId;
private String empName;
private Double empSal;

}

4. Controller
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.nareshit.raghu.entity.Employee;

@Controller
public class EmployeeController {

//1. TO SHOW REGISTER FORM
@GetMapping("/show")
public String showReg() {
return "EmpReg";
}

//2. TO READ FORM DATA ON SUBMIT
@PostMapping("/save")
public String readData(
@ModelAttribute Employee employee,
Model model
)
{
System.out.println("Data is => " + employee);
model.addAttribute("emp", employee);
return "EmpData";
}
}


5. application.properties
server.port=8686

spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp

6. UI Pages:
----EmpReg.jsp-----
<html>
<head>
<title>Document</title>
</head>
<body>
<h3>WELCOME TO REGISTER PAGE</h3>
<form action="save" method="POST">
<pre>
ID   : <input type="text" name="empId"/>
NAME : <input type="text" name="empName"/>
SAL  : <input type="text" name="empSal"/>
<input type="submit" value="Register"/>
</pre>
</form>  
</body>
</html>

---EmpData.jsp-------
<html>
<head>
<title>Document</title>
</head>
<body>
DATA IS : ${emp}
</body>
</html>
------------------------------------------------

Run app and Enter URL:
http://localhost:8686/show


====case#2 Multiple Inputs==============================================
*) incase of checkbox/multi-selelect dropDown use Collection variable
(or Array variable). Collection holds multiple values even can be stored
inside database (as a child table , ie ElementCollection).


--code changes ---
a. Entity
package in.nareshit.raghu.entity;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {

private Integer empId;
private String empName;
private Double empSal;
private String empGen;
private String empPwd;
private String empAddr;
private String empDept;
private Set<String> empPrjs;
private List<String> empClients;

}

b. UI File (EmpReg.jsp)
<html>
<head>
<title>Document</title>
</head>
<body>
<h3>WELCOME TO REGISTER PAGE</h3>
<form action="save" method="POST">
<pre>
ID   : <input type="text" name="empId"/>
NAME : <input type="text" name="empName"/>
SAL  : <input type="text" name="empSal"/>
GEN  : <input type="radio" name="empGen" value="Male"/> Male <input type="radio" name="empGen" value="Female"/> Female
PWD  : <input type="password" name="empPwd"/>
ADD  : <textarea name="empAddr"></textarea>
DEPT : <select name="empDept">
<option value="">-SELECT-</option>
<option value="DEV">DEV</option>
<option value="QA">QA</option>
<option value="BA">BA</option>
</select>
PROJS:
<input type="checkbox" name="empPrjs" value="HTC"/> HTC  		   
<input type="checkbox" name="empPrjs" value="NIT"/> NIT  		   
<input type="checkbox" name="empPrjs" value="ORC"/> ORC
CLIENTS:
<select name="empClients" multiple>
<option value="HYD">HYD</option>
<option value="MUM">MUM</option>
<option value="CHN">CHN</option>
<option value="KOT">KOT</option>
</select>		  		   
<input type="submit" value="Register"/>
</pre>
</form>  
</body>
</html>
================================================================================
