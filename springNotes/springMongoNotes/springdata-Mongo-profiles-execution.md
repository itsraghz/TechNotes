# Spring Data Mongo Project Execution

This is a quick reference notes for executing a demo project on Spring Data Mongo with two different profiles.

* Mongodb at localhost (localhost:27017) (Windows 10 Machine) [DEV]
* Mongodb at Mongodb.com cluster account (Remote and on cloud) [PROD]

## Spring Boot Project

The Spring Data Mongo project structure and the listing of the Source Code along with the profiles is explained in a different file [springdata-Mongo-project.md](./springdata-Mongo-project.md).

## Localhost Execution 

Follow the steps in order to execute the MongoDB at localhost.

1. Start the Mongo DB Server at localhost
2. Execute the JAR file with the default profile (`application.properties`).

### Start the MongoDB at localhost


```sh
:\installedSoft\mongodb-win32-x86_64-windows-4.4.6\bin>mongod --dbpath C:\mongodata
{"t":{"$date":"2022-01-01T19:29:40.863+05:30"},"s":"I",  "c":"CONTROL",  "id":23285,   "ctx":"main","msg":"Automatically disabling TLS 1.0, to force-enable TLS 1.0 specify --sslDisabledProtocols 'none'"}
{"t":{"$date":"2022-01-01T19:29:41.561+05:30"},"s":"W",  "c":"ASIO",     "id":22601,   "ctx":"main","msg":"No TransportLayer configured during NetworkInterface startup"}
{"t":{"$date":"2022-01-01T19:29:41.561+05:30"},"s":"I",  "c":"NETWORK",  "id":4648602, "ctx":"main","msg":"Implicit TCP FastOpen in use."}
{"t":{"$date":"2022-01-01T19:29:41.564+05:30"},"s":"I",  "c":"STORAGE",  "id":4615611, "ctx":"initandlisten","msg":"MongoDB starting","attr":{"pid":28088,"port":27017,"dbPath":"C:/mongodata","architecture":"64-bit","host":"Raghs-LegionY540-TPIN"}}
{"t":{"$date":"2022-01-01T19:29:41.565+05:30"},"s":"I",  "c":"CONTROL",  "id":23398,   "ctx":"initandlisten","msg":"Target operating system minimum version","attr":{"targetMinOS":"Windows 7/Windows Server 2008 R2"}}
{"t":{"$date":"2022-01-01T19:29:41.565+05:30"},"s":"I",  "c":"CONTROL",  "id":23403,   "ctx":"initandlisten","msg":"Build Info","attr":{"buildInfo":{"version":"4.4.6","gitVersion":"72e66213c2c3eab37d9358d5e78ad7f5c1d0d0d7","modules":[],"allocator":"tcmalloc","environment":{"distmod":"windows","distarch":"x86_64","target_arch":"x86_64"}}}}
{"t":{"$date":"2022-01-01T19:29:41.565+05:30"},"s":"I",  "c":"CONTROL",  "id":51765,   "ctx":"initandlisten","msg":"Operating System","attr":{"os":{"name":"Microsoft Windows 10","version":"10.0 (build 19043)"}}}
{"t":{"$date":"2022-01-01T19:29:41.566+05:30"},"s":"I",  "c":"CONTROL",  "id":21951,   "ctx":"initandlisten","msg":"Options set by command line","attr":{"options":{"storage":{"dbPath":"C:\\mongodata"}}}}
{"t":{"$date":"2022-01-01T19:29:41.569+05:30"},"s":"I",  "c":"STORAGE",  "id":22270,   "ctx":"initandlisten","msg":"Storage engine to use detected by data files","attr":{"dbpath":"C:/mongodata","storageEngine":"wiredTiger"}}
{"t":{"$date":"2022-01-01T19:29:41.570+05:30"},"s":"I",  "c":"STORAGE",  "id":22315,   "ctx":"initandlisten","msg":"Opening WiredTiger","attr":{"config":"create,cache_size=7640M,session_max=33000,eviction=(threads_min=4,threads_max=4),config_base=false,statistics=(fast),log=(enabled=true,archive=true,path=journal,compressor=snappy),file_manager=(close_idle_time=100000,close_scan_interval=10,close_handle_minimum=250),statistics_log=(wait=0),verbose=[recovery_progress,checkpoint_progress,compact_progress],"}}
{"t":{"$date":"2022-01-01T19:29:41.615+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045581:614587][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY_PROGRESS] Recovering log 3 through 4"}}
{"t":{"$date":"2022-01-01T19:29:41.762+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045581:761506][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY_PROGRESS] Recovering log 4 through 4"}}
{"t":{"$date":"2022-01-01T19:29:41.920+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045581:919558][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY | WT_VERB_RECOVERY_PROGRESS] Main recovery loop: starting at 3/74624 to 4/256"}}
{"t":{"$date":"2022-01-01T19:29:42.231+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045582:230797][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY_PROGRESS] Recovering log 3 through 4"}}
{"t":{"$date":"2022-01-01T19:29:42.367+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045582:367269][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY_PROGRESS] Recovering log 4 through 4"}}
{"t":{"$date":"2022-01-01T19:29:42.486+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045582:485662][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY | WT_VERB_RECOVERY_PROGRESS] Set global recovery timestamp: (0, 0)"}}
{"t":{"$date":"2022-01-01T19:29:42.486+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045582:486626][28088:140727354807632], txn-recover: [WT_VERB_RECOVERY | WT_VERB_RECOVERY_PROGRESS] Set global oldest timestamp: (0, 0)"}}
{"t":{"$date":"2022-01-01T19:29:42.488+05:30"},"s":"I",  "c":"STORAGE",  "id":22430,   "ctx":"initandlisten","msg":"WiredTiger message","attr":{"message":"[1641045582:487631][28088:140727354807632], WT_SESSION.checkpoint: [WT_VERB_CHECKPOINT_PROGRESS] saving checkpoint snapshot min: 1, snapshot max: 1 snapshot count: 0, oldest timestamp: (0, 0) , meta checkpoint timestamp: (0, 0)"}}
{"t":{"$date":"2022-01-01T19:29:42.507+05:30"},"s":"I",  "c":"STORAGE",  "id":4795906, "ctx":"initandlisten","msg":"WiredTiger opened","attr":{"durationMillis":937}}
{"t":{"$date":"2022-01-01T19:29:42.508+05:30"},"s":"I",  "c":"RECOVERY", "id":23987,   "ctx":"initandlisten","msg":"WiredTiger recoveryTimestamp","attr":{"recoveryTimestamp":{"$timestamp":{"t":0,"i":0}}}}
{"t":{"$date":"2022-01-01T19:29:42.512+05:30"},"s":"I",  "c":"STORAGE",  "id":4366408, "ctx":"initandlisten","msg":"No table logging settings modifications are required for existing WiredTiger tables","attr":{"loggingEnabled":true}}
{"t":{"$date":"2022-01-01T19:29:42.517+05:30"},"s":"I",  "c":"STORAGE",  "id":22262,   "ctx":"initandlisten","msg":"Timestamp monitor starting"}
{"t":{"$date":"2022-01-01T19:29:42.520+05:30"},"s":"W",  "c":"CONTROL",  "id":22120,   "ctx":"initandlisten","msg":"Access control is not enabled for the database. Read and write access to data and configuration is unrestricted","tags":["startupWarnings"]}
{"t":{"$date":"2022-01-01T19:29:42.521+05:30"},"s":"W",  "c":"CONTROL",  "id":22140,   "ctx":"initandlisten","msg":"This server is bound to localhost. Remote systems will be unable to connect to this server. Start the server with --bind_ip <address> to specify which IP addresses it should serve responses from, or with --bind_ip_all to bind to all interfaces. If this behavior is desired, start the server with --bind_ip 127.0.0.1 to disable this warning","tags":["startupWarnings"]}
{"t":{"$date":"2022-01-01T19:29:42.530+05:30"},"s":"I",  "c":"STORAGE",  "id":20536,   "ctx":"initandlisten","msg":"Flow Control is enabled on this deployment"}
{"t":{"$date":"2022-01-01T19:29:43.194+05:30"},"s":"I",  "c":"FTDC",     "id":20625,   "ctx":"initandlisten","msg":"Initializing full-time diagnostic data capture","attr":{"dataDirectory":"C:/mongodata/diagnostic.data"}}
{"t":{"$date":"2022-01-01T19:29:43.200+05:30"},"s":"I",  "c":"NETWORK",  "id":23015,   "ctx":"listener","msg":"Listening on","attr":{"address":"127.0.0.1"}}
{"t":{"$date":"2022-01-01T19:29:43.200+05:30"},"s":"I",  "c":"NETWORK",  "id":23016,   "ctx":"listener","msg":"Waiting for connections","attr":{"port":27017,"ssl":"off"}}
```

