/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 * No need to use brute force, this question is a little bit like best time to
 * sell and buy stock and longest parentheses
 * ref:
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * Don't know how to explain this, it's like store every higher trough in stack
 * then compare which trough makes the largest rectangle.
 * And that trough is bigger than its previous element in stack and the coming 
 * element out of stack, which is functioned as a peak and multiplied by the distance
 * between its previous element in stack and the coming element.
 */
import java.util.Arrays;
import java.util.Stack;

/**
 * @author yu
 * 
 */
public class Solution {
	public int largestRectangleArea(int[] height) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int h[] = new int[height.length + 1];
		// need to add an 0 at tail of the array for putting the last
		// element into stack
		h = Arrays.copyOf(height, height.length + 1);
		if (height.length == 0)
			return max;
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
