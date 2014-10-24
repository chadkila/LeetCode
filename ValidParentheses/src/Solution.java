/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * ANS:
 * Very classic application of using stack. When meets ')','}'or']' pop up stack
 * and see whether it meets that bracket. And then return whether stack is empty.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{') {
				stack.push(cur);
			} else {
				if (stack.size() == 0)
					return false;
				char top = stack.pop();
				if (cur == ')')
					if (top != '(')
						return false;
				if (cur == '}')
					if (top != '{')
						return false;
				if (cur == ']')
					if (top != '[')
						return false;
			}
		}
		return stack.size() == 0;
	}
}
