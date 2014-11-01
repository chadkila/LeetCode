/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * ANS:
 * In the previous question, the i-1th element is impossible to be overwritten,
 * so compare A[i-1] and A[i] works. But in this question, i-2th element may be
 * overwritten, so it is not appropriate to compare A[i-2] and A[i]. Compare 
 * A[i-count-2] and A[i] will avoid the overwritten element.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int removeDuplicates(int[] A) {
		int count = 0;
		for (int i = 2; i < A.length; i++) {
			// meets duplicate
			if (A[i] == A[i - count - 1] && A[i] == A[i - count - 2])
				count++;
			else if (count > 0)
				A[i - count] = A[i];
		}
		return A.length - count;
	}
}
