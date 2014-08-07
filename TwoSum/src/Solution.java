import java.util.*;

/**
 * https://oj.leetcode.com/problems/two-sum/
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	/*
	 * use hash table to store all numbers and their indexes then search whether
	 * the difference is in table too
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length == 0)
			return null;
		int answer[] = new int[] { 0, 0 };
		Hashtable<Integer, Integer> table = new Hashtable<>();
		for (int i = 0; i < numbers.length; i++) {
			table.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int diff = target - numbers[i];
			// consider same numbers
			if (table.containsKey(diff) && table.get(diff) != i) {
				answer[0] = i + 1;
				answer[1] = table.get(diff) + 1;
				break;
			}
		}
		return answer;
	}
}
