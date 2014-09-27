/**
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * ANS
 * To write a string array of letter combinations first. Then map the current
 * digit to corresponding combination and DFS to the last digit.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<String>();
		// char array for constructing result string
		char tmpstr[] = new char[digits.length()];
		// combination map
		String map[] = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		DFS(digits, 0, tmpstr, ans, map);
		return ans;
	}

	private void DFS(String digits, int index, char tmpstr[], List ans,
			String map[]) {
		// reach the end of digits
		if (index == digits.length()) {
			ans.add(new String(tmpstr));
			return;
		}
		// change the current char and DFS
		for (int i = 0; i < map[digits.charAt(index) - '0'].length(); i++) {
			tmpstr[index] = map[digits.charAt(index) - '0'].charAt(i);
			DFS(digits, index + 1, tmpstr, ans, map);
		}
	}
}
