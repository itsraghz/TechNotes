# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 11 \
13 Oct 2021 Wed \
7 30 AM IST - 08 45 AM IST

# Agenda

* `@Bean` Annotation
* `@Autowired` Annotation

## 4 Steps

* Write a Public class
* Add @Configuration to the class
* Write 1 method = 1 Bean
* Add @Bean annotation to the method

## Example - predefined class

* `DriverManagerDataSource` from Spring Framework  - `org.springframework.jdbc.datasource`
* We can write our custom/dummy example to replicate the same, to start with `MyDataSource`

## Example - with custom/user-defined class

* New Project : *Spring5CoreJavaConfigEx*

> SpringCore - write bean and Config \
> SpringBoot - no ned of any config, directly use the objects

### Maven config file

*File*: `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
			http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.raghsonline</groupId>
	<artifactId>Spring5CoreJavaConfigEx</artifactId>
	<version>1.0</version>
	<name>Spring5CoreJavaConfigEx</name>
	<description>Spring 5 Core Java Config Example Project in Maven</description>
	<properties>
		<maven.compiler.source>11</maven.compiler.source>
		<maven.compiler.target>11</maven.compiler.target>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.3.10</version>
		</dependency>
	</dependencies>
</project>
```

### Spring Bean

*File*: `MyDataSource.java`

```java
package com.raghsonline.springcore.bean;

public class MyDataSource {

	private String driver;
	private String url;
	private String userName;
	private String password;

	public MyDataSource() {
		super();
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MyDataSource [driver=" + driver + ", url=" + url + ", userName=" + userName + ", password=" + password
				+ "]";
	}
}
```

### Configuration class

*File*: `AppConfig.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raghsonline.springcore.bean.MyDataSource;

@Configuration
public class AppConfig {

	/* Manual Configuration via Java Classes with Annotation */
	/* Spring Boot helps us get the same via Auto-Configuration with the parent starter types */
	// the methodName - 'dsObj' will become the object reference name
	@Bean
	public MyDataSource dsObj() {
		MyDataSource ds = new MyDataSource();
		ds.setDriver("Oracle");
		ds.setUrl("jdbc-url");
		ds.setUserName("sample");
		ds.setPassword("test");
		return ds;
	}
}
```

### Configuration file

No need of any `config.xml` file here, as everything is taken care in the Java config file.

### Test Class

*File*: `Test.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Object ob = ac.getBean("dsObj");
		System.out.println(ob);

		((AnnotationConfigApplicationContext)ac).close();
	}
}
```

### Console Output

```sh
MyDataSource [driver=Oracle, url=jdbc-url, userName=sample, password=test]
```

## Property File

* Annotation Config - Use `@Value`
* Java Config - Use `Environment` Interface and use `env.gevProperty(key)` of `org.springframework.core.env` package.
* Spring Container creates the `Environment`  whose default implementation class is `StandardEnvironment`

### Reading values

* In case of Annotation config, use `@Value` to read the config data
* In case of Java Confgiuration,
  * Autowire the `Environment`
  * Use the method `getProperty()` of the `Environment` to read a value. It gets a key in `String` and returns the value in `String` datatype.

## Example

### Spring Bean

*File* : `MyDataSource.java`

No change. Same Bean class.

### Properties file

*File*: `jdbc.properties` in `src/main/resources` directory

```properties
# Keys for the JDBC Driver Configuration
my.app.driver=MySQL
my.app.url=jdbc:mysql:test
my.app.username=root
my.app.password=test
```

### Config File

*File*: `AppConfigForProperty.java`

We do the following in order to read the configured values from a properties file.

*  `autowire` the `Environment`
* Add `@PropertySource` to the Configuration class
* Read the property value from the `env` object using the `getProperty()` method

```java
package com.raghsonline.springcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.raghsonline.springcore.bean.MyDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfigForProperty {

	@Autowired
	private Environment env;

	@Bean
	public MyDataSource myDSviaProperty() {
		MyDataSource ds = new MyDataSource();

		//now fill the properties with the values retrieved from Environment object
		ds.setDriver(env.getProperty("my.app.driver"));
		ds.setUrl(env.getProperty("my.app.url"));
		ds.setUserName(env.getProperty("my.app.username"));
		ds.setPassword(env.getProperty("my.app.password"));

		return ds;
	}
}
```

### Test Class

*File*: `Test.java`

Here we have a new method to test the configuration from a newly written Configuration class

```java
package com.raghsonline.springcore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfig;
import com.raghsonline.springcore.config.AppConfigForProperty;

public class Test {

	public static void main(String[] args) {
		testJavaConfig();
		testPropertyConfig();
	}

	private static void testPropertyConfig() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigForProperty.class);
		Object ob = ac.getBean("myDSviaProperty");
		System.out.println(ob);

		((AnnotationConfigApplicationContext)ac).close();
	}

	private static void testJavaConfig() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Object ob = ac.getBean("dsObj");
		System.out.println(ob);

		((AnnotationConfigApplicationContext)ac).close();		
	}
}
```

### Console Output

```
MyDataSource [driver=Oracle, url=jdbc-url, userName=sample, password=test]
MyDataSource [driver=MySQL, url=jdbc:mysql:test, userName=root, password=test]
```

## Task

* Task 1 - Student (Sid, SName, SFee)
  * create Object using Java Config.
  * Load data from the Properties file
* Task 2 - JDBC Example (Advanced Java)
  * CRUD basic example
* Task 3 - Go through the Lombok Video in NareshIT YouTube - https://www.youtube.com/watch?v=kSceQH4fFi4&t=3365s
* Task 4 - Go through the Log4j Video in the NareshIT YouTube


> Reference Materials : https://www.mediafire.com/file/w5x9w5vcmkwkkdv/RaghuSirNareshITJavaPdfs.zip
