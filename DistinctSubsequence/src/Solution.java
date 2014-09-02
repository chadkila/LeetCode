/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * ANS
 * A recursive approach is for every i in S
 * if (S.charAt(i) == T.charAt(0)) { 
 * cnt += numDistinct(S.substring(i + 1),T.substring(1)); 
 * }
 * But it is very slow, a DP approach is O(n^2)
 * Let DP(i, j) stand for the number of subsequences of T[0,i] in S[0,j]. 
 * If T[i]=S[j], DP(i,j)=DP(i-1,j-1)+DP(i,j-1)
 * Otherwise, DP(i,j) = DP(i,j-1).
 */
import java.util.Arrays;

/**
 * @author yu
 * 
 */
public class Solution {
	public int numDistinct(String S, String T) {
		// T[0,i] is a subsequence of S[0,j]
		int DP[][] = new int[T.length() + 1][S.length() + 1];
		// "" is a sub sequence of S
		Arrays.fill(DP[0], 1);
		for (int i = 1; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				DP[i][j] = DP[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1))
					DP[i][j] += DP[i - 1][j - 1];
			}
		}
		return DP[T.length()][S.length()];
	}
}
