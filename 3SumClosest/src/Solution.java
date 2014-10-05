/**
 * https://oj.leetcode.com/problems/3sum-closest/
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * ANS
 * Like '3Sum' problem, this problem can be reduced to 2 sum problem. But it is a 
 * 2 sum closest problem, so hash table is not appropriate here. There is a general
 * way is that, sort the array first and then look up from head and tail. If current
 * sum is greater than target then move tail to smaller elements and vice versa.
 */
import java.util.Arrays;

/**
 * @author yu
 * 
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int ans = 0;
		// distance between current result and target
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			// target for two sum
			int newTarget = target - num[i];
			// the closest two sum result
			// search from i+1 to end to avoid duplicate computing
			int two = twoSumClosest(num, newTarget, i + 1);
			// smaller distance, better result
			if (dis > Math.abs(two + num[i] - target)) {
				ans = two + num[i];
				dis = Math.abs(two + num[i] - target);
				if (ans == target)
					return ans;
			}
		}
		return ans;
	}

	private int twoSumClosest(int[] num, int target, int startIdx) {
		int start = startIdx, end = num.length - 1;
		int ans = 0;
		// distance
		int dis = Integer.MAX_VALUE;
		while (start < end) {
			// current result
			int tmp = num[start] + num[end];
			if (tmp < target) {
				// smaller distance
				if (target - tmp < dis) {
					// update result
					ans = tmp;
					dis = target - tmp;
				}
				// need bigger values
				start++;
			} else if (tmp > target) {
				if (tmp - target < dis) {
					ans = tmp;
					dis = tmp - target;
				}
				// need smaller values
				end--;
			} else {
				// result is same with target
				return tmp;
			}
		}
		return ans;
	}
}
