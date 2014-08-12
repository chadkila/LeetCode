/**
 * https://oj.leetcode.com/problems/multiply-strings/ 
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * e.g
 *     123 
 *     456 
 * -----------
 * 	   738 
 * 	  615 
 *  +492 
 * ----------- 
 *   56088 
 * thus, 
 * 123*456 = 56088.
 * 
 * In the same way, the algorithm is: A*B 
 * 1, For each element B[i] Compute tmp = B[i]*A Add tmp to the previous 
 * result, note the start position. res = res"+"tmp 
 * 2, Return result.
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int num[] = new int[len1 + len2];
		for (int i = 0; i < num1.length(); i++) {
			int carry = 0;
			int m = num1.charAt(len1 - 1 - i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int n = num2.charAt(len2 - 1 - j) - '0';
				// the answer array is reversed
				num[i + j] += carry + m * n;
				carry = num[i + j] / 10;
				// removes carry
				num[i + j] %= 10;
			}
			num[i + len2] += carry;
		}
		int i1 = num.length - 1;
		// head zeros
		while (i1 > 0 && num[i1] == 0)
			i1--;
		// removes head zeros and reverse the answer array
		StringBuilder ans = new StringBuilder("");
		while (i1 >= 0)
			ans.append((char) ('0' + num[i1--]));
		return ans.toString();
	}
}
