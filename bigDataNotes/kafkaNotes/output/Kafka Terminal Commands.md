# Terminal 1

## Login to AWS EC2 Instance created for Kafka (t4.micro)

```
login as: ec2-user
Authenticating with public key "imported-openssh-key"
Last login: Sat Feb 29 12:25:41 2020 from 49.207.139.195

       __|  __|_  )
       _|  (     /   Amazon Linux 2 AMI
      ___|\___|___|

https://aws.amazon.com/amazon-linux-2/
[ec2-user@ip-172-31-87-105 ~]$

```

## Zookeeper start

```
[ec2-user@ip-172-31-87-105 ~]$ cd downloads/
[ec2-user@ip-172-31-87-105 downloads]$ cd zookeeper-3.4.12/
[ec2-user@ip-172-31-87-105 zookeeper-3.4.12]$ ls
bin        contrib     ivysettings.xml  LICENSE.txt  README_packaging.txt  zookeeper-3.4.12.jar      zookeeper-3.4.12.jar.sha1
build.xml  dist-maven  ivy.xml          NOTICE.txt   recipes               zookeeper-3.4.12.jar.asc  zookeeper.out
conf       docs        lib              README.md    src                   zookeeper-3.4.12.jar.md5
[ec2-user@ip-172-31-87-105 zookeeper-3.4.12]$ cd bin/
[ec2-user@ip-172-31-87-105 bin]$ pwd
/home/ec2-user/downloads/zookeeper-3.4.12/bin
[ec2-user@ip-172-31-87-105 bin]$
[ec2-user@ip-172-31-87-105 bin]$ ./zkServer.sh  start
ZooKeeper JMX enabled by default
Using config: /home/ec2-user/downloads/zookeeper-3.4.12/bin/../conf/zoo.cfg
Starting zookeeper ... STARTED
[ec2-user@ip-172-31-87-105 bin]$
```

### Zookeeper attempt to rerun

```
[ec2-user@ip-172-31-87-105 bin]$ ./zkServer.sh start
ZooKeeper JMX enabled by default
Using config: /home/ec2-user/downloads/zookeeper-3.4.12/bin/../conf/zoo.cfg
Starting zookeeper ... already running as process 4175.
[ec2-user@ip-172-31-87-105 bin]$
```

# Terminal 2

## Kafka Services Start

```
[ec2-user@ip-172-31-87-105 bin]$ pwd
/home/ec2-user/downloads/kafka_2.12-2.0.0/bin
[ec2-user@ip-172-31-87-105 bin]$ ls
connect-distributed.sh        kafka-consumer-groups.sh     kafka-preferred-replica-election.sh  kafka-streams-application-reset.sh  zookeeper-server-start.sh
connect-standalone.sh         kafka-consumer-perf-test.sh  kafka-producer-perf-test.sh          kafka-topics.sh                     zookeeper-server-stop.sh
kafka-acls.sh                 kafka-delegation-tokens.sh   kafka-reassign-partitions.sh         kafka-verifiable-consumer.sh        zookeeper-shell.sh
kafka-broker-api-versions.sh  kafka-delete-records.sh      kafka-replica-verification.sh        kafka-verifiable-producer.sh
kafka-configs.sh              kafka-dump-log.sh            kafka-run-class.sh                   trogdor.sh
kafka-console-consumer.sh     kafka-log-dirs.sh            kafka-server-start.sh                windows
kafka-console-producer.sh     kafka-mirror-maker.sh        kafka-server-stop.sh                 zookeeper-security-migration.sh
[ec2-user@ip-172-31-87-105 bin]$ ./kafka-server-start.sh  ../config/server.properties

```

# Terminal 3

## Eclipse - Kafka Producer Demo Run

# Terminal 4

## Kafka Consumer Invocation

### login 
### Step 3 : cd to kafka installation directory

```
cd /home/ec2-user/downloads/kafka_2.12-2.0.0
```

### Step 4 - run the consumer command of Kafka

```
[ec2-user@ip-172-31-87-105 kafka_2.12-2.0.0]$ pwd
/home/ec2-user/downloads/kafka_2.12-2.0.0
[ec2-user@ip-172-31-87-105 kafka_2.12-2.0.0]$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning
...
...
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
^CProcessed a total of 300 messages
```

