/**
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * Don't use brute force, that will be O(n^3)
 * This problem is little bit like 'Largest Rectangle in Histogram' 
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * convert every line into a histogram, each slot stores the height of 1s
 * then it will be reduced to O(n^2)
 */
import java.util.Arrays;
import java.util.Stack;

/**
 * @author yu
 * 
 */
public class Solution {
	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		// don't forget rows may be 0 and runtime exception
		int cols = rows == 0 ? 0 : matrix[0].length;
		int maxRect = 0;
		// last column is for 0s
		int hist[][] = new int[rows][cols + 1];
		if (rows == 0 || cols == 0)
			return 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '0') {
					// no 1 then height is 0
					hist[i][j] = 0;
				} else {
					// if not the first row then add upper row's height
					hist[i][j] = i == 0 ? 1 : hist[i - 1][j] + 1;
				}
			}
		}
		// find row by row
		for (int i = 0; i < rows; i++) {
			int tmp = largestRectangleArea(hist[i]);
			if (tmp > maxRect)
				maxRect = tmp;
		}
		return maxRect;
	}

	private int largestRectangleArea(int[] h) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (i < h.length) {
			// stack is empty or the coming one is larger than stack top
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
				i++;
			} else {
				// find which trough makes a bigger rectangle
				int cur = stack.pop();
				max = Math.max(max, stack.isEmpty() ? h[cur] * i : h[cur]
						* (i - stack.peek() - 1));
			}
		}
		return max;
	}
}
