/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * undergraduate level stack problem
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		String op = "+-*/";
		for (int i = 0; i < tokens.length; i++) {
			if (!op.contains(tokens[i])) {
				// current token is not an operator
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				if (stack.size() < 2)
					return -1;
				int i1 = stack.pop();
				int i2 = stack.pop();
				int opr = op.indexOf(tokens[i]);
				// which operator
				if (opr == 0)
					stack.push(i2 + i1);
				if (opr == 1)
					stack.push(i2 - i1);
				if (opr == 2)
					stack.push(i2 * i1);
				if (opr == 3)
					stack.push(i2 / i1);
			}
		}
		return stack.pop();
	}
}
