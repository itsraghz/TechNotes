# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 3
02 Oct 2021 Sat
7 30 AM IST 

> Old Google Classroom (till today for the Demo) : https://classroom.google.com/u/0/c/Mzk4MTAwMjE3OTE3?cjc=janenmj \
> New Zoom link and Google Classroom link will be shared by Admin from Monday onwards. 

## Software Installation and Project Setup 

* Using Maven
* Using Gradle 

## Software 

* JDK 11 or above - the latest (Stable)
* STS (Spring Tool Suite) Preferred over Eclipse (STS for Eclipse - Windows)
  > It is an extractable .zip file. No installation is required.
* JDK One time setup in STS - Replace the built in JDK with your JDK recently downloaded in the 'Installed JRE' item in 'Preferences'

## Spring Maven Project Creation / Setup 

> Search in YouTube in the "NareshIT YouTube Channel" with "Raghu Maven"

* Create a New Maven Project by giving the project coordinates/Artifacts
* Make the following changes in the `pom.xml` file 
  * Add Java Compiler Dependency to 11 (the default one is JDK5)
  * Add Spring Context Dependency 
* 

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
* Switch to `Windows -> Show View -> Project Explorer`.
* Make the changes in the `build.gradle` file 

```java
  plugins  {
    id 'java'
  }
```

> Dont forget to `Gradle -> Refresh Project` for the changes to take effect.

> No plugins are needed to be downloaded separately, as they come built in with the STS. 



### Gradle Tutorials by Mr Raghu in Naresh IT YouTube Channel 

* https://www.youtube.com/watch?v=xQQ982rgP9c
* https://www.youtube.com/watch?v=1B3KXwZYThI


