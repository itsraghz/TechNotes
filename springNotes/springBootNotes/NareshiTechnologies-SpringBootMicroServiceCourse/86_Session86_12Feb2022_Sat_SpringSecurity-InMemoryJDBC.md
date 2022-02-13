# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 86 \
12 Feb 2022 Sat \
7 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringCloud Gateway

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5MDU4Mzc3NDQ0/details

```
						Date : 12-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring Security
https://www.youtube.com/watch?v=XTyQIrlyWfQ
https://www.youtube.com/watch?v=7wA46kRh2u8
https://www.youtube.com/watch?v=oLlSs-p6OEs
https://www.youtube.com/watch?v=cnrJ-Nnvoik
https://www.youtube.com/watch?v=rgG2_T-OB8g

JWT Security
https://www.youtube.com/watch?v=feETfZbvu-k
https://www.youtube.com/watch?v=Hzkw846jIOU
https://www.youtube.com/watch?v=bJAsHOH4lMk


					*Spring Boot Security Concept*
		 *JAAS* : Java Authentication and Authorization Service

*) JAAS is given by Sun/Oracle. Implemented by Spring and Boot.

*) Authentication : Store and Validate User details (username and password)

1. InMemoryAuthentication : Storing User data inside RAM(Random Access memory)
	temp memory. Validate when Request comes.
 [Testing purpose , without using DB]

2. Jdbc Authentication : Storing User data inside Database and validate using
				SQL queries (check user, check role)

3.*** UserDetailsService (ORM) : Storing User data inside Database and validate user
			using ORM Concepts[Spring Data JPA]

=======================================================================
*) Authorization : Role Management (Who can access what in application)
		[Which User can access what Resources]

*) Bank Application
 Role
 -------------------------------
 Customer  (SAM)   RequestFor Loan
 Manager   (SYED)  Approve Loan

 Faculty
 Student
 NTStaff

 Admin
 User
 Guest

 ..etc


Authorization is 3 types again :-
1. permitAll		: No Security check, allow every user to access this Resources

	URL : /contactUs, /homePage, /LoginPage, /RegisterPage
		No Login, Everyone can see this.

2. Authentication	: Login is must, User can have any only

	URL : /profile, /logout, /settings, ..etc

3. hasAuthority		: Login Must + matching Role also required.

       URL: /reqLoan     + CUSTOMER
            /approveLoan + MANAGER
	    /addMember   + ADMIN
=============================================================================
*) Spring Security has provided one Pre-defined filter named as "DelegatingFilterProxy"
   It is called before sending request to servlets.

   it is doing JAAS work using one Impl class of : WebSecurityConfigurerAdapter(AC)
   it has 2 methods 1 is for Authentication anther one for Authorization.

WebSecurityConfigurerAdapter
 configure​(AuthenticationManagerBuilder):void
 configure​(HttpSecurity):void

============InMemoryAuthentication======================================
*) Write Application using Spring Web and Thymeleaf as


	URL            Page                    Access level
  ---------------------------------------------------------------------------
      /welcome    WelcomePage.html            PermitAll-Everyone
      /emp        EmployeePage.html           hasAuthority[EMPLOYEE] [login + role-EMPLOYEE]
      /admin      AdminPage.html              hasAuthority[ADMIN] [login + role-ADMIN]
      /home       HomePage.html               After Login [authenticated]
      /denied     DeniedPage.html             For Wrong access [403 Forbidden]

=> If your login is falied ie 401 Unauthorized
  if login sucess but role is not matching then 403 Forbidden

=> Spring Security provides
    >> Default Login Page (no code required)
    >> Default Form validation
    >> Default User validation(login valdation code)
    >> Session Creation and Destory..etc
    >> Logout code

=========================================================================
Coding for InMemoryAuthentication:-

a. Name : SpringBootSecurityInMemoryEx
   Dep  : Spring Web, Lombok, Devtools, Thymeleaf

b. Controller class
```java
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showA() {
		return "Page";
	}

	@GetMapping("/welcome")
	public String showWelcome() {
		return "WelcomePage";
	}

	@GetMapping("/admin")
	public String showAdmin() {
		return "AdminPage";
	}

	@GetMapping("/emp")
	public String showEmployee() {
		return "EmployeePage";
	}

	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}

	@GetMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
}
```

c. UI Pages

--WelcomePage.html--------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Welcome Page</title>
 </head>
 <body>
  	<h3>WELCOME TO ALL</h3>
 </body>
</html>
```

