# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 3
02 Oct 2021 Sat
7 30 AM IST - 08 15 AM IST

> Old Google Classroom (till today for the Demo) : https://classroom.google.com/u/0/c/Mzk4MTAwMjE3OTE3?cjc=janenmj \
> New Zoom link and Google Classroom link will be shared by Admin from Monday onwards. 

## Software Installation and Project Setup 

* Using Maven
* Using Gradle 

## Software 

* JDK 11 or above - the latest (Stable)
* STS (Spring Tool Suite) Preferred over Eclipse (STS for Eclipse - Windows)
  > It is an extractable .zip file. No installation is required.


### STS Customization 

* JDK One time setup in STS - Replace the built in JDK with your JDK recently downloaded in the 'Installed JRE' item in 'Preferences'
* Increase the default font size for certain items to have a bettter readability without straining the eyes.
  * `Basic -> Text Font` to `Consolas`, `Bold`, `16` or `20` whichever is okay. 
  * `Basic -> Text Editor Block Selection Font` to `Consolas, Bold, 12`
  * `View and Editor Folders -> Tree and Table font for views` to `Segoe UI (default), Semibold, 12` or `16` whichever suits you.
  * `View and Editor Folders -> Part Title Font` to `Segoe UI (default), Semibold, 12` or `16` whichever suits you.
  
> The settings can be updated in the `Windows -> Preferences -> General -> Appearance -> Colors and Fonts`.
  
## Spring Maven Project Creation / Setup 

> Search in YouTube in the "NareshIT YouTube Channel" with "Raghu Maven"

* Create a New Maven Project by giving the project coordinates/Artifacts
* Make the following changes in the `pom.xml` file 
  * Add Java Compiler Dependency to 11 (the default one is JDK5)
  * Add Spring Context Dependency 

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
	https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.raghsonline</groupId>
	<artifactId>SpringFirstApp</artifactId>
	<version>0.0.1-SNAPSHOT</version>

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

> Dont forget to `Update Maven Project` - either by pressing `Alt + F5` ,or `Right Click -> Maven -> Update Project` for the settings to take effect. 

### Maven Tutorials by Mr Raghu in Naresh IT YouTube Channel 

* https://www.youtube.com/watch?v=9eJAvApRAI0
* https://www.youtube.com/watch?v=jOykBjSl1X0
* https://www.youtube.com/watch?v=iLwuhbnFPqo

## Spring Gradle Project Creation / Setup 

> Search in YouTube in the "NareshIT YouTube Channel" with "Raghu Gradle"

> Gradle is performant and easy to set up than Maven.

* Create a new Gradle Project 
* Override the Default Settings 
	* Choose the specific Gradle version `6.9`
	* Set the Java home directory
* Switch to `Windows -> Show View -> Project Explorer`.
* Make the changes in the `build.gradle` file after removing the boiler plate code for the defaults and the comments, to keep it simple in the beginning.

```java
plugins {    
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
	// https://mvnrepository.com/artifact/org.springframework/spring-context
	implementation group: 'org.springframework', name: 'spring-context', version: '5.3.10'
}
```

> Dont forget to `Gradle -> Refresh Project` for the changes to take effect.

> No plugins are needed to be downloaded separately, as they come built in with the STS. 



### Gradle Tutorials by Mr Raghu in Naresh IT YouTube Channel 

* https://www.youtube.com/watch?v=xQQ982rgP9c
* https://www.youtube.com/watch?v=1B3KXwZYThI


