/**
 * https://oj.leetcode.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 
 * 11 is read off as "two 1s" or 21. 
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * ANS
 * The idea is simple, compare the current char in the string with the previous
 * one, if they are the same, count +1, if not, print the previous char (count +
 * char), set the new char and count, until the string ends.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String countAndSay(int n) {
		// initial string
		String cur = "1";
		for (int i = 1; i < n; i++) {
			cur = count(cur);
		}
		return cur;
	}

	private String count(String str) {
		StringBuilder tmp = new StringBuilder();
		char pre = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == pre)
				// meet same more numbers
				count++;
			else {
				// construct by how many last digit
				tmp = tmp.append(count).append(pre);
				// move forward
				pre = cur;
				count = 1;
			}
		}
		// don't forget last round
		tmp.append(count).append(pre);
		return tmp.toString();
	}
}
