import java.util.*;

/**https://oj.leetcode.com/problems/combinations/
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		subsets(n, k, 0, subset, result);
		return result;
	}

	private void subsets(int n, int k, int begin, ArrayList<Integer> subset,
			ArrayList<List<Integer>> result) {
		if (subset.size() >= k) {
			ArrayList<Integer> c = new ArrayList<Integer>(subset);
			result.add(c);
		} else {
			for (int i = begin; i < n; i++) {
				subset.add(i + 1);
				subsets(n, k, i + 1, subset, result);
				subset.remove(subset.size() - 1);
			}
		}
	}
}
