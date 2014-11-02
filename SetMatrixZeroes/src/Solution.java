/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up. Follow up:
 * Did you use extra space? A straight forward solution using O(mn) space is
 * probably a bad idea. A simple improvement uses O(m + n) space, but still not
 * the best solution. Could you devise a constant space solution?
 * 
 * ANS:
 * The easiest way is to use an array with m length and another with n length to
 * store which line needs to be cleared. But this question asks for an in-place
 * algorithm, so a straight forward solution is using first row and first column
 * in the matrix to store which line needs to be cleared.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public void setZeroes(int[][] matrix) {
		// whether first row and first column will be cleared
		boolean row0 = false, col0 = false;
		// first column needs to be cleared or not
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				col0 = true;
				break;
			}
		}
		// first row needs to be cleared or not
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				row0 = true;
				break;
			}
		}
		// find 0s and mark its coordinate at first row and column
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// clear the marked rows to be 0
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++)
					matrix[i][j] = 0;
			}
		}
		// clear the marked columns to be 0
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++)
					matrix[i][j] = 0;
			}
		}
		// if first row needs to be cleared
		if (row0) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;
		}
		// if first column needs to be cleared
		if (col0) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}
	}
}
