/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * ANS:
 * Similar with the previous question, when A[start] and A[mid] are the
 * same, just skip start index to next one.
 * e.g.
 * [1,3,1,1,1], start index will be skipped from 0(1) to 1(3).
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			// meets target
			if (A[mid] == target)
				return true;
			// right half is rotated
			if (A[mid] > A[start]) {
				// whether target is in not rotated left part
				if (A[start] <= target && target < A[mid])
					end = mid - 1;
				else
					// search rotated right half
					start = mid + 1;
			}
			// left half is rotated
			else if (A[start] > A[mid]) {
				// whether target is in not rotated right part
				if (A[mid] < target && target <= A[end])
					start = mid + 1;
				else
					// search rotated left half
					end = mid - 1;
			}
			// duplicate numbers
			else
				// skip duplicates
				start++;
		}
		// not found
		return false;
	}
}
