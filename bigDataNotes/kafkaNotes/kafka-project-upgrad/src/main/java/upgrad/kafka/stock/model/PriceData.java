package upgrad.kafka.stock.model;

/**
 * <p>
 * A POJO (Plain Old Java Object) to represent the different attributes of the 
 * <tt>PriceData</tt> as a composite entity to be represented in the primary data model <b>Stock</b>.
 * </p>
 * @author raghs
 *
 */
public class PriceData {
	
	/**
	 * <p>
	 * An attribute to represent the amount of a stock during its closing time.
	 * </p>
	 */
	private double close;
	
	/**
	 * <p>
	 * An attribute to represent the amount of a stock during its peak time.
	 * </p>
	 */	
	private double high;
	
	/**
	 * <p>
	 * An attribute to represent the amount of a stock during its non-peak time.
	 * </p>
	 */
	private double low;
	
	/**
	 * <p>
	 * An attribute to represent the amount of a stock during its opening time.
	 * </p>
	 */
	private double open;
	
	/**
	 * <p>
	 * An attribute to represent the volume of a stock being traded on a particular day.
	 * </p>
	 */
	private double volume;

	/**
	 * @return the close
	 */
	public double getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(double close) {
		this.close = close;
	}

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(double high) {
		this.high = high;
	}

	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(double low) {
		this.low = low;
	}

	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(double open) {
		this.open = open;
	}

	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "PriceData [close=" + close + ", high=" + high + ", low=" + low + ", open=" + open + ", volume=" + volume
				+ "]";
	}

	/**
	 * @param close
	 * @param high
	 * @param low
	 * @param open
	 * @param volume
	 */
	public PriceData(double close, double high, double low, double open, double volume) {
		super();
		this.close = close;
		this.high = high;
		this.low = low;
		this.open = open;
		this.volume = volume;
	}

}