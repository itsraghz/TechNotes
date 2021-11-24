# SpringBoot Docker Notes

Notes and Console output after referring to the YouTube videos of Mr Raghu, from Naresh IT.

* Spring Boot Docker - Session 1 - https://www.youtube.com/watch?v=LmoLFcoaeQw
* Spring Boot Docker - Session 2 - https://www.youtube.com/watch?v=6_6MoohzdEI&t=1459s

## Steps

* Create a Simple SpringBoot Rest project using an IDE (I used SpringToolSuite - STS)
* Generate the JAR file using `Maven-Clean` and `Maven-Install` (inside STS or any other IDE or even in command line)
* Add a Dockerfile with the simple steps to generate a Docker Image
* Login to DockerHub account
* Create a Tag
* Push the image to DockerHub
* Pull an existing image from the Dockerhub Account

## Console Output

The console output for the complete exercise has been given  below in portions.

```
Microsoft Windows [Version 10.0.19043.1348]
(c) Microsoft Corporation. All rights reserved.

C:\WINDOWS\system32>cd "\users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE"

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE>ls
FirstGradleProj                    Spring5ScopesEx
HibernatGradleProj                 SpringBoot2DataJpaFindByEx-10Nov2021
JDBCGradleProj                     SpringBoot2FirstEx
README.md                          SpringBoot2RunnersEx
ServletGradleProj                  SpringBoot2YamlEx
Spring5CoreAnnoConfigExGradleProj  SpringBootDockerTest-01
Spring5CoreAnnotationExGradle      SpringCoreCollectionExMaven
Spring5CoreJavaConfigEx            SpringCoreFirstExMaven
Spring5CoreLifeCycleEx             SpringCoreGradleProj
Spring5CoreLookupMethod            SpringFirstApp
Spring5CorePropertiesExMaven       SpringFirstAppGradle
Spring5CoreRefEx01Maven            Workspace_730AM_NOV2021_RAGHUSIR
Spring5CoreRefEx02Maven

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE>cd SpringBootDockerTest-01

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>ls
Dockerfile  HELP.md  mvnw  mvnw.cmd  pom.xml  src  target

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>ls
Dockerfile  HELP.md  mvnw  mvnw.cmd  pom.xml  src  target

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>ls -l
total 36
-rw-rw-rw-  1 raghs 0   367 2021-10-31 12:38 Dockerfile
-rw-rw-rw-  1 raghs 0   891 2021-10-31 10:59 HELP.md
-rw-rw-rw-  1 raghs 0 10070 2021-10-31 10:59 mvnw
-rwxrwxrwx  1 raghs 0  6608 2021-10-31 10:59 mvnw.cmd
-rw-rw-rw-  1 raghs 0  1270 2021-10-31 11:01 pom.xml
drw-rw-rw-  4 raghs 0     0 2021-10-31 10:59 src
drw-rw-rw-  9 raghs 0  4096 2021-11-23 22:58 target
```

## Console Output - Dockerfile

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>cat Dockerfile
# FROM <ImageName> - refer https://hub.docker.com/_/openjdk
FROM openjdk:11

# Temporary Run Location
VOLUME /tmp

# Provide the Port Info
EXPOSE 8080

# Specify an Alias name for the target
ADD target/SpringBootDockerTest-01-1.0.jar SpringBootDockerTest-01-1.0.jar

