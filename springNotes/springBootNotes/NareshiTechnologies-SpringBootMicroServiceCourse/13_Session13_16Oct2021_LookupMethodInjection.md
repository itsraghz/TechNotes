# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 13 \
16 Oct 2021 Sat \
7 30 AM IST - 08 45 AM IST

# Agenda

* Lookup Method Injection (LMI) - Spring Scope

## Scenarios

Parent and child objects using HAS-A relation.

## Case Study

* Parent (Singleton) - Child (Prototype) -- Reference between parent and child has an issue.  
  * The link from Parent to Child is not updated with the new object Created, instead it holds on to the 1st child object
  * Reason : Parent object scope is Singleton - the reference assigned during the Parent object creation will be fixed.
* Rest of the other combinations work fine in Spring Core.
* Solution : Use Lookup Method Injection.

*Note* :

* Parent (Singleton) - Child (Singleton) -- Works fine!
* Parent (Prototype) - Child (Singleton) -- Works fine!
* Parent (Prototype) - Child (Prototype) - Works fine!
* Parent (Singleton) - Child (Prototype) -- NOT works fine!

*Project*: `Spring5CoreLookupMethod`

## Example - Token Vs TokenService

Everytime, a new token must be generated and set/linked with the TokenService.

* Token - Child
* TokenService - Parent (HAS-A)
* A TokenService has a Token.

```
TokenService ------<> Token
(singleton)          (Prototype)
1 object            n-objects
```

### Child Class - Spring Bean

File: `Token.java`

```java
package com.raghsonline.springcore.bean;

import java.util.Random;

public class Token {

	private int id;

	public Token() {
		this.id = new Random().nextInt(9999);
		System.out.println("Token (child) is created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + "]";
	}
}
```

### Parent Class - Spring Bean

File: `TokenService.java`

```java
package com.raghsonline.springcore.service;

import com.raghsonline.springcore.bean.Token;

public class TokenService {

	private Token token;

	public TokenService() {
		System.out.println("TokenService (Parent) is created");
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenService [token=" + token + "]";
	}
}
```

### Config file

*File*: `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="token" class="com.raghsonline.springcore.bean.Token" scope="prototype">
	</bean>

	<bean id="tokenService" class="com.raghsonline.springcore.service.TokenService" scope="singleton">
		<property name="token">
			<ref bean="token"/>
		</property>
	</bean>
</beans>
```

### Test Class

*File* : `Test.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.raghsonline.springcore.service.TokenService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

		/* Reading first time */
		TokenService ts1 = (TokenService) ac.getBean("tokenService");
		System.out.println(ts1);
		System.out.println(ts1.hashCode() + " - " + ts1.getToken().hashCode());

		/* Reading second time */
		TokenService ts2 = (TokenService) ac.getBean("tokenService");
		System.out.println(ts2);
		System.out.println(ts2.hashCode() + " - " + ts2.getToken().hashCode());

		/* Reading third time */
		TokenService ts3 = (TokenService) ac.getBean("tokenService");
		System.out.println(ts3);
		System.out.println(ts3.hashCode() + " - " + ts3.getToken().hashCode());
	}
}
```

### Console  Output

```java
TokenService (Parent) is created
Token (child) is created
TokenService [token=Token [id=7876]]
990355670 - 296347592
TokenService [token=Token [id=7876]]
990355670 - 296347592
TokenService [token=Token [id=7876]]
990355670 - 296347592
```

# Task

* Find a solution for this problem? How will you avoid the child object being referred with the first instance itself, despite being declared as a `prototype` in the `config.xml` ?
