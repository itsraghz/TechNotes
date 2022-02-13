# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 87 \
13 Feb 2022 Sun \
* Part I  - 7 00 AM IST - 08 30 AM IST
* Part II - 9 35 AM IST to 10 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringCloud ORM, In Memory, CSRF Token, JWT

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5MDU4Mzc3NDQ0/details

```
						Date : 13-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
JWT Security (task)
https://www.youtube.com/watch?v=feETfZbvu-k
https://www.youtube.com/watch?v=Hzkw846jIOU
https://www.youtube.com/watch?v=bJAsHOH4lMk


			Spring Security ORM (UserDetailsService)

1. User Register Process
2.*** User Login and Password Encoder
3. Custom Login Page
4. HttpSession and CSRF View
===================================================================
		Stage#1 User Register Process

Name : SpringBootSecurityOrmEx
Dep  : Lombok, Data Jpa, MySQL, Web, Thymeleaf, DevTools

1. application.properties
#Database connection keys
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

#JPA Details
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
----------------------------------------
2. Entity class : User.java

package in.nareshit.raghu.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usertab")
public class User {
	@Id
	@Column(name="uid")
	private Integer userId;
	@Column(name="udispname")
	private String displayName;
	@Column(name="uemail")
	private String userEmail;
	@Column(name="upwd")
	private String userPwd;

	@ElementCollection
	@CollectionTable(
			name="rolestab",
			joinColumns = @JoinColumn(name="uid")
			)
	@Column(name="urole")
	private Set<String> userRoles;
}
--------

3. Repository Interface : UserRepository.java
package in.nareshit.raghu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserEmail(String userEmail);

}
--------------------
4. Service Interface : IUserService.java

package in.nareshit.raghu.service;

import java.util.Optional;

import in.nareshit.raghu.entity.User;

public interface IUserService {

	Integer saveUser(User user);
	Optional<User> findByUserEmail(String userEmail);
}
---------------
5. Service Impl : UserServiceImpl.java
package in.nareshit.raghu.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.repo.UserRepository;
import in.nareshit.raghu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;

	public Integer saveUser(User user) {
		return repo.save(user).getUserId();
	}

	public Optional<User> findByUserEmail(String userEmail) {
		return repo.findByUserEmail(userEmail);
	}

}
---------
6. Controller   : UserController.java
package in.nareshit.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	//1. Show Register page
	@GetMapping("/register")
	public String showReg() {
		return "UserRegister";
	}

	//2. Save user data
	@PostMapping("/save")
	public String saveUser(
			@ModelAttribute User user,
			Model model
			)
	{
		Integer id = service.saveUser(user);
		String msg = "User '"+id+"' created";
		model.addAttribute("message", msg);
		return "UserRegister";
	}

}
---------------
7. Register Page: UserRegister.html
<html xmlns:th="https://www.thymeleaf.org/">
	<head>
		<title>REGISTER</title>
	</head>
	<body>
		<h3>USER REGISTER PAGE</h3>
		<form th:action="@{/user/save}" method="POST">
		<pre>
			Name  : <input type="text" name="displayName" id="displayName"/>
			Email : <input type="text" name="userEmail" id="userEmail"/>
			Pwd   : <input type="password" name="userPwd" id="userPwd"/>
			Roles :
					<input type="checkbox" name="userRoles" id="userRoles1" value="ADMIN"/> ADMIN
					<input type="checkbox" name="userRoles" id="userRoles2" value="EMPLOYEE"/> EMPLOYEE
				<input type="submit" value="Register"/>					
		</pre>
		</form>
		<b>[[ ${message}  ]] </b>
	</body>
</html>

=======================================================================
	Stage 2: *** User Login and Password Encoder

1. Add Security Dependency
> Right click on Project > Spring > Add Starter > Select Spring Security
> next > pom.xml > finish

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

2. AppConfig (For PasswordEncoder bean)
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
-------------Service Impl save method ---------
	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Integer saveUser(User user) {
		//Read Form Password and Encode
		String encPwd = encoder.encode(user.getUserPwd());
		//set back to same object
		user.setUserPwd(encPwd);
		//save into DB
		return repo.save(user).getUserId();
	}

-----------------------------------------

3. UserDetailsService(I) Impl class


package in.nareshit.raghu.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.repo.UserRepository;
import in.nareshit.raghu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Integer saveUser(User user) {
		//Read Form Password and Encode
		String encPwd = encoder.encode(user.getUserPwd());
		//set back to same object
		user.setUserPwd(encPwd);
		//save into DB
		return repo.save(user).getUserId();
	}

	public Optional<User> findByUserEmail(String userEmail) {
		return repo.findByUserEmail(userEmail);
	}


	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<User> opt = findByUserEmail(username);
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException("Not exist");
		} else {
			//entity user
			User user =  opt.get();
			//spring security user
			return new org.springframework.security.core.userdetails.User(
					user.getUserEmail(),
					user.getUserPwd(),
					user.getUserRoles()
					.stream()
					.map(role-> new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet())
					);
		}
	}
}

---------------------------------
4. SecurityConfig

package in.nareshit.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Inmemory, JDBC, ORM(now)
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/home").authenticated()
		.antMatchers("/user/register","/user/save").permitAll()

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


-----------------------------------
*) Run app and Enter URL
http://localhost:8080/user/register
http://localhost:8080/admin
http://localhost:8080/emp



*) Authority : Role
*) GrantedAuthority(I) allocated roles to Users
   Impl class is SimpleGrantedAuthority(C)

Ex: App is having roles(Authorities) : ADMIN, EMPLOYEE, CLERK, GUEST, STUDENT ..etc

   SAME is a USER allocated roles (GrantedAuthorities ) are ADMIN, EMPLOYEE

   class SimpleGrantedAuthority implements GrantedAuthority  {}

   String role = "ADMIN"; //security can not understand this
   GrantedAuthority ga1 = new SimpleGrantedAuthority(role);


========================================================================
Internal Flow (Filters and HttpSession)

*) If we make any request below filter is called:
  UsernamePasswordAuthenticationFilter(C)
  >> Reading username and password (req.getParameter()
  >> Allowed only POST methods
  >> Calling UsernamePasswordAuthenticationToken
     which calls UserDetailsService(I) impl class
  >> UserServiceImpl is called
  >> Loading user by email(username)
  >> Converting into Spring Security object
  >> Create HttpSession
    AbstractSessionFixationProtectionStrategy(C)
    onAuthentication() method
 >> check SessionExist or not?
    Read old session: request.getSession(false)
    Else create new Session :
       request.getSession(true)
       request.getSession()
     Which creates HttpSession(I)

  >> Sun provided a standard to Store username : Principal(I)
  >> Sub Interface given by Spring Security : Authentication(I)
  		[username + roles ]
  >> Impl class: UsernamePasswordAuthenticationToken(C)
  >> SecurityContextHolder and linked to Session
  //to read current usern name and roles
    SecurityContext sc = SecurityContextHolder.getContext();
    Authentication auth = sc.getAuthentication();
    String name = auth.getName(); //username
    auth.getAuthorities(); //roles


*) On click logout link:
  SecurityContextLogoutHandler(C) -logout() is called

  >> Read Current session

   HttpSession session = request.getSession(false);


  >> remove session (invalidate)

   session.invalidate();

  >> Set null to SecurityContext

   context.setAuthentication(null);

**** use ctrl+shift+T (open type) Enter class to open pre-defined classes.
=======================================================================
		    Stage #3 Custom Login Page

*) Default HTML page is given by Spring Security itself.
   Main part of Code looks like:

   <form  method="post" action="/login">
     <input type="text" id="username" name="username" />
     <input type="password" id="password" name="password"/>
     <button  type="submit">Sign in</button>
   </form>

*) URL : /login and Method Type : POST
*) Above Login request is calling : UsernamePasswordAuthenticationFilter(C)
   attemptAuthentication() method.

			Defaults            Customize
		--------------------------------------------
Show Login             /login + GET       /user/login + GET

Login Validation       /login + POST         /login + POST

Login Failed            /login?error      /user/login?error=true

Logout Success          /login?logout     /user/login?logout=true

*) Create Login page and show Login Page

1) Controller method:
	@GetMapping("/login")
	public String showLogin() {
		return "UserLogin";
	}

2) Security Config (Modified Code)
package in.nareshit.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Inmemory, JDBC, ORM(now)
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/home").authenticated()
		.antMatchers("/user/register","/user/save","/user/login").permitAll()

		.anyRequest().authenticated()

		// + Form/Login
		.and()
		.formLogin() //Generates one Login Page
		.loginPage("/user/login") //to Show Login page
		.loginProcessingUrl("/login") //login processing URL
		.defaultSuccessUrl("/home", true) //one login success goto where?
		.failureUrl("/user/login?error=true") //On login failed

		// + Logout
		.and()
		.logout() //Logout code is provided
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //For which URL Logout must be done
		.logoutSuccessUrl("/user/login?logout=true") //On logout success

		// + ExceptionHandling
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
	}
}

3) UserLogin.html (Custom Login Page)
<html xmlns:th="https://www.thymeleaf.org/">
	<head>
		<title>REGISTER</title>
	</head>
	<body>
		<h3>USER LOGIN PAGE</h3>
		<form  method="post" th:action="@{/login}">
		<pre>
    			username :  <input type="text" id="username" name="username" required/>
     			password :  <input type="password" id="password" name="password" required/>
     			<button type="submit">Sign in</button>
		</pre>
		</form>
		<div th:if="${param.error}"> Login Failed!!</div>
		<div th:if="${param.logout}"> Logout Success!!</div>
		<br/>
		Dont you have account <a th:href="@{/user/register}">Register</a>
	</body>
</html>
=================================================================
		4. HttpSession and CSRF View

*) Session Management : Store data and handle for a period of time
		share between multiple pages (user data)

  HttpSession concept in Servlets (in spring and boot)

1. creating a new session on login success

  HttpSession session = request.getSession();

  ctrl+shift+T : AbstractSessionFixationProtectionStrategy(C)
  ctrl+O       : onAuthentication()
  ctrl+L       : 82

2. Reading old session

 HttpSession session =  request.getSession(false);

3. Remove/Delete existed session on logout

 HttpSession session =  request.getSession();
 if(session!=null)
   session.invalidate();

ctrl+shift+T   : SecurityContextLogoutHandler(C)
  ctrl+O       : logout()
  ctrl+L       : 61


*** HomeController code *********
	@GetMapping("/home")
	public String showHome(Principal p,HttpSession session) {
		String username = p.getName();
		System.out.println(username);
		User user = service.findByUserEmail(username).get();
		session.setAttribute("userRoles", user.getUserRoles());
		session.setAttribute("userDisplayName", user.getDisplayName());
		//session.setMaxInactiveInterval(600); //in sec (10 mins) session max idel time
		//session.setMaxInactiveInterval(-1); //[Keep me logged in] session should never timeout
		return "HomePage";
	}

--HomePage.html---
<html xmlns:th="https://www.thymeleaf.org/">
 <head>
  <title>HOME Page</title>
 </head>
 <body>
  	<h3>WELCOME TO HOME (LOGIN SUCCESS) [[${session.userDisplayName}]] - [[${session.userRoles}]]</h3>
  	<a th:href="@{/logout}">LOGOUT</a>
 </body>
</html>
=======================================================================
*) Spam Emails?

Hey! You won $ 10000000000000000000 !! Enter yor bank account details below
to get this amount.. last 20 mins time.

*) To handle CSRF Attacks (Cross Site Request Forgery)
  Spring Boot is Generating one Token, CSRF Token and validating it while
  submitting. Attacker can not read or provide token.

  CsrfWebFilter
  CsrfRequestDataValueProcessor (to validate)
  CsrfAuthenticationStrategy(for generating)

===========================================================================
		(JWT) : JSON Web Token

*** Stateless(no httpSession)
Statefull(using HttpSession)
JWT Security
https://www.youtube.com/watch?v=feETfZbvu-k
https://www.youtube.com/watch?v=Hzkw846jIOU
https://www.youtube.com/watch?v=bJAsHOH4lMk
