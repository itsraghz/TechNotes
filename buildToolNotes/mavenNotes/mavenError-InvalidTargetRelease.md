# Maven Errors - Invalid Target Release

## Error Message

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project kafka-project-upgrad: Fatal error compiling: error: invalid target release: 1.13 -> [Help 1]
```

### Detailed stack trace on the console in Eclipse (STS) Project 

```
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< kafka-project-upgrad:kafka-project-upgrad >--------------
[INFO] Building Kafka-project-upgrad 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ kafka-project-upgrad ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ kafka-project-upgrad ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 5 source files to C:\raghs\prfsnl\workspace-spring-tool-suite-4-4.5.1.RELEASE\kafka-project-upgrad\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.777 s
[INFO] Finished at: 2020-03-01T14:38:17+05:30
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project kafka-project-upgrad: Fatal error compiling: error: invalid target release: 1.13 -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

## Reason

  Maven while building finds that the target version supplied in the `pom.xml` as wrong and hence gives this error message on the console.

## Fix

  Supply the right versioning. Until JDK 10, it is `1.x` (1.5, 1.6, 1.7, ,,,, 1.10) thereafter, it is all the whole number - 10, 11 etc., 

```
For maven-compiler-plugin, the correct JDK version is 1.8, 1.9, 1.10, 10, 11, 12, 13...
```
### Sample `pom.xml` file 

```
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.8.0</version>
		<configuration>
			<source>13</source> <!-- 1.8,1.9,1.10,11,12,13 -->
			<target>13</target>
		</configuration>
	</plugin>
```

Alternatively, you can configure the same in the `<properties>` element of the `pom.xml` file as follows.

```
	<properties>
		<maven.compiler.source>13</maven.compiler.source>
		<maven.compiler.target>13</maven.compiler.target>
	</properties>
```

### Build Successful Error Message 

```
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< kafka-project-upgrad:kafka-project-upgrad >--------------
[INFO] Building Kafka-project-upgrad 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ kafka-project-upgrad ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ kafka-project-upgrad ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ kafka-project-upgrad ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ kafka-project-upgrad ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ kafka-project-upgrad ---
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ kafka-project-upgrad ---
[INFO] Building jar: C:\raghs\prfsnl\workspace-spring-tool-suite-4-4.5.1.RELEASE\kafka-project-upgrad\target\kafka-project-upgrad-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ kafka-project-upgrad ---
[INFO] Installing C:\raghs\prfsnl\workspace-spring-tool-suite-4-4.5.1.RELEASE\kafka-project-upgrad\target\kafka-project-upgrad-0.0.1-SNAPSHOT.jar to C:\Users\ragha\.m2\repository\kafka-project-upgrad\kafka-project-upgrad\0.0.1-SNAPSHOT\kafka-project-upgrad-0.0.1-SNAPSHOT.jar
[INFO] Installing C:\raghs\prfsnl\workspace-spring-tool-suite-4-4.5.1.RELEASE\kafka-project-upgrad\pom.xml to C:\Users\ragha\.m2\repository\kafka-project-upgrad\kafka-project-upgrad\0.0.1-SNAPSHOT\kafka-project-upgrad-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  19.250 s
[INFO] Finished at: 2020-03-01T14:54:39+05:30
[INFO] ------------------------------------------------------------------------
```

## References

   * http://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
   * https://mkyong.com/maven/maven-error-release-version-1-13-not-supported/
   * https://mkyong.com/maven/maven-error-invalid-target-release-1-11/
