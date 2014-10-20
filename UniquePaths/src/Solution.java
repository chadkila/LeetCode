/**
 * https://oj.leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * 
 * ANS:
 * If using traditional backtracking algorithm (recursion) it would possibly out of
 * time limit. e.g.
 * BT(i,j) {
 *     return BT(i+1,j)+BT(i,j+1);
 * }
 * A simple DP would reduce it to O(n^2) time.
 * For the problem without any obstacles the recursive formula is:
 * 
 * dp[m][n] = dp[m][n-1] + dp[m-1][n] 
 * where dp[m][n] denotes the number of unique paths
 * 
 * For the problem with obstacles, the recursive formula is essentially the
 * same:
 * dp[m][n] = dp[m][n-1] + dp[m-1][n] 
 * dp[m][n] = 0 if the cell at the position (m, n) is occupied by an obstacle
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int uniquePaths(int m, int n) {
		int DP[][] = new int[m][n];

		// initialize first column
		for (int i = 0; i < m; i++) {
			DP[i][0] = 1;
		}

		// initialize first row
		for (int j = 0; j < n; j++) {
			DP[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
			}
		}

		return DP[m - 1][n - 1];
	}
}
