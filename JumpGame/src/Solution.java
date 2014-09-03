/**
 * https://oj.leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * Each element in the array represents your maximum jump length at that
 * position.
 * Determine if you are able to reach the last index.
 * For example: 
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * ANS
 * A dynamic programming problem, use an integer m to store maximum value of 
 * idx+A[idx], it it could be bigger than array's length then it's valid.
 * and idx should be smaller than m.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean canJump(int[] A) {
		int len = A.length;
		// maximum jump index
		int m = 0;
		for (int i = 0; i < len; i++) {
			// i cannot jump further than A[i]+i
			if (i <= m) {
				m = Math.max(m, A[i] + i);
				if (m >= len - 1)
					return true;
			}
		}
		return false;
	}
}
