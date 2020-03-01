# Kafka Spark Streaming Job Error

```
[UPGRAD-DEBUG] (1) Spark Conf created successfully. org.apache.spark.SparkConf@291caca8
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
20/03/02 04:12:15 INFO SparkContext: Running Spark version 2.3.1
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.hadoop.security.authentication.util.KerberosUtil (file:/C:/Users/ragha/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar) to method sun.security.krb5.Config.getInstance()
WARNING: Please consider reporting this to the maintainers of org.apache.hadoop.security.authentication.util.KerberosUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20/03/02 04:12:16 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
20/03/02 04:12:16 ERROR Shell: Failed to locate the winutils binary in the hadoop binary path
java.io.IOException: Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
	at org.apache.hadoop.util.Shell.getQualifiedBinPath(Shell.java:378)
	at org.apache.hadoop.util.Shell.getWinUtilsPath(Shell.java:393)
	at org.apache.hadoop.util.Shell.<clinit>(Shell.java:386)
	at org.apache.hadoop.util.StringUtils.<clinit>(StringUtils.java:79)
	at org.apache.hadoop.security.Groups.parseStaticMapping(Groups.java:116)
	at org.apache.hadoop.security.Groups.<init>(Groups.java:93)
	at org.apache.hadoop.security.Groups.<init>(Groups.java:73)
	at org.apache.hadoop.security.Groups.getUserToGroupsMappingService(Groups.java:293)
	at org.apache.hadoop.security.UserGroupInformation.initialize(UserGroupInformation.java:283)
	at org.apache.hadoop.security.UserGroupInformation.ensureInitialized(UserGroupInformation.java:260)
	at org.apache.hadoop.security.UserGroupInformation.loginUserFromSubject(UserGroupInformation.java:789)
	at org.apache.hadoop.security.UserGroupInformation.getLoginUser(UserGroupInformation.java:774)
	at org.apache.hadoop.security.UserGroupInformation.getCurrentUser(UserGroupInformation.java:647)
	at org.apache.spark.util.Utils$$anonfun$getCurrentUserName$1.apply(Utils.scala:2467)
	at org.apache.spark.util.Utils$$anonfun$getCurrentUserName$1.apply(Utils.scala:2467)
	at scala.Option.getOrElse(Option.scala:121)
	at org.apache.spark.util.Utils$.getCurrentUserName(Utils.scala:2467)
	at org.apache.spark.SparkContext.<init>(SparkContext.scala:292)
	at org.apache.spark.streaming.StreamingContext$.createNewSparkContext(StreamingContext.scala:838)
	at org.apache.spark.streaming.StreamingContext.<init>(StreamingContext.scala:85)
	at org.apache.spark.streaming.api.java.JavaStreamingContext.<init>(JavaStreamingContext.scala:138)
	at upgrad.kafka.spark.KafkaSparkIntegration.simpleMovingAvgClosePrice(KafkaSparkIntegration.java:103)
	at upgrad.kafka.spark.KafkaSparkIntegration.main(KafkaSparkIntegration.java:56)
20/03/02 04:12:17 INFO SparkContext: Submitted application: SparkStreamingStockDataAnalysis1
20/03/02 04:12:17 INFO SecurityManager: Changing view acls to: raghs
20/03/02 04:12:17 INFO SecurityManager: Changing modify acls to: raghs
20/03/02 04:12:17 INFO SecurityManager: Changing view acls groups to: 
20/03/02 04:12:17 INFO SecurityManager: Changing modify acls groups to: 
20/03/02 04:12:17 INFO SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(raghs); groups with view permissions: Set(); users  with modify permissions: Set(raghs); groups with modify permissions: Set()
20/03/02 04:12:24 INFO Utils: Successfully started service 'sparkDriver' on port 50103.
20/03/02 04:12:24 INFO SparkEnv: Registering MapOutputTracker
20/03/02 04:12:24 INFO SparkEnv: Registering BlockManagerMaster
20/03/02 04:12:24 INFO BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
20/03/02 04:12:24 INFO BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
20/03/02 04:12:24 INFO DiskBlockManager: Created local directory at C:\Users\ragha\AppData\Local\Temp\blockmgr-8a54528d-a951-4eae-8f32-750b869bf064
20/03/02 04:12:24 INFO MemoryStore: MemoryStore started with capacity 2.1 GB
20/03/02 04:12:24 INFO SparkEnv: Registering OutputCommitCoordinator
20/03/02 04:12:25 INFO Utils: Successfully started service 'SparkUI' on port 4040.
20/03/02 04:12:26 INFO SparkUI: Bound SparkUI to 0.0.0.0, and started at http://LAPTOP-63DBKP7Q:4040
20/03/02 04:12:27 INFO Executor: Starting executor ID driver on host localhost
20/03/02 04:12:27 INFO Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 50124.
20/03/02 04:12:27 INFO NettyBlockTransferService: Server created on LAPTOP-63DBKP7Q:50124
20/03/02 04:12:27 INFO BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
20/03/02 04:12:27 INFO BlockManagerMaster: Registering BlockManager BlockManagerId(driver, LAPTOP-63DBKP7Q, 50124, None)
20/03/02 04:12:27 INFO BlockManagerMasterEndpoint: Registering block manager LAPTOP-63DBKP7Q:50124 with 2.1 GB RAM, BlockManagerId(driver, LAPTOP-63DBKP7Q, 50124, None)
20/03/02 04:12:27 INFO BlockManagerMaster: Registered BlockManager BlockManagerId(driver, LAPTOP-63DBKP7Q, 50124, None)
20/03/02 04:12:27 INFO BlockManager: Initialized BlockManager: BlockManagerId(driver, LAPTOP-63DBKP7Q, 50124, None)
[UPGRAD-DEBUG] (2) JavaStreamingContext created successfully. org.apache.spark.streaming.api.java.JavaStreamingContext@673919a7
[UPGRAD-DEBUG] (3) JavaInputDStream created successfully. org.apache.spark.streaming.api.java.JavaInputDStream@6415f61e
[UPGRAD-DEBUG] (4) JavaDStream<String> lines - created successfully. org.apache.spark.streaming.api.java.JavaDStream@470d183
[UPGRAD-DEBUG] (5) JavaDStream<Stock> stockData - created successfully. org.apache.spark.streaming.api.java.JavaDStream@619f2afc
[UPGRAD-DEBUG] (6) JavaPairDStream<String, Double> stock - created successfully. org.apache.spark.streaming.api.java.JavaPairDStream@6bccd036
[UPGRAD-DEBUG] (7) JavaPairDStream<String, Double> stockSum - created successfully. org.apache.spark.streaming.api.java.JavaPairDStream@748f93bb
[UPGRAD-DEBUG] (8) JavaPairDStream stockAvg - created successfully. org.apache.spark.streaming.api.java.JavaPairDStream@6d8796c1
[UPGRAD-DEBUG] (9) stockAvg - print() executed successfully. 
20/03/02 04:17:01 ERROR JobScheduler: Error running job streaming job 1583102820000 ms.0
java.lang.IllegalArgumentException
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.spark.util.ClosureCleaner$.getClassReader(ClosureCleaner.scala:46)
	at org.apache.spark.util.FieldAccessFinder$$anon$3$$anonfun$visitMethodInsn$2.apply(ClosureCleaner.scala:449)
	at org.apache.spark.util.FieldAccessFinder$$anon$3$$anonfun$visitMethodInsn$2.apply(ClosureCleaner.scala:432)
	at scala.collection.TraversableLike$WithFilter$$anonfun$foreach$1.apply(TraversableLike.scala:733)
	at scala.collection.mutable.HashMap$$anon$1$$anonfun$foreach$2.apply(HashMap.scala:134)
	at scala.collection.mutable.HashMap$$anon$1$$anonfun$foreach$2.apply(HashMap.scala:134)
	at scala.collection.mutable.HashTable$class.foreachEntry(HashTable.scala:236)
	at scala.collection.mutable.HashMap.foreachEntry(HashMap.scala:40)
	at scala.collection.mutable.HashMap$$anon$1.foreach(HashMap.scala:134)
	at scala.collection.TraversableLike$WithFilter.foreach(TraversableLike.scala:732)
	at org.apache.spark.util.FieldAccessFinder$$anon$3.visitMethodInsn(ClosureCleaner.scala:432)
	at org.apache.xbean.asm5.ClassReader.a(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.b(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.accept(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.accept(Unknown Source)
	at org.apache.spark.util.ClosureCleaner$$anonfun$org$apache$spark$util$ClosureCleaner$$clean$14.apply(ClosureCleaner.scala:262)
	at org.apache.spark.util.ClosureCleaner$$anonfun$org$apache$spark$util$ClosureCleaner$$clean$14.apply(ClosureCleaner.scala:261)
	at scala.collection.immutable.List.foreach(List.scala:392)
	at org.apache.spark.util.ClosureCleaner$.org$apache$spark$util$ClosureCleaner$$clean(ClosureCleaner.scala:261)
	at org.apache.spark.util.ClosureCleaner$.clean(ClosureCleaner.scala:159)
	at org.apache.spark.SparkContext.clean(SparkContext.scala:2299)
	at org.apache.spark.SparkContext.runJob(SparkContext.scala:2073)
	at org.apache.spark.rdd.RDD$$anonfun$take$1.apply(RDD.scala:1358)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:151)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:112)
	at org.apache.spark.rdd.RDD.withScope(RDD.scala:363)
	at org.apache.spark.rdd.RDD.take(RDD.scala:1331)
	at org.apache.spark.streaming.dstream.DStream$$anonfun$print$2$$anonfun$foreachFunc$3$1.apply(DStream.scala:735)
	at org.apache.spark.streaming.dstream.DStream$$anonfun$print$2$$anonfun$foreachFunc$3$1.apply(DStream.scala:734)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply$mcV$sp(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.DStream.createRDDWithLocalProperties(DStream.scala:416)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply$mcV$sp(ForEachDStream.scala:50)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply(ForEachDStream.scala:50)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply(ForEachDStream.scala:50)
	at scala.util.Try$.apply(Try.scala:192)
	at org.apache.spark.streaming.scheduler.Job.run(Job.scala:39)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply$mcV$sp(JobScheduler.scala:257)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply(JobScheduler.scala:257)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply(JobScheduler.scala:257)
	at scala.util.DynamicVariable.withValue(DynamicVariable.scala:58)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler.run(JobScheduler.scala:256)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:830)
java.lang.IllegalArgumentException
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.<init>(Unknown Source)
	at org.apache.spark.util.ClosureCleaner$.getClassReader(ClosureCleaner.scala:46)
	at org.apache.spark.util.FieldAccessFinder$$anon$3$$anonfun$visitMethodInsn$2.apply(ClosureCleaner.scala:449)
	at org.apache.spark.util.FieldAccessFinder$$anon$3$$anonfun$visitMethodInsn$2.apply(ClosureCleaner.scala:432)
	at scala.collection.TraversableLike$WithFilter$$anonfun$foreach$1.apply(TraversableLike.scala:733)
	at scala.collection.mutable.HashMap$$anon$1$$anonfun$foreach$2.apply(HashMap.scala:134)
	at scala.collection.mutable.HashMap$$anon$1$$anonfun$foreach$2.apply(HashMap.scala:134)
	at scala.collection.mutable.HashTable$class.foreachEntry(HashTable.scala:236)
	at scala.collection.mutable.HashMap.foreachEntry(HashMap.scala:40)
	at scala.collection.mutable.HashMap$$anon$1.foreach(HashMap.scala:134)
	at scala.collection.TraversableLike$WithFilter.foreach(TraversableLike.scala:732)
	at org.apache.spark.util.FieldAccessFinder$$anon$3.visitMethodInsn(ClosureCleaner.scala:432)
	at org.apache.xbean.asm5.ClassReader.a(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.b(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.accept(Unknown Source)
	at org.apache.xbean.asm5.ClassReader.accept(Unknown Source)
	at org.apache.spark.util.ClosureCleaner$$anonfun$org$apache$spark$util$ClosureCleaner$$clean$14.apply(ClosureCleaner.scala:262)
	at org.apache.spark.util.ClosureCleaner$$anonfun$org$apache$spark$util$ClosureCleaner$$clean$14.apply(ClosureCleaner.scala:261)
	at scala.collection.immutable.List.foreach(List.scala:392)
	at org.apache.spark.util.ClosureCleaner$.org$apache$spark$util$ClosureCleaner$$clean(ClosureCleaner.scala:261)
	at org.apache.spark.util.ClosureCleaner$.clean(ClosureCleaner.scala:159)
	at org.apache.spark.SparkContext.clean(SparkContext.scala:2299)
	at org.apache.spark.SparkContext.runJob(SparkContext.scala:2073)
	at org.apache.spark.rdd.RDD$$anonfun$take$1.apply(RDD.scala:1358)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:151)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:112)
	at org.apache.spark.rdd.RDD.withScope(RDD.scala:363)
	at org.apache.spark.rdd.RDD.take(RDD.scala:1331)
	at org.apache.spark.streaming.dstream.DStream$$anonfun$print$2$$anonfun$foreachFunc$3$1.apply(DStream.scala:735)
	at org.apache.spark.streaming.dstream.DStream$$anonfun$print$2$$anonfun$foreachFunc$3$1.apply(DStream.scala:734)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply$mcV$sp(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1$$anonfun$apply$mcV$sp$1.apply(ForEachDStream.scala:51)
	at org.apache.spark.streaming.dstream.DStream.createRDDWithLocalProperties(DStream.scala:416)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply$mcV$sp(ForEachDStream.scala:50)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply(ForEachDStream.scala:50)
	at org.apache.spark.streaming.dstream.ForEachDStream$$anonfun$1.apply(ForEachDStream.scala:50)
	at scala.util.Try$.apply(Try.scala:192)
	at org.apache.spark.streaming.scheduler.Job.run(Job.scala:39)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply$mcV$sp(JobScheduler.scala:257)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply(JobScheduler.scala:257)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler$$anonfun$run$1.apply(JobScheduler.scala:257)
	at scala.util.DynamicVariable.withValue(DynamicVariable.scala:58)
	at org.apache.spark.streaming.scheduler.JobScheduler$JobHandler.run(JobScheduler.scala:256)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:830)
```

