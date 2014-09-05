/**
 * https://oj.leetcode.com/problems/edit-distance/
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * ANS
 * When talking about finding minimum or maximum it is possibly a DP problem, and 
 * this is a classic DP problem.
 * 
 * dist[i][j] presents distance between word1[0..i] and word2[0..j]
 * dist[0][0]=0 because word1 and word2 are empty
 * dist[0][j]=j because word1 is empty while word2 is not, and dist[i][0]=i
 * when word1[i]=word[j] dist[i][j]=dist[i-1][j-1]
 * when word1[i]!=word[j]
 * 1) dist[i-1][j-1] stands for modifying word1[i] to word2[j] and vice versa
 * 2) dist[i][j-1] stands for deleting word2[j]
 * 3) dist[i-1][j] stands for deleting word1[i]
 * and dist[i][j] would be the smallest of them plus 1
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int dist[][] = new int[len1 + 1][len2 + 1];
		// if word1 is empty
		if (len1 == 0)
			return len2;
		// if word2 is empty
		if (len2 == 0)
			return len1;
		// dist[i][0]=i for word2 is empty
		for (int i = 0; i <= len1; i++) {
			dist[i][0] = i;
		}
		// dist[0][j]=j for word1 is empty
		for (int j = 0; j <= len2; j++) {
			dist[0][j] = j;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				// word1[i]=word[j]
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dist[i][j] = dist[i - 1][j - 1];
				} else {
					// modify word1[i] and word2[j]
					dist[i][j] = Math.min(dist[i - 1][j - 1],
					// deleting word1[i] or word2[j]
							Math.min(dist[i - 1][j], dist[i][j - 1])) + 1;
				}
			}
		}
		return dist[len1][len2];
	}
}
