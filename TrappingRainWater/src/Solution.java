/**
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * ANS:
 * This problem is similar to the problem of finding Largest Rectangle in
 * Histogram. So, we can use a similar strategy here:
 * 
 * 1. Use Stack to store the index of a bar. 
 * 2. If the current one is smaller then the top of the stack, push it to stack.
 * 3. Otherwise, pop up the top until stack is empty or top is greater than the 
 * current one, add up the volume, push the current smaller one into stack.
 * 
 * Consider {2,1,0,1,2}
 * 2(0),1(1),0(2) have been pushed into stack.
 * 1(3) appears:
 * 0(2) popped, (3-1-1)*(1-0)=1 added into sum. stack is 2(0),1(1)
 * 1(1) popped, (3-0-1)*(1-1)=0 added into sum. stack is 2(0)
 * 1(3) pushed into stack. stack is 2(0),1(3)
 * 2(4) appears:
 * 1(3) popped, (4-0-1)*(2-1)=3 added into sum. stack is 2(0)
 * 2(0) popped, stack is empty, break.
 * sum=4.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public int trap(int[] A) {
		// current bar index
		int cur = 0;
		// volume of rain
		int sum = 0;
		// skip zeros
		while (cur < A.length && A[cur] == 0)
			++cur;
		Stack<Integer> stack = new Stack<Integer>();
		while (cur < A.length) {
			// current bar is bigger
			while (!stack.isEmpty() && A[cur] >= A[stack.peek()]) {
				// the bottom
				int low = stack.pop();
				if (stack.isEmpty())
					break;
				int width = cur - stack.peek() - 1;
				int height = Math.min(A[cur], A[stack.peek()]) - A[low];
				sum += width * height;
			}
			stack.push(cur);
			++cur;
		}

		return sum;
	}
}
