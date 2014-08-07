/**
 * http://oj.leetcode.com/problems/word-break/ 
 * Given a string s and a dictionary 
 * of words dict, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {

	// records whether substring from start to end is breakable
	public byte BREAK[][];

	public boolean wordBreak(String s, Set<String> dict) {
		BREAK = new byte[s.length()][s.length()];
		if (s == null || dict.size() <= 0) {
			return false;
		}
		wordBreak(s, dict, 0, s.length() - 1);
		return (BREAK[0][s.length()-1] == 1);
	}

	/**
	 * recursively dp
	 * 
	 * @return whether breakable
	 */
	private boolean wordBreak(String str, Set<String> dict, int start, int end) {
		if (BREAK[start][end] == 1)
			return true;
		else if (BREAK[start][end] == -1)
			return false;

		String substring = str.substring(start, end + 1);
		// record the current sub string is directly breakable
		if (dict.contains(substring)) {
			BREAK[start][end] = 1;
			return true;
		}
		// if cannot be found from dictionary, using dp to find whether its sub
		// string is breakable
		for (int i = start + 1; i <= end; i++) {
			if (wordBreak(str, dict, start, i - 1)
					&& wordBreak(str, dict, i, end)) {
				BREAK[start][end] = 1;
				return true;
			}
		}
		BREAK[start][end] = -1;
		return false;
	}

}
