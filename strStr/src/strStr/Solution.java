/**
 * https://oj.leetcode.com/problems/implement-strstr/
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * Don't want to wrtie a naive algorithm, use rolling hash that is little bit like 
 * Robin-Karth method
 * http://en.wikipedia.org/wiki/Rolling_hash
 * abacd=1+2*29+1*29^2+3*29^3+4*29^4 -> h by using prime number 29
 * bacde=h/29+5*29^4
 * 
 */
package strStr;

/**
 * @author yu
 * 
 */
public class Solution {
	public String strStr(String haystack, String needle) {
		// consider null before using length()
		if (haystack == null || needle == null)
			return null;
		int hayLen = haystack.length();
		int neeLen = needle.length();
		// string is empty
		if (neeLen == hayLen && neeLen == 0)
			return "";
		if (neeLen == 0)
			return haystack;
		if (hayLen < neeLen)
			return null;
		// prime number
		int prime = 29;
		// hash for needle
		long neeHash = 0;
		// multiplier
		long multplr = 1;
		// get hash for needle
		for (int i = 0; i < neeLen; i++) {
			neeHash += (long) needle.charAt(i) * multplr;
			multplr *= prime;
		}
		// System.out.println(neeHash);
		long hayHash = 0;
		multplr = 1;
		for (int i = 0; i < neeLen; i++) {
			hayHash += (long) haystack.charAt(i) * multplr;
			multplr *= prime;
		}
		// System.out.println(hayHash);
		// if needle could meet at head of haystack
		if (neeHash == hayHash)
			return haystack;
		multplr /= prime;
		// System.out.println(multplr);
		for (int i = neeLen; i < hayLen; i++) {
			hayHash = (hayHash - (long) haystack.charAt(i - neeLen)) / prime
					+ (long) haystack.charAt(i) * multplr;
			if (hayHash == neeHash)
				return haystack.substring(i - neeLen + 1);
		}
		return null;
	}
}
