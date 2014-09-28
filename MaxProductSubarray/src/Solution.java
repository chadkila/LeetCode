/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * ANS
 * The solution is similar with 'Maximum Subarray', which is 1-dimension DP.
 * But the problem is two negative numbers provides positive product.
 * The easiest way is use another array to store the minimum product, specifically
 * negative numbers.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int maxProduct(int[] A) {
		int max = A[0];
		// Array for maximum positive products
		int pos[] = new int[A.length];
		// Array for minimal products
		int neg[] = new int[A.length];
		pos[0] = A[0];
		neg[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			pos[i] = Math.max(Math.max(pos[i - 1] * A[i], neg[i - 1] * A[i]),
					A[i]);
			neg[i] = Math.min(Math.min(pos[i - 1] * A[i], neg[i - 1] * A[i]),
					A[i]);
			max = Math.max(max, pos[i]);
		}
		return max;
	}
}
