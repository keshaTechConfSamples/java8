package bloom;

import java.util.Comparator;

public class StockComparator implements Comparator<Stock>{
	 public int compare(Stock stock1, Stock stock2) {
	        return stock1.getSymbol().compareTo(stock2.getSymbol());
	    }
}
