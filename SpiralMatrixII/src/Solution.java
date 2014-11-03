/**
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3, You should return the following matrix:
 * [ 
 *  [ 1, 2, 3 ], 
 *  [ 8, 9, 4 ], 
 *  [ 7, 6, 5 ] 
 *  
 *  ANS:
 *  Operations of index of array. Index i and j stand for start and end indexes 
 *  of a inner matrix. 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int[][] generateMatrix(int n) {
		// start and end index
		int i = 0, j = n - 1;
		int matrix[][] = new int[n][n];
		int num = 1;
		// start and end indexes shrink 1 size each loop
		for (; i < j; i++, j--) {
			// 1 -> 3
			for (int k = i; k <= j; k++) {
				matrix[i][k] = num++;
			}
			// 4 -> 5
			for (int k = i + 1; k <= j; k++) {
				matrix[k][j] = num++;
			}
			// 6 -> 7
			for (int k = j - 1; k >= i; k--) {
				matrix[j][k] = num++;
			}
			// 8
			for (int k = j - 1; k > i; k--) {
				matrix[k][i] = num++;
			}
		}
		// only one element left
		if (i == j)
			matrix[i][j] = num;
		return matrix;
	}
}