# Execution Entry Point
ENTRYPOINT ["java", "-jar", "/SpringBootDockerTest-01-1.0.jar"]
```

## Console Output - Docker Build

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker build -f Dockerfile -t springbootdockertest01
.
[+] Building 168.7s (8/8) FINISHED
 => [internal] load build definition from Dockerfile                                                                                                   0.1s
 => => transferring dockerfile: 406B                                                                                                                   0.0s
 => [internal] load .dockerignore                                                                                                                      0.0s
 => => transferring context: 2B                                                                                                                        0.0s
 => [internal] load metadata for docker.io/library/openjdk:11                                                                                         12.4s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                         0.0s
 => [internal] load build context                                                                                                                      0.2s
 => => transferring context: 17.50MB                                                                                                                   0.2s
 => [1/2] FROM docker.io/library/openjdk:11@sha256:84539d4caf6f51c850978ee138458560f84c12e647ad78b8fd9f24854b27da1d                                  155.6s
 => => resolve docker.io/library/openjdk:11@sha256:84539d4caf6f51c850978ee138458560f84c12e647ad78b8fd9f24854b27da1d                                    0.0s
 => => sha256:8c0978077f161d5a06c399bcfeb716207482cff3a67e46ac3a8daca03275dead 6.26kB / 6.26kB                                                         0.0s
 => => sha256:e1ad2231829e42e6f095971b5d2dc143d97db2d0870571ba4d29ecd599db62cb 10.87MB / 10.87MB                                                       9.6s
 => => sha256:84539d4caf6f51c850978ee138458560f84c12e647ad78b8fd9f24854b27da1d 1.29kB / 1.29kB                                                         0.0s
 => => sha256:647acf3d48c2780e00cd27bb0984367415f270d78477ef9d5b238e6ebd5290da 54.93MB / 54.93MB                                                      94.6s
 => => sha256:b02967ef003473d9adc6e20868d9d66af85b0871919bcec92419f65c974aa8ce 5.15MB / 5.15MB                                                         9.9s
 => => sha256:ee88e25a3132352903054de2246fd06c64c95718e1734d27741b2fd0582f6d41 1.79kB / 1.79kB                                                         0.0s
 => => sha256:5576ce26bf1df68da60eeb5162dccde1b69f865d2815aba8b2d29e7181aeb62b 54.57MB / 54.57MB                                                      74.7s
 => => sha256:26518d6c686a233a54207844e4b7d3b6d61257949d6ad066f69d7a71a6a372aa 5.42MB / 5.42MB                                                        17.0s
 => => sha256:cdb1f4e0dbfd41d06a54d449884e69cc8d0e912dcc0992a4e38372388e96d98a 209B / 209B                                                            18.8s
 => => sha256:1d872b5136cc5107372f49c8e70da9ff97147824c50d2b88be26a6ac5accc1a3 203.12MB / 203.12MB                                                   150.9s
 => => extracting sha256:647acf3d48c2780e00cd27bb0984367415f270d78477ef9d5b238e6ebd5290da                                                              2.3s
 => => extracting sha256:b02967ef003473d9adc6e20868d9d66af85b0871919bcec92419f65c974aa8ce                                                              0.2s
 => => extracting sha256:e1ad2231829e42e6f095971b5d2dc143d97db2d0870571ba4d29ecd599db62cb                                                              0.3s
 => => extracting sha256:5576ce26bf1df68da60eeb5162dccde1b69f865d2815aba8b2d29e7181aeb62b                                                              2.8s
 => => extracting sha256:26518d6c686a233a54207844e4b7d3b6d61257949d6ad066f69d7a71a6a372aa                                                              0.2s
 => => extracting sha256:cdb1f4e0dbfd41d06a54d449884e69cc8d0e912dcc0992a4e38372388e96d98a                                                              0.0s
 => => extracting sha256:1d872b5136cc5107372f49c8e70da9ff97147824c50d2b88be26a6ac5accc1a3                                                              4.4s
 => [2/2] ADD target/SpringBootDockerTest-01-1.0.jar SpringBootDockerTest-01-1.0.jar                                                                   0.5s
 => exporting to image                                                                                                                                 0.1s
 => => exporting layers                                                                                                                                0.1s
 => => writing image sha256:e0674b3ecbfd1bfc1372230bdab6f059ee075522f144b82baf8e06549fd9de1b                                                           0.0s
 => => naming to docker.io/library/springbootdockertest01                                                                                              0.0s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>ls
Dockerfile  HELP.md  mvnw  mvnw.cmd  pom.xml  src  target
```

## Console Output - Verify the Docker Images

The docker images can be verified by using the command `docker image ls` OR `docker images`

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker images
REPOSITORY               TAG       IMAGE ID       CREATED         SIZE
springbootdockertest01   latest    e0674b3ecbfd   2 minutes ago   677MB
docker/getting-started   latest    083d7564d904   5 months ago    28MB

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls
REPOSITORY               TAG       IMAGE ID       CREATED         SIZE
springbootdockertest01   latest    e0674b3ecbfd   6 minutes ago   677MB
docker/getting-started   latest    083d7564d904   5 months ago    28MB
```

## Console Output - Run the Docker Image

We can run the docker image we just created with the command `docker run` with some additional arguments as follows.

*Syntax*: `docker run [<arguments>] <imageName>`

*Arguments* :

* `-p <mappedPort>:<actualPort>` - to map the actual port number into a different/virtual/logical port number for the convenience, so that we can leave the port free.

> *Note*: The image name has to be specified in all lower case!

*Actual Syntax*: `docker run -p 9090:8080 springbootdockertest01`

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker run -p 9090:8080 springbootdockertest01

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.6)

2021-11-23 19:08:06.291  INFO 1 --- [           main] c.r.s.SpringBootDockerTest01Application  : Starting SpringBootDockerTest01Application v1.0 using Java 11.0.13 on e0b6ee2b56ae with PID 1 (/SpringBootDockerTest-01-1.0.jar started by root in /)
2021-11-23 19:08:06.294  INFO 1 --- [           main] c.r.s.SpringBootDockerTest01Application  : No active profile set, falling back to default profiles: default
2021-11-23 19:08:07.256  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-11-23 19:08:07.269  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-11-23 19:08:07.269  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.54]
2021-11-23 19:08:07.331  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-11-23 19:08:07.331  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 970 ms
2021-11-23 19:08:07.676  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-11-23 19:08:07.689  INFO 1 --- [           main] c.r.s.SpringBootDockerTest01Application  : Started SpringBootDockerTest01Application in 1.876 seconds (JVM running for 2.277)
2021-11-23 19:10:28.729  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-11-23 19:10:28.730  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-11-23 19:10:28.731  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Request Received for '/' at : 2021-11-23T19:10:28.756823
```

