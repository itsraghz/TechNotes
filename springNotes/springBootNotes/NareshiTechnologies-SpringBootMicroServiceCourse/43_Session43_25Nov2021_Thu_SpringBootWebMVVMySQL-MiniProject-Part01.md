# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 43 \
25 Nov 2021 Thu \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC JPA MySQL - Mini Project - Part 01

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDMwNTI0ODMzOTcx/details

```
						Date : 25-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Task: Student(sid,sname, sfee, course)


Similer Concept :
https://www.youtube.com/watch?v=rgG2_T-OB8g

			Spring Boot - Mini Project
                [ Web MVC +  Thymeleaf + MySQL + Data JPA ]

*) Layers Design (3) used to develop applications
PL = Presentation Layer = To show final result to enduser (Spring Boot Web MVC)
SL = Service Layer      = To do calculation/operations, Transactions, logics..etc
DAL= Data Access Layer  = To do Database Operations (INSERT,UPDATE,DELETE,SELECT)


--coding---------------------------------------------------
Setup Files
a. application.properties
b. pom.xml
c. Starter|Main class
d. Basic folders

Module File
1. Entity class
2. Repository Interface
3. Service Interface
4. Service Impl
5. Controller
6. UI Pages

*) Note: @GeneratedValue is used to generate one PK based on strategy taken

=> Oracle Database : Sequences (start=1, step=5)
   Numbers : 1, 6, 11, 16, ...etc

=> MySQL Database : IDENTITY (AutoIncrement , start=1, stpe=1)
   Numbers: 1,2,3,...etc


@GeneratedValue(strategy = GenerationType.SEQUENCE) //Oracle

@GeneratedValue(strategy = GenerationType.IDENTITY)// MySQL

@GeneratedValue(strategy = GenerationType.AUTO) //any DB

*) Here we used interface at service to create loose connection
   b/w classes. if Impl class is modified/changed then dependent
   class is not going to get any effect. (Loosecoupling)


*) For
   SQLSyntaxErrorException: Unknown database 'boot7am'

mysql> create database boot7am;
mysql> use boot7am
mysql> show tables;
+-------------------+
| Tables_in_boot7am |
+-------------------+
| emptab            |
+-------------------+
mysql> select * from emptab;
+-----+-------+-------+------+-------+------+
| eid | eaddr | edept | egen | ename | esal |
+-----+-------+-------+------+-------+------+
|   1 | HYD   | DEV   | Male | SAM   |  500 |
+-----+-------+-------+------+-------+------+

===Coding with Steps================================================
S#1 Creating Application
Name : SpringBoot2WebMvcMySQLCrudEx
Dep  : Lombok, Devtools, Data Jpa, MySQL, Web, Thymeleaf

S#2 application.properties
-------------------------------
server.port=8080

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create
-------------------------------

S#3 Entity class
package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@Column(name="eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)// MySQL
	private Integer empId;

	@Column(name="ename")
	private String empName;

	@Column(name="esal")
	private Double empSal;

	@Column(name="egen")
	private String empGen;

	@Column(name="edept")
	private String empDept;

	@Column(name="eaddr")
	private String empAddr;
}

S#4 Repository
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

S#5 Service interface
package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	List<Employee> getAllEmployees();

}

S#6 ServiceImpl
package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo; //HAS-A

	@Override
	public Integer saveEmployee(Employee emp) {
		emp = repo.save(emp);
		return emp.getEmpId();
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO: existed or not?
		repo.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO: existed or not?
		repo.deleteById(id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			// TODO: existed or not?
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

}
---------------------------
S#7 Controller

package in.nareshit.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;//HAS-A

	//1. show Register page
	@GetMapping("/register")
	public String showReg() {
		return "EmployeeRegister";
	}

	//2. Read Form data and save (on submit)
	@PostMapping("/save")
	public String saveEmp(
			@ModelAttribute Employee employee,
			Model model
			)
	{
		Integer id = service.saveEmployee(employee);
		String msg = "Employee '"+id+"' created!";
		model.addAttribute("message", msg);
		return "EmployeeRegister";
	}

	//3. show All Employees
	@GetMapping("/all")
	public String viewAll(Model model)
	{
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	//4. Delete one Employee By id

	//5. Show Employee data in Edit Page by Id

	//6. Update Employee data on update(submit)
}


S#8 UI Pages
---EmployeeRegister.html------------
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>EMPLOYEE REGISTER PAGE</h3>
  <form method="post" th:action="@{/employee/save}">
  <pre>
	NAME : <input type="text" name="empName">
	SAL  : <input type="text" name="empSal">
	GEN  :
	   <input type="radio" name="empGen" value="Male"/> Male
	   <input type="radio" name="empGen" value="Female"/> Female
	DEPT : <select name="empDept">
	          <option value="">--SELECT--</option>
	          <option value="DEV">DEV</option>
	          <option value="QA">QA</option>
	          <option value="BA">BA</option>
		  </select>
     ADDR : <textarea name="empAddr"></textarea>
     <button type="submit">REGISTER</button> 		  
  </pre>
  </form>
  <b> [[${message}]] </b>
 </body>
</html>
----------------------------------------------------------

---------EmployeeData.html------------------------
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>EMPLOYEE DATA PAGE</h3>
  <table border="1">
  	<tr>
  		<th>ID</th>
  		<th>NAME</th>
  		<th>SAL</th>
  		<th>GEN</th>
  		<th>DEPT</th>
  		<th>ADDR</th>
  	</tr>
  	<tr th:each="ob:${list}">
  		<td>[[${ob.empId}]]</td>
  		<td>[[${ob.empName}]]</td>
  		<td>[[${ob.empSal}]]</td>
  		<td>[[${ob.empGen}]]</td>
  		<td>[[${ob.empDept}]]</td>
  		<td>[[${ob.empAddr}]]</td>
  	</tr>
  </table>
 </body>
</html>
---------------------------------------------------
*) Run app and enter URL
 http://localhost:8080/employee/register

*) After inserting few rows
 http://localhost:8080/employee/all