The Mongodb server (`mongod.exe` process) has been successfully started and it is waiting for connections - the last line of the output. 

```sh
"ctx":"listener","msg":"Waiting for connections","attr":{"port":27017,"ssl":"off"}
```

### Run the project 

Now, let us execute the project to connect to the mongodb server at localhost. We see the output for two different sections

1. Mongo Server Terminal where it accepts the client request
2. Spring Boot Application Execution where we print the Application logs for the execution


#### MongoDB Server - Output

```sh
{"t":{"$date":"2022-01-01T19:35:21.986+05:30"},"s":"I",  "c":"NETWORK",  "id":22943,   "ctx":"listener","msg":"Connection accepted","attr":{"remote":"127.0.0.1:51961","connectionId":3,"connectionCount":3}}
{"t":{"$date":"2022-01-01T19:35:21.987+05:30"},"s":"I",  "c":"NETWORK",  "id":51800,   "ctx":"conn3","msg":"client metadata","attr":{"remote":"127.0.0.1:51961","client":"conn3","doc":{"driver":{"name":"mongo-java-driver|sync|spring-boot","version":"4.4.0"},"os":{"type":"Linux","name":"Linux","architecture":"amd64","version":"4.4.0-19041-Microsoft"},"platform":"Java/Eclipse Adoptium/17.0.1+12"}}}
{"t":{"$date":"2022-01-01T19:35:22.356+05:30"},"s":"I",  "c":"NETWORK",  "id":22944,   "ctx":"conn3","msg":"Connection ended","attr":{"remote":"127.0.0.1:51961","connectionId":3,"connectionCount":2}}
{"t":{"$date":"2022-01-01T19:35:22.362+05:30"},"s":"I",  "c":"NETWORK",  "id":22944,   "ctx":"conn1","msg":"Connection ended","attr":{"remote":"127.0.0.1:51958","connectionId":1,"connectionCount":1}}
{"t":{"$date":"2022-01-01T19:35:22.907+05:30"},"s":"I",  "c":"-",        "id":20883,   "ctx":"conn2","msg":"Interrupted operation as its client disconnected","attr":{"opId":4235}}
{"t":{"$date":"2022-01-01T19:35:22.910+05:30"},"s":"I",  "c":"NETWORK",  "id":22944,   "ctx":"conn2","msg":"Connection ended","attr":{"remote":"127.0.0.1:51959","connectionId":2,"connectionCount":0}}
{"t":{"$date":"2022-01-01T19:35:22.911+05:30"},"s":"E",  "c":"NETWORK",  "id":23841,   "ctx":"conn2","msg":"Error shutting down socket","attr":{"error":"An existing connection was forcibly closed by the remote host."}}
```

