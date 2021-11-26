# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 44 \
26 Nov 2021 Fri \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC JPA MySQL - Mini Project - Part 02

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDMwNjU4MzExNTE1/details

```
						Date : 26-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*)URL Re-Writing :-
  Creating one URL using static path and dynamic path

ex: /employee/delete?id=1
    /employee/delete?id=2

-code--
<a
   th:href="
             @{  /employee/delete  ( id=${ob.empId} )  }
	  ">

   DELETE
</a>

===Modified Code================
1. Custom Exception class
package in.nareshit.raghu.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}

2. ServiceImpl code
package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.exception.EmployeeNotFoundException;
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
		if(emp.getEmpId()==null || !repo.existsById(emp.getEmpId()))
			throw new EmployeeNotFoundException(emp.getEmpId()+"-not exist");
		else
			repo.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		//repo.deleteById(id);
		repo.delete(getOneEmployee(id));
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new EmployeeNotFoundException(id+"-not exist");
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

}


3. Controller code (modified methods)
	//3. show All Employees
	@GetMapping("/all")
	public String viewAll(
			@RequestParam(value = "message", required = false)String message,
			Model model)
	{
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "EmployeeData";
	}

	//4. Delete one Employee By id
	@GetMapping("/delete")
	public String delete(
			@RequestParam("id") Integer id,
			RedirectAttributes attributes
			)
	{
		String message = null;
		try {
			service.deleteEmployee(id);
			 message = id+"-deleted!";
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		attributes.addAttribute("message", message);
		return "redirect:all";
	}


	//5. Show Employee data in Edit Page by Id
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam("id") Integer id,
			Model model,
			RedirectAttributes attributes
			)
	{
		String page = null;
		try {
			Employee emp = service.getOneEmployee(id);
			model.addAttribute("employee", emp);
			page = "EmployeeEdit";
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}


	//6. Update Employee data on update(submit)
	@PostMapping("/update")
	public String updateEmp(
			@ModelAttribute Employee employee,
			RedirectAttributes attributes
			)
	{
		service.updateEmployee(employee);
		String message = "Employee '"+employee.getEmpId()+"' Updated!";
		attributes.addAttribute("message", message);
		return "redirect:all";
	}

4) UI Pages
----EmployeeData.html-------------
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
  		<th>OPERATIONS</th>
  	</tr>
  	<tr th:each="ob:${list}">
  		<td>[[${ob.empId}]]</td>
  		<td>[[${ob.empName}]]</td>
  		<td>[[${ob.empSal}]]</td>
  		<td>[[${ob.empGen}]]</td>
  		<td>[[${ob.empDept}]]</td>
  		<td>[[${ob.empAddr}]]</td>
  		<td>
  			<a th:href="@{/employee/delete(id=${ob.empId})}">DELETE</a> |
  			<a th:href="@{/employee/edit(id=${ob.empId})}">EDIT</a>
  		</td>
  	</tr>
  </table>
  <div>[[${message}]]</div>
 </body>
</html>

--------EmployeeEdit.html----------------------
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>EMPLOYEE EDIT PAGE</h3>
  <form method="post" th:action="@{/employee/update}" th:object="${employee}">
  <pre>
    ID   : <input type="text" th:field="*{empId}" readonly>
	NAME : <input type="text" th:field="*{empName}">
	SAL  : <input type="text" th:field="*{empSal}">
	GEN  :
	   <input type="radio" th:field="*{empGen}" value="Male"/> Male
	   <input type="radio" th:field="*{empGen}" value="Female"/> Female
	DEPT : <select th:field="*{empDept}">
	          <option value="">--SELECT--</option>
	          <option value="DEV">DEV</option>
	          <option value="QA">QA</option>
	          <option value="BA">BA</option>
		  </select>
     ADDR : <textarea th:field="*{empAddr}"></textarea>
     <button type="submit">UPDATE</button> 		  
  </pre>
  </form>
 </body>
</html>

===UI Modified Files=======================================================================
1. EmployeeRegister.html
<html xmlns:th="https://www.thymeleaf.org/">

<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.0/css/font-awesome.min.css" />

	<title>Document</title>
</head>

<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h3>EMPLOYEE REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form method="post" th:action="@{/employee/save}">
					NAME : <input type="text" name="empName" class="form-control">
					SAL : <input type="text" name="empSal" class="form-control">
					GEN :
					<input type="radio" name="empGen" value="Male" /> Male
					<input type="radio" name="empGen" value="Female" /> Female
					<br/>
					DEPT : <select name="empDept" class="form-control">
						<option value="">--SELECT--</option>
						<option value="DEV">DEV</option>
						<option value="QA">QA</option>
						<option value="BA">BA</option>
					</select>
					ADDR : <textarea name="empAddr" class="form-control"></textarea>
					<button type="submit" class="btn btn-success">REGISTER <i class="fa fa-plus-square" aria-hidden="true"></i> </button>
				</form>
			</div>
			<div class="card-footer">
				<b> [[${message}]] </b>
			</div>
		</div>
	</div>

</body>

</html>

2. EmployeeEdit.html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Document</title>
 </head>
 <body>
  <h3>EMPLOYEE EDIT PAGE</h3>
  <form method="post" th:action="@{/employee/update}" th:object="${employee}">
  <pre>
    ID   : <input type="text" th:field="*{empId}" readonly>
	NAME : <input type="text" th:field="*{empName}">
	SAL  : <input type="text" th:field="*{empSal}">
	GEN  :
	   <input type="radio" th:field="*{empGen}" value="Male"/> Male
	   <input type="radio" th:field="*{empGen}" value="Female"/> Female
	DEPT : <select th:field="*{empDept}">
	          <option value="">--SELECT--</option>
	          <option value="DEV">DEV</option>
	          <option value="QA">QA</option>
	          <option value="BA">BA</option>
		  </select>
     ADDR : <textarea th:field="*{empAddr}"></textarea>
     <button type="submit">UPDATE</button> 		  
  </pre>
  </form>
 </body>
</html>
=====Bootstrap based Pagination======================================================================
1. At Data HTML Page
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-center">
						<li class="page-item" th:if="${!page.isFirst()}">
						   <a class="page-link" th:href="@{/employee/all(page=${0})}">First</a>
						</li>
						<li class="page-item" th:if="${page.hasPrevious()}">
						   <a class="page-link" th:href="@{/employee/all(page=${page.number-1})}">Previous</a>
						</li>
						<th:block th:each="i:${#numbers.sequence(0,page.totalPages-1)}">
						  <li class="page-item active" th:if="${i==page.number}">
						  	<a class="page-link" th:href="@{/employee/all(page=${i})}">[[${i+1}]]</a>
						  </li>
						  <li class="page-item" th:if="${i!=page.number}">
						  	<a class="page-link" th:href="@{/employee/all(page=${i})}">[[${i+1}]]</a>
						  </li>
						</th:block>
						<li class="page-item" th:if="${page.hasNext()}">
						  <a class="page-link" th:href="@{/employee/all(page=${page.number+1})}">Next</a>
						</li>
						<li class="page-item" th:if="${!page.isLast()}">
						   <a class="page-link" th:href="@{/employee/all(page=${page.totalPages-1})}">Last</a>
						</li>
					</ul>
				</nav>

2. AT Controller
	@GetMapping("/all")
	public String viewAll(
			@PageableDefault(page = 0,size=3)Pageable pageable,
			@RequestParam(value = "message", required = false)String message,
			Model model)
	{
		//List<Employee> list = service.getAllEmployees();
		Page<Employee> page = service.getAllEmployees(pageable);
		model.addAttribute("list", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("message", message);
		return "EmployeeData";
	}


3. Service interface
  Page<Employee> getAllEmployees(Pageable pageable);

4. Service Impl
