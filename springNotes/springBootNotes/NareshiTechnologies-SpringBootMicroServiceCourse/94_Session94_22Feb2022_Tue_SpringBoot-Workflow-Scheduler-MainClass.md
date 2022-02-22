# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 94 \
22 Feb 2022 Tue \
7 00 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot Main Class, Workflow, Scheduler

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5NzA3MjQ2NTUz/details

## Contents

```
        Date : 22-02-2022
				 Spring Boot 7AM
				   Mr. RAGHU
	--------------------------------------------------------------
```
Spring Boot Main class (run() method Flow)

=> Create StopWatch Object and start it.
=> Read data from different sources for key=val combinations
like Option-args, VM-args, Properties/YAML files

=> Load all these into Environment memory.
=> print Banner (Logo Spring at console)
=> Create Empty New container : ApplicationContext(I)
=> Read all classes from component scan, create object to them
(Refesh context)
=> once container is Ready call runners(your runner classes)
=> Handle all exceptions and print al console
=> Return application context reference back to main class.

=========================================================================
Scheduling:-   Execute a task in a loop based on some time

*) Generate a Report after 1 week
*) send emails to every user at 1st of month
..etc

https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions

> It works for any type of Spring Boot application.
> At main class you need to add : @EnableScheduling
> Define one class and method with @Scheduled
> Provide cron expressions.
> cron indicates date/time to execute task.

ex:
```
SEC MIN HRS DAY MON WEEKDAY
0 0 9 * * *
```
> Execute task every day at 9:00:00

```
0 0 9,10 1 1 MON-FRI
```
> Execute task every year JAN 1st 9:00:00 and 10:00:00
only if it is WEEK DAY

```
* * * * * *
```
> Execute task without gap (for 1sec)

=====================Example=============================
Name : *SpringbootEmail*
Dep  : Java Mail Sender

a. proeprties
```java
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=sample2025nit
spring.mail.password=GetThe58Run!
spring.mail.properties.mail.smtp.starttls.enable=true
```

b. Service class
```java
package in.nareshit.raghu.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MyMailSender {

@Autowired
private JavaMailSender sender;


public boolean send(
  String to,
  String cc[],
  String bcc[],
  String subject,
  String text,
  Resource[] files
  )
{
  boolean falg = false;
  try {
    //1. create Empty message
    MimeMessage message = sender.createMimeMessage();

    //2 take helper class object
    MimeMessageHelper helper = new MimeMessageHelper(message, (files!=null && files.length>0));

    //3. fill details
    helper.setTo(to);
    if(cc!=null)
      helper.setCc(cc);
    if(bcc!=null)
      helper.setBcc(bcc);

    helper.setSubject(subject);
    helper.setText(text);

    if(files!=null && files.length>0) {
      for(Resource fileOb:files) {
        helper.addAttachment(fileOb.getFilename(), fileOb);
      }
    }

    //4. send email
    sender.send(message);

    falg = true;
  } catch (Exception e) {
    e.printStackTrace();
    falg = false;
  }

  return falg;
  }
}
```
c. Runner class for test
```java
package in.nareshit.raghu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.service.MyMailSender;

@Component
public class TestRunner implements CommandLineRunner {

@Autowired
private MyMailSender mailSender;

public void run(String... args) throws Exception {

  boolean sent = mailSender.send("sample2025nit@gmail.com",
      new String[] {
        "ramap2953@gmail.com"
      },
      new String[] {
          "durgeshdoddi1306@gmail.com"
      },
      "HELLO FROM BOOT", "WELCOME",
      new Resource[] {
          new FileSystemResource("D:\\Downloads\\common\\doc.jpg"),
          new FileSystemResource("D:\\Downloads\\common\\Resume_Boot.docx")
  });
  System.out.println(sent);
  }

}
```
