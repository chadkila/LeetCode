/**
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * Using 2 DP in this solution
 * int cuts[i] -> number of cuts from index i to the end of string
 * cuts[i] = min (cuts[i] , cuts[j]+1) when finding substring(i,j) is palindrome
 * initialize cuts[i] = length-i because it is the worst case (cut every single character)
 * 
 * boolean pal[i][j] -> substring (i,j) is a palindrome or not
 * pal[i][j] is true if 
 * pal[i+1][j-1] and charAt(i)=charAt(j)
 * or
 * j-i < 2 and charAt(i)=charAt(j)  because when j-i=1 means only 2 characters and j-i=0 means only one
 *  
 */

/**
 * @author yu
 * 
 */
public class Solution {

	public int minCut(String s) {
		int len = s.length();
		// at first loop j will get len value
		int cuts[] = new int[len + 1];
		boolean pal[][] = new boolean[len][len];
		if (len == 0 || s.isEmpty())
			return 0;
		// initialization
		for (int i = 0; i < len; i++)
			cuts[i] = len - i;
		// DP
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				// deciding (i,j) is palindrome or not
				if ((j - i < 2 && s.charAt(i) == s.charAt(j))
						|| (pal[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
					pal[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
				}
			}
		}
		return cuts[0] - 1;
	}

}
