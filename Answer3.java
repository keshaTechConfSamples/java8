package bloom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Answer3 {
	public static void main(String... args) {
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
		
		System.out.printf("The total amount of gain across the portfolio is : %.2f", 
				stocks.stream()
					  //currentPrice > previousClosingPrice indicates a gain
			          .filter(stock->stock.getCurrentPrice().compareTo(stock.getPreviousClosingPrice()) == 1) 
			          //determine the amount of the gain
			          .mapToDouble(stock->stock.getCurrentPrice().subtract(stock.getPreviousClosingPrice()).doubleValue()) 
			          //sum all the values
			          .sum());
	}

}