> *Note*: You can press `Ctrl+C` to stop the application/docker instance running.

## Console Output - Verify Docker Images

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls
REPOSITORY               TAG       IMAGE ID       CREATED          SIZE
springbootdockertest01   latest    e0674b3ecbfd   15 minutes ago   677MB
docker/getting-started   latest    083d7564d904   5 months ago     28MB

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls -a
REPOSITORY               TAG       IMAGE ID       CREATED          SIZE
springbootdockertest01   latest    e0674b3ecbfd   15 minutes ago   677MB
docker/getting-started   latest    083d7564d904   5 months ago     28MB
```
## Console Output - Docker Login to push the image to the Docker Hub

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker login
Authenticating with existing credentials...
Login Succeeded

Logging in with your password grants your terminal complete access to your account.
For better security, log in with a limited-privilege personal access token. Learn more at https://docs.docker.com/go/access-tokens/
```

## Console Output - Create a Tag (labeling) for an Image

The tag acts a label, where an image can have multiple versions/labels attached to it for different snapshots. The default tag is `latest` when not specified.

*Syntax*: `docker tag <imageName> <userName><repoName>[:<tagName>]`

*Example*: `docker tag springbootdockertest01 itsraghz/docker-test-1:initial`

The image `springbootdockertest01` will be having the version/tag/label `initial` attached.

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker tag springbootdockertest itsraghz/docker-test-1:initial
Error response from daemon: No such image: springbootdockertest:latest

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker tag springbootdockertest01 itsraghz/docker-test-1:initial
```

## Console Output - Docker Push

It is similar to a `git push` where we promote the image from our local /dev machine to the remote repository (which is Dockerhub), for which we need the following.

* UserName with Docker - `itsraghz`
* Repo Name - `docker-test-1`
* Image Name with Label/Tag : `initial`

*Syntax*: `docker push <userName>/<repoName>:<tagName>`
*Example*: `docker push itsraghz/docker-test-1:initial`

> *Note*: The tag/label is associated with a repository. Hence we do NOT need to specify an image while pushing.

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker push itsraghz/docker-test-1:initial
The push refers to repository [docker.io/itsraghz/docker-test-1]
fce001ddc6b1: Pushed
a9e4c9343539: Mounted from library/openjdk
47ee2d19f81a: Mounted from library/openjdk
ab9d251e27cb: Mounted from library/openjdk
8a5844586fdb: Mounted from library/openjdk
a4aba4e59b40: Mounted from library/openjdk
5499f2905579: Mounted from library/openjdk
a36ba9e322f7: Mounted from library/openjdk
initial: digest: sha256:8ee9b84e71ea00c6b631b2c33c84bb49e8a94344fdfa9d3351861f6fa665bcb1 size: 2007
```

