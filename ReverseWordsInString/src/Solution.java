/**
 * http://oj.leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public Solution() {

	}

	public String reverseWords(String s) {
		StringBuilder revString = new StringBuilder();
		if (s.isEmpty() || s.length() == 0)
			return revString.toString();
		int end = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' || i == 0) {
				if (i != 0) {
					if (isSpace(s.substring(i + 1, end)))
						continue;
					revString.append(s.substring(i + 1, end).trim())
							.append(" ");
				} else {
					if (isSpace(s.substring(i, end)))
						continue;
					revString.append(s.substring(i, end).trim());
				}
				end = i;
			}
		}
		return revString.toString().trim();
	}

	private boolean isSpace(String str) {
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				flag = false;
		}
		return flag;
	}
}
