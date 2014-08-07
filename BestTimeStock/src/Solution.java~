/**
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 */

/**
 * 
 * @author yu
 * 
 */
public class Solution {
	public Solution() {

	}

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int min = Integer.MAX_VALUE;
		int diff = 0;
		// find the min value then get the highest difference
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			diff = Math.max(diff, prices[i] - min);
		}
		return diff;
	}
}
