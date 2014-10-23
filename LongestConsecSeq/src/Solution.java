/**
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * ANS:
 * Because it is required to run in O(n), sorting is not a good option for this.
 * So using hash set is better. Put every integer into hash set first, when find 
 * if there is an element in set, search whether larger or smaller element in the 
 * set.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public int longestConsecutive(int[] num) {
		int len = num.length;
		// maximum length
		int maxLen = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		if (num == null || num.length == 0)
			return 0;
		// initialize the hash set
		for (int i = 0; i < len; i++) {
			set.add(num[i]);
		}
		while (!set.isEmpty()) {
			Iterator<Integer> iter = set.iterator();
			int cur = iter.next();
			// remove searched item
			set.remove(cur);
			// temporary length
			int tmpLen = 1;
			// search smaller integers
			int pre = cur - 1;
			// if smaller integer exists
			while (set.contains(pre)) {
				set.remove(pre--);
				tmpLen++;
			}
			// search bigger integers
			int suc = cur + 1;
			// if bigger integer exists
			while (set.contains(suc)) {
				set.remove(suc++);
				tmpLen++;
			}
			if (tmpLen > maxLen)
				maxLen = tmpLen;
		}
		return maxLen;
	}
}
