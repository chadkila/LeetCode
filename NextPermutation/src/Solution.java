/**
 * https://oj.leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 
 * 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3 
 * 1,1,5 → 1,5,1
 * 
 * ANS
 * Because it doesn't allow extra space, cannot calculate all the sequences
 * then finds next (https://oj.leetcode.com/problems/permutation-sequence/)
 * So,
 * 1) from end to beginning find the first ascending order pair index i
 * 2) from end to i+1 find the first number larger than num[i] index j
 * 3) swap num[i] and num[j], this time num[i+1..j] is in descending order
 * 4) reverse num[i+1..j], let num[i+1..j] in ascending order
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public void nextPermutation(int[] num) {
		int len = num.length;
		for (int i = len - 2; i >= 0; i--) {
			// step 1 find an ascending pair
			if (num[i] < num[i + 1]) {
				// step 2 find first element larger than num[i]
				for (int j = len - 1; j > i; j--) {
					if (num[j] > num[i]) {
						// step 3
						swap(num, i, j);
						break;
					}
				}
				// step 4 reverse them to ascending order
				reverse(num, i + 1);
				return;
			}
		}
		reverse(num, 0);
	}

	// a fast swap method without allocating extra space
	private void swap(int num[], int i, int j) {
		num[i] = num[i] ^ num[j];
		num[j] = num[i] ^ num[j];
		num[i] = num[i] ^ num[j];
	}

	// reverse the sublist from start index to end of array
	private void reverse(int num[], int start) {
		for (int i = start, j = num.length - 1; i < start + (num.length - start)
				/ 2; i++, j--) {
			swap(num, i, j);
		}
	}
}
