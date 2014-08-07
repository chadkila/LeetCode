import java.util.*;

/**
 * http://oj.leetcode.com/problems/word-break-ii/
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */

/**
 * @author yu
 * 
 */
public class Solution {
	// records whether substring from start with length len is breakable
	public boolean BREAK[][];
	private ArrayList<String> LISTS;

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		BREAK = new boolean[s.length()][s.length() + 1];
		LISTS = new ArrayList<String>();
		if (s == null || dict.size() <= 0) {
			return LISTS;
		}
		int strLength = s.length();
		// shortest word length is 1
		for (int len = 1; len <= strLength; len++) {
			// traverse to length of string
			for (int i = 0; i < strLength - len + 1; i++) {
				String t = s.substring(i, i + len);
				if (dict.contains(t)) {
					BREAK[i][len] = true;
					continue;
				}
				// if current sub string cannot be found from dictionary
				for (int k = 1; k < len; k++) {
					if (BREAK[i][k] && BREAK[i + k][len - k]) {
						BREAK[i][len] = true;
						break;
					}
				}
			}
		}

		if (!BREAK[0][s.length()])
			return LISTS;
		dfsResult(s, dict, new StringBuffer(), 0);
		return LISTS;
	}

	private void dfsResult(String str, Set<String> dict, StringBuffer builder,
			int start) {
		// see if the whole sentence has been found
		if (start == str.length()) {
			LISTS.add(builder.toString().trim());
			return;
		}
		for (int len = 1; len <= str.length(); len++) {
			if (BREAK[start][len]) {
				String temp = str.substring(start, start + len);
				// only need the element could be found from dictionary
				if (!dict.contains(temp))
					continue;
				// marked to clean the string builder when popped out of
				// recursion stack
				int beforeAdd = builder.length();
				builder.append(temp).append(" ");

				dfsResult(str, dict, builder, start + len);
				// clear the list after recursed up to avoid dirty data
				builder.delete(beforeAdd, builder.length());
			}

		}
	}
}
