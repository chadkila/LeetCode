/**
 * https://oj.leetcode.com/problems/simplify-path/
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases: 
 * Did you consider the case where path = "/../"? In this case, you should return "/". 
 * Another corner case is the path might contain multiple slashes '/' together, 
 * such as "/home//foo/". In this case, you should ignore redundant slashes and return 
 * "/home/foo".
 * 
 * use stack to store the path
 * if '/' skip to next
 * if '.' skip to next
 * if '..' pop the stack
 * others push into stack
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		int i = 0;
		while (i < path.length()) {
			// skip beginning '/////'
			while (i < path.length() && path.charAt(i) == '/')
				i++;
			if (i == path.length())
				break;
			// get path between '/'
			int start = i;
			while (i < path.length() && path.charAt(i) != '/')
				i++;
			int end = i;
			String tmp = path.substring(start, end);
			// System.out.println(tmp);
			if (tmp.equals("..")) {
				if (stack.size() > 0)
					stack.pop();
			} else if (!tmp.equals(".")) {
				stack.push(tmp);
			}
		}
		if (stack.size() == 0)
			return "/";
		String simPath = "";
		for (int j = 0; j < stack.size(); j++) {
			if (stack.elementAt(j).length() > 0)
				simPath += ("/" + stack.elementAt(j));
		}
		return simPath;
	}
}
