/**
 * https://oj.leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * Each element in the array represents your maximum jump length at that
 * position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * ANS
 * Using greedy method, every time get the maximum jump length
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int jump(int[] A) {
		int m = 0;
		int len = A.length;
		int count = 0;
		int i = 0;
		if (len == 1)
			return count;
		while (i < len) {
			m = Math.max(m, A[i] + i);
			if (m > 0)
				count++;
			if (m >= len - 1)
				return count;
			int tmp = 0;
			// find the longest next jump, A[m]+m might not be the longest
			for (int j = i + 1; j <= m; j++) {
				if (j + A[j] > tmp) {
					tmp = j + A[j];
					// go to that longest jump
					i = j;
				}
			}
		}
		return count;
	}
}
