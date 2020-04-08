# Install and Run Jenkins

 * Install the Jenkins - download the .war file from the jenkins.io website
 * Run it with the standard Java command `java -jar jenkins.war`
 * By default it runs on port # 8080. if needed to modify, issue the command `java -jar jenkins.war --httpPort=9090`.

## Console Output for running Jenkins

*Note*: Jenkins.war as on date is prepared to run on Java 8, or 11. I had Java 13 installed in my machine, which I had to
manually adjust in the present terminal session through `set JAVA_HOME` and `set PATH=%JAVA_HOME%\bin;%PATH%` commands in the
beginning.

```
C:\Users\ragha\Downloads\soft\Jenkins
¿ ls
jenkins-17Aug2017.war  jenkins-24Feb2018.war  jenkins.war

C:\Users\ragha\Downloads\soft\Jenkins
¿ java -jar jenkins.war
Apr 08, 2020 11:35:44 PM Main verifyJavaVersion
java.lang.UnsupportedClassVersionError: 57.0
        at Main.verifyJavaVersion(Main.java:174)
        at Main.main(Main.java:142)

Jenkins requires Java versions [8, 11] but you are running with Java 13 from C:\Program Files\Java\jdk-13.0.1
java.lang.UnsupportedClassVersionError: 57.0

C:\Users\ragha\Downloads\soft\Jenkins
¿ ls -ltrh "\Program Files\Java\jdk
jdk-13.0.1\    jdk1.7.0_80\   jdk1.8.0_211\  jdk1.8.0_92\
C:\Users\ragha\Downloads\soft\Jenkins
¿ ls -lrh "C:\Program Files\Java\jdk1.8.0_211\
total 26M
-rw-r--r-- 1 raghs 197610  21M Apr  1  2019 src.zip
-rw-r--r-- 1 raghs 197610  426 Dec  6 23:14 release
drwxr-xr-x 1 raghs 197610    0 Dec  6 23:14 lib/
drwxr-xr-x 1 raghs 197610    0 Dec  6 23:14 jre/
-rw-r--r-- 1 raghs 197610 5.0M Dec  6 23:14 javafx-src.zip
drwxr-xr-x 1 raghs 197610    0 Dec  6 23:14 include/
drwxr-xr-x 1 raghs 197610    0 Dec  6 23:14 bin/
¿ set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_211\

C:\Users\ragha\Downloads\soft\Jenkins
¿ echo %JAVA_HOME%
C:\Program Files\Java\jdk1.8.0_211\

C:\Users\ragha\Downloads\soft\Jenkins
¿ java -jar jenkins.war
java.lang.UnsupportedClassVersionError: 57.0
        at Main.verifyJavaVersion(Main.java:174)
        at Main.main(Main.java:142)

Jenkins requires Java versions [8, 11] but you are running with Java 13 from C:\Program Files\Java\jdk-13.0.1
        at Main.main(Main.java:142)

C:\Users\ragha\Downloads\soft\Jenkins
¿ set PATH=%JAVA_HOME%\bin;%PATH%

C:\Users\ragha\Downloads\soft\Jenkins
¿ echo %PATH%

2020-04-08 18:08:05.737+0000 [id=1]     INFO    org.eclipse.jetty.util.log.Log#initialized: Logging initialized @9109ms to org.eclipse.jetty.util.log.JavaUtilLog
2020-04-08 18:08:06.403+0000 [id=1]     INFO    winstone.Logger#logInternal: Beginning extraction from war file
2020-04-08 18:08:17.360+0000 [id=1]     WARNING o.e.j.s.handler.ContextHandler#setContextPath: Empty contextPath
2020-04-08 18:08:22.623+0000 [id=1]     INFO    o.e.j.s.s.DefaultSessionIdManager#doStart: DefaultSessionIdManager workerName=node0
2020-04-08 18:08:22.624+0000 [id=1]     INFO    o.e.j.s.s.DefaultSessionIdManager#doStart: No SessionScavenger set, using defaults
2020-04-08 18:08:22.670+0000 [id=1]     INFO    o.e.j.server.session.HouseKeeper#startScavenging: node0 Scavenging every 600000ms
2020-04-08 18:08:28.404+0000 [id=1]     INFO    hudson.WebAppMain#contextInitialized: Jenkins home directory: C:\Users\ragha\.jenkins found at: $user.home/.jenkins
2020-04-08 18:08:30.645+0000 [id=1]     INFO    o.e.j.server.AbstractConnector#doStart: Started ServerConnector@7b4c50bc{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
2020-04-08 18:08:30.648+0000 [id=1]     INFO    org.eclipse.jetty.server.Server#doStart: Started @34033ms
2020-04-08 18:08:30.651+0000 [id=22]    INFO    winstone.Logger#logInternal: Winstone Servlet Engine running: controlPort=disabled
2020-04-08 18:08:36.646+0000 [id=31]    INFO    jenkins.InitReactorRunner$1#onAttained: Started initialization
2020-04-08 18:08:36.803+0000 [id=30]    INFO    jenkins.InitReactorRunner$1#onAttained: Listed all plugins
2020-04-08 18:08:49.396+0000 [id=30]    INFO    jenkins.InitReactorRunner$1#onAttained: Prepared all plugins
2020-04-08 18:08:49.438+0000 [id=32]    INFO    jenkins.InitReactorRunner$1#onAttained: Started all plugins
2020-04-08 18:08:49.485+0000 [id=32]    INFO    jenkins.InitReactorRunner$1#onAttained: Augmented all extensions
2020-04-08 18:08:55.422+0000 [id=32]    INFO    jenkins.InitReactorRunner$1#onAttained: System config loaded
2020-04-08 18:08:55.436+0000 [id=29]    INFO    jenkins.InitReactorRunner$1#onAttained: System config adapted
2020-04-08 18:08:55.439+0000 [id=29]    INFO    jenkins.InitReactorRunner$1#onAttained: Loaded all jobs
2020-04-08 18:08:55.442+0000 [id=34]    INFO    jenkins.InitReactorRunner$1#onAttained: Configuration for all jobs updated
2020-04-08 18:08:55.556+0000 [id=49]    INFO    hudson.model.AsyncPeriodicWork#lambda$doRun$0: Started Download metadata
2020-04-08 18:08:55.896+0000 [id=49]    INFO    hudson.util.Retrier#start: Attempt #1 to do the action check updates server
2020-04-08 18:09:04.852+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#prepareRefresh: Refreshing org.springframework.web.context.support.StaticWebApplicationContext@7f0a1293: display name [Root WebApplicationContext]; startup date [Wed Apr 08 23:39:04 IST 2020]; root of context hierarchy
2020-04-08 18:09:04.971+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#obtainFreshBeanFactory: Bean factory for application context [org.springframework.web2020-04-08 18:08:55.442+0000 [id=34]    INFO    jenkins.InitReactorRunner$1#onAttained: Configuration for all jobs updated
2020-04-08 18:08:55.556+0000 [id=49]    INFO    hudson.model.AsyncPeriodicWork#lambda$doRun$0: Started Download metadata
2020-04-08 18:08:55.896+0000 [id=49]    INFO    hudson.util.Retrier#start: Attempt #1 to do the action check updates server
2020-04-08 18:09:04.852+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#prepareRefresh: Refreshing org.springframework.web.context.support.StaticWebApplicationContext@7f0a1293: display name [Root WebApplicationContext]; startup date [Wed Apr 08 23:39:04 IST 2020]; root of context hierarchy
2020-04-08 18:09:04.971+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#obtainFreshBeanFactory: Bean factory for application context [org.springframework.web.context.support.StaticWebApplicationContext@7f0a1293]: org.springframework.beans.factory.support.DefaultListableBeanFactory@35150c05
2020-04-08 18:09:05.200+0000 [id=35]    INFO    o.s.b.f.s.DefaultListableBeanFactory#preInstantiateSingletons: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@35150c05: defining beans [authenticationManager]; root of factory hierarchy
2020-04-08 18:09:06.996+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#prepareRefresh: Refreshing org.springframework.web.context.support.StaticWebApplicationContext@27988587: display name [Root WebApplicationContext]; startup date [Wed Apr 08 23:39:06 IST 2020]; root of context hierarchy
2020-04-08 18:09:06.999+0000 [id=35]    INFO    o.s.c.s.AbstractApplicationContext#obtainFreshBeanFactory: Bean factory for application context [org.springframework.web.context.support.StaticWebApplicationContext@27988587]: org.springframework.beans.factory.support.DefaultListableBeanFactory@6c718f85
2020-04-08 18:09:07.003+0000 [id=35]    INFO    o.s.b.f.s.DefaultListableBeanFactory#preInstantiateSingletons: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@6c718f85: defining beans [filter,legacy]; root of factory hierarchy
2020-04-08 18:09:08.487+0000 [id=35]    INFO    jenkins.install.SetupWizard#init:

*************************************************************
*************************************************************
*************************************************************

Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

4b58895a8d104f048fb07166b3fd73eb

This may also be found at: C:\Users\ragha\.jenkins\secrets\initialAdminPassword

*************************************************************
*************************************************************
*************************************************************

2020-04-08 18:09:34.506+0000 [id=49]    INFO    h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tasks.Maven.MavenInstaller
2020-04-08 18:09:34.534+0000 [id=49]    INFO    hudson.util.Retrier#start: Performed the action check updates server successfully at the attempt #1
2020-04-08 18:09:34.698+0000 [id=49]    INFO    hudson.model.AsyncPeriodicWork#lambda$doRun$0: Finished Download metadata. 38,973 ms
2020-04-08 18:09:38.893+0000 [id=32]    INFO    jenkins.InitReactorRunner$1#onAttained: Completed initialization
2020-04-08 18:09:39.050+0000 [id=21]    INFO    hudson.WebAppMain$3#run: Jenkins is fully up and running
```

