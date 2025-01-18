# Maven Project Execution Log - 17012025-233037-IST

## 1. Maven Clean Package

```bash
$ cd kafka-java-maven && mvn clean package
```

### Output:

```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.example:kafka-java-maven >--------------------
[INFO] Building kafka-java-maven 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ kafka-java-maven ---
[INFO] Deleting /Users/raghavan.muthu/raghs/prfsnl/github-repos/TechNotes/kafkaNotes/kafka-java-maven/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ kafka-java-maven ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/raghavan.muthu/raghs/prfsnl/github-repos/TechNotes/kafkaNotes/kafka-java-maven/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ kafka-java-maven ---
[INFO] Recompiling the module because of changed source code.
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files with javac [debug target 11] to target/classes
[WARNING] location of system modules is not set in conjunction with -source 11
  not setting the location of system modules may lead to class files that cannot run on JDK 11
    --release 11 is recommended instead of -source 11 -target 11 because it sets the location of system modules automatically
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ kafka-java-maven ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/raghavan.muthu/raghs/prfsnl/github-repos/TechNotes/kafkaNotes/kafka-java-maven/src/test/resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ kafka-java-maven ---
[INFO] No sources to compile
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ kafka-java-maven ---
[INFO] No tests to run.
[INFO] 
[INFO] --- jar:3.4.1:jar (default-jar) @ kafka-java-maven ---
[INFO] Building jar: /Users/raghavan.muthu/raghs/prfsnl/github-repos/TechNotes/kafkaNotes/kafka-java-maven/target/kafka-java-maven-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.806 s
[INFO] Finished at: 2025-01-17T23:30:39+05:30
[INFO] ------------------------------------------------------------------------
```
