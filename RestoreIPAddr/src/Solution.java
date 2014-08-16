/**
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * A little bit familiar with word break?
 * This is as simple as a DFS problem. The string would be divided into 4 parts,
 * each part may have length of 1, 2 or 3, and a function will decide whether it's
 * valid.
 * 
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return ans;
		DFS(s, "", 0, ans);
		return ans;
	}

	private void DFS(String s, String tmp, int layer, List<String> ans) {
		if (layer == 3 && isValid(s)) {
			ans.add(tmp + s);
			return;
		}
		for (int i = 1; i < 4 && i < s.length(); i++) {
			String sub = s.substring(0, i);
			if (isValid(sub)) {
				DFS(s.substring(i), tmp + sub + ".", layer + 1, ans);
			}
		}
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num > 0 && num <= 255;
	}
}
