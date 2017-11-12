package bloom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* The goal of this exercise is to refactor the legacy code to use a functional style.
 * Objective: Write code that sums up all stocks that start with A
 */
public class Exercise1 {
	
	public static void main (String... args) {
		Stock zillow = new Stock("Zillow", "ZLLW", new BigDecimal(150.00), new BigDecimal(200.00));
		Stock apple = new Stock("Apple", "APPL", new BigDecimal(100.00), new BigDecimal(75.00));
		Stock amazon = new Stock("Amazon", "AMZN", new BigDecimal(200.00), new BigDecimal(250.00));
		Stock microsoft = new Stock("Microsoft", "MCSFT", new BigDecimal(375.00), new BigDecimal(300.00));
		Stock google = new Stock("Google", "GGL", new BigDecimal(350.00), new BigDecimal(400.00));
		Stock delta = new Stock("Delta", "DLA", new BigDecimal(175.00), new BigDecimal(300.00));
		
		List<Stock> stocks = new ArrayList<>();
		
		stocks.add(apple);
		stocks.add(amazon);
		stocks.add(microsoft);
		stocks.add(google);
		stocks.add(zillow);
		stocks.add(delta);
		
		//TODO: Refactor lines 30-38 to use the Java 8 functional techniques we learned
		BigDecimal total = new BigDecimal(0.00);
		
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getName().startsWith("A")) {
				total = total.add(stocks.get(i).getCurrentPrice());		
			}
		}
		
		System.out.printf("The total of stocks containing A is : %.2f", total.doubleValue());
		
	}

}