The connection has been accepted from the localhost (loopback address - `127.0.0.1` with the port # `51961`).

#### Project Execution - Output 

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$ java -jar springdata-mongodb-demo-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.2)

2022-01-01 19:35:19.078  INFO 1212 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Starting SpringdataMongodbDemoApplication v0.0.1-SNAPSHOT using Java 17.0.1 on Raghs-LegionY540-TPIN with PID 1212 (/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target/springdata-mongodb-demo-0.0.1-SNAPSHOT.jar started by raghs in /mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target)
2022-01-01 19:35:19.083  INFO 1212 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : No active profile set, falling back to default profiles: default
2022-01-01 19:35:19.798  INFO 1212 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2022-01-01 19:35:19.896  INFO 1212 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 87 ms. Found 1 MongoDB repository interfaces.
2022-01-01 19:35:20.531  INFO 1212 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms'}
2022-01-01 19:35:20.792  INFO 1212 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:2}] to localhost:27017
2022-01-01 19:35:20.793  INFO 1212 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=9, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=53835300}
2022-01-01 19:35:20.792  INFO 1212 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:1}] to localhost:27017
2022-01-01 19:35:21.783  INFO 1212 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Started SpringdataMongodbDemoApplication in 3.532 seconds (JVM running for 4.338)
MongoDbClientRunner - run() method invoked
2022-01-01 19:35:21.990  INFO 1212 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:3}] to localhost:27017
Customers found with findAll()
-------------------------------
Customer [id=61d05fa260f8e7249de28bb0, firstName=Alice, lastName=Smith]
Customer [id=61d05fa260f8e7249de28bb1, firstName=Bob, lastName=Smith]

