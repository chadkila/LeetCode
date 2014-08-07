/**
 * https://oj.leetcode.com/problems/candy/
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * scan from left to right once and then scan from right to left
 * if the current one is higher than the last one then current value is last+1
 * then get maximum at each position
 * then add them up
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int candy(int[] ratings) {
		int sum = 0;
		int len = ratings.length;
		int[] ls = new int[len];
		int[] rs = new int[len];
		// every kid has at least one candy
		for (int i = 0; i < len; i++) {
			ls[i] = 1;
			rs[i] = 1;
		}
		// scan from left
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1])
				ls[i] = ls[i - 1] + 1;
		}
		// scan from right
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				rs[i] = rs[i + 1] + 1;
		}
		// adding up
		for (int i = 0; i < len; i++)
			sum += Math.max(ls[i], rs[i]);
		return sum;
	}
}
