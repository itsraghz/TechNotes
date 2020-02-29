# JSON to Java Conversion

## Error

```
Exception in thread "main" java.lang.ClassCastException: class org.json.simple.JSONObject cannot be cast to class upgrad.kafka.stock.model.Stock (org.json.simple.JSONObject and upgrad.kafka.stock.model.Stock are in unnamed module of loader 'app')
	at upgrad.kafka.stock.KafkaStockConsumer.main(KafkaStockConsumer.java:66)
```

## Detailed Stack Trace from the Server Start

```
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [52.55.237.11:9092]
	check.crcs = true
	client.id = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = kafkaStockDataGrp
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[main] INFO org.apache.kafka.clients.Metadata - Cluster ID: EFn_WelQQpmuqTu8srYLlA
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Discovered group coordinator ec2-52-55-237-11.compute-1.amazonaws.com:9092 (id: 2147483647 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Revoking previously assigned partitions []
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Successfully joined group with generation 5
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Setting newly assigned partitions [stockData-0]
Topic = [stockData], offset = 339428, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 23:46:00","priceData":{"close":8694.04,"high":8696.8,"low":8670.19,"open":8670.19,"volume":-2781.6890000000003}}Exception in thread "main" java.lang.ClassCastException: class org.json.simple.JSONObject cannot be cast to class upgrad.kafka.stock.model.Stock (org.json.simple.JSONObject and upgrad.kafka.stock.model.Stock are in unnamed module of loader 'app')
	at upgrad.kafka.stock.KafkaStockConsumer.main(KafkaStockConsumer.java:66)

```