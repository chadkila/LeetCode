/**
 * https://oj.leetcode.com/problems/scramble-string/
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.f
 * 
 * ANS:
 * 3-way DP problem
 * DP[i][j][len] stands for s1[i,i+len] and s2[j,j+len] are scramble or not.
 * DP[i][j][1] is true if s1[i]=s2[j]
 * And so on, if k<len, DP[i][j][len] is true 
 * if there is a k that 
 * s1[i,i+k], s2[j,j+k] scramble and s1[i+k,i+len], s2[j+k,j+len] scramble
 * or
 * s1[i,i+k], s2[j+len-k,j+len] scramble and s1[i+k,i+len], s2[j,j+len-k] scramble 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		// two strings are empty
		if (s1.length() == 0)
			return true;
		int len = s1.length();
		// use length+1 because index itself will be length
		boolean DP[][][] = new boolean[len][len][len + 1];
		// DP[i][j][1] is true if s1[i]=s2[j]
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				DP[i][j][1] = (s1.charAt(i) == s2.charAt(j));
			}
		}
		for (int n = 2; n <= len; n++) {
			// x-i+1=n
			for (int i = 0; i <= len - n; i++) {
				for (int j = 0; j <= len - n; j++) {
					// split string
					for (int k = 1; k < n; k++) {
						// s1[i,i+k], s2[j,j+k] : s1[i+k,i+len], s2[j+k,j+len]
						DP[i][j][n] |= (DP[i][j][k] && DP[i + k][j + k][n - k])
						// s1[i,i+k],s2[j+len-k,j+len]:s1[i+k,i+len],s2[j,j+len-k]
								|| (DP[i][j + n - k][k] && DP[i + k][j][n - k]);
					}
				}
			}
		}
		return DP[0][0][len];
	}
}
