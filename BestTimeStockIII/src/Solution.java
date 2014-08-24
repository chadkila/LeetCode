/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * One dimenstion DP problem, divide the list into 2 parts and use the algorithm
 * in BestTimeStock to get the max profit in each part. Then find the maximum sum.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int len = prices.length;
		int max = 0;
		// stores max profit between [0, i]
		int left[] = new int[len];
		// stores max profit between [i, len-1]
		int right[] = new int[len];

		DP(prices, left, right);
		// find max sum
		for (int i = 0; i < len; i++) {
			max = Math.max(max, left[i] + right[i]);
		}
		return max;
	}

	private void DP(int[] prices, int[] left, int[] right) {
		// profit between [0,0] is 0
		left[0] = 0;
		// profit between [len-1,len-1] is 0
		right[right.length - 1] = 0;
		// minimal buying price
		int min = prices[0];
		// maximum sell price
		int max = prices[right.length - 1];
		// finding max profit while min buying price has been determined
		for (int i = 1; i < left.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i], prices[i] - min);
		}
		// finding max profit while max selling price has been determined
		for (int i = right.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
	}
}
