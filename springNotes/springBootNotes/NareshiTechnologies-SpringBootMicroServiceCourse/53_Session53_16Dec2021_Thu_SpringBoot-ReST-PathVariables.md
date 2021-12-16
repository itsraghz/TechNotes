# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 53 \
16 Dec 2021 Thu \
7 15 AM IST - 8 10 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Path Variables

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ2OTE3MDU3MjQy/details

```
						Date : 16-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
PathVariable in Spring ReST

*) PathVariable : To pass primitive data (String/int/char/boolean)
	          using URL as Path.

=> RequestParam : To pass primitive data (Even this one works in ReST)
=> PathVariable : Sending Dynamic Data using URL/Path

Path at Code: `/employee/find/{id}`

Static Path : Fixd Path (as it is enter in Request URL) : /employee/find
Dynamic Path : [Syntax /{key} ] Data comes in this place

URL looks like : `/employee/find/101`

=> While sending data using PathVariable concept, there is no KEY.


=> To read data in Controller#method Parameter:
  Syntax:
            @PathVariable DataType keyName
===Code================================================
Name: SpringBoot2RestPathVariableEx
Dep : Web, Devtools

*) RestController
```
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/find/eid")
	public ResponseEntity<String> findOneEmployeeC()
	{
		return new ResponseEntity<String>(
				"Hello Employee NONE",
				HttpStatus.OK);
	}

	//EX URL:.../employee/find/101
	@GetMapping("/find/{eid}")
	public ResponseEntity<String> findOneEmployeeA(
			@PathVariable Integer eid
			)
	{
		return new ResponseEntity<String>(
				"Hello Employee " + eid,
				HttpStatus.OK);
	}

	@GetMapping("/find/{eid}/{ename}")
	public ResponseEntity<String> findOneEmployeeB(
			@PathVariable Integer eid,
			@PathVariable String ename
			)
	{
		return new ResponseEntity<String>(
				"Hello Employee " + eid +","+ename,
				HttpStatus.OK);
	}
}
```
===========================================================================
*) Run and Enter URLs:
```
http://localhost:8080/employee/find/eid
http://localhost:8080/employee/find/101
http://localhost:8080/employee/find/101/AJAY
```

=> We can not send additional path levels, that leads to 404 error.
ex: http://localhost:8080/employee/find/101/AJAY
=> If we did not send same path count, that leads to 404 error.
ex: http://localhost:8080/employee/find
=> If we send data wrong type then FC returns 400 Bad Request
ex: http://localhost:8080/employee/find/AJAY (expected Integer)

=> Order must be followed while sending multiple values
  Path at Code:  /employee/find/{id}/{name}/{sal}
  URL         :  /employee/find/10/AJAY/200.0

=> if There are multiple Paths found with same paths
    first priority is given to static path
    then next dynamic path
    if nothing matched then 404-Not Found
-------------------------------------------------------------------
RequestParam:- (Servlets-> Web MVC)
`/employee/find?eid=101&ename=ABC`

PathVariable:- (new Concept added in Spring WEB)
`/employee/find/101/ABC`

=> In RequestParam we can make Key data as optional.
   But in Pathvariable no such concept. Data must be sent.

=====(task#1)===================================================================
```
m1  -  /find/test/data
m2  -  /find/test/{data}
m3  -  /find/{test}/{data}
m4  -  /{find}/{test}/{data}
```

Req#1 /find/101/ABC
Methods Matching: m3, m4
executed Method: m3

Req#2 /find/test/AAA
Methods Matching : m2, m3, m4
executed Method  : m2

Req#3 /101/AA/200.0
Methods Matching : m4
executed Method  : m4
------*----------------------------------------------------------------------

=> incase of Two paths having same static count and same dynamic count with
   matching order, then FC returns 500- IllegalStateException

```
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/find/{eid}/{ename}")
	public ResponseEntity<String> findOneEmployeeB(
			@PathVariable Integer eid,
			@PathVariable String ename
			)
	{
		return new ResponseEntity<String>(
				"Hello Employee " + eid +","+ename,
				HttpStatus.OK);
	}

	@GetMapping("/find/{deptId}/{deptName}")
	public ResponseEntity<String> findOneDeptE(
			@PathVariable Integer deptId,
			@PathVariable String deptName
			)
	{
		return new ResponseEntity<String>(
				"Hello Dept " + deptId +","+deptName,
				HttpStatus.OK);
	}
}
```

*) Enter URL: http://localhost:8080/employee/find/101/ABC
```
{
    "timestamp": "2021-12-16T02:37:45.947+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "trace": "java.lang.IllegalStateException: Ambiguous handler methods mapped for
        '/employee/find/101/ABC': findOneDeptE(), findOneEmployeeB()
    "path": "/employee/find/101/ABC"
}
```
Solution : just modify path like /find/emp/{eid}/{ename}
                                 /find/dept/{deptId}/{deptName}
*) Even 1 with GET and another with POST works, but it is not a valid solution.
=================================================================================
