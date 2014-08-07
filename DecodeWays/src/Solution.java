/**
 * https://oj.leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 
 * 'B' -> 2 
 * ... 
 * 'Z' -> 26 
 * 
 * Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * one dimension dynamic programming. 
 * Could be a string of 2 characters or 1 character 
 * equation : num[i] = num[i-1] + num[i-2] 
 * num[i-1] if only charAt(i-1) != 0
 * num[i-2] if only charAt(i-2) != 0 
 * e.g 1102 -> 11211 one decoding way
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		// first character cannot be 0
		if (s.charAt(0) == '0')
			return 0;
		int[] DP = new int[s.length() + 1];
		DP[0] = 1;
		// first character is not 0
		DP[1] = 1;
		// i will reach one digit after the end of string
		for (int i = 2; i <= s.length(); i++) {
			int one = s.charAt(i - 1) - '0';
			// get num[i-1]
			if (one != 0) {
				DP[i] = DP[i - 1];
			}
			// convert the 2 digit string to integer
			int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
			// adding up num[i-2]
			// e.g 01 cannot be decoded, 11 can be decoded
			if (two >= 10 && two <= 26) {
				DP[i] += DP[i - 2];
			}
		}
		return DP[s.length()];
	}
}
