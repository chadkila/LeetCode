/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * ANS:
 * Like previous question, just need to skip the duplicated element. The worst case
 * will be O(n).
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int findMin(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (num[mid] > num[end]) {
				// search in rotated part
				start = mid + 1;
			} else if (num[mid] < num[end]) {
				// middle might be the smallest
				end = mid;
			} else {
				// skip the duplicated, and start index will be updated in next
				// loop
				end--;
			}
		}
		return num[start];
	}
}
