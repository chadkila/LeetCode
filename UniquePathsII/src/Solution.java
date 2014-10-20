/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * Follow up for "Unique Paths"(https://oj.leetcode.com/problems/unique-paths/):
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [ 
 * [0,0,0], 
 * [0,1,0], 
 * [0,0,0] 
 * ]
 * The total number of unique paths is 2.
 * 
 * ANS:
 * Same as 'Unique Path', use a two-way DP to solve this.
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
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int DP[][] = new int[m][n];

		// initialize first column
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] != 1)
				// if there was an obstacle whole column will be 0 afterward
				if (!(i > 0 && DP[i - 1][0] == 0))
					DP[i][0] = 1;
		}

		// initialize first row
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] != 1)
				// if there was an obstacle whole row will be 0 afterward
				if (!(j > 0 && DP[0][j - 1] == 0))
					DP[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// not obstacle
				if (obstacleGrid[i][j] != 1)
					DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
				else
					// meets obstacle
					DP[i][j] = 0;
			}
		}

		return DP[m - 1][n - 1];
	}
}
