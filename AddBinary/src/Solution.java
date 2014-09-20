/**
 * https://oj.leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 * For example, 
 * a = "11" 
 * b = "1" 
 * Return "100".
 * 
 * ANS
 * This a straight forward solution by using 'carry', while the real problem 
 * is how extend the question to adding hexadecimal or decimal. 
 * For hexadecimal, change '%2' and '/2' to '%16' and '/16'
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String addBinary(String a, String b) {
		int carry = 0;
		StringBuilder ans = new StringBuilder();
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int aNum = (i >= 0 ? a.charAt(i) - '0' : 0);
			int bNum = (j >= 0 ? b.charAt(j) - '0' : 0);
			// current digit
			int cur = (aNum + bNum + carry) % 2;
			// carry for next digit
			carry = (aNum + bNum + carry) / 2;
			ans.insert(0, cur);
		}
		// don't forget the result of final loop
		if (carry > 0) {
			ans.insert(0, carry);
		}
		return ans.toString();
	}
}