The above terminal output shows when there was an interruption made through the `Control+C` charater being pressed together and the Kafka Consumer had completed
reading 300 messages `from-the-beginning` on the topic `my-topic`. As per our program `KafkaProducerDemo` we push 100 messages at a time, thus it indicates that
so far the `KafkaProducer` was executed thrice (3 * 100 = 300 messages in the topic so far).

``
bin/kafka-topics.sh --zookeeper localhost:2181 --topic my-topic --describe
```

### Output of Kafka Topic Describe command
```
[ec2-user@ip-172-31-87-105 kafka_2.12-2.0.0]$ bin/kafka-topics.sh --zookeeper localhost:2181 --topic my-topic --describe
Topic:my-topic  PartitionCount:1        ReplicationFactor:1     Configs:
        Topic: my-topic Partition: 0    Leader: 0       Replicas: 0     Isr: 0
[ec2-user@ip-172-31-87-105 kafka_2.12-2.0.0]$
```

The above terminal output indicates that there is a topic by named `my-topic` exists successfully with Kafka (registered under the name specified)
and it has got a Replication Factor of 1 and Partition Count as well `. 

## Kafka Shutting down

Terminal messages while shutting down the kafka Server - by pressing `Control+C` - the typical shell interruption.

```
^C[2020-02-29 18:54:53,848] INFO Terminating process due to signal SIGINT (org.apache.kafka.common.utils.LoggingSignalHandler)
[2020-02-29 18:54:53,856] INFO [KafkaServer id=0] shutting down (kafka.server.KafkaServer)
[2020-02-29 18:54:53,857] INFO [KafkaServer id=0] Starting controlled shutdown (kafka.server.KafkaServer)
[2020-02-29 18:54:53,897] INFO [KafkaServer id=0] Controlled shutdown succeeded (kafka.server.KafkaServer)
[2020-02-29 18:54:53,901] INFO [/config/changes-event-process-thread]: Shutting down (kafka.common.ZkNodeChangeNotificationListener$ChangeEventProcessThread)
[2020-02-29 18:54:53,902] INFO [/config/changes-event-process-thread]: Stopped (kafka.common.ZkNodeChangeNotificationListener$ChangeEventProcessThread)
[2020-02-29 18:54:53,903] INFO [/config/changes-event-process-thread]: Shutdown completed (kafka.common.ZkNodeChangeNotificationListener$ChangeEventProcessThread)
[2020-02-29 18:54:53,903] INFO [SocketServer brokerId=0] Stopping socket server request processors (kafka.network.SocketServer)
[2020-02-29 18:54:53,915] INFO [SocketServer brokerId=0] Stopped socket server request processors (kafka.network.SocketServer)
[2020-02-29 18:54:53,916] INFO [Kafka Request Handler on Broker 0], shutting down (kafka.server.KafkaRequestHandlerPool)
[2020-02-29 18:54:53,919] INFO [Kafka Request Handler on Broker 0], shut down completely (kafka.server.KafkaRequestHandlerPool)
[2020-02-29 18:54:53,922] INFO [KafkaApi-0] Shutdown complete. (kafka.server.KafkaApis)
[2020-02-29 18:54:53,924] INFO [ExpirationReaper-0-topic]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,012] INFO [ExpirationReaper-0-topic]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,012] INFO [ExpirationReaper-0-topic]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,015] INFO [TransactionCoordinator id=0] Shutting down. (kafka.coordinator.transaction.TransactionCoordinator)
[2020-02-29 18:54:54,015] INFO [ProducerId Manager 0]: Shutdown complete: last producerId assigned 10000 (kafka.coordinator.transaction.ProducerIdManager)
[2020-02-29 18:54:54,016] INFO [Transaction State Manager 0]: Shutdown complete (kafka.coordinator.transaction.TransactionStateManager)
[2020-02-29 18:54:54,016] INFO [Transaction Marker Channel Manager 0]: Shutting down (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2020-02-29 18:54:54,016] INFO [Transaction Marker Channel Manager 0]: Stopped (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2020-02-29 18:54:54,016] INFO [Transaction Marker Channel Manager 0]: Shutdown completed (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2020-02-29 18:54:54,016] INFO [TransactionCoordinator id=0] Shutdown complete. (kafka.coordinator.transaction.TransactionCoordinator)
[2020-02-29 18:54:54,017] INFO [GroupCoordinator 0]: Shutting down. (kafka.coordinator.group.GroupCoordinator)
[2020-02-29 18:54:54,017] INFO [ExpirationReaper-0-Heartbeat]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,194] INFO [ExpirationReaper-0-Heartbeat]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,194] INFO [ExpirationReaper-0-Heartbeat]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,194] INFO [ExpirationReaper-0-Rebalance]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,279] INFO [ExpirationReaper-0-Rebalance]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,279] INFO [ExpirationReaper-0-Rebalance]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,280] INFO [GroupCoordinator 0]: Shutdown complete. (kafka.coordinator.group.GroupCoordinator)
[2020-02-29 18:54:54,281] INFO [ReplicaManager broker=0] Shutting down (kafka.server.ReplicaManager)
[2020-02-29 18:54:54,282] INFO [LogDirFailureHandler]: Shutting down (kafka.server.ReplicaManager$LogDirFailureHandler)
[2020-02-29 18:54:54,282] INFO [LogDirFailureHandler]: Stopped (kafka.server.ReplicaManager$LogDirFailureHandler)
[2020-02-29 18:54:54,282] INFO [LogDirFailureHandler]: Shutdown completed (kafka.server.ReplicaManager$LogDirFailureHandler)
[2020-02-29 18:54:54,282] INFO [ReplicaFetcherManager on broker 0] shutting down (kafka.server.ReplicaFetcherManager)
[2020-02-29 18:54:54,284] INFO [ReplicaFetcherManager on broker 0] shutdown completed (kafka.server.ReplicaFetcherManager)
[2020-02-29 18:54:54,284] INFO [ReplicaAlterLogDirsManager on broker 0] shutting down (kafka.server.ReplicaAlterLogDirsManager)
[2020-02-29 18:54:54,284] INFO [ReplicaAlterLogDirsManager on broker 0] shutdown completed (kafka.server.ReplicaAlterLogDirsManager)
[2020-02-29 18:54:54,284] INFO [ExpirationReaper-0-Fetch]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,480] INFO [ExpirationReaper-0-Fetch]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,480] INFO [ExpirationReaper-0-Fetch]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,480] INFO [ExpirationReaper-0-Produce]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,679] INFO [ExpirationReaper-0-Produce]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,679] INFO [ExpirationReaper-0-Produce]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,679] INFO [ExpirationReaper-0-DeleteRecords]: Shutting down (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,880] INFO [ExpirationReaper-0-DeleteRecords]: Stopped (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,880] INFO [ExpirationReaper-0-DeleteRecords]: Shutdown completed (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2020-02-29 18:54:54,882] INFO [ReplicaManager broker=0] Shut down completely (kafka.server.ReplicaManager)
[2020-02-29 18:54:54,883] INFO Shutting down. (kafka.log.LogManager)
[2020-02-29 18:54:54,907] INFO [ProducerStateManager partition=__consumer_offsets-42] Writing producer snapshot at offset 3 (kafka.log.ProducerStateManager)
[2020-02-29 18:54:54,924] INFO Shutdown complete. (kafka.log.LogManager)
[2020-02-29 18:54:54,936] INFO [ZooKeeperClient] Closing. (kafka.zookeeper.ZooKeeperClient)
[2020-02-29 18:54:54,940] INFO EventThread shut down for session: 0x10000de0bb80006 (org.apache.zookeeper.ClientCnxn)
[2020-02-29 18:54:54,941] INFO Session: 0x10000de0bb80006 closed (org.apache.zookeeper.ZooKeeper)
[2020-02-29 18:54:54,942] INFO [ZooKeeperClient] Closed. (kafka.zookeeper.ZooKeeperClient)
[2020-02-29 18:54:54,942] INFO [ThrottledChannelReaper-Fetch]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:55,730] INFO [ThrottledChannelReaper-Fetch]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:55,731] INFO [ThrottledChannelReaper-Fetch]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:55,731] INFO [ThrottledChannelReaper-Produce]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:56,731] INFO [ThrottledChannelReaper-Produce]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:56,731] INFO [ThrottledChannelReaper-Produce]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:56,731] INFO [ThrottledChannelReaper-Request]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:57,731] INFO [ThrottledChannelReaper-Request]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:57,731] INFO [ThrottledChannelReaper-Request]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2020-02-29 18:54:57,732] INFO [SocketServer brokerId=0] Shutting down socket server (kafka.network.SocketServer)
[2020-02-29 18:54:57,761] INFO [SocketServer brokerId=0] Shutdown completed (kafka.network.SocketServer)
[2020-02-29 18:54:57,767] INFO [KafkaServer id=0] shut down completed (kafka.server.KafkaServer)
[ec2-user@ip-172-31-87-105 bin]$
```