/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * ANS:
 * Scan the array and count number of duplicates, and place unique numbers to the 
 * right place.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int removeDuplicates(int[] A) {
		// duplicate number counter
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			// meets duplicate
			if (A[i] == A[i - 1])
				count++;
			else if (count > 0)
				// if it's not duplicate move it to right place
				A[i - count] = A[i];
		}
		return A.length - count;
	}
}
