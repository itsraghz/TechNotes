package upgrad.kafka.stock.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * Sample Data: 
 * 
 * Topic = [stockData], offset = 339048, key = null, value = {"symbol":"BTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":8630.74,"high":8636.15,"low":8630.73,"open":8636.1,"volume":-122138.31000000001}}
 * Topic = [stockData], offset = 339049, key = null, value = {"symbol":"ETH","timestamp":"2020-02-29 22:09:00","priceData":{"close":223.48,"high":223.55,"low":223.44,"open":223.5,"volume":-13240.96}}
 * Topic = [stockData], offset = 339050, key = null, value = {"symbol":"LTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":58.42,"high":58.46,"low":58.38,"open":58.46,"volume":-22788.51}}
 * Topic = [stockData], offset = 339051, key = null, value = {"symbol":"XRP","timestamp":"2020-02-29 22:09:00","priceData":{"close":0.2333,"high":0.2336,"low":0.2333,"open":0.2336,"volume":34411.2
 * {"symbol":"BTC","timestamp":"2020-02-29 22:09:00","priceData":{"close":8630.74,"high":8636.15,"low":8630.73,"open":8636.1,"volume":-122138.31000000001}}
 * 
 * @author raghs
 *
 */
public class Stock implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2553388808002737115L;

	/**
	 * <p>
	 * An attribute to represent the Symbol of a stock.
	 * </p>
	 */
	private String symbol;
	
	/**
	 * <p>
	 * An attribute to represent the timestamp at which the stock data is captured for processing.
	 * </p>
	 */
	private LocalDateTime timestamp;
	
	/**
	 * <p>
	 * An attribute to represent the composite data <tt>priceData</tt> to have several different attributes
	 * associated with the prices of a stock along with the volume.
	 * </p>
	 */
	private PriceData priceData;
	
	private static int totalNoPeriod=0;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the priceData
	 */
	public PriceData getPriceData() {
		return priceData;
	}

	/**
	 * @param priceData the priceData to set
	 */
	public void setPriceData(PriceData priceData) {
		this.priceData = priceData;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", timestamp=" + timestamp + ", priceData=" + priceData + "]";
	}

	/**
	 * @param symbol
	 * @param timestamp
	 * @param priceData
	 */
	public Stock(String symbol, LocalDateTime timestamp, PriceData priceData) {
		super();
		this.symbol = symbol;
		this.timestamp = timestamp;
		this.priceData = priceData;
	}	
	
	public static int getTotalNoPeriod() {
		
		return totalNoPeriod;
	
	}
	
	public static void setTotalNoPeriod(int totalNoPeriod) {
		
		Stock.totalNoPeriod = totalNoPeriod;
		
		System.out.println("Stock - totalNoPeriod : " + totalNoPeriod);
	
	}
	
	/* Reset the total number of period to 0. */
	public static void resetTotalNoPeriod() {
		
		Stock.totalNoPeriod = 0;
	
	}
	
	/* Increments the total number of period by 1. */
	public static void incrTotalNoPeriod() {
		
		Stock.totalNoPeriod = Stock.totalNoPeriod+1;
	
	}
}