---AdminPage.html-----------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>ADMIN Page</title>
 </head>
 <body>
  	<h3>WELCOME TO ADMIN</h3>
 </body>
</html>
```

--EmployeePage.html---------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>EMPLOYEE Page</title>
 </head>
 <body>
  	<h3>WELCOME TO EMPLOYEE</h3>
 </body>
</html>
```
----HomePage.html------------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>HOME Page</title>
 </head>
 <body>
  	<h3>WELCOME TO HOME (LOGIN SUCCESS)</h3>
 </body>
</html>
```
-------------DeniedPage.html--------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>DENIED Page</title>
 </head>
 <body>
  	<h3>YOU CAN NOT ACCESS THIS PAGE</h3>
 </body>
</html>
```
======================
d. Add Security Dependency
```
> Right click on Project > Spring > Add Starters > select Spring Security
> next > select pom.xml > Finish
```
(or pom.xml)
```xml
<dependency>
 	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
---Common Template ----------------
```java
package in.nareshit.raghu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory/JDBC/ORM
	}

	//Authorization
	protected void configure(HttpSecurity http) throws Exception {
		// URL - Access Level
		// + Form/Login
		// + Logout
		// + ExceptionHandling
	}
}
```
		(inside RAM)
   ----------------------------------------------
	user        password         role
   ----------------------------------------------
	SAM          SAM            EMPLOYEE
	SYED         SYED           ADMIN
	AJAY         AJAY           STUDENT
   ----------------------------------------------

equal configuration code:
```java
auth.inMemoryAuthentication().withUser("SAM").password("{noop}SAM").authorities("EMPLOYEE");
auth.inMemoryAuthentication().withUser("SYED").password("{noop}SYED").authorities("ADMIN");
auth.inMemoryAuthentication().withUser("AJAY").password("{noop}AJAY").authorities("STUDENT");
```
*)Encode Password alwasy:
  Converting normal text into unreadable format
  ex:  HELLO -> aHatg%3b*2ndk

  Spring Security recomands to one passwordEncoder, but i'm saying
  i dont want any PasswordEncoder now : {noop} [NoOpPasswordEncoder]


*) antMatchers() --> Compares Request URL with given and provides access level

    ex: antMatchers("/emp").hasAuthority('EMPLOYEE')
      If you enter /emp URL in browser and you logged in as EMPLOYEE
        then allowed else goto Login page.


*) For Logout code Link : <a th:href="@{/logout}">LOGOUT</a>

---------------------------------------------------------
```java
package in.nareshit.raghu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory/JDBC/ORM
		auth.inMemoryAuthentication().withUser("SAM").password("{noop}SAM").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("SYED").password("{noop}SYED").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("AJAY").password("{noop}AJAY").authorities("STUDENT");
	}

	//Authorization
	protected void configure(HttpSecurity http) throws Exception {
		// URL - Access Level
		http.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/home").authenticated()

		.anyRequest().authenticated()

		// + Form/Login
		.and()
		.formLogin() //Generates one Login Page
		.defaultSuccessUrl("/home", true) //one login success goto where?

		// + Logout
		.and()
		.logout() //Logout code is provided
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //For which URL Logout must be done

		// + ExceptionHandling
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
	}
}
```
==========================================================================
		JDBC Authentication

=> Store data inside Database table
=> We can even use Password Encoder to convert password into unreadable format
=> Fetch and validate data using SQLs

```
	       usertab
  ------------------------------------
   uname    upwd     urole   uenabled
  ------------------------------------
    AJAY   gatbdjw%2 STUDENT   1
    SYED   Ts%37Hsgw ADMIN     1
    SAM    ^3hGGasjd EMPLOYEE  1
  ------------------------------------

SAM  $2a$10$YfA0qAQcct8po46uTvwWNufdUj9LzoPIenJXF8avlrtUrdbXgaznG
SYED $2a$10$MLv6Jl5pgyhXzZiOM07otuTerPw7lCVxI43AUh6A.zeFgyQpmS3ni
AJAY $2a$10$1lEdXea.DY19cFAuSpU3bufbVnnIF.EkA07jrQ5ba22XxNhuTifAm
```

--Example code for Password Encoder------
```java
package in.nareshit.raghu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		String pwd = "AJAY";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encPwd = encoder.encode(pwd);
		System.out.println(encPwd);
	}
}
```
---------------------------------------------------------------------------
MySQL Database setup:
```sql
mysql> drop database boot7am;

