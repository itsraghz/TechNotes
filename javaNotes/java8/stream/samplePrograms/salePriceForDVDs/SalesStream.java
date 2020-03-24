/* Example program written in the Chapter 12 of Wiley's Java for Dummies, 7th Edition written by Barry Burd */
// Modified slightly to fit my needs 

import java.util.ArrayList;
import java.text.NumberFormat;
import static java.lang.System.out;

public class SalesStream
{
	static NumberFormat currency = NumberFormat.getCurrencyInstance();

	public static void main(String... args)
	{
		ArrayList<Sale> sales = new ArrayList<>();
		
		fillTheList(sales);
		
		//compute the total using the No Streams way (traditional, imperative way)
		computeTotalNonStreams(sales);

		//compute the total using the Streams (funcional programming style)
		computeTotal(sales);

		//compute the total using the Streams and the existing method of Double.sum with the scope resolution operator (::)
		computeTotal2(sales);
	}

	static void fillTheList(ArrayList<Sale> sales) {
		sales.add(new Sale("DVD", 15.00));
		sales.add(new Sale("Books", 12.00));
		sales.add(new Sale("DVD", 21.00));
		sales.add(new Sale("CD", 5.25));
	}

	static void computeTotalNonStreams(ArrayList<Sale> sales) {
		double total = 0;
		
		for(Sale sale : sales) {
			if(sale.getItem().equals("DVD")){
				total += sale.getPrice();
			}
		}

		out.println("Imperative Way (non streams) - Total Price of all DVDs : " + currency.format(total));
	}

	static void computeTotal(ArrayList<Sale> sales) {
		double total = sales.stream()
				    .filter(sale -> sale.getItem().equals("DVD"))
				    .map(sale -> sale.getPrice())
				    .reduce(0.0, (price1, price2) -> price1 + price2);

		out.println("Functional way (streams) - Total Price of all DVDs : " + currency.format(total));
	}
	
	static void computeTotal2(ArrayList<Sale> sales) {
		double total = sales.stream()
				    .filter(sale -> sale.getItem().equals("DVD"))
				    .map(sale -> sale.getPrice())
				    .reduce(0.0, Double :: sum);

		out.println("Functional way (streams) [Double::sum] - Total Price of all DVDs : " + currency.format(total));
	}
}
