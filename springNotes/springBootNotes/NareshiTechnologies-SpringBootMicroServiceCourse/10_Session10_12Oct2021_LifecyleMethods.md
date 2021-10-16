# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 10 \
12 Oct 2021 Tue \
7 30 AM IST - 08 45 AM IST

# Agenda

* Lifecycle Methods 
* Sample SpringBoot Application

## LifeCycle Methods of a Spring Bean 

* `init`
* `destroy`

## Coding / Implementation 

* XML 
* Spring Interfaces
* Java Annotation 

### XML - Lifecycle 

```xml
<bean id="" class="" init-method="" destroy-method="">
  ...
</bean>
```

> Not in use due to performance issues.

### Spring Interfaces

> Generally Recommended. 

* (I) `InitiailizingBean` -- `afterPropertiesSet()` method
* (I) `DisposableBean` -- `destroy()` method

### Java Annotations 

* PostConstruct
* @PreDestroy 

> Both are removed now. 

## Example - XML Based 

* Add the additonal attributes in the `config.xml` file 


### Config file 

*File* : `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean 
		id="exportObj" 
		class="com.raghsonline.springcore.bean.ExcelExport"
		init-method="setUp"
		destroy-method="destroy"
	>
		<property name="name" value="ABC"/>
		<property name="data" value="Hello"/>
	</bean>
	
</beans>
```

### Maven Config 

*File :* `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
					http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.raghsonline</groupId>
	<artifactId>Spring5CoreLifeCycleEx</artifactId>
	<version>1.0</version>
	<name>Spring5CoreLifeCycleEx</name>
	<description>Spring 5 Core LifeCycle Example Project in Maven</description>
	
	<properties>
		<maven.compiler.source>14</maven.compiler.source>
		<maven.compiler.target>14</maven.compiler.target>
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

*File :* `ExcelExport.java`

```java
package com.raghsonline.springcore.bean;

public class ExcelExport {
	
	private String name;
	private String data;
	
	public ExcelExport() {
		super();
		System.out.println("ExcelExport is Created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() is called");
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ExcelExport [name=" + name + ", data=" + data + "]";
	}
	
	public void setUp() {
		System.out.println("Inside setUp() method");
	}
	
	public void destroy() {
		System.out.println("Inside destroy() method");
	}	
}
```

### Console Output 

```
ExcelExport is Created
setName() is called
Inside setUp() method
ExcelExport [name=ABC, data=Hello]
Inside destroy() method
```

> You need to close the container by invoking the `close()` method of the Implementation class of a Context, 
> in order to invoke the hook on destroy for a particular object bound in the context till now.

## Example - Spring Interfaces based 

* No need of any additional attributes in the `config.xml` file
* Implement the interfaces in the Spring Bean 

### Config file 

*File* : `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean 
		id="exportObjIntrf" 
		class="com.raghsonline.springcore.bean.ExcelExportSpringInterfaces"
	>
		<property name="name" value="ExportSpringInterface"/>
		<property name="data" value="afterPropertiesSet(), destroy()"/>
	</bean>	

</beans>
```
>  No need of the attributes `init-method` and `destroy-method` as it is taken in the Java class with the methods overridden. 

### Spring Bean 

*File : * `ExcelExportSpringInterfaces.java`

```java
package com.raghsonline.springcore.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExcelExportSpringInterfaces implements InitializingBean, DisposableBean {
	private String name;
	private String data;
	
	public ExcelExportSpringInterfaces() {
		super();
		System.out.println("ExcelExportSpringInterfaces is Created");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() is called");
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ExcelExportSpringInterfaces [name=" + name + ", data=" + data + "]";
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean-destroy() method called");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean-afterProperties() method called");
	}
}
```

### Test Class 

*File:* `Test.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");		
		Object obj = ac.getBean("exportObjIntrf");
		System.out.println(obj);
		
		ac.close();
	}
}
```

### Console Output 

```
ExcelExportSpringInterfaces is Created
setName() is called
InitializingBean-afterProperties() method called
ExcelExportSpringInterfaces [name=ExportSpringInterface, data=afterPropertiesSet(), destroy()]
DisposableBean-destroy() method called
```

## Example - Java Annotation based 

### Maven Config file 

*File : * `pom.xml`

Add a following dependency in the `<dependencies>` tag in the `pom.xml` file as the Annotations are declared in the `javax.annotation` package. 

The `@PostConstruct` and `@PreDestroy` were earlier available in Core Java and Spring provided an implementatin but now they are moved to a new package `javax.annotation`.

```xml
		<!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
		<dependency>
			<groupId>javax.annotation</groupId>
			<artifactId>javax.annotation-api</artifactId>
			<version>1.3.2</version>
		</dependency>
```

### Spring Bean 

*File : * `ExcelExportJavaAnnotation.java`

```java
package com.raghsonline.springcore.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("excelExportJava")
public class ExcelExportJavaAnnotation {
	
	@Value("ABC")
	private String name;
	
	@Value("ExcelExportJavaAnnotation")
	private String data;
	
	@PostConstruct // After creating an Object of this class
	public void setUp() {
		System.out.println("setUp() method called");
	}
	
	@PreDestroy // Before removing an Object from the context.
	public void destroy() {
		System.out.println("destroy() method called");
	}
	
	@Override
	public String toString() {
		return "ExcelExportJavaAnnotation [name=" + name + ", data=" + data + "]";
	}
}
```

### Java Config class 

*File : * `AppConfig.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.raghsonline.springcore")
public class AppConfig {

}
```

### Test Class 

*File : * `ConfigTest.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.raghsonline.springcore.config.AppConfig;

public class AppConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Object obj = ac.getBean("excelExportJava");
		System.out.println(obj);
		
		ac.close();
	}
}
```

### Console Output 

```
setUp() method called
ExcelExportJavaAnnotation [name=ABC, data=ExcelExportJavaAnnotation]
destroy() method called
```

# SpringBoot Sample Application 

* File -> New -> Spring Starter Project 
* Attributes as needed.

## Maven Config file 

*File : * `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
						http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.raghsonline</groupId>
	<artifactId>SpringBoot2FirstEx</artifactId>
	<version>1.0</version>
	<name>SpringBoot2FirstEx</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
	
</project>
```

### Java Executable Class 

*File : * `SpringBoot2FirstExApplication.java`

```java
```

### Console Output 

* Right Click on the Project. 
* Run as -> `Spring Boot Application`

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v2.5.5)[0;39m

[2m2021-10-13 01:12:44.336[0;39m [32m INFO[0;39m [35m40216[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.r.s.SpringBoot2FirstExApplication     [0;39m [2m:[0;39m Starting SpringBoot2FirstExApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 40216 (C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBoot2FirstEx\target\classes started by raghs in C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBoot2FirstEx)
[2m2021-10-13 01:12:44.338[0;39m [32m INFO[0;39m [35m40216[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.r.s.SpringBoot2FirstExApplication     [0;39m [2m:[0;39m No active profile set, falling back to default profiles: default
[2m2021-10-13 01:12:44.714[0;39m [32m INFO[0;39m [35m40216[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.r.s.SpringBoot2FirstExApplication     [0;39m [2m:[0;39m Started SpringBoot2FirstExApplication in 0.628 seconds (JVM running for 1.256)

```
