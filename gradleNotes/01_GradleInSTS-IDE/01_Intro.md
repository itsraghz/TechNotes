# Gradle Tutorial in STS IDE 

In this post/page, we will see how can we use Gradle in a few different applications in the STS IDE. 

* Basic Core Java Application
* Core Java JDBC Application
* Servlet Web Application 
* Hibernate Core Java Application 
* Spring Core Application 
* Spring Boot Application 

> *Note*: The focus is on using Gradle and not the technologies or the applications. Hence, the applications will be of very basic.

```gradle
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.9/userguide/building_java_projects.html
 */

plugins {
    // Apply the java-library plugin for API and implementation separation.
    id 'java'
}

repositories {
    mavenCentral()
}

// version
sourceCompatibility = 14
targetCompatibility = 14

dependencies {
	// https://mvnrepository.com/artifact/commons-codec/commons-codec
	implementation group: 'commons-codec', name: 'commons-codec', version: '1.15'
}

//task 
task fatJar(type: Jar) {
	manifest {
		attributes 'Main-Class' : 'com.raghsonline.gradle.Base64EncoderDemo' 
	}
	
	baseName = 'my-first-gradle-app'
	
	from {
		configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it)} 
	} with jar 
}
```

```sh
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj\lib
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: build

> Task :lib:compileJava
> Task :lib:processResources NO-SOURCE
> Task :lib:classes
> Task :lib:jar
> Task :lib:assemble
> Task :lib:compileTestJava NO-SOURCE
> Task :lib:processTestResources NO-SOURCE
> Task :lib:testClasses UP-TO-DATE
> Task :lib:test NO-SOURCE
> Task :lib:check UP-TO-DATE
> Task :lib:build

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```


```
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: fatJar

> Task :lib:compileJava UP-TO-DATE
> Task :lib:processResources NO-SOURCE
> Task :lib:classes UP-TO-DATE
> Task :lib:fatJar

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 4s
2 actionable tasks: 1 executed, 1 up-to-date
```

```
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: clean

> Task :lib:clean FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':lib:clean'.
> java.io.IOException: Unable to delete directory 'C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj\lib\build'
    Failed to delete some children. This might happen because a process has files open or has its working directory set in the target directory.
    - C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj\lib\build\libs

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 179ms
1 actionable task: 1 executed
```


```
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\FirstGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: clean

> Task :lib:clean

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 68ms
1 actionable task: 1 executed
```

## Gradle - Servlet Application 

*build.gradle* file 

```
plugins {
	id 'java'
	id 'war'
	id 'org.gretty' version '3.0.5'
}

sourceCompatibility = 14
targetCompatibility = 14

repositories {
	mavenCentral()
}

dependencies {
	// https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
	compileOnly group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
}

// custom task

war {
	archiveName = 'ServletGradleProj.war'
}

gretty {
	httpPort = 8282
	contextPath = '/'
	servletContainer = 'jetty9'
}
```

## Gradle Build - Successful - for WAR file creation for Servlet Project 

```
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\ServletGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: :lib:build

> Task :lib:compileJava UP-TO-DATE
> Task :lib:processResources NO-SOURCE
> Task :lib:classes UP-TO-DATE
> Task :lib:war
> Task :lib:assemble
> Task :lib:compileTestJava
> Task :lib:processTestResources NO-SOURCE
> Task :lib:testClasses
> Task :lib:test NO-SOURCE
> Task :lib:check UP-TO-DATE
> Task :lib:build

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 279ms
3 actionable tasks: 2 executed, 1 up-to-date
```

### `appStart` in `gretty` plugin on a Gradle Project for a Servlet App 

```java
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\ServletGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: appStart

> Task :lib:prepareInplaceWebAppFolder NO-SOURCE
> Task :lib:createInplaceWebAppFolder
> Task :lib:compileJava UP-TO-DATE
> Task :lib:processResources NO-SOURCE
> Task :lib:classes UP-TO-DATE
> Task :lib:prepareInplaceWebAppClasses UP-TO-DATE
> Task :lib:prepareInplaceWebApp
> Task :lib:appStart

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:/C:/Users/Raghavan%20Muthu/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy/2.5.12/c5a65ece40ef0030e6958af990bd6d83b4e206ec/groovy-2.5.12.jar) to method java.lang.Object.finalize()
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20:51:59 INFO  Jetty 9.2.26.v20180806 started and listening on port 8282
20:51:59 INFO   runs at:
20:51:59 INFO    http://localhost:8282/

> Task :lib:appStart
Run 'gradle appStop' to stop the server.
```

