/**
 * https://oj.leetcode.com/problems/interleaving-string/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. 
 * When s3 = "aadbbbaccc", return false.
 * 
 * 2 dimension DP
 * DP[i][j] i characters covered in s1, j characters covered in s2
 * DP[i][j] means i elements from s1 and j elements from s2 can match i+j from s3
 * DP[i+1][j+1] is true if
 * DP[i+1][j] is true and s2[j]==s3[i+j+1] 
 * (i+1's in s1 and j's in s2 are match and s2 current is s3 current)
 * OR 
 * DP[i][j+1] is true and s1[i]==s3[i+j+1]
 * (i's in s1 and j+1's in s2 are match and s1 current is s3 current)
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		boolean DP[][] = new boolean[s1.length() + 1][s2.length() + 1];
		DP[0][0] = true;
		if (s1.length() + s2.length() != s3.length())
			return false;
		if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
			return true;
		// initialize the first column, need some base data for DP
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i) && DP[i][0])
				DP[i + 1][0] = true;
		}
		// initialize the first row, need some base data for DP
		for (int j = 0; j < s2.length(); j++) {
			if (s2.charAt(j) == s3.charAt(j) && DP[0][j])
				DP[0][j + 1] = true;
		}
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				// ?DP[i+1][j+1]
				if (s1.charAt(i) == s3.charAt(i + j + 1) && DP[i][j + 1])
					DP[i + 1][j + 1] = true;
				if (s2.charAt(j) == s3.charAt(i + j + 1) && DP[i + 1][j])
					DP[i + 1][j + 1] = true;
			}
		}
		// to see the DP table
		/*
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}
		*/
		return DP[s1.length()][s2.length()];
	}
}
