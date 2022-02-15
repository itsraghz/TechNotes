# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 89 \
15 Feb 2022 Tue \
7 00 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Oauth 2.x Login  Facebook

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDcwMDczNzU1NDM0/details

```
						Date : 15-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Oauth 2.x : Open Authorization

*) Open Standard Protocol to authorize a client application using Resource
   And Auth Server to access end user resoruces.

*) EndUser is identified by 3rdParty Services for a Application.

*) 3 Components:
 1. End user Machine (Browser)
 2. Client Application (Business Application)
 3. Authorization and Resource Server (3rd Party Server)

*) It is Open Source.
*) Good for Day to Day Business Applications
*) One Time Login (SSO-Single Sign On)
*) It is also called as Social Login.
  [Facebook Login, Google Login, Github Login, LinkedIn,...etc]

*) Not Recomanded in Finance based Applications,
   Only good at service(business ) based applications.

 Ex: bookmyshow, redbus, zomato, carewale, quicker, makemytrip...etc
     are day to day business application, simple authorization
     is fine.

     Who are you, emailId, profile pic, mobileNumber.,...etc

 Ex: ICICI Bank, CreditCard, AMT, Stock Market...etc
     are not recomanded to use Open-Auth (Or Social Login).
  ==============================================================================
			  Implementation Stages

Step#1. Register Client Application with Authorization and Resource Server

=> Client Application need to be register with Auth Server.
=> Auth Server provides clientId and secret to ClientApp.

Step#2. Register Enduser and provide profile data to Authorization and Resource Server

=> EndUser even needs to be register with Auth and Resource server,
   login and update their details(profile details)

=> You can use as regular social accoutn and Auth Server.

Step#3. Authorize Client+User combination, validate and generate Token
	Allow Client to Read User data.


a. User Request to Client Application , Login using OAuth Concept
b. Client Request user Grant(permission)
   Grant = Login First + Accept Condition

c. If user not logged in, redirect to Auth Server login page.
   ex: Facebook Login

d. Once user provded data and validate, it is sucess and redirect to grant page

e. Now, Enduser should click on Accept link ie providing Grant
  ex: Continue as AJAY


f. Finally client app goes to Auth Server with ClientId,Secret and usergrant

g. Auth server validates data and provides AccesToken which is valid for Client+User combination
   if Client is changed or user is changed that is not going to work.

h. Client Request to Read EndUser data with AccessToken from Resource server

i. Resource server validating AccesToken and sharing userdata.

j. Client stores userdata (in DB/Temp memory)

k. Finally client says, User login success using Facebook.


==============================================================================
Step#1. Register Client Application with Authorization and Resource Server

A) Goto https://developers.facebook.com/
B) Login if not into Facebook Account
C) Click on MyApps on Top Right Corner
D) Click on Create App, Select Consumer, Enter App details
  Name : NIT-BMS-SAMPLE > Click on create button

E) Click on Project Options (Top Left Corner)
F) Create Test application
G) Goto Settings > Basics > Copy clientId and secret
 clientId : 1075996906516110
 secret   : d04383fa0a02dc108a4465a78866c3f8


Step#2. Register Enduser and provide profile data to Authorization and Resource Server

>> You create FB account, Update Profile details


Stage#3 coding part
Name : *SpringBootOAuthFBEx*
Dep  : Web, Spring Security, OAuth2 Client, Devtools

a. application.yml
```java
server:
  port: 8080
spring:
  application:
    name: OAuth-Test-App
  security:
    oauth2:
      client:
        registration:
          facebook:
            client-id: 1075996906516110
            client-secret: d04383fa0a02dc108a4465a78866c3f8
```

b. Security Config
```java
package in.nareshit.raghu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory, JDBC, UserDetails
		auth.inMemoryAuthentication().withUser("sam").password("{noop}sam").authorities("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		.anyRequest().authenticated()

		.and()
		.formLogin()
		.defaultSuccessUrl("/user",true)

		.and()
		.oauth2Login()

		.and()
		.logout()
		;
	}
}
```

c. Controller class
```java
package in.nareshit.raghu.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@GetMapping("/welcome")
	public String showWelcome() {
		return "WELCOME TO ALL!";
	}

	@GetMapping("/user")
	public Authentication showUser(Principal p) {
		System.out.println(p.getName());
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@GetMapping("/home")
	public String showhome() {
		return "WELCOME AFTER LOGIN";
	}
}
```

d. Run application and enter URL:
```
http://localhost:8080/welcome
http://localhost:8080/user
http://localhost:8080/logout
```
==================================================================
