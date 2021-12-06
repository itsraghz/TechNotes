# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 47 \
06 Dec 2021 Mon \
7 15 AM IST - 7 35 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC Fragments

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQyMTI4ODYwNDM2/details

```
						Date : 06-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Web MVC - Fragments

*) Fragments : Reusable UI tages, given from a shared location to multiple pages.

Step#1 Create below folder System

|-templates
	 |-fragments
			|-common.html  (anyFileName.html)

Step#2 Define any tag with common HTML tags and name using
				th:fragment="name"

Step#3 Link Fragment using
			 th:replace="fragments/common :: name"


*) Note:
a. No duplicate HTML tags in multiple Pages [Reusable]
b. Easy to modify and maintain.


--sample code--------------------
a. common.html

<html xmlns:th="https://www.thymeleaf.org/">

<head th:fragment="headers">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.0/css/font-awesome.min.css" />
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
</head>


<nav th:fragment="menu" class="navbar navbar-expand-lg navbar-dark bg-dark">
 <a class="navbar-brand" href="#">EMPLOYEE APPLICATION</a>
 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	 <span class="navbar-toggler-icon"></span>
 </button>

 <div class="collapse navbar-collapse" id="navbarSupportedContent">
	 <ul class="navbar-nav mr-auto">
		 <li class="nav-item ">
			 <a class="nav-link text-white" th:href="@{/employee/register}">Register </a>
		 </li>
		 <li class="nav-item">
			 <a class="nav-link text-white" th:href="@{/employee/all}">Data</a>
		 </li>
		 <li class="nav-item dropdown">
			 <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
				 OPTIONS
			 </a>
			 <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				 <a class="dropdown-item" th:href="@{/employee/register}">Register</a>
				 <a class="dropdown-item" th:href="@{/employee/all}">Data</a>
			 </div>
		 </li>

	 </ul>

 </div>
</nav>

</html>
----------------------------------------------------------------------
b. EmployeeRegister.html (even in Edit and Data Pages)
<div th:replace="fragments/common :: headers"></div>

<div th:replace="fragments/common :: menu"></div>
