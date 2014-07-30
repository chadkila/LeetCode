/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * ref:
 * http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
 * http://www.lifeincode.net/programming/leetcode-median-of-two-sorted-arrays-java/
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length, lenB = B.length;
		int len = lenA + lenB;
		if (len % 2 == 0) {
			// length is even
			return (findKth(A, 0, lenA, B, 0, lenB, len / 2) + findKth(A, 0,
					lenA, B, 0, lenB, len / 2 + 1)) / 2.0;
		} else {
			// length is odd
			return findKth(A, 0, lenA, B, 0, lenB, len / 2 + 1);
		}
	}

	public int findKth(int A[], int AStart, int AEnd, int B[], int BStart,
			int BEnd, int k) {
		int A_i = AEnd - AStart;
		int B_i = BEnd - BStart;
		// array A is empty
		// or the range of A has been narrowed to 0 because K is always bigger
		// or smaller than median of A
		if (A_i <= 0)
			return B[BStart + k - 1];
		// array B is empty
		// or the range of B has been narrowed to 0 because K is always bigger
		// or smaller than median of B
		if (B_i <= 0)
			return A[AStart + k - 1];
		// only one element to compare, the smallest is the 1st element
		if (k == 1)
			return A[AStart] < B[BStart] ? A[AStart] : B[BStart];

		// get current median
		int midA = (AStart + AEnd) / 2;
		int midB = (BStart + BEnd) / 2;

		if (A[midA] > B[midB]) {
			// midA is greater than midB
			if (A_i / 2 + B_i / 2 + 1 >= k)
				// k is smaller than or equal current median
				// so values greater than midA will be neglected
				return findKth(A, AStart, midA, B, BStart, BEnd, k);
			else
				// k is bigger than current median
				// so values smaller than or equal midB will be neglected
				// first half (B_i/2+1) elements are neglected so k will
				// Subtract them
				return findKth(A, AStart, AEnd, B, midB + 1, BEnd, k
						- (B_i / 2 + 1));
		} else {
			if (A_i / 2 + B_i / 2 + 1 >= k)
				// k is smaller than or equal current median
				// so values greater than midB will be neglected
				return findKth(A, AStart, AEnd, B, BStart, midB, k);
			else
				// k is bigger than current median
				// so values smaller than or equal midA will be neglected
				// first half (A_i/2+1) elements are neglected so k will
				// Subtract them
				return findKth(A, midA + 1, AEnd, B, BStart, BEnd, k
						- (A_i / 2 + 1));
		}

	}
}
