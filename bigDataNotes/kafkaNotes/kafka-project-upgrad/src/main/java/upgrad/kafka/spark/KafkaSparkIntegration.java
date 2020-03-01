/**
 * 
 */
package upgrad.kafka.spark;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.StreamingContext;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import scala.Tuple2;
import upgrad.kafka.stock.model.PriceData;
import upgrad.kafka.stock.model.Stock;


/**
 * @author raghs
 *
 */
public class KafkaSparkIntegration {

	static StreamingContext streamingContext = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		simpleMovingAvgClosePrice(args);
	}

	public static void simpleMovingAvgClosePrice(String[] args) {
		
		/* This is the APP NAME to be set while initializing the SparkConf object */
		final String APP_NAME 				       = "SparkStreamingStockDataAnalysis1";
		
		/* This is the name of the analysis to be performed on streaming data*/
		final String ANALYSIS_NAME		           = "SimpleMovingAverage-Close-Price";
		
		//SparkConf sparkConf = new SparkConf().setAppName("Kafka Spark Integration for Stock Data").setMaster("local[*]");
		
		/* The Seconds variable contains value as 60. This value will be later used to convert seconds into minutes for Batch Interval, Window Duration and Sliding Window Duration. */
		int secs								   = 60;
		
		/* The Batch Interval Is Defined To Be 01 Minute */
		int batchInterval                          = 01;
		
		/* The Window Duration Is Defined To Be 10 Minutes */
		int windowDuration                         = 02;
		
		/* The Sliding Window Duration Is Defined To Be 05 Minutes */
		int slidingWindowDuration                  = 01;
		
		SparkConf sparkConf = null;
		JavaStreamingContext javaStreamingContext = null;
		
		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put("bootstrap.servers", "52.55.237.11:9092");
		kafkaParams.put("key.deserializer", StringDeserializer.class);
		kafkaParams.put("value.deserializer", StringDeserializer.class);
		kafkaParams.put("group.id", "KafkaUpgradStockConsumer");
		//TODO - Revisit
		kafkaParams.put("auto.offset.reset", "latest");
		kafkaParams.put("enable.auto.commit", "false");

		Collection<String> topics = Arrays.asList("stockData");

		try {
			
			/* The SparkConf object is re-initialized to run in local mode. An APPNAME is set for Spark to uniquely distinguish the spark streaming context for this program execution. */
			sparkConf = new SparkConf().setAppName(APP_NAME).setMaster("local[*]");
			
			System.out.println("[UPGRAD-DEBUG] (1) Spark Conf created successfully. " + sparkConf);
		
			/* The JavaStreamingContext is re-initialized. The SparkConf object is passed along with Batch Interval (in seconds) */
			javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(batchInterval*(long)secs));
			
			System.out.println("[UPGRAD-DEBUG] (2) JavaStreamingContext created successfully. " + javaStreamingContext);
		
			/* Introduced Logger to reduce Spark Logging on console */
			Logger.getRootLogger().setLevel(Level.ERROR);
			
			JavaInputDStream<ConsumerRecord<String, String>> dStream = 
					KafkaUtils.createDirectStream(
							javaStreamingContext,
							LocationStrategies.PreferConsistent(),
							ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
							);
			
			System.out.println("[UPGRAD-DEBUG] (3) JavaInputDStream created successfully. " + dStream);			
					
			/* The FlatMapFunction jsonExtractor  is used for a flatMap() transformation. 
			 * This transformation operates on the JSON data collected as JavaDStream<String>.
			 * The JSON data is parsed to fetch individual data elements pertaining to each Stock (like, symbol, volume, etc) and are stored in an object of type Stock.
			 * The class Stock is an implementation of a serializable POJO with composition of Price data.
			 * Logic:
			 * 1. The FlatMapFunction casts the JSON String into an object of type JSONArray
			 * 2. An ArrayList<Stock> is created and initialized
			 * 3. The JSONArray object is looped through to fetch the individual data elements and store them in an object of Stock type.
			 * 4. The Stock object is added to the Stock ArrayList.
			 * 5. There is an IF-ELSE construct which is used to calculate the total number of periods within a window, which will be used as a denominator for calculating Simple Moving Average. 
			 * 5.a The total number of periods is stored within the Stock class as a Static member variable.
			 * 5.b If the total number of periods is greater than Window Duration then the total number of periods is set to the value of Window Duration i.e. 10.
			 * 5.c Else the total number of periods is incremented by one.
			 * 5.d This logic is coded to make sure that in the first window the total number of periods is 5 as the sliding interval is 5 minutes and it is the first window.
			 * 5.e Later on for all windows, a total number of periods will always be 10 as the Window Duration is 10.
			 * The transformed RDDs are stored in a JavaDStream<Stock>.
			 * */
			final FlatMapFunction<String, Stock> jsonExtractor = new FlatMapFunction<String, Stock>() {
			
				private static final long serialVersionUID = 1L;

				@Override
				public Iterator<Stock> call(String record) throws ParseException  
				{
					System.out.println(" >>>> [UPGRAD-DEBUG] call() method of jsonExtractor - ENTRY");
					
					Stock stockObj;
					PriceData priceData;
					    
					JSONParser jsonParser = new JSONParser();
					JSONArray jsonArray = (JSONArray) jsonParser.parse(record);
					JSONObject jsonObj = null;
					
					if (Stock.getTotalNoPeriod()>windowDuration) {
						Stock.setTotalNoPeriod(windowDuration);
					}else {
						Stock.incrTotalNoPeriod();
					}
				    
					//TODO 
					/* For Development purposes */
					int maxRecordCount = 30;
					int recordsConsumed =  0;
					
					ArrayList<Stock> stockList = new ArrayList<>();
					
					/** Preferred Stock List */
					//TODO Move to a constant
					List<String> preferredStockList = Arrays.asList("BTC", "ETH", "LTC", "XRP");
					
					String symbol = null;
					LocalDateTime timestamp = null;
					double volume = 0, high = 0, low = 0, close = 0, open = 0.0;
					String formattedOutputStr = null;
					
					for(int i= 0 ; i < jsonArray.size(); i++)
					{
						jsonObj = (JSONObject) jsonArray.get(i);
					
						symbol = String.valueOf(jsonObj.get("symbol"));
						
						/** Business Validation : Consume only the interested stocks */
						if(Objects.isNull(symbol) || !preferredStockList.contains(symbol)) {
							System.out.println(" ==== [{##}] Record consumed is of type [ " + symbol + "]. "
									+ "Skipping this as it is NOT of the preferred stock symbol ["+ preferredStockList + "]");
							//TODO
							/* For development purposes */
							recordsConsumed--;
							continue;
						}
						
						//2020-03-01 00:15:00
						DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						timestamp = LocalDateTime.parse(String.valueOf(jsonObj.get("timestamp")), dateTimeFormatter);
						
						formattedOutputStr = String.format("[JSON-Java] Symbol: [%s], dateTime : [%s]", symbol, timestamp);
						
						JSONObject priceDataJSONObj = (JSONObject) jsonObj.get("priceData");
						if(null!=priceDataJSONObj) 
						{
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
						
						/** Add the stock POJO to the list */
						stockList.add(stockObj);
					}
					
					System.out.println(" <<<< [UPGRAD-DEBUG] call() method of jsonExtractor - EXIT");
					
					return stockList.iterator();
				}
			};
		
			/* The PairFunction stockMapper is used for a mapToPair() transformation.
			 * This transformation operates on JavaDStream<Stock> which contains the stock data fetched and stored as Stock (POJO).
			 * The PairFunction extracts the data elements Symbol and Close Price from the Stock POJO and returns a Key-Value pair of type Tuple2<String, Double>.
			 * The transformed RDDs are stored in a JavaPairDStream<String, Double>.
			 * */
			final PairFunction stockMapper = new PairFunction() {
			
				private static final long serialVersionUID = 1L;

				@Override
				public Tuple2<String, Double> call(Object arg0) throws Exception {
				
					Stock st      = (Stock)arg0;
					String symbol = st.getSymbol();
					Double close  = st.getPriceData().getClose();
				
					return new Tuple2<>(symbol, close);
			
				}
		
			};
		
			/* The Function2 stockReducer is used for a reduceByKeyAndWindow() transformation.
			 * The reduceByKeyAndWindow() takes as input the following 03 arguments:
			 * a. Name of the function (of type Function2)
			 * b. Window Duration (in seconds)
			 * c. Sliding Window Duration (in seconds) 
			 * This transformation operates on JavaPairDStream<String, Double> which contains Stock Symbol and Close Price.
			 * The function aggregates the Close Price of all stocks. 
			 * The aggregation happens for all Stock records having the same Key in a particular window i.e. the aggregation happens on Key (Symbol) and within the Window. 
			 * The transformed RDDs are stored in a JavaPairDStream<String, Double>
			 * */
			final Function2<Double, Double, Double> stockReducer = new Function2<Double, Double, Double>() {
			  	
				private static final long serialVersionUID = 1L;

				@Override
		        public Double call(Double a, Double b) throws Exception {
					return a + b;
				}
			};
		
			/* The PairFunction stockAverage is used for a mapToPair() transformation 
			 * This transformation operates on JavaPairDStream<String, Double> which contains the aggregated close price of stocks.
			 * The PairFunction extracts the following data elements from Stock
			 * a. Symbol
			 * b. Close Price
			 * c. Total Number of Period (calculated in the JSON_EXTRACTOR function.
			 * The PairFunction calculates the close price moving average by dividing the aggregated close price by total number of periods.
			 * The transformed RDDs are stored in a JavaPairDStream<String, Double>
			 * */
			final PairFunction stockAverage = new PairFunction() {
			
				private static final long serialVersionUID = 1L;

				@Override
				public Tuple2<String, Double> call(Object arg0) throws Exception {
				
					Tuple2<String, Double> temp = (Tuple2)arg0;
				
					String symbol = temp._1();
					Double avg    = Double.valueOf(temp._2()/Stock.getTotalNoPeriod());
				
					return new Tuple2<>(symbol, avg);
				}
		
			};
			
			JavaDStream<String> lines = dStream.map(ConsumerRecord::value);
			
			System.out.println("[UPGRAD-DEBUG] (4) JavaDStream<String> lines - created successfully. " + lines);
			
			 
			/* This transformation operates on the JSON data collected as JavaDStream<String>.
			 * The JSON data is parsed to fetch individual data elements pertaining to each Stock (like, symbol, volume, etc) and are stored in an object of type Stock.
			 * The transformed RDDs are stored in a JavaDStream<Stock>.
			 * */
			JavaDStream<Stock> stockData = lines.flatMap(jsonExtractor);		
			
			System.out.println("[UPGRAD-DEBUG] (5) JavaDStream<Stock> stockData - created successfully. " + stockData);
			
			/* This transformation operates on JavaDStream<Stock> which contains the stock data fetched and stored as Stock (POJO).
			 * The PairFunction extracts the data elements Symbol and Close Price from the Stock POJO and returns a Key-Value pair of type Tuple2<String, Double>.
			 * The transformed RDDs are stored in a JavaPairDStream<String, Double>.
			 * */
			JavaPairDStream<String, Double> stock = stockData.mapToPair(stockMapper);			
			
			System.out.println("[UPGRAD-DEBUG] (6) JavaPairDStream<String, Double> stock - created successfully. " + stock);
			
			/* This transformation operates on JavaPairDStream<String, Double> which contains Stock Symbol and Close Price.
			 * The function aggregates the Close Price of all stocks. 
			 * The aggregation happens for all Stock records having the same Key in a particular window i.e. the aggregation happens on Key (Symbol) and within the Window. 
			 * The transformed RDDs are stored in a JavaPairDStream<String, Double>
			 * */
			JavaPairDStream<String, Double> stockSum = stock.reduceByKeyAndWindow(stockReducer, Durations.seconds(windowDuration*(long)secs), Durations.seconds(slidingWindowDuration*(long)secs));
			
			System.out.println("[UPGRAD-DEBUG] (7) JavaPairDStream<String, Double> stockSum - created successfully. " + stockSum);
			
			/* This transformation operates on the JSON data collected as JavaDStream<String>.
			 * The JSON data is parsed to fetch individual data elements pertaining to each Stock (like, symbol, volume, etc) and are stored in an object of type Stock.
			 * The transformed RDDs are stored in a JavaDStream<Stock>.
			 * */
			JavaPairDStream stockAvg = stockSum.mapToPair(stockAverage);
			
			System.out.println("[UPGRAD-DEBUG] (8) JavaPairDStream stockAvg - created successfully. " + stockAvg);
			
			/* The final output i.e. Stock With Simple Moving Average (Symbol, Simple Moving Average For Close Price) is printed on the console. 
			 * This will be printed once for each window 
			 * */
			stockAvg.print();
			
			System.out.println("[UPGRAD-DEBUG] (9) stockAvg - print() executed successfully. ");
			
			javaStreamingContext.start();
			
			javaStreamingContext.awaitTermination();
		
			javaStreamingContext.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if (javaStreamingContext!=null) {
					
					javaStreamingContext.close();
			
				}
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
		}
		
	}
}
