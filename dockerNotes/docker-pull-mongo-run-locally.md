# Pull Mongo Image from DockerHub and run it locally.

Follow the steps as described below.

## Commands 

```sh
## -----------------------------------
## 1 - Check Docker Version
## -----------------------------------
docker version

## -----------------------------------
## 2 - Pull the latest image of Mongo
## -----------------------------------
docker pull mongo

## -----------------------------------
## 3 - Verify the images 
## -----------------------------------
docker images 

## -----------------------------------
## 4 - Run the docker image with the configurations
## -----------------------------------
docker run --name mymongo -d -p 27017:27017 mongo:latest

whereas the arugments

run - stands for executing
--name - to give a meaningful name to the image
-d is to run it in a detached mode
-p is the mapping of port <localhostPort>:<dockerPort> (here we use same for both)
mongo:latest - is the name of the image (verify it in the *docker images* command)

You get an Image ID in the command prompt as a result of succcessful execution of the docker image. 

## -----------------------------------
## 5 -  verify all the running docker processes
## -----------------------------------
docker ps -a

ps - stands for process status
-a - to get all the processes, not just the actively running ones.
```

## Console Output 

```sh
Microsoft Windows [Version 10.0.19043.1415]
(c) Microsoft Corporation. All rights reserved.

C:\WINDOWS\System32>docker version
Client:
 Cloud integration: v1.0.22
 Version:           20.10.11
 API version:       1.41
 Go version:        go1.16.10
 Git commit:        dea9396
 Built:             Thu Nov 18 00:42:51 2021
 OS/Arch:           windows/amd64
 Context:           default
 Experimental:      true

Server: Docker Engine - Community
 Engine:
  Version:          20.10.11
  API version:      1.41 (minimum version 1.12)
  Go version:       go1.16.9
  Git commit:       847da18
  Built:            Thu Nov 18 00:35:39 2021
  OS/Arch:          linux/amd64
  Experimental:     false
 containerd:
  Version:          1.4.12
  GitCommit:        7b11cfaabd73bb80907dd23182b9347b4245eb5d
 runc:
  Version:          1.0.2
  GitCommit:        v1.0.2-0-g52b36a2
 docker-init:
  Version:          0.19.0
  GitCommit:        de40ad0

C:\WINDOWS\System32>docker images
REPOSITORY               TAG         IMAGE ID       CREATED         SIZE
itsraghz/docker-test-1   initial     e0674b3ecbfd   5 weeks ago     677MB
springbootdockertest01   latest      e0674b3ecbfd   5 weeks ago     677MB
docker/getting-started   latest      083d7564d904   6 months ago    28MB
itsraghz/citi-ecs        webserver   e4b722d549f4   15 months ago   133MB

C:\WINDOWS\System32>docker ps -a
CONTAINER ID   IMAGE                           COMMAND                  CREATED       STATUS                     PORTS     NAMES
0ed2fd54c510   springbootdockertest01:latest   "java -jar /SpringBo."   12 days ago   Exited (143) 4 hours ago             RaghsSpringBootDockerTest01
8279f1c9e3d6   springbootdockertest01          "java -jar /SpringBo."   12 days ago   Exited (143) 12 days ago             epic_burnell
9077641479e6   docker/getting-started          "/docker-entrypoint.."   12 days ago   Exited (0) 12 days ago               jovial_wing

C:\WINDOWS\System32>docker pull mongo
Using default tag: latest
latest: Pulling from library/mongo
7b1a6ab2e44d: Pull complete
90eb44ebc60b: Pull complete
5085b59f2efb: Pull complete
c7499923d022: Pull complete
019496b6c44a: Pull complete
c0df4f407f69: Pull complete
351daa315b6c: Pull complete
a233e6240acc: Pull complete
a3f57d6be64f: Pull complete
dd1b5b345323: Pull complete
Digest: sha256:5be752bc5f2ac4182252d0f15d74df080923aba39700905cb26d9f70f39e9702
Status: Downloaded newer image for mongo:latest
docker.io/library/mongo:latest

C:\WINDOWS\System32>docker images
REPOSITORY               TAG         IMAGE ID       CREATED         SIZE
mongo                    latest      dfda7a2cf273   3 weeks ago     693MB
springbootdockertest01   latest      e0674b3ecbfd   5 weeks ago     677MB
itsraghz/docker-test-1   initial     e0674b3ecbfd   5 weeks ago     677MB
docker/getting-started   latest      083d7564d904   6 months ago    28MB
itsraghz/citi-ecs        webserver   e4b722d549f4   15 months ago   133MB

C:\WINDOWS\System32>docker run --name mymongo -d -p 27017:27017 mongo:latest
12420b8bff75211ae5d702a7e03400befc3826966d00f037b2456c39b0833e63

C:\WINDOWS\System32>docker ps -a
CONTAINER ID   IMAGE                           COMMAND                  CREATED         STATUS                     PORTS                      NAMES
12420b8bff75   mongo:latest                    "docker-entrypoint.s."   6 seconds ago   Up 5 seconds               0.0.0.0:27017->27017/tcp   mymongo
0ed2fd54c510   springbootdockertest01:latest   "java -jar /SpringBo."   12 days ago     Exited (143) 4 hours ago                              RaghsSpringBootDockerTest01
8279f1c9e3d6   springbootdockertest01          "java -jar /SpringBo."   12 days ago     Exited (143) 12 days ago                              epic_burnell
9077641479e6   docker/getting-started          "/docker-entrypoint.."   12 days ago     Exited (0) 12 days ago                                jovial_wing

C:\WINDOWS\System32>
```

