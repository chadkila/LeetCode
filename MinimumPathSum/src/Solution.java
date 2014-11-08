import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * ANS:
 * Set DP[i][j] is the minimum path sum from left up corner to grid[i][j],
 * then DP[i][j] = grid[i][j]+min(DP[i-1][j],DP[i][j-1]),
 * DP[0][0]=grid[0][0]
 * DP[i][0]=grid[i][0]+DP[i-1][0], DP[0][j]=grid[0][j]+DP[0][j-1]
 * And there is a smarter way to reduce space cost to O(n), noticed that when
 * calculating DP[i][j], only one row upper than it is used, and that could be 
 * merged to current row. So
 * DP[j]=grid[i][j]+min(DP[j-1],DP[j])
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		// DP array
		int DP[] = new int[col];
		// they cannot be 0s at first
		Arrays.fill(DP, Integer.MAX_VALUE);
		DP[0] = 0;
		for (int i = 0; i < row; i++) {
			// firstly update first column
			DP[0] += grid[i][0];
			for (int j = 1; j < col; j++) {
				DP[j] = grid[i][j] + Math.min(DP[j - 1], DP[j]);
			}
		}
		return DP[col - 1];
	}
}
