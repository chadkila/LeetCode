/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * ANS:
 * The array could always be divided into a sorted part and a rotated part (
 * or two sorted parts). And if middle>end determines that from middle to end
 * is rotated, and smallest element must be in there. Otherwise the smallest 
 * is in the other part. Run time is O(log(n)).
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int findMin(int[] num) {
		int start = 0, end = num.length - 1;
		while (start < end) {
			// get middle
			int mid = start + ((end - start) >> 1);
			if (num[mid] > num[end]) {
				// search in rotated part
				start = mid + 1;
			} else {
				// middle might be the smallest
				// don't use mid-1
				end = mid;
			}
		}
		// start equals end
		return num[start];
	}
}
