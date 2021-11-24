# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 42 \
25 Nov 2021 Wed \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC - Thymeleaf with Forms

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDMwNTI0ODMzOTcx/details

```
						Date : 24-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Boot : Web MVC UI
		        (Thymeleaf)

*) JSP is a java based UI which take more memory to run page
	(Heavy weight UI)
  JSP -> Servlet -> Compiled -> Executed
 Even static content --> Servlet(java code)

 <p>Hello</p> -> out.println("<p>Hello</p>")

=> As it is a servlet internally lot of objects created
  Servlet, Request, Response, Config, Context Ref,
  print object..etc


*) Thymeleaf : Light Wegith Java based UI
=> It is like normal HTML File
=> It will not convert static into Java code
=> only dynamic content is converted into Java code
   executed output is replaced back(rendering)

-----filename.html------------------
```html
<html xmlns:th="https://www.thymeleaf.org/">
  <head>  </head>
  <body>

  </body>
</html>
```
=========================================
*) If a tag has prefix 'th' then , it is a Thymeleaf tag.
  Its definition exist at NameSpace(location) [xmlns]
   ex: thymeleaf.org

--Symbols ------------------------
```
 @   --- URL/Path/Location

 $   --- Read data from Model (Controller--->Model-->UI)

 *   --- Link (Form input with Object-field binding)

 #   --- to use pre-defined objects of thymeleaf
 ```
-------------------------------------

th:text="${data}"  => given data is read from Model and print

[[ ${expression} ]]  => execute expression and print

*) Here th means thymeleaf, fixed prefix.

--For Each Loop--
`th:each="tempVariable:${collectionKeyName}"`
equal java code
```java
for(Type tempVariable: collectionKeyName) {

}
```
==============================================================
*) Spring Boot Thymeleaf Dependency need to be added in pom.xml
  [ `spring-boot-starter-thymeleaf` ]

*) Spring boot has given default configuration for Thymeleaf
   (C) ThymeleafProperties
   (V) DEFAULT PREFIX = "classpath:/templates/"
       DEFAULT SUFFIX = ".html"

*) We can even modify them using keys
```java
spring.thymeleaf.prefix=/WEB-INF/pages/
spring.thymeleaf.suffix=.html
```
--------------------------------------------------
HyperLink:-
`<a th:href=" @{/fullPath} " > ___ </a>`

Adding Image (Location /static folder)
`<img th:src=" @{/fullPath} " />`

Link a CSS File
`<link rel="stylesheet" th:href="@{/fullPath"}/>`

Link a Java Script File:-
`<script th:src="@{/fullPath}"></script>`

=======================code========================
Name : SpringBoot2ThymeleafEx
Dep  : Web, Lombok, Devtools, Thymeleaf

a. Entity
```java
package in.nareshit.raghu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
}
```

b. Controller
```java
package in.nareshit.raghu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/data")
	public String showData(Model model)
	{
		model.addAttribute("title", "WELCOME TO ALL!!");

		Employee emp = new Employee(10,"A",200.0);
		model.addAttribute("employee", emp);

		List<Employee> list = Arrays.asList(
				 new Employee(10,"A",200.0),
				 new Employee(11,"B",300.0),
				 new Employee(12,"C",400.0),
				 new Employee(13,"D",500.0)
				);
		model.addAttribute("list", list);

		return "EmpData";
	}

	@GetMapping("/info")
	public String getInfo() {
		System.out.println("info is called");
		return "EmpInfo";
	}
}
```

c. UI Files
---/static/css/custom.css-----
```css
.myd{
	color : green;
	border: 2px solid red;
	background-color: pink;
}
```
---/static/myjs/message.js---
```js
alert('HELLO');
```
----------------------------
---/static/images/NIT.jpg--
(add an image here)

--/templates/EmpData.html-----------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>FROM THYMELEAF </h3>
  [[ ${title } ]] <br/>
  <div th:text="${title}"> </div>

  <hr/>
  [[${employee}]] <br/> [[${employee.empId}]] , [[${employee.empName}]]
  <b th:text="${employee.empSal}"></b> <br/>
  [[${ 'Your name is ' + employee.empName +', having sal '+ employee.empSal}]]
  <br/>

  <table border="1">
  	<tr>
  		<th>ID</th>
  		<th>NAME</th>
  		<th>SAL</th>
  	</tr>
  	<tr th:each="ob:${list}">
  		<td>[[${ob.empId}]]</td>
  		<td>[[${ob.empName}]]</td>
  		<td>[[${ob.empSal}]]</td>
  	</tr>
  </table>
  <hr/>
  <a th:href="@{/employee/info}"> CLICK HERE! </a>
 </body>
</html>
```
----------------------------------------------
---/templates/EmpInfo.html---------------------------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
  <link rel="stylesheet" th:href="@{/css/custom.css}"/>
  <script th:src="@{/myjs/message.js}"></script>
 </head>
 <body>
 	<img th:src="@{/images/NIT.jpg}"/> <br/>
 	<div class="myd"> EMPLOYEE INFO PAGE </div>
 </body>
</html>
```
=========================================================
Thymeleaf Forms are Bi-directional Forms.
They can submit data into ModelAttribute, even read from Model.

```
       Form <---> Object
```

S#1 Link A Form with Object

```html
 <form th:action="@{/fullPath}" method="" th:object="${objName}">

 </form>
```

S#2 Link Input with Variable
```
	<input type="" th:field="*{variable}"/>
```

===code============
Name : *SpringBoot2ThymeleafExForms*
Dep  : Web, Lombok, Devtools, Thymeleaf

a. Entity class
```java
package in.nareshit.raghu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
}
```

b. Controller
```java
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/edit")
	public String showEditPage(Model model)
	{
		Employee emp = new Employee(101, "AA", 200.0);
		model.addAttribute("employee", emp);
		return "EmpEdit";
	}
}
```

c. UI : EmpEdit.html

```html
<html>
	<head></head>
	<body>
		<h3>EDIT PAGE </h3>
		<form th:action="@{/employee/update}" method="POST" th:object="${employee}">
			<pre>
				ID   : <input type="text" th:field="*{empId}"/>
				NAME : <input type="text" th:field="*{empName}"/>
				SAL  : <input type="text" th:field="*{empSal}"/>
					<button type="submit">Update</button>
			</pre>
		</form>
	</body>
</html>
```

*) Run app and enter URL:
http://localhost:8080/employee/edit
