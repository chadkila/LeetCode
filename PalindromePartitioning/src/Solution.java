/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * When face the "return all", "get all ", "find all possible",
 * "find the total number of", an idea is to use the recursion(DFS). Same as this
 * problem!
 * 
 * To get the all the partitions of a string s: 
 * 1. find all the palindromes in substring s[0], and all the palindromes in substring s[1:end] 
 * 2. find all the palindromes in substring s[0:1], and all the palindromes in substring
 * s[2:end] ... find all the palindromes in substring s[1:end-1], and all the
 * palindromes in substring s[end]
 * 
 * So the problem is quite clear, when we do recursion, two things should be
 * considered: 1. stop condition: when the search goes to the last position in
 * the string 2. for loop or while loop: for position=current start position to
 * the end.
 */
import java.util.*;

/**
 * 
 * 
 * @author yu
 * 
 */
public class Solution {
	public List<List<String>> partition(String s) {
		ArrayList<List<String>> answer = new ArrayList<List<String>>();
		ArrayList<String> list = new ArrayList<String>();

		if (s.length() == 0 || s == null)
			return answer;

		DFS(answer, list, s);
		return answer;
	}

	// check whether is a palindrome
	private boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	// finding palindrome recursively
	private void DFS(ArrayList<List<String>> answer, ArrayList<String> list,
			String str) {
		if (str.length() == 0) {
			// adding a copy of list into result list
			// otherwise the data will be erased when recursed back up for
			// list.remove(list.size() - 1)
			List<String> tmp = new ArrayList<String>(list);
			answer.add(tmp);
		}
		// i must equals 1
		// i <= str.length() because of substring method takes one more digit
		for (int i = 1; i <= str.length(); i++) {
			String subStr = str.substring(0, i);
			if (isPalindrome(subStr)) {
				list.add(subStr);
				// the rest part of the array
				String restStr = str.substring(i);
				DFS(answer, list, restStr);
				// clear the list after recursed up to avoid dirty data
				list.remove(list.size() - 1);
			}
		}

	}
}
