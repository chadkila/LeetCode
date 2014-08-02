/**
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 */

/**
 * 
 * @author yu
 * 
 */
public class Solution {
	/**
	 * using greedy strategy to get total maximum profit which is find every
	 * price pair that last price is lowest and current price is the highest
	 */
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int total = 0;
		// when to buy
		int buyIndex = 0;
		int i;

		// the maximum value is greater than last value and next value
		for (i = 1; i < prices.length; i++) {
			// if current price is less than last price, i -> buyIndex because
			// is a lower price
			if (prices[i] < prices[i - 1]) {
				total += prices[i - 1] - prices[buyIndex];
				buyIndex = i;
			}
		}
		// check if last value is greater than last buy time
		if (prices[prices.length - 1] > prices[buyIndex]) {
			total += prices[i - 1] - prices[buyIndex];
		}
		return total;
	}
}
