/**
 * https://oj.leetcode.com/problems/triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3] 
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * ANS
 * This is a DP problem. One solution is from top to bottom, triangle[i][j] += 
 * min(triangle[i-1][j-1], triangle[i-1][j]). But this will judge special cases
 * like triangle[i-1][j-1] or triangle[i-1][j] exists.
 * Better Solution is store path sum from bottom to top,
 * triangle[i][j] += min(triangle[i+1][j],triangle[i+1][j+1])
 * To achieve the bonus point, use an array to store each line's path sums.
 * For last row, row[j]=triangle[length][j]
 * Then go to upper levels,
 * row[j]=min(row[j],row[j+1])+triangle[i][j]
 */
import java.util.*;

/**
 * 
 * 
 * @author yu
 * 
 */
public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int row[] = new int[rows];
		if (rows == 0)
			return 0;
		// initialize the row array
		for (int i = 0; i < rows; i++) {
			row[i] = triangle.get(rows - 1).get(i);
		}
		for (int i = rows - 2; i >= 0; i--) {
			// i starts from rows-2, is real index
			for (int j = 0; j <= i; j++) {
				// update the row array to upper row
				row[j] = Math.min(row[j], row[j + 1]) + triangle.get(i).get(j);
			}
		}
		return row[0];
	}
}
