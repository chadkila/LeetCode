/**
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * e.g
 * (()() max = 4 
 * ()(() max = 2
 * using stack to store indexes
 * for '(', put index into stack
 * for ')', 
 * if current stack is empty, renew start pointer
 * if not empty, stack pop, 
 * if stack is not empty after pop len=index-start+1, 
 * else len=index-stack.peek
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public int longestValidParentheses(String s) {
		int start = 0;
		int maxLen = -1;
		Stack<Integer> stack = new Stack<Integer>();
		if (s.isEmpty() || s.length() == 0)
			return 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				// consider "())()" the second ')'
				if (stack.isEmpty()) {
					start = i + 1;
				} else {
					stack.pop();
					maxLen = Math.max(maxLen, stack.isEmpty() ? i - start + 1
							: i - stack.peek());
				}
			}
		}
		return maxLen;
	}
}
