import java.util.*;

/**
 * https://oj.leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. 
 * For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		Hashtable<Integer, Integer> two = new Hashtable<Integer, Integer>();
		for (int i = 0; i < num.length - 1; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			two = twoSum(num, 0 - num[i], i + 1);
			if (!two.isEmpty()) {
				for (Integer tmp : two.keySet()) {
					answer.add(Arrays.asList(num[i], tmp, two.get(tmp)));
				}
			}
		}
		return answer;
	}

	public Hashtable<Integer, Integer> twoSum(int[] numbers, int target,
			int start) {
		if (numbers.length == 0)
			return null;
		Hashtable<Integer, Integer> answer = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> table = new Hashtable<>();

		for (int i = start; i < numbers.length; i++) {
			table.put(numbers[i], i);
		}
		for (int i = start; i < numbers.length; i++) {
			int diff = target - numbers[i];
			// consider same numbers and number appeared before
			if (table.containsKey(diff) && table.get(diff) != i
					&& numbers[i] <= diff) {
				int loc[] = new int[2];
				loc[0] = i;
				loc[1] = table.get(diff);
				// if (!answer.containsKey(numbers[loc[0]]))
				answer.put(numbers[loc[0]], numbers[loc[1]]);
				// break;
			}
		}
		return answer;
	}

}
