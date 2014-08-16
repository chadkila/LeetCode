/**
 * https://oj.leetcode.com/problems/regular-expression-matching/
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a") → false 
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false 
 * isMatch("aa", "a*") → true 
 * isMatch("aa", ".*") → true 
 * isMatch("ab", ".*") → true 
 * isMatch("aab", "c*a*b") → true
 * 
 * the solution is NOT the same with WildCard Matching
 * isMatch("aab", "c*a*b") → true means c*a*b could stand for ccaaab or aab or cccb
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		assert (p != null && (p.length() == 0 || p.charAt(0) != '*'));
		if (p.length() == 0)
			return s.length() == 0;
		// special case
		if (p.length() == 1) {
			if (p.equals(s) || (p.equals(".") && s.length() == 1)) {
				return true;
			} else {
				return false;
			}
		}
		if (p.charAt(1) != '*') {
			// there is no start after p, compare current character
			if (s.length() > 0
					&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
				// current is a match, move forward
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		} else {
			while (s.length() > 0
					&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
				// consider "aaaaa" "a*a*a"
				if (isMatch(s, p.substring(2)))
					return true;
				// characters after * is not a match, move s forward
				s = s.substring(1);
			}
			// it's not a match now
			return isMatch(s, p.substring(2));
		}
	}

}
