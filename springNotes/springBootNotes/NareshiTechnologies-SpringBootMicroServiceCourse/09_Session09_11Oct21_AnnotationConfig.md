# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 09 \
11 Oct 2021 Mon \
7 30 AM IST - 08 45 AM IST

> Spring Boot & MS @ 7:30 AM (IST) by `Mr.Raghu_NEW` Link \
> Link: zoom.us/j/98599236248 \
> Registered myself in the new link. \

# Agenda

* Annotation Configuration Continuation

## App Config Class

*  A Java class is used for configuration, but annotated with `@Configuration` for its purpose.

```java
@Configuration
@ComponentScan(basePackage="in.nit")
class AppConfig {

}
```

> `@Component` lets the Spring Container creates an instance of the Bean.

## StereoType Annotation - `@Component`

## Supporting Annotation - `@Value`

* Direct Values in code - not a good approach
* Reading values from property files - Recommended and Important
* SpEL - Spring Expression Language

### Demo - `@Value` - direct

#### Spring Bean

*File*: `Product.java`

```java
package com.raghsonline.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pob")
public class Product {

	@Value("101")
	private Integer pId;

	@Value("PEN")
	private String pCode;

	public Product() {
		System.out.println("Product constructor invoked.");
	}

	@Override
	public String toString() {
		System.out.println("Product toString() invoked.");
		return "Product [pId=" + pId + ", pCode=" + pCode + "]";
	}
}
```

#### Config Java class

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "com.raghsonline.springcore")
public class AppConfig {

}
```

#### Test class

*Test.java*

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Object obj = ac.getBean("pob");
		System.out.println(obj);

		((AnnotationConfigApplicationContext) ac).close();
	}
}
```

#### Output  - Console

```
Product constructor invoked.
Product toString() invoked.
Product [pId=101, pCode=PEN]
```

## Supporting Annotation - `@PropertySource`

`@PropertySource("classpath:app.properties")`

### Demo - `@Value`  from config file

> The location : `src/main/resources`

(P) `org.springframework.env`
(I) `Environment`
(C) `StandardEnvironment`

* Create a New Maven Project 'Spring5CorePropertiesEx'
* Create a new properties file `jdbc.properties` under `src/main/resources`

```
#Comment - Key name can have a dot(.) and underscore('_')
my.app.driver=OracleDriver
my.app.url=jdbc.url.orcl-xyz
```

#### Properties file `jdbc.properties`

```
my.app.driver=OracleDriver
my.app.url=jdbc-orcl-xyz
my.app.un=raghs
my.app.pwd=RagPwd!
```

#### Spring Bean - `MyDataSource.java`

*File* : `MyDataSource.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dbCon")
public class MyDataSource {

	@Value("${my.app.driver}")
	private String driver;

	@Value("${my.app.url}")
	private String url;

	@Value("${my.app.un}")
	private String username;

	@Value("${my.app.pwd}")
	private String password;

	@Override
	public String toString() {
		return "MyDataSource [driver=" + driver + ", url=" + url + ", username=" + username + ", password=" + password
				+ "]";
	}
}
```

#### Config file `AppConfig.java`

*File*: `AppConfig.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.raghsonline.springcore")
@PropertySource("classpath:jdbc.properties")
public class AppConfig {

}
```

#### Test Class - `Test.java`

*File* : `Test.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Object obj = ac.getBean("dbCon");
		System.out.println(obj);

		((AnnotationConfigApplicationContext) ac).close();
	}
}
```

#### Console Output

```java
MyDataSource [driver=OracleDriver, url=jdbc-orcl-xyz, username=raghs, password=RagPwd!]
```

# Notes

* If a key is not present in the `@Value` annotation, the value is treated as a literal string - `${my.app.driver}` for example.
* If a key is not present in the `@Value` annotation for a numeric variable (`int port` for ex), the Spring Container will throw a `ParseException`
	as it would not be able to convert that to an interger parameter/member for the `port`.

## Loading Multiple Properties

It is possible with the *repeated annotation* and / or an `Array` format.

### Syntax 1 - Repeated

```java
@PropertySource("classpath:jdbc.properties")
@PropertySource("classpath:orm.properties")
@PropertySource("classpath:email.properties")
@PropertySource("classpath:security.properties")
```

### Syntax 2 - Array

```
@PropertySource({
	"classpath:jdbc.properties",
	"classpath:orm.properties",
	"classpath:email.properties",
	"classpath:security.properties",
})
public class AppConfig {

}
```

> The order of configuring the `.properties` file matter. If at all a same key has been configured in more than one file, the value of the key
> will be considered/preferred from the config file loaded at last.

### Example

#### Config file - new one `email.properties`

*File*: `email.properties`

```
my.mail.host=gmail.com
my.mail.port=999

my.app.driver=MySQLDriver-Email
```

#### Config file `AppConfig.java`

*File*: `AppConfig.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.raghsonline.springcore")
@PropertySource("classpath:jdbc.properties")
@PropertySource({
	"classpath:email.properties"
})
public class AppConfig {

}
```

#### Console Output

```
MyDataSource [driver=MySQLDriver-Email, url=jdbc-orcl-xyz, username=raghs, password=RagPwd!]
```

> *Note*: Careful observation will tell you that the value for `driver` has changed to `MySQLDriver.
