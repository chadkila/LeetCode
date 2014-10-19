/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, 
 * return [3, 4].
 * 
 * ANS
 * Finding lower bound and upper bound by binary searching.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int[] searchRange(int[] A, int target) {
		int ans[] = { -1, -1 };
		int start = 0;
		int end = A.length - 1;
		// find lower bound
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (A[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		if (A[start] != target)
			return ans;
		ans[0] = start;
		// set end to one position beyond end
		end = A.length;
		// find upper bound
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (A[mid] > target)
				end = mid;
			else
				start = mid + 1;
		}
		ans[1] = end - 1;
		return ans;
	}
}
