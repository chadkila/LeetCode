/**
 * https://oj.leetcode.com/problems/permutation-sequence/
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" 
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * It's a math problem.
 * e.g 1,2,3,4 and k=8
 * if the first digit (choose 1 for exmp) has already been chosen, left [234]
 * could have 3!=6 combinations. And for each chosen first digit, there will 
 * be 6 possible combinations following it, so 4! combinations are divided 
 * into 4 groups and each group has 6 combinations. 
 * In the same way, if the second digit has been chosen, there are 2!=2 
 * combinations following it, and 1!=1 combinations for the third digit.
 * So the problem is iteratively finding the current digit is in which group.
 * 
 * n=4 so nums=[1,2,3,4], and k=8 (k=7 for index starts from 0)
 * (4-1)!=6, 7/6=1, so the first digit is in 2nd group (first is 0), [2134 .. 2431]
 * so first digit is nums[1]=2
 * 
 * 7%6=1, to find 2nd permutation among [2134 .. 2431], nums=[1,3,4]
 * (3-1)!=2, 1/2=0, so the 2nd digit is in 1st group [2134, 2143]
 * so 2nd digit is nums[0]=1
 * 
 * 1%2=1, to find 3rd permutation among [2134, 2143], nums=[3,4]
 * (2-1)!=1, 1/1=1, so the 3rd digit is in 2nd group [2143]
 * so 3rd digit is nums[1]=4
 * 
 * ..
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public String getPermutation(int n, int k) {
		// list contains 1 to n
		List<Integer> nums = new ArrayList<>();
		// how many combinations remaining
		int comb = 1;
		// fill up the list
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			comb *= i;
		}
		// combinations of n-1 digits
		comb /= n;
		// list index starts from 0 not 1
		k--;
		StringBuilder strBdr = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			// current digit in which group
			int currIdx = k / comb;
			strBdr.append(nums.get(currIdx));
			// remove used number from list
			nums.remove(currIdx);
			// n-i-1 cannot be 0
			if (i == n - 1)
				break;
			// for the rest of groups
			k %= comb;
			// reduce one digit
			comb /= (n - i - 1);
		}
		return strBdr.toString();
	}
}
