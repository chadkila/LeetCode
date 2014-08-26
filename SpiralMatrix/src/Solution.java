/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ], 
 *  [ 4, 5, 6 ], 
 *  [ 7, 8, 9 ] 
 * ] 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * Using a recursive solution.
 * Recursively to loop circles and circles
 * 1st circle is 12369874, 2nd is 5
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return ans;
		ans = circle(matrix, 0, 0, matrix.length, matrix[0].length);
		return ans;
	}

	private ArrayList<Integer> circle(int[][] matrix, int x, int y, int m, int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (m <= 0 || n <= 0)
			return res;
		if (m == 1 && n == 1) {
			res.add(matrix[x][y]);
			return res;
		}
		// 1 -> 2
		for (int i = 0; i < n - 1; i++)
			res.add(matrix[x][y++]);
		// 3 -> 6
		for (int j = 0; j < m - 1; j++)
			res.add(matrix[x++][y]);
		// if there is only one line don't trace back
		// 9 -> 8
		if (m > 1) {
			for (int i1 = 0; i1 < n - 1; i1++)
				res.add(matrix[x][y--]);
		}
		// if there is only one column don't trace back
		// 7 -> 4
		if (n > 1) {
			for (int j1 = 0; j1 < m - 1; j1++)
				res.add(matrix[x--][y]);
		}
		// if there is only one line, then adding last one item into list
		if (m == 1 || n == 1)
			res.add(matrix[x][y]);
		else
			res.addAll(circle(matrix, x + 1, y + 1, m - 2, n - 2));
		return res;
	}
}
