/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * ANS
 * Get strs[0] and compare others, the length of LCP is min(LCP, strs[i])
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		// initial length
		int len = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			int k;
			for (k = 0; k < Math.min(len, strs[i].length()); k++) {
				// break at unmet character
				if (strs[0].charAt(k) != strs[i].charAt(k))
					break;
			}
			// update length
			if (len > k)
				len = k;
		}
		// return LCP
		return strs[0].substring(0, len);
	}
}
