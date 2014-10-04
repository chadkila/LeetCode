/**
 * https://oj.leetcode.com/problems/subsets-ii/
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets.
 * 
 * For example, If S = [1,2,2], a solution is:
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * ANS
 * Like 'Subsets', just adding to check whether current element is the same with
 * last element. If yes, only edit half of existing elements, which have already 
 * been added that same number. 
 * e.g.
 * [][1] add 2
 * [][1][2][1,2] add 2
 * [][1][2][1,2] [2,2][1,2,2]
 * only [2][1,2] need to be modified after detecting same number 2 
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = num.length;
		// non-descending order
		Arrays.sort(num);
		// add a empty subset
		ans.add(new ArrayList<Integer>());
		int last = num[0], lastSize = 1;
		for (int i = 0; i < len; i++) {
			// if meet different number with last time
			if (last != num[i]) {
				// update last number
				last = num[i];
				lastSize = ans.size();
			}
			// if meet same number, the last size was kept
			int ansSize = ans.size();
			// starts from last size
			for (int j = ansSize - lastSize; j < ansSize; j++) {
				// adding new element into existed list elements
				List<Integer> newItem = new ArrayList<Integer>(ans.get(j));
				newItem.add(num[i]);
				// adding new elements
				ans.add(newItem);
			}
		}
		return ans;
	}
}
