package bloom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StockTest {
	public static void main(String... args) {
		Stock zillow = new Stock("Zillow", "ZLLW", new BigDecimal(150.00), new BigDecimal(200.00));
		Stock apple = new Stock("Apple", "APPL", new BigDecimal(100.00), new BigDecimal(75.00));
		Stock amazon = new Stock("Amazon", "AMZN", new BigDecimal(200.00), new BigDecimal(250.00));
		Stock microsoft = new Stock("Microsoft", "MCSFT", new BigDecimal(375.00), new BigDecimal(300.00));
		Stock google = new Stock("Google", "GGL", new BigDecimal(350.00), new BigDecimal(400.00));
		
		List<Stock> stocks = new ArrayList<>();
		
		stocks.add(apple);
		stocks.add(amazon);
		stocks.add(microsoft);
		stocks.add(google);
		stocks.add(zillow);
		
		//imperative style (external iterator-developers controls the iteration)
		//mutable external iterator
		for (int i = 0; i < stocks.size(); i++) {
			System.out.println(stocks.get(i).getName());
		}
		
		//parenthesis are optional, but only for a single parameter
		stocks.forEach((value)->System.out.println(value.getName()));
		
		//internal iterator & functional style (go iterate; i don't care how you iterate, just do this for every element in the collection)
		//--same as the line above; shortened way
		stocks.forEach(value->System.out.println(value.getName()));
		
		//since it's a simple pass through and didn't change the value can shorten it even more to this
		//if we changed the value (like increased the prices we couldnt' do this)
		//method references (replaced the lambda with a method reference--we aren't messing with the value, we are simply passing it through
		//use as an argument to function
		stocks.forEach(System.out::println);
		
		System.out.printf("The total lost in the portfolio is: %.2f", getPoorPerformingStocks(stocks));
		
	}
	
	public static double getPoorPerformingStocks(List<Stock> stocks) {
		//---find poor performing stocks 
		//---print the list of stocks that have lost value out sorted by symbol 
		//---print the total dollar amount of the lost
		
		//show the imperative (pre-Java 8 way) to filter a list
		BigDecimal amountLost = new BigDecimal(0.0);
		List<Stock> poorPerformers = new ArrayList<>();
		
		for (Stock stock: stocks) {
			if (stock.getPreviousClosingPrice().compareTo(stock.getCurrentPrice()) == 1) {
				poorPerformers.add(stock);
				amountLost = amountLost.add(stock.getPreviousClosingPrice().subtract(stock.getCurrentPrice()));
			}
		}
		
		Collections.sort(poorPerformers, new StockComparator());
		
		for(Stock stock: poorPerformers) {
			System.out.println(stock.getSymbol());
		}
		
		return amountLost.doubleValue();
		
		//the functional Java 8 way using streams
		//show pipeline
//		return stocks.stream()
					 //return only records where Previous Closing Price > Current Price
//					 .filter( stock -> stock.getPreviousClosingPrice().compareTo(stock.getCurrentPrice()) == 1) 
//					 //sort the values using StockComparator
//					 .sorted(new StockComparator()) 
		             //print the sorted values in the pipeline
//					 .peek( stock -> System.out.println(stock.getSymbol())) 
		             //for each element, transform the value to Closing Price - Current Price
//					 .mapToDouble(stock -> (stock.getPreviousClosingPrice().subtract(stock.getCurrentPrice())).doubleValue()) 
		             //for each element sum
//					 .sum(); 
	
		
		
		
		
	}
	
	
	
}
