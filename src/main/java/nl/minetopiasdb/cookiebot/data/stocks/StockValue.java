package nl.minetopiasdb.cookiebot.data.stocks;

public class StockValue {

	private int openPrice, currentPrice;

	public StockValue(int openPrice, int currentPrice) {
		this.openPrice = openPrice;
		this.currentPrice = currentPrice;
	}

	public int getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(int openPrice) {
		this.openPrice = openPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

}