## Verify

## Verify via Telnet on the service being run

Run the following command in the terminal to ensure that the mongodb service is running on the port # 27017 we configured.

```sh
C:\raghs\prfsnl\github-repos\TechNotes\dockerNotes>http http://localhost:27017
HTTP/1.0 200 OK
Connection: close
Content-Length: 85
Content-Type: text/plain

It looks like you are trying to access MongoDB over HTTP on the native driver port.


C:\raghs\prfsnl\github-repos\TechNotes\dockerNotes>

```

### Verify it via Spring Boot Application

Run a Spring Boot Application that connects to the Mongodb service at localhost:27017.

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo\target>ls -ltrh
total 14M
drw-rw-rw-  3 raghs 0    0 2021-12-31 12:27 generated-sources
drw-rw-rw-  3 raghs 0    0 2021-12-31 12:27 maven-status
drw-rw-rw-  3 raghs 0    0 2021-12-31 12:27 classes
drw-rw-rw-  3 raghs 0    0 2021-12-31 12:27 generated-test-sources
drw-rw-rw-  3 raghs 0    0 2021-12-31 12:27 test-classes
drw-rw-rw-  2 raghs 0    0 2021-12-31 12:27 surefire-reports
drw-rw-rw-  2 raghs 0    0 2021-12-31 12:27 maven-archiver
-rw-rw-rw-  1 raghs 0 6.3K 2021-12-31 12:27 springdata-mongodb-demo-0.0.1-SNAPSHOT.jar.original
-rw-rw-rw-  1 raghs 0  14M 2021-12-31 12:28 springdata-mongodb-demo-0.0.1-SNAPSHOT.jar

C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo\target>java -jar springdata-mongodb-demo-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.2)

2021-12-31 12:30:13.858  INFO 36532 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Starting SpringdataMongodbDemoApplication v0.0.1-SNAPSHOT using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 36532 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo\target\springdata-mongodb-demo-0.0.1-SNAPSHOT.jar started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo\target)
2021-12-31 12:30:13.862  INFO 36532 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : No active profile set, falling back to default profiles: default
2021-12-31 12:30:14.267  INFO 36532 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2021-12-31 12:30:14.318  INFO 36532 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 46 ms. Found 1 MongoDB repository interfaces.
2021-12-31 12:30:14.740  INFO 36532 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms'}
2021-12-31 12:30:14.841  INFO 36532 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:5}] to localhost:27017
2021-12-31 12:30:14.841  INFO 36532 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:6}] to localhost:27017
2021-12-31 12:30:14.844  INFO 36532 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=13, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=27943500}
2021-12-31 12:30:15.240  INFO 36532 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Started SpringdataMongodbDemoApplication in 1.899 seconds (JVM running for 2.338)
MongoDbClientRunner - run() method invoked
2021-12-31 12:30:15.303  INFO 36532 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:7}] to localhost:27017
Customers found with findAll()
-------------------------------
Customer [id=61ceaa7f158f9811f824f888, firstName=Alice, lastName=Smith]
Customer [id=61ceaa7f158f9811f824f889, firstName=Bob, lastName=Smith]

Customer found with findByFirstName("Alice")
----------------------------------------------
Customer [id=61ceaa7f158f9811f824f888, firstName=Alice, lastName=Smith]
Customers found with findByLastName("Smith"
---------------------------------------------
Customer [id=61ceaa7f158f9811f824f888, firstName=Alice, lastName=Smith]
Customer [id=61ceaa7f158f9811f824f889, firstName=Bob, lastName=Smith]
MongoDbClientRunner - run() method completed

C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\springdata-mongodb-demo\target>
```