# JSON to Java Formatting - Proper

```
Topic = [stockData], offset = 339479, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 23:58:00","priceData":{"close":0.2354,"high":0.2354,"low":0.2354,"open":0.2354,"volume":0.0}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":0.0,"high":0.2354,"low":0.2354,"close":0.2354,"open":0.2354},"timestamp":"2020-02-29 23:58:00"}

```

## Terminal Output from the Server Startup

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
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Successfully joined group with generation 9
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Setting newly assigned partitions [stockData-0]
Topic = [stockData], offset = 339464, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 23:55:00","priceData":{"close":8708.1,"high":8708.41,"low":8705.2,"open":8706.06,"volume":-466330.98}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-466330.98,"high":8708.41,"low":8705.2,"close":8708.1,"open":8706.06},"timestamp":"2020-02-29 23:55:00"}

Topic = [stockData], offset = 339465, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 23:55:00","priceData":{"close":226.17,"high":226.18,"low":226.14,"open":226.18,"volume":-13179.1}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-13179.1,"high":226.18,"low":226.14,"close":226.17,"open":226.18},"timestamp":"2020-02-29 23:55:00"}

Topic = [stockData], offset = 339466, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 23:55:00","priceData":{"close":59.44,"high":59.44,"low":59.44,"open":59.44,"volume":0.0}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":0.0,"high":59.44,"low":59.44,"close":59.44,"open":59.44},"timestamp":"2020-02-29 23:55:00"}

Topic = [stockData], offset = 339467, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 23:55:00","priceData":{"close":0.2357,"high":0.2358,"low":0.2357,"open":0.2358,"volume":23880.4}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":23880.4,"high":0.2358,"low":0.2357,"close":0.2357,"open":0.2358},"timestamp":"2020-02-29 23:55:00"}

Topic = [stockData], offset = 339468, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 23:56:00","priceData":{"close":8700.41,"high":8702.47,"low":8700.41,"open":8701.6,"volume":-24370.642}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-24370.642,"high":8702.47,"low":8700.41,"close":8700.41,"open":8701.6},"timestamp":"2020-02-29 23:56:00"}

Topic = [stockData], offset = 339469, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 23:56:00","priceData":{"close":226.04,"high":226.23,"low":226.04,"open":226.23,"volume":-5801.110000000001}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-5801.110000000001,"high":226.23,"low":226.04,"close":226.04,"open":226.23},"timestamp":"2020-02-29 23:56:00"}

Topic = [stockData], offset = 339470, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 23:56:00","priceData":{"close":59.39,"high":59.39,"low":59.39,"open":59.39,"volume":0.0}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":0.0,"high":59.39,"low":59.39,"close":59.39,"open":59.39},"timestamp":"2020-02-29 23:56:00"}

Topic = [stockData], offset = 339471, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 23:56:00","priceData":{"close":0.2357,"high":0.2357,"low":0.2357,"open":0.2357,"volume":3572.79}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":3572.79,"high":0.2357,"low":0.2357,"close":0.2357,"open":0.2357},"timestamp":"2020-02-29 23:56:00"}

Topic = [stockData], offset = 339472, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 23:57:00","priceData":{"close":8694.3,"high":8694.3,"low":8693.07,"open":8693.76,"volume":-8024.4744}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-8024.4744,"high":8694.3,"low":8693.07,"close":8694.3,"open":8693.76},"timestamp":"2020-02-29 23:57:00"}

Topic = [stockData], offset = 339473, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 23:57:00","priceData":{"close":225.98,"high":226.01,"low":225.96,"open":226.01,"volume":-440.918}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-440.918,"high":226.01,"low":225.96,"close":225.98,"open":226.01},"timestamp":"2020-02-29 23:57:00"}

Topic = [stockData], offset = 339474, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 23:57:00","priceData":{"close":59.36,"high":59.36,"low":59.36,"open":59.36,"volume":0.0}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":0.0,"high":59.36,"low":59.36,"close":59.36,"open":59.36},"timestamp":"2020-02-29 23:57:00"}

