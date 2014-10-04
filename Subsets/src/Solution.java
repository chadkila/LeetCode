/**
 * https://oj.leetcode.com/problems/subsets/
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets.
 * 
 * For example, If S = [1,2,3], a solution is:
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * ANS
 * This a typical DFS problem, that every branch is that whether choose current
 * element
 * list.add(); DFS();
 * list.remove();DFS();
 * 
 * Instead of using traditional recursive solution, we can iteratively adding 
 * elements into list.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = S.length;
		// non-descending order
		Arrays.sort(S);
		// add a empty subset
		ans.add(new ArrayList<Integer>());
		// the length of S layers
		for (int i = 0; i < len; i++) {
			int ansSize = ans.size();
			for (int j = 0; j < ansSize; j++) {
				// adding new element into existed list elements
				List<Integer> newItem = new ArrayList<Integer>(ans.get(j));
				newItem.add(S[i]);
				// adding new elements
				ans.add(newItem);
			}
		}
		return ans;
	}
}