mysql> create database boot7am;

mysql> use boot7am;

mysql> show tables;

mysql> CREATE TABLE user_tab(uid INT, uname VARCHAR(30), upwd VARCHAR(70),uenabled INT,urole varchar(20));
```

```sql
INSERT INTO user_tab values(1,'SAM','$2a$10$YfA0qAQcct8po46uTvwWNufdUj9LzoPIenJXF8avlrtUrdbXgaznG',1,'EMPLOYEE');
INSERT INTO user_tab values(2,'SYED','$2a$10$MLv6Jl5pgyhXzZiOM07otuTerPw7lCVxI43AUh6A.zeFgyQpmS3ni',1,'ADMIN');
INSERT INTO user_tab values(3,'AJAY','$2a$10$1lEdXea.DY19cFAuSpU3bufbVnnIF.EkA07jrQ5ba22XxNhuTifAm',1,'STUDENT');
```

```sql
mysql> select * from user_tab;
+------+-------+--------------------------------------------------------------+----------+----------+
| uid  | uname | upwd                                                         | uenabled | urole    |
+------+-------+--------------------------------------------------------------+----------+----------+
|    2 | SYED  | $2a$10$MLv6Jl5pgyhXzZiOM07otuTerPw7lCVxI43AUh6A.zeFgyQpmS3ni |        1 | ADMIN    |
|    3 | AJAY  | $2a$10$1lEdXea.DY19cFAuSpU3bufbVnnIF.EkA07jrQ5ba22XxNhuTifAm |        1 | STUDENT  |
|    1 | SAM   | $2a$10$YfA0qAQcct8po46uTvwWNufdUj9LzoPIenJXF8avlrtUrdbXgaznG |        1 | EMPLOYEE |
+------+-------+--------------------------------------------------------------+----------+----------+
```

-------coding--------------------------------
a. Name : SpringBootSecurityJdbcEx
   Dep  : Spring Web, Lombok, Devtools, Thymeleaf, Security, JDBC , MySQL

b. Controller class
```java
package in.nareshit.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/welcome")
	public String showWelcome() {
		return "WelcomePage";
	}

	@GetMapping("/admin")
	public String showAdmin() {
		return "AdminPage";
	}

	@GetMapping("/emp")
	public String showEmployee() {
		return "EmployeePage";
	}

	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}

	@GetMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
}
```

c. UI Pages

--WelcomePage.html--------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>Welcome Page</title>
 </head>
 <body>
  	<h3>WELCOME TO ALL</h3>
 </body>
</html>
```

---AdminPage.html-----------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>ADMIN Page</title>
 </head>
 <body>
  	<h3>WELCOME TO ADMIN</h3>
	  	<a th:href="@{/logout}">LOGOUT</a>
 </body>
</html>
```

--EmployeePage.html---------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>EMPLOYEE Page</title>
 </head>
 <body>
  	<h3>WELCOME TO EMPLOYEE</h3>
	  	<a th:href="@{/logout}">LOGOUT</a>
 </body>
</html>
```
----HomePage.html------------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>HOME Page</title>
 </head>
 <body>
  	<h3>WELCOME TO HOME (LOGIN SUCCESS)</h3>
	  	<a th:href="@{/logout}">LOGOUT</a>
 </body>
</html>
```
-------------DeniedPage.html--------
```html
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>DENIED Page</title>
 </head>
 <body>
  	<h3>YOU CAN NOT ACCESS THIS PAGE</h3>
 </body>
</html>
```

d. AppConfig
```java
package in.nareshit.raghu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
```

e. Security Config
```java
package in.nareshit.raghu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory/JDBC/ORM
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT UNAME,UPWD,UENABLED FROM USER_TAB WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,UROLE FROM USER_TAB WHERE UNAME=?")
		.passwordEncoder(passwordEncoder);

	}

	//Authorization
	protected void configure(HttpSecurity http) throws Exception {
		// URL - Access Level
		http.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/home").authenticated()

		.anyRequest().authenticated()

		// + Form/Login
		.and()
		.formLogin() //Generates one Login Page
		.defaultSuccessUrl("/home", true) //one login success goto where?

		// + Logout
		.and()
		.logout() //Logout code is provided
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //For which URL Logout must be done

		// + ExceptionHandling
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
	}
}
```

f. application.properties
```java
#Database connection keys
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root
```