Customer found with findByFirstName("Alice")
----------------------------------------------
Customer [id=61d05fa260f8e7249de28bb0, firstName=Alice, lastName=Smith]
Customers found with findByLastName("Smith"
---------------------------------------------
Customer [id=61d05fa260f8e7249de28bb0, firstName=Alice, lastName=Smith]
Customer [id=61d05fa260f8e7249de28bb1, firstName=Bob, lastName=Smith]
MongoDbClientRunner - run() method completed
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$
```

The following line in the output confirms that the connection to the Mongodb at localhost (`localhost:27017`) has been obtained successfully.

```java
2022-01-01 19:35:21.990  INFO 1212 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:3}] to localhost:27017
```
The following line in the output confirms that the *default* profile has been picked up by the Spring Boot at runtime.

```java
2022-01-01 19:35:19.083  INFO 1212 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : No active profile set, falling back to default profiles: default
```

The default profile can be activated by specifying the profile name as 

```java
java -Dspring.profiles.active=default -jar <executableJarFileName.jar>
```

If needed, you can make it explicit to connect to the *default* profile as follows, and the Application will confirm the same, as follows.

```sh
java -Dspring.profiles.active=default -jar springdata-mongodb-demo-0.0.1-SNAPSHOT.jar
```

```java
2022-01-01 22:08:22.752  INFO 1583 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : The following profiles are active: default
```

## MongoCluster Execution

Follow the steps in order to execute the MongoDB at localhost.

1. Start the Mongo DB Server at Mongo Cluster - mostly it will be in started state unless otherwise.
2. Enable the Access control with the IP Address in the *Network Settings* of the cluster, where you can either temporarily or permanently allow the specific IP Address to connect to the cluster, OR can have an *Open All* Access (`*.*.*.*`) - which is not generally recommended. 
3. Execute the JAR file with the `mongocluster` profile (`application-mongocluster.properties`).

*Command* : `java -Dspring.profiles.active=mongocluster -jar springdata-mongodb-demo-0.0.1-SNAPSHOT.jar`

```java
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$ java -Dspring.profiles.active=mongocluster
 -jar springdata-mongodb-demo-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.2)

