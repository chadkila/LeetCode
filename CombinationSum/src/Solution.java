/**
 * https://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note: 
 * All numbers (including target) will be positive integers. 
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
 * (ie, a1 ≤ a2 ≤ … ≤ ak). 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: [7] [2, 2, 3]
 * 
 * ANS
 * It's a DFS recursive solution, pick a number and subtract it from target,
 * then recursively find whether it could be reduced to 0
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return ans;
		// sort list first
		Arrays.sort(candidates);
		DFS(candidates, target, 0, new ArrayList<Integer>(), ans);
		return ans;
	}

	private void DFS(int[] candidates, int target, int start,
			ArrayList<Integer> cur, List<List<Integer>> ans) {
		if (target < 0)
			return;
		// find a good result, add to answer list
		if (target == 0) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			// no need to run duplicate element
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			// no need to continue loop if current element is too large
			if (candidates[i] > target)
				break;
			cur.add(candidates[i]);
			// DFS
			DFS(candidates, target - candidates[i], i, cur, ans);
			// remove added element after popping back
			cur.remove(cur.size() - 1);
		}
	}
}