Topic = [stockData], offset = 339475, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 23:57:00","priceData":{"close":0.2354,"high":0.2358,"low":0.2354,"open":0.2358,"volume":491.52}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":491.52,"high":0.2358,"low":0.2354,"close":0.2354,"open":0.2358},"timestamp":"2020-02-29 23:57:00"}

Topic = [stockData], offset = 339476, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 23:58:00","priceData":{"close":8692.09,"high":8692.33,"low":8691.94,"open":8692.05,"volume":-4604.8393}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-4604.8393,"high":8692.33,"low":8691.94,"close":8692.09,"open":8692.05},"timestamp":"2020-02-29 23:58:00"}

Topic = [stockData], offset = 339477, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 23:58:00","priceData":{"close":225.84,"high":225.84,"low":225.84,"open":225.84,"volume":-4.65623}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-4.65623,"high":225.84,"low":225.84,"close":225.84,"open":225.84},"timestamp":"2020-02-29 23:58:00"}

Topic = [stockData], offset = 339478, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 23:58:00","priceData":{"close":59.29,"high":59.3,"low":59.29,"open":59.29,"volume":-167.49599999999998}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":-167.49599999999998,"high":59.3,"low":59.29,"close":59.29,"open":59.29},"timestamp":"2020-02-29 23:58:00"}

Topic = [stockData], offset = 339479, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 23:58:00","priceData":{"close":0.2354,"high":0.2354,"low":0.2354,"open":0.2354,"volume":0.0}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":0.0,"high":0.2354,"low":0.2354,"close":0.2354,"open":0.2354},"timestamp":"2020-02-29 23:58:00"}


