/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * using DP to store from i to j whether is palindromic
 * DP[0][0]=1 every single character is palindrom
 * DP[0][1]=(s[0]==s[1]), DP[1][1]=1
 * DP[0][2]=(s[0]==s[2] && DP[1][1]), DP[1][2]=(s[1]==s[2]), DP[2][2]=1
 * so,
 * DP[i][j]=1 if i==j
 * = s[i]==s[j] if i+1==j
 * = s[i]==s[j] && DP[i+1][j-1] if j>i+1 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean DP[][] = new boolean[len][len];
		// max length
		int max = 0;
		// index of max length substring
		int start = 0, end = 0;
		if (s.length() <= 1)
			return s;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < j; i++) {
				// when i!=j
				DP[i][j] = (i + 1 == j ? (s.charAt(i) == s.charAt(j)) : (s
						.charAt(i) == s.charAt(j) && DP[i + 1][j - 1]));
				// new max length, update index of that
				if (DP[i][j] && max < (j - i + 1)) {
					max = j - i + 1;
					start = i;
					end = j;
				}
			}
			// when i==j
			DP[j][j] = true;
		}
		return s.substring(start, end + 1);
	}
}
