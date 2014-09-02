/**
 * https://oj.leetcode.com/problems/combination-sum-ii/
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note: 
 * All numbers (including target) will be positive integers. 
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
 * (ie, a1 ≤ a2 ≤ … ≤ ak). 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * ANS
 * Very similar with Combination Sum, change a little of previous solution.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return ans;
		// sort list first
		Arrays.sort(num);
		DFS(num, target, 0, new ArrayList<Integer>(), ans);
		return ans;
	}

	private void DFS(int[] num, int target, int start, ArrayList<Integer> cur,
			List<List<Integer>> ans) {
		if (target < 0)
			return;
		// find a good result, add to answer list
		if (target == 0) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < num.length; i++) {
			// avoid adding same element
			if (i > start && num[i] == num[i - 1])
				continue;
			// no need to continue loop if current element is too large
			if (num[i] > target)
				break;
			cur.add(num[i]);
			// DFS
			DFS(num, target - num[i], i + 1, cur, ans);
			// remove added element after popping back
			cur.remove(cur.size() - 1);
		}
	}
}