### Gradle `appStop` task on a Servlet Project 

```
Working Directory: C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\ServletGradleProj
Gradle user home: C:\Users\Raghavan Muthu\.gradle
Gradle Distribution: Specific Gradle version 6.9
Gradle Version: 6.9
Java Home: C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2
JVM Arguments: None
Program Arguments: None
Build Scans Enabled: false
Offline Mode Enabled: false
Gradle Tasks: appStop

> Task :lib:appStop

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 30s
1 actionable task: 1 executed
```

## Gradle - Hibernate Project 

### `build.gradle` file 

```
plugins {
	id 'java'
}

repositories {
	mavenCentral()
}

sourceCompatibility = 14
targetCompatibility = 14

dependencies {
	// https://mvnrepository.com/artifact/org.hibernate/hibernate-core
	//implementation group: 'org.hibernate', name: 'hibernate-core', version: '5.5.7.Final'
	implementation 'org.hibernate:hibernate-core:5.5.7.Final'
	
	// https://mvnrepository.com/artifact/org.projectlombok/lombok	
	annotationProcessor group: 'org.projectlombok', name: 'lombok', version: '1.18.20'
	compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.20'
	
	/* ==== https://mvnrepository.com/artifact/mysql/mysql-connector-java ==== */
	// Short Form
	implementation 'mysql:mysql-connector-java:8.0.26'
}
```

### `hibernate.cfg.xml` file 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC 
  "-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<!-- Version 8 MySQL hiberante-cfg.xml example for Hibernate 5 -->
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost/test</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    <property name="hibernate.connection.username">raghs</property>
    <property name="hibernate.connection.password">RaghsMySQL12#</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>
    <property name="hibernate.hbm2ddl.auto">create</property>
    <mapping class="com.raghsonline.gradle.hibernate.Employee" />
  </session-factory>
</hibernate-configuration>
```

### Console Output 

```java
Oct 03, 2021 11:14:55 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.5.7.Final
Oct 03, 2021 11:14:55 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Oct 03, 2021 11:14:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Oct 03, 2021 11:14:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.cj.jdbc.Driver] at URL [jdbc:mysql://localhost/test]
Oct 03, 2021 11:14:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=raghs}
Oct 03, 2021 11:14:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Oct 03, 2021 11:14:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Oct 03, 2021 11:14:55 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
Hibernate: 
    
    drop table if exists TblEmployee
Oct 03, 2021 11:14:56 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@113e13f9] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table TblEmployee (
       id bigint not null auto_increment,
        firstName varchar(255),
        lastName varchar(255),
        salary double precision,
        primary key (id)
    ) engine=InnoDB
Oct 03, 2021 11:14:56 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@21079a12] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Oct 03, 2021 11:14:56 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
    insert 
    into
        TblEmployee
        (firstName, lastName, salary) 
    values
        (?, ?, ?)
The transction completed!
```

## Spring Core Project in Gradle 

### `build.gradle` file 

```
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.9/userguide/building_java_projects.html
 */

plugins {
    id 'java'
}

repositories {
	mavenCentral()
}

sourceCompatibility = 14
targetCompatibility = 14

dependencies {
	// https://mvnrepository.com/artifact/org.springframework/spring-context
	implementation group: 'org.springframework', name: 'spring-context', version: '5.3.10'
	
	// https://mvnrepository.com/artifact/org.projectlombok/lombok	
	annotationProcessor group: 'org.projectlombok', name: 'lombok', version: '1.18.20'
	compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.20'
	
}
```

### `Product.java` - Bean 

```java
package com.raghsonline.gradle.springcore;

import lombok.Data;

@Data
public class Product {
	
	private int productId;
	private String productCode;

}
```

### `config.xml` file 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="product" class="com.raghsonline.gradle.springcore.Product">
		<property name="productId">
			<value>101</value>
		</property>
		<property name="productCode">
			<value>Pen</value>
		</property>		
	</bean>
    
</beans>
```

### `SpringTest.java`

```java
/**
 * 
 */
package com.raghsonline.gradle.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		//Product product = (Product) context.getBean("product");
		Product product = context.getBean("product", Product.class);
		System.out.println("Product Bean : " + product);
	}
}
```

### Console Output 

```java 
Product Bean : Product(productId=101, productCode=Pen)
```