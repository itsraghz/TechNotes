# Kafka Java Project Execution Log - 17012025-234245-IST

## 1. Running Kafka Producer

```bash
$ mvn exec:java -Dexec.mainClass="com.example.kafka.SimpleProducer"
```

### Output:

```
[INFO] Scanning for projects...
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/apache/maven/plugins/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/codehaus/mojo/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml
Progress (1): 1.4/14 kBProgress (1): 2.8/14 kBProgress (1): 4.1/14 kBProgress (1): 5.5/14 kBProgress (1): 6.9/14 kBProgress (1): 8.3/14 kBProgress (1): 9.7/14 kBProgress (1): 11/14 kB Progress (1): 12/14 kBProgress (1): 14/14 kBProgress (1): 14 kB                      Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml (14 kB at 48 kB/s)
Progress (1): 1.4/21 kBProgress (1): 2.8/21 kBProgress (1): 4.1/21 kBProgress (1): 5.5/21 kBProgress (1): 6.9/21 kBProgress (1): 8.3/21 kBProgress (1): 9.7/21 kBProgress (1): 11/21 kB Progress (1): 12/21 kBProgress (1): 14/21 kBProgress (1): 15/21 kBProgress (1): 17/21 kBProgress (1): 18/21 kBProgress (1): 19/21 kBProgress (1): 21 kB                      Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml (21 kB at 63 kB/s)
[WARNING] Could not transfer metadata org.apache.maven.plugins/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[WARNING] Could not transfer metadata org.codehaus.mojo/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml
Progress (1): 989 B                   Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml (989 B at 33 kB/s)
[WARNING] Could not transfer metadata org.codehaus.mojo:exec-maven-plugin/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[INFO] 
[INFO] --------------------< com.example:kafka-java-maven >--------------------
[INFO] Building kafka-java-maven 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] org.apache.maven.plugins/maven-metadata.xml failed to transfer from https://maven.pkg.github.com/sqlcomponents/sqlcomponents during a previous attempt. This failure was cached in the local repository and resolution will not be reattempted until the update interval of github has elapsed or updates are forced. Original error: Could not transfer metadata org.apache.maven.plugins/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[WARNING] org.codehaus.mojo/maven-metadata.xml failed to transfer from https://maven.pkg.github.com/sqlcomponents/sqlcomponents during a previous attempt. This failure was cached in the local repository and resolution will not be reattempted until the update interval of github has elapsed or updates are forced. Original error: Could not transfer metadata org.codehaus.mojo/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[INFO] 
[INFO] --- exec:3.5.0:java (default-cli) @ kafka-java-maven ---
```

## 2. Running Kafka Consumer (with 30-second timeout)

```bash
$ timeout 30s mvn exec:java -Dexec.mainClass="com.example.kafka.SimpleConsumer"
```

### Output:

```
[INFO] Scanning for projects...
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/codehaus/mojo/maven-metadata.xml
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/apache/maven/plugins/maven-metadata.xml
[WARNING] Could not transfer metadata org.apache.maven.plugins/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[WARNING] Could not transfer metadata org.codehaus.mojo/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
Downloading from github: https://maven.pkg.github.com/sqlcomponents/sqlcomponents/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml
[WARNING] Could not transfer metadata org.codehaus.mojo:exec-maven-plugin/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[INFO] 
[INFO] --------------------< com.example:kafka-java-maven >--------------------
[INFO] Building kafka-java-maven 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] org.apache.maven.plugins/maven-metadata.xml failed to transfer from https://maven.pkg.github.com/sqlcomponents/sqlcomponents during a previous attempt. This failure was cached in the local repository and resolution will not be reattempted until the update interval of github has elapsed or updates are forced. Original error: Could not transfer metadata org.apache.maven.plugins/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[WARNING] org.codehaus.mojo/maven-metadata.xml failed to transfer from https://maven.pkg.github.com/sqlcomponents/sqlcomponents during a previous attempt. This failure was cached in the local repository and resolution will not be reattempted until the update interval of github has elapsed or updates are forced. Original error: Could not transfer metadata org.codehaus.mojo/maven-metadata.xml from/to github (https://maven.pkg.github.com/sqlcomponents/sqlcomponents): status code: 401, reason phrase: Unauthorized (401)
[INFO] 
[INFO] --- exec:3.5.0:java (default-cli) @ kafka-java-maven ---
```
