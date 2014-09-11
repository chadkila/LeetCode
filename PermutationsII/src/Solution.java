/**
 * https://oj.leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * ANS
 * This is modified from Permutation(https://oj.leetcode.com/problems/permutations/), 
 * in this question, cannot use list.contains() anymore, instead, use an
 * array that records each element whether has been visited.
 * And the array should be sorted first for arranging same elements together.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean visited[] = new boolean[num.length];
		Arrays.sort(num);
		DFS(num, tmp, ans, visited);
		return ans;
	}

	private void DFS(int num[], List<Integer> tmp, List<List<Integer>> ans,
			boolean visited[]) {
		if (tmp.size() == num.length) {
			ans.add(new ArrayList<Integer>(tmp));
			return;
		} else {
			// for DFS
			for (int i = 0; i < num.length; i++) {
				// visited[i-1] should be checked or it will skip not used
				// elements
				if (visited[i] == true
						|| (i > 0 && num[i - 1] == num[i] && visited[i - 1] == false)) {
					// skip used element
					continue;
				} else {
					tmp.add(num[i]);
					visited[i] = true;
					DFS(num, tmp, ans, visited);
					tmp.remove(tmp.size() - 1);
					visited[i] = false;
				}
			}
		}
	}
}