```


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
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Successfully joined group with generation 11
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Setting newly assigned partitions [stockData-0]
Topic = [stockData], offset = 339512, key = null, value = {"symbol":"BTC","timestamp":"2020-03-01 00:07:00","priceData":{"close":8701.17,"high":8701.18,"low":8699.74,"open":8699.74,"volume":-25283.014}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-25283.014,"high":8701.18,"low":8699.74,"close":8701.17,"open":8699.74},"timestamp":"2020-03-01 00:07:00"}
[JSON-Java] Symbol: [BTC], Price Data : [{"volume":-25283.014,"high":8701.18,"low":8699.74,"close":8701.17,"open":8699.74}]

Topic = [stockData], offset = 339513, key = null, value = {"symbol":"ETH","timestamp":"2020-03-01 00:07:00","priceData":{"close":225.85,"high":225.92,"low":225.85,"open":225.85,"volume":-10106.24}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-10106.24,"high":225.92,"low":225.85,"close":225.85,"open":225.85},"timestamp":"2020-03-01 00:07:00"}
[JSON-Java] Symbol: [ETH], Price Data : [{"volume":-10106.24,"high":225.92,"low":225.85,"close":225.85,"open":225.85}]

Topic = [stockData], offset = 339514, key = null, value = {"symbol":"LTC","timestamp":"2020-03-01 00:07:00","priceData":{"close":59.37,"high":59.37,"low":59.33,"open":59.33,"volume":-2261.4300000000003}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":-2261.4300000000003,"high":59.37,"low":59.33,"close":59.37,"open":59.33},"timestamp":"2020-03-01 00:07:00"}
[JSON-Java] Symbol: [LTC], Price Data : [{"volume":-2261.4300000000003,"high":59.37,"low":59.33,"close":59.37,"open":59.33}]

Topic = [stockData], offset = 339515, key = null, value = {"symbol":"XRP","timestamp":"2020-03-01 00:07:00","priceData":{"close":0.2355,"high":0.2355,"low":0.2353,"open":0.2353,"volume":125728.71}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":125728.71,"high":0.2355,"low":0.2353,"close":0.2355,"open":0.2353},"timestamp":"2020-03-01 00:07:00"}
[JSON-Java] Symbol: [XRP], Price Data : [{"volume":125728.71,"high":0.2355,"low":0.2353,"close":0.2355,"open":0.2353}]
```

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
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Successfully joined group with generation 13
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=kafkaStockDataGrp] Setting newly assigned partitions [stockData-0]
Topic = [stockData], offset = 339528, key = null, value = {"symbol":"BTC","timestamp":"2020-03-01 00:11:00","priceData":{"close":8684.01,"high":8691.81,"low":8684.01,"open":8691.69,"volume":-52452.287}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-52452.287,"high":8691.81,"low":8684.01,"close":8684.01,"open":8691.69},"timestamp":"2020-03-01 00:11:00"}
[JSON-Java] Symbol: [BTC], Volume : [-52452.287]
Topic = [stockData], offset = 339529, key = null, value = {"symbol":"ETH","timestamp":"2020-03-01 00:11:00","priceData":{"close":225.31,"high":225.57,"low":225.31,"open":225.57,"volume":-2557.15}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-2557.15,"high":225.57,"low":225.31,"close":225.31,"open":225.57},"timestamp":"2020-03-01 00:11:00"}
[JSON-Java] Symbol: [ETH], Volume : [-2557.15]
Topic = [stockData], offset = 339530, key = null, value = {"symbol":"LTC","timestamp":"2020-03-01 00:11:00","priceData":{"close":59.35,"high":59.4,"low":59.35,"open":59.4,"volume":-2404.25}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":-2404.25,"high":59.4,"low":59.35,"close":59.35,"open":59.4},"timestamp":"2020-03-01 00:11:00"}
[JSON-Java] Symbol: [LTC], Volume : [-2404.25]
Topic = [stockData], offset = 339531, key = null, value = {"symbol":"XRP","timestamp":"2020-03-01 00:11:00","priceData":{"close":0.235,"high":0.2353,"low":0.235,"open":0.2353,"volume":16841.81}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":16841.81,"high":0.2353,"low":0.235,"close":0.235,"open":0.2353},"timestamp":"2020-03-01 00:11:00"}
[JSON-Java] Symbol: [XRP], Volume : [16841.81]
Topic = [stockData], offset = 339532, key = null, value = {"symbol":"BTC","timestamp":"2020-03-01 00:12:00","priceData":{"close":8689.63,"high":8691.05,"low":8683.4,"open":8684.01,"volume":-95019.02}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"BTC","priceData":{"volume":-95019.02,"high":8691.05,"low":8683.4,"close":8689.63,"open":8684.01},"timestamp":"2020-03-01 00:12:00"}
[JSON-Java] Symbol: [BTC], Volume : [-95019.02]
Topic = [stockData], offset = 339533, key = null, value = {"symbol":"ETH","timestamp":"2020-03-01 00:12:00","priceData":{"close":225.4,"high":225.46,"low":225.17,"open":225.31,"volume":-44596.35}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"ETH","priceData":{"volume":-44596.35,"high":225.46,"low":225.17,"close":225.4,"open":225.31},"timestamp":"2020-03-01 00:12:00"}
[JSON-Java] Symbol: [ETH], Volume : [-44596.35]
Topic = [stockData], offset = 339534, key = null, value = {"symbol":"LTC","timestamp":"2020-03-01 00:12:00","priceData":{"close":59.38,"high":59.38,"low":59.32,"open":59.35,"volume":-3504.44}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"LTC","priceData":{"volume":-3504.44,"high":59.38,"low":59.32,"close":59.38,"open":59.35},"timestamp":"2020-03-01 00:12:00"}
[JSON-Java] Symbol: [LTC], Volume : [-3504.44]
Topic = [stockData], offset = 339535, key = null, value = {"symbol":"XRP","timestamp":"2020-03-01 00:12:00","priceData":{"close":0.235,"high":0.2351,"low":0.235,"open":0.235,"volume":35515.08}}
 [##] jsonObject type : org.json.simple.JSONObject
 [##] jsonObject  : {"symbol":"XRP","priceData":{"volume":35515.08,"high":0.2351,"low":0.235,"close":0.235,"open":0.235},"timestamp":"2020-03-01 00:12:00"}
[JSON-Java] Symbol: [XRP], Volume : [35515.08]
```