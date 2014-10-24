/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * ANS:
 * Using A[mid]>A[left] to determine whether there is rotated part within 
 * left to middle. 
 * Then find out target is within rotated part or not rotated part.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			// meets target
			if (A[mid] == target)
				return mid;
			// right half is rotated
			if (A[mid] >= A[start]) {
				// whether target is in not rotated left part
				if (A[start] <= target && target < A[mid])
					end = mid - 1;
				else
					// search rotated right half
					start = mid + 1;
			}
			// left half is rotated
			else {
				// whether target is in not rotated right part
				if (A[mid] < target && target <= A[end])
					start = mid + 1;
				else
					// search rotated left half
					end = mid - 1;
			}
		}
		// not found
		return -1;
	}
}
