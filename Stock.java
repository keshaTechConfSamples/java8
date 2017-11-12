package bloom;

import java.math.BigDecimal;

public class Stock {
	private String name;
	private String symbol;
	private BigDecimal currentPrice;
	private BigDecimal previousClosingPrice;
	
	public Stock(String name, String symbol, BigDecimal currentPrice,
			BigDecimal previousClosingPrice) {
		this.name = name;
		this.symbol = symbol;
		this.currentPrice = currentPrice;
		this.previousClosingPrice = previousClosingPrice;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public BigDecimal getPreviousClosingPrice() {
		return previousClosingPrice;
	}
	
	public void setPreviousClosingPrice(BigDecimal previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