2022-01-01 18:59:38.111  INFO 1079 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Starting SpringdataMongodbDemoApplication v0.0.1-SNAPSHOT using Java 17.0.1 on Raghs-LegionY540-TPIN with PID 1079 (/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target/springdata-mongodb-demo-0.0.1-SNAPSHOT.jar started by raghs in /mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target)
2022-01-01 18:59:38.114  INFO 1079 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : The following profiles are active: mongocluster
2022-01-01 18:59:38.681  INFO 1079 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2022-01-01 18:59:38.753  INFO 1079 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 65 ms. Found 1 MongoDB repository interfaces.
2022-01-01 18:59:39.311  INFO 1079 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[127.0.0.1:27017], srvHost=raghscluster.lxy8a.mongodb.net, mode=MULTIPLE, requiredClusterType=REPLICA_SET, serverSelectionTimeout='30000 ms', requiredReplicaSetName='RaghsCluster-shard-0'}
2022-01-01 18:59:39.411  INFO 1079 --- [y8a.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server raghscluster-shard-00-01.lxy8a.mongodb.net:27017 to client view of cluster
2022-01-01 18:59:39.481  INFO 1079 --- [y8a.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server raghscluster-shard-00-00.lxy8a.mongodb.net:27017 to client view of cluster
2022-01-01 18:59:39.485  INFO 1079 --- [y8a.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server raghscluster-shard-00-02.lxy8a.mongodb.net:27017 to client view of cluster
2022-01-01 18:59:40.429  INFO 1079 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : Started SpringdataMongodbDemoApplication in 2.955 seconds (JVM running for 3.674)
MongoDbClientRunner - run() method invoked
2022-01-01 18:59:40.527  INFO 1079 --- [           main] org.mongodb.driver.cluster               : No server chosen by com.mongodb.client.internal.MongoClientDelegate$1@30e868be from cluster description ClusterDescription{type=REPLICA_SET, connectionMode=MULTIPLE, serverDescriptions=[ServerDescription{address=raghscluster-shard-00-01.lxy8a.mongodb.net:27017, type=UNKNOWN, state=CONNECTING}, ServerDescription{address=raghscluster-shard-00-02.lxy8a.mongodb.net:27017, type=UNKNOWN, state=CONNECTING}, ServerDescription{address=raghscluster-shard-00-00.lxy8a.mongodb.net:27017, type=UNKNOWN, state=CONNECTING}]}. Waiting for 30000 ms before timing out
2022-01-01 18:59:42.547  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:679302}] to raghscluster-shard-00-02.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.547  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:6, serverValue:684414}] to raghscluster-shard-00-01.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.547  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:5, serverValue:684414}] to raghscluster-shard-00-01.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.547  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:679302}] to raghscluster-shard-00-02.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.574  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=raghscluster-shard-00-01.lxy8a.mongodb.net:27017, type=REPLICA_SET_PRIMARY, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=9, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=1120919200, setName='RaghsCluster-shard-0', canonicalAddress=raghscluster-shard-00-01.lxy8a.mongodb.net:27017, hosts=[raghscluster-shard-00-02.lxy8a.mongodb.net:27017, raghscluster-shard-00-00.lxy8a.mongodb.net:27017, raghscluster-shard-00-01.lxy8a.mongodb.net:27017], passives=[], arbiters=[], primary='raghscluster-shard-00-01.lxy8a.mongodb.net:27017', tagSet=TagSet{[Tag{name='nodeType', value='ELECTABLE'}, Tag{name='provider', value='AWS'}, Tag{name='region', value='US_EAST_1'}, Tag{name='workloadType', value='OPERATIONAL'}]}, electionId=7fffffff0000000000000051, setVersion=6, topologyVersion=TopologyVersion{processId=61b39a89b17693a72640276a, counter=6}, lastWriteDate=Sat Jan 01 18:59:42 IST 2022, lastUpdateTimeNanos=3027437544600}
2022-01-01 18:59:42.577  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=raghscluster-shard-00-02.lxy8a.mongodb.net:27017, type=REPLICA_SET_SECONDARY, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=9, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=1120602900, setName='RaghsCluster-shard-0', canonicalAddress=raghscluster-shard-00-02.lxy8a.mongodb.net:27017, hosts=[raghscluster-shard-00-02.lxy8a.mongodb.net:27017, raghscluster-shard-00-00.lxy8a.mongodb.net:27017, raghscluster-shard-00-01.lxy8a.mongodb.net:27017], passives=[], arbiters=[], primary='raghscluster-shard-00-01.lxy8a.mongodb.net:27017', tagSet=TagSet{[Tag{name='nodeType', value='ELECTABLE'}, Tag{name='provider', value='AWS'}, Tag{name='region', value='US_EAST_1'}, Tag{name='workloadType', value='OPERATIONAL'}]}, electionId=null, setVersion=6, topologyVersion=TopologyVersion{processId=61b39bba87e12eb946ce8e28, counter=3}, lastWriteDate=Sat Jan 01 18:59:42 IST 2022, lastUpdateTimeNanos=3027437349500}
2022-01-01 18:59:42.588  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Setting max election id to 7fffffff0000000000000051 from replica set primary raghscluster-shard-00-01.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.589  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Setting max set version to 6 from replica set primary raghscluster-shard-00-01.lxy8a.mongodb.net:27017
2022-01-01 18:59:42.590  INFO 1079 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Discovered replica set primary raghscluster-shard-00-01.lxy8a.mongodb.net:27017
2022-01-01 18:59:44.228  INFO 1079 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:7, serverValue:684445}] to raghscluster-shard-00-01.lxy8a.mongodb.net:27017
Customers found with findAll()
-------------------------------
Customer [id=61d057489e3a3f3a79ede263, firstName=Alice, lastName=Smith]
Customer [id=61d057489e3a3f3a79ede264, firstName=Bob, lastName=Smith]

Customer found with findByFirstName("Alice")
----------------------------------------------
Customer [id=61d057489e3a3f3a79ede263, firstName=Alice, lastName=Smith]
Customers found with findByLastName("Smith"
---------------------------------------------
Customer [id=61d057489e3a3f3a79ede263, firstName=Alice, lastName=Smith]
Customer [id=61d057489e3a3f3a79ede264, firstName=Bob, lastName=Smith]
MongoDbClientRunner - run() method completed
raghs@Raghs-LegionY540-TPIN:/mnt/c/users/Raghavan Muthu/OneDrive/Documents/prfsnl/springdata-mongodb-demo/target$
```

The following line in the output confirms the connection to the MongoDB at the Mongo cluster (`raghscluster-shard-00-01.lxy8a.mongodb.net:27017`) has been obtained successfully.

```java
2022-01-01 18:59:44.228  INFO 1079 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:7, serverValue:684445}] to raghscluster-shard-00-01.lxy8a.mongodb.net:27017
```

The following line in the output confirms that the *mongocluster* profile has been picked up by the Spring Boot at runtime.

```java
2022-01-01 18:59:38.114  INFO 1079 --- [           main] c.r.s.SpringdataMongodbDemoApplication   : The following profiles are active: mongocluster
```
