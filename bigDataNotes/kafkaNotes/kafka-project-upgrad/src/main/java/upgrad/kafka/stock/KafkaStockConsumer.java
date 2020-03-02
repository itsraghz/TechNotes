package upgrad.kafka.stock;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import upgrad.kafka.stock.model.PriceData;
import upgrad.kafka.stock.model.Stock;

/**
 * 
 * @author raghs
 *
 */
public class KafkaStockConsumer {

	public static void main(String[] args) 
	{
		Properties props = new Properties();
		
		/** IP Address of the machine where Kafka Server is running (IPV4 Address of Amazon EC2 Instance */
		//props.put("bootstrap.servers", "localhost:9092");
		props.put("bootstrap.servers", "52.55.237.11:9092");
		props.put("group.id", "kafkaStockDataGrp");
		props.put("enable.auto.commit", "true");
		props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("enable.auto.commit", "false");
		props.put("auto.offset.reset", "latest");
		
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> stockConsumer = new KafkaConsumer<String, String>(props);
		stockConsumer.subscribe(Arrays.asList("stockData"));
		
		/* For Development purposes */
		int maxRecordCount = 1000;
		int recordsConsumed =  0;
		
		/** Preferred Stock List */
		List<String> preferredStockList = Arrays.asList("BTC", "ETH", "LTC", "XRP");
		
		/**
		 * Topic = [stockData], offset = 339048, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":8630.74,"high":8636.15,"low":8630.73,"open":8636.1,"volume":-122138.31000000001}}
		 * Topic = [stockData], offset = 339049, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 22:09:00","priceData":{"close":223.48,"high":223.55,"low":223.44,"open":223.5,"volume":-13240.96}}
		 * Topic = [stockData], offset = 339050, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":58.42,"high":58.46,"low":58.38,"open":58.46,"volume":-22788.51}}
		 * Topic = [stockData], offset = 339051, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 22:09:00","priceData":{"close":0.2333,"high":0.2336,"low":0.2333,"open":0.2336,"volume":34411.2
		 * {"symbol":"BTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":8630.74,"high":8636.15,"low":8630.73,"open":8636.1,"volume":-122138.31000000001}}
		 */
		while (true) {
			
			ConsumerRecords<String, String> records = stockConsumer.poll(Duration.ofMillis(100));
		
			for (ConsumerRecord<String, String> record : records) 
			{
				System.out.printf("Topic = [%s], offset = %d, key = %s, value = %s", 
						record.topic(), record.offset(), record.key(), record.value());
				System.out.println();
				
				/* For development purposes */
				if(recordsConsumed ++ > maxRecordCount) {
					System.err.println("MaxRecords Reached. Program exiting now as per configuration..");
					break;
				}
				
				/* JSON to Java Conversion */
				JSONParser jsonParser = new JSONParser();
				Object obj = null;
				Stock stockObj = null;
				PriceData priceData = null;
				JSONObject jsonObj = null;
				
				try {
					obj = jsonParser.parse(record.value());
				} catch (ParseException e) {
					System.err.println("Exception occurred while parsing the JSON data and converting to the Stock data model..");
					e.printStackTrace();
				}
				
				if(null!=obj)
					 jsonObj = (JSONObject) obj;

				//System.out.println(" [##] jsonObject type : " + jsonObj.getClass().getTypeName());
				//System.out.println(" [##] jsonObject  : " + jsonObj);
				
				String symbol = null;
				LocalDateTime timestamp = null;
				double volume = 0, high = 0, low = 0, close = 0, open = 0.0;
				String formattedOutputStr = null;
				
				if(null!=jsonObj) {
					symbol = String.valueOf(jsonObj.get("symbol"));
					
					/** Business Validation : Consume only the interested stocks */
					if(Objects.isNull(symbol) || !preferredStockList.contains(symbol)) {
						System.out.println(" ==== [{##}] Record consumed is of type [ " + symbol + "]. "
								+ "Skipping this as it is NOT of the preferred stock symbol ["+ preferredStockList + "]");
						/* For development purposes */
						recordsConsumed--;
						continue;
					}
					
					//2020-03-01 00:15:00
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					timestamp = LocalDateTime.parse(String.valueOf(jsonObj.get("timestamp")), dateTimeFormatter);
					
					formattedOutputStr = String.format("[JSON-Java] Symbol: [%s], dateTime : [%s]", symbol, timestamp);
					
					JSONObject priceDataJSONObj = (JSONObject) jsonObj.get("priceData");
					if(null!=priceDataJSONObj) {
						volume = Double.valueOf(String.valueOf(priceDataJSONObj.get("volume")));
						if(volume < 0) {
							System.out.println(" [{%%}] Volume - [" + volume + "] is negative. Taking the absolute value of it.");
							volume = Math.abs(volume);
						}
						high = Double.valueOf(String.valueOf(priceDataJSONObj.get("high")));
						low = Double.valueOf(String.valueOf(priceDataJSONObj.get("low")));
						close = Double.valueOf(String.valueOf(priceDataJSONObj.get("close")));
						open = Double.valueOf(String.valueOf(priceDataJSONObj.get("open")));
						
						formattedOutputStr += String.format(", Volume : [%s]", volume);
					}
					priceData = new PriceData(close, high, low, open, volume);
					stockObj = new Stock(symbol, timestamp, priceData);
					
					System.out.println("[{##}] stockObj parsed: " + stockObj);
				}
				//System.out.println(formattedOutputStr);
				//System.out.println();
			}
			
			//consumer.close();
		}
	}
}