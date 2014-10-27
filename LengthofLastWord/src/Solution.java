/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * ANS:
 * Get the last index of string, skip spaces and get length.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int lengthOfLastWord(String s) {
		int idx = s.length() - 1;
		// skip spaces
		// index could be negative if string is empty
		while (idx >= 0 && s.charAt(idx) == ' ')
			idx--;
		int len = 0;
		for (; idx >= 0 && s.charAt(idx) != ' '; idx--, len++)
			;
		return len;
	}
}