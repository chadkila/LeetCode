/**
 * https://oj.leetcode.com/problems/permutations/
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * ANS
 * The idea of this classic problem is still DFS. Use list.contains() function
 * to judge whether the number has appeared before.
 * This function only works for collections of unique numbers, if there is
 * duplicate element see Permutations II's slightly modified algorithm.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		DFS(num, tmp, ans);
		return ans;
	}

	private void DFS(int num[], List<Integer> tmp, List<List<Integer>> ans) {
		if (tmp.size() == num.length) {
			ans.add(new ArrayList<Integer>(tmp));
			return;
		} else {
			// for DFS
			for (int i = 0; i < num.length; i++) {
				if (tmp.contains(num[i])) {
					// skip used element
					continue;
				} else {
					tmp.add(num[i]);
					DFS(num, tmp, ans);
					tmp.remove(tmp.size() - 1);
				}
			}
		}
	}
}
