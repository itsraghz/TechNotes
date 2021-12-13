# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 51 \
13 Dec 2021 Mon \
7 00 AM IST - 7 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring ReST MediaType Annotations

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ2MDM1NTM3NjQ3/details

```
						Date : 13-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Task:
https://www.youtube.com/watch?v=LE3KvvhkUkM

			Spring ReST - MediaType Annotations

*) MVC - Form -> Object -> @ModelAttribute
         Controller -> Data -> Model -> UI

*) ReST
     Consumer --> Data --> JSON/XML --> (@RequestBody) --> Object --> Producer
     Producer --> Object -> (@ResponseBody) --> XML/JSON --> Data --> Consumer


*) MediaType Annotations(2) :-
a. RequestBody : (Input/Parameter/Request)
    It converts Http Request (JSON/XML) into Object format and given as method param.  

b. ResponseBody : (Output/ReturnType/Response)
   It converts Method Return value(Object) into XML/JSON and given as Http Response.


*) Note:
a. Type must be non-String. For String --> Text Output/Input.
b. non-String, Object/Collection <--> JSON/XML
c. Content-Type Header Param says 'What type of data exist in Body'.
d. @RestController internally it adds @ResponseBody too.
   So, no need to add this annotation externally.

e. JSON Format: (Java Script Object Notation)
   {
     "key" : val, ..
   }

   value is quoted if String type only.

f. Spring boot supports only JSON conversion default.
     No XML conversion support is given.
----------------------------------------------------------------
Download and install postman tool
Link: https://www.postman.com/downloads/
> Double click to install
> Do not register, skip to goto app
> use ctrl+ and ctrl- to zoom out/in
----------------------------------------------------------------

==code=============================
Name : SpringBoot2ReSTProducerOutputEx
Dep  : Web, Lombok, Devtools

a. Entity
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
---------------
b. RestController
package in.nareshit.raghu.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/msg")
	public ResponseEntity<String> showMsg() {
		//ResponseEntity = body + HTTP Status
		ResponseEntity<String> response =
			new ResponseEntity<String>("Hello Data",HttpStatus.OK);
		return response;
	}

	@GetMapping("/find")
	//@ResponseBody
	public ResponseEntity<Employee> findOneEmployee() {
		ResponseEntity<Employee> response =
			new ResponseEntity<Employee>(
				new Employee(101, "ABC", 200.0),
				HttpStatus.OK);
		return response;
	}

	@GetMapping("/all")
	//@ResponseBody
	public ResponseEntity<List<Employee>> findAllEmployees() {
		ResponseEntity<List<Employee>> response =
			new ResponseEntity<List<Employee>>(
				Arrays.asList(
					new Employee(101, "ABC", 200.0),
					new Employee(102, "IJK", 300.0),
					new Employee(103, "MNO", 400.0),
					new Employee(104, "PQR", 500.0)
				),
			  HttpStatus.OK);
		return response;
	}
}
---------------

*) Run app and enter URL as:
http://localhost:8080/employee/find
http://localhost:8080/employee/all


--To work with XML ------------------
S#1 Add below Dependency in pom.xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>

S#2 While making Request send Header
   Accept = application/xml

----------POSTMAN---------------------------------
GET | http://localhost:8080/employee/find | SEND
--------------------------------------------------
          Header
   Key            Val
 [Accept]        [application/xml]
---------------------------------------------------

*) if jackson-dataformat-xml dependency not exist in classpath/pom.xml
   then we try to request for Accept = application/xml,
   FC throw 406 - Not Acceptable.
