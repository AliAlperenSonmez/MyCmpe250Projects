import java.util.*;

public class Product implements Comparable<Product> {
	private int start;
	private int end;
	private int profit;
	private int maxProfit;

	public Product(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
		this.maxProfit = profit;
	}

	public int getEnd() {
		return end;
	}

	public int getProfit() {
		return profit;
	}

	public int getStart() {
		return start;
	}

	public int getMaxProfit() {
		return maxProfit;
	}

	public void setMaxProfit(int maxProfit) {
		this.maxProfit = maxProfit;
	}

	@Override
	public int compareTo(Product o) {
//		if (this.getEnd() < o.getEnd()) {
//			return -1;
//		} else if (o.getEnd() == this.getEnd()) {
//			if (this.getStart() < o.getStart()) {
//				return -1;
//			} else if (this.getStart() == o.getStart()) {
//				if (this.getProfit() > o.getProfit()) {
//					return -1;
//				} else {
//					return 1;
//				}
//			} else {
//				return 1;
//			}
//
//		}
//		return 1;
//	}
		
		if (this.getEnd()<o.getEnd()) {
			return -1;
			}
		else if (this.getEnd()==o.getEnd()) {
			if (this.getProfit() > o.getProfit()) {
			return -1;
			} else {
				return 1;
		}
	}
		else {return 1;}
	}
}
