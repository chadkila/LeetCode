/**
 * http://oj.leetcode.com/problems/single-number/
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory? 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int singleNumber(int[] A) {
		int tempNum[] = new int[32];
		int single = 0;
		for (int i = 0; i < 32; i++) {
			for (int ii = 0; ii < A.length; ii++) {
				tempNum[i] += (A[ii] >> i) & 1;
			}
			single |= (tempNum[i] % 2) << i;
		}
		return single;
	}
}
