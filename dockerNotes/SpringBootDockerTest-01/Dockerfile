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