/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi to convert a string to an integer.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		// positive number?
		boolean positive = true;
		int i = 0;
		double result = 0;
		// omit leading and trailing spaces
		str = str.trim();
		// positive or negative
		if (str.charAt(0) == '+') {
			positive = true;
			i++;
		} else if (str.charAt(0) == '-') {
			positive = false;
			i++;
		}
		// add each bit at tail
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'
				&& i <= 11) {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		// change positive to negative
		result = positive ? result : -result;
		// bounds
		if (result > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		if (result < Integer.MIN_VALUE) {
			result = Integer.MIN_VALUE;
		}
		return (int) result;
	}
}
