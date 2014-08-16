/**
 * https://oj.leetcode.com/problems/4sum/
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * It's a advanced version of 2Sum
 * Divide quadruplet into 2 parts, then solve it as 2Sum. And make sure that 
 * each part has no common element of the other.
 */

import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = num.length;
		// use hashmap to store sum and its pairs
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				// add new pairs into existed
				if (map.containsKey(num[i] + num[j])) {
					map.get(num[i] + num[j]).add(new Pair(i, j));
				} else {
					// new pairs
					ArrayList<Pair> pairs = new ArrayList<Pair>();
					pairs.add(new Pair(i, j));
					map.put(num[i] + num[j], pairs);
				}
			}
		}
		// Use HashSet to prevent duplicate result.
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for (int tmp : map.keySet()) {
			if (map.containsKey(target - tmp)) {
				// exclude mapping to itself
				if (tmp == target - tmp && map.get(tmp).size() == 1)
					continue;
				ArrayList<Pair> pairs1 = map.get(target - tmp);
				ArrayList<Pair> pairs2 = map.get(tmp);
				for (Pair p1 : pairs1) {
					for (Pair p2 : pairs2) {
						// the two pairs have no same indexes
						if (p1.crosses(p2))
							continue;
						ArrayList<Integer> quadruplet = new ArrayList<Integer>(
								4);
						quadruplet.add(num[p1.first]);
						quadruplet.add(num[p1.second]);
						quadruplet.add(num[p2.first]);
						quadruplet.add(num[p2.second]);
						Collections.sort(quadruplet);
						set.add(quadruplet);
					}
				}
			}

		}
		ans.addAll(set);
		return ans;
	}
}

class Pair {
	int first;
	int second;

	public Pair(int i, int j) {
		this.first = i;
		this.second = j;
	}

	// whether they have same elements
	public boolean crosses(Pair p) {
		return (p.first == this.first || p.second == this.first
				|| p.first == this.second || p.second == this.second);
	}
}
