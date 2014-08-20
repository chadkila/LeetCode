import java.util.*;

/**
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * 
 * using hash table to find whether the words appear exactly once
 * scan from left to right
 * but notice in L there may be duplicate words
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> answer = new ArrayList<Integer>();
		int num = L.length;
		int len = L[0].length();
		if (num == 0 || S.length() == 0)
			return answer;
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		// initialize the dictionary hash table
		for (int i = 0; i < L.length; i++)
			dict.put(L[i], (dict.containsKey(L[i]) ? dict.get(L[i]) : 0) + 1);
		// scan the sting in a fixed window length
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; (i + num * len - 1) < S.length(); i++) {
			map.clear();

			for (int j = 0; j < num; j++) {
				String sub = S.substring(i + j * len, i + (j + 1) * len);
				if (!dict.containsKey(sub)) {
					break;
				} else {
					map.put(sub, (map.containsKey(sub) ? map.get(sub) : 0) + 1);
					// it may has same strings in list L, so only compare the
					// time it appears
					if (map.get(sub) > dict.get(sub))
						break;
					if (j == num - 1)
						answer.add(i);
				}
			}
		}
		return answer;
	}
}
