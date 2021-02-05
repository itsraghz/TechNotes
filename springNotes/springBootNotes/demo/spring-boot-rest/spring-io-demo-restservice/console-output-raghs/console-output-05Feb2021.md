# Console Output

## Change the default Port

The default port is `8080`. I had here demonstrated to let the Application listen on a different port using a Command Line Argument of the executable JAR with `--server.port=8083` to listen on 8083 port. 

 The port number can be customized in many different ways, and this is the simplest and easiest one, without making any changes to the code after the package has been created. 

## Command
```
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-io-demo-restservice\target
λ java -jar restservice-0.0.1-SNAPSHOT.jar --server.port=8083
```

### Output

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

2021-02-05 09:07:35.766  INFO 23064 --- [           main] c.e.restservice.RestServiceApplication   : Starting RestServiceApplication v0.0.1-SNAPSHOT using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 23064 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-io-demo-restservice\target\restservice-0.0.1-SNAPSHOT.jar started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-io-demo-restservice\target)
2021-02-05 09:07:35.770  INFO 23064 --- [           main] c.e.restservice.RestServiceApplication   : No active profile set, falling back to default profiles: default
2021-02-05 09:07:37.778  INFO 23064 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8083 (http)
2021-02-05 09:07:37.797  INFO 23064 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-02-05 09:07:37.803  INFO 23064 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
2021-02-05 09:07:37.930  INFO 23064 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-02-05 09:07:37.930  INFO 23064 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2050 ms
2021-02-05 09:07:38.312  INFO 23064 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-02-05 09:07:38.645  INFO 23064 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8083 (http) with context path ''
2021-02-05 09:07:38.668  INFO 23064 --- [           main] c.e.restservice.RestServiceApplication   : Started RestServiceApplication in 3.768 seconds (JVM running for 4.457) 2021-02-05 09:07:57.282  INFO 23064 --- [nio-8083-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-02-05 09:07:57.295  INFO 23064 --- [nio-8083-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-02-05 09:07:57.297  INFO 23064 --- [nio-8083-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Greeting instance created
Greeting Instance : Greeting(id=1, content=Hello, World!)
Greeting instance created
Greeting Instance : Greeting(id=2, content=Hello, Raghs!)
```