/**
 * https://oj.leetcode.com/problems/wildcard-matching/
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0;
		int smark = -1, pstar = -1;
		while (i < s.length()) {
			// exactly matches the same character
			if (j < p.length()
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			}
			// star appears, moves pointer of p to next character
			else if (j < p.length() && p.charAt(j) == '*') {
				smark = i;
				pstar = j;
				j++;
			} 
			// meets an unmatched character, finds whether can be fitted by star
			else if (pstar != -1) {
				i = smark + 1;
				smark++;
				// back to the star coz star stands for any lenght's characters
				j = pstar + 1;
			} else {
				return false;
			}
		}
		// for ("", "*")
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		System.out.println(i + "," + j);
		return j == p.length();
	}
}
