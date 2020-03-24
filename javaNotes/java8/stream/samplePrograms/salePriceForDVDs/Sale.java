/* Example program written in the Chapter 12 of Wiley's Java for Dummies, 7th Edition written by Barry Burd */
public class Sale
{
	private String item;
	private double price;

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Sale(String item, double price) {
		this.item = item;
		this.price = price;
	}
}
