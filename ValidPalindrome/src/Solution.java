/**
 * https://oj.leetcode.com/problems/valid-palindrome/
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * ANS
 * Using left and right pointers to find out whether the characters are the same
 * and avoid invalid characters
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.isEmpty())
			return true;
		// normalize to lower case
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			// avoid invalid characters from left
			while (left < right && !isValid(s.charAt(left)))
				left++;
			// avoid invalid characters from right
			while (left < right && !isValid(s.charAt(right)))
				right--;
			// unmatched character, return false
			if (s.charAt(left) != s.charAt(right))
				return false;
			// moving pointer forward
			left++;
			right--;
		}
		return true;
	}

	private boolean isValid(char c) {
		if (c >= 'a' && c <= 'z')
			return true;
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}
}