## Console Output - Verify the images

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls
REPOSITORY               TAG       IMAGE ID       CREATED          SIZE
its
raghz/docker-test-1   initial   e0674b3ecbfd   26 minutes ago   677MB
springbootdockertest01   latest    e0674b3ecbfd   26 minutes ago   677MB
docker/getting-started   latest    083d7564d904   5 months ago     28MB
```

## Console Output - Retry pushing again

The `docker push` again will inform that the image layer is already existing.

```
C:\WINDOWS\System32>docker push itsraghz/docker-test-1:initial
The push refers to repository [docker.io/itsraghz/docker-test-1]
fce001ddc6b1: Layer already exists
a9e4c9343539: Layer already exists
47ee2d19f81a: Layer already exists
ab9d251e27cb: Layer already exists
8a5844586fdb: Layer already exists
a4aba4e59b40: Layer already exists
5499f2905579: Layer already exists
a36ba9e322f7: Layer already exists
initial: digest: sha256:8ee9b84e71ea00c6b631b2c33c84bb49e8a94344fdfa9d3351861f6fa665bcb1 size: 2007
```

## Console Output - Push without any tagging - default `latest`

The `docker push` without any tag/label will consider the image with the default tag/label `latest`, if one exists.

The below attempt fails because there is no image with the tag `latest`.

```
C:\WINDOWS\System32>docker push itsraghz/docker-test-1
Using default tag: latest
The push refers to repository [docker.io/itsraghz/docker-test-1]
tag does not exist: itsraghz/docker-test-1:latest
```

# Docker Pull - pull an existing image

`docker pull` helps us to get / fetch an image from the remote repository `Dockerhub`.

```
C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker pull itsraghz/citi-ecs
Using default tag: latest
Error response from daemon: manifest for itsraghz/citi-ecs:latest not found: manifest unknown: manifest unknown

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker pull itsraghz/citi-ecs:webserver
webserver: Pulling from itsraghz/citi-ecs
d121f8d1c412: Pull complete
ebd81fc8c071: Pull complete
655316c160af: Pull complete
d15953c0e0f8: Pull complete
2ee525c5c3cc: Pull complete
2aad087ba780: Pull complete
Digest: sha256:14f081ec3dc6222df3a5c154eaef86979cc06e33580787b2b2451405208b850d
Status: Downloaded newer image for itsraghz/citi-ecs:webserver
docker.io/itsraghz/citi-ecs:webserver

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls
REPOSITORY               TAG         IMAGE ID       CREATED          SIZE
itsraghz/docker-test-1   initial     e0674b3ecbfd   31 minutes ago   677MB
springbootdockertest01   latest      e0674b3ecbfd   31 minutes ago   677MB
docker/getting-started   latest      083d7564d904   5 months ago     28MB
itsraghz/citi-ecs        webserver   e4b722d549f4   13 months ago    133MB

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker run itsraghz/citi-ecs:webserver
/docker-entrypoint.sh: /docker-entrypoint.d/ is not empty, will attempt to perform configuration
/docker-entrypoint.sh: Looking for shell scripts in /docker-entrypoint.d/
/docker-entrypoint.sh: Launching /docker-entrypoint.d/10-listen-on-ipv6-by-default.sh
10-listen-on-ipv6-by-default.sh: error: IPv6 listen already enabled
/docker-entrypoint.sh: Launching /docker-entrypoint.d/20-envsubst-on-templates.sh
/docker-entrypoint.sh: Configuration complete; ready for start up

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls
REPOSITORY               TAG         IMAGE ID       CREATED          SIZE
itsraghz/docker-test-1   initial     e0674b3ecbfd   36 minutes ago   677MB
springbootdockertest01   latest      e0674b3ecbfd   36 minutes ago   677MB
docker/getting-started   latest      083d7564d904   5 months ago     28MB
itsraghz/citi-ecs        webserver   e4b722d549f4   13 months ago    133MB

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker image ls -a
REPOSITORY               TAG         IMAGE ID       CREATED          SIZE
itsraghz/docker-test-1   initial     e0674b3ecbfd   36 minutes ago   677MB
springbootdockertest01   latest      e0674b3ecbfd   36 minutes ago   677MB
docker/getting-started   latest      083d7564d904   5 months ago     28MB
itsraghz/citi-ecs        webserver   e4b722d549f4   13 months ago    133MB

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>docker ps -a
CONTAINER ID   IMAGE                           COMMAND                  CREATED          STATUS                        PORTS     NAMES
1c9be7d6b605   itsraghz/citi-ecs:webserver     "/docker-entrypoint.…"   2 minutes ago    Exited (0) 29 seconds ago               blissful_khorana
4aa5b4968409   itsraghz/citi-ecs:webserver     "/docker-entrypoint.…"   4 minutes ago    Exited (0) 2 minutes ago                crazy_snyder
e0b6ee2b56ae   springbootdockertest01          "java -jar /SpringBo…"   26 minutes ago   Exited (143) 20 minutes ago             admiring_haibt
bcd4de6b1657   springbootdockertest01:latest   "java -jar /SpringBo…"   32 minutes ago   Exited (143) 28 minutes ago             sleepy_cartwright
03bbf0c2b0dc   docker/getting-started          "/docker-entrypoint.…"   4 weeks ago      Exited (0) 53 minutes ago               focused_mclean

C:\Users\Raghavan Muthu\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\SpringBootDockerTest-01>
```
