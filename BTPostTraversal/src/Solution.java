/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 *       1 
 *        \ 
 *         2 
 *        / 
 *       3
 * 
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * ANS:
 * Recursive solution is too easy, and this question requires iterative solution.
 * Rather than using a system stack, we can use a stack class to simulate what
 * happens in memory. 
 * While stack is not empty or there is unvisited node
 * 1. Iteratively push current node and its left child into stack.
 *    Until current node is null.
 * 2. If 
 *       the top of stack node's right has not been visited and it has right child
 *            set current as its right child and continue from step 1
 *    Else
 *       there is no right child of stack top or its right child has been visited
 *            set it as visited and pop it from stack
 *            continue from step 2
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return ans;
		TreeNode lastVisit = null;
		// current tree node in stack
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// put all current and left child node into stack
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// not pop() because don't know to visit it or not yet
			cur = stack.peek();
			// if that node has no right child or its right child has been
			// visited before
			if (cur.right == null || lastVisit == cur.right) {
				ans.add(cur.val);
				// visited root node, pop out from stack
				stack.pop();
				// set as last visited node
				lastVisit = cur;
				// no current node in stack
				cur = null;
			} else {
				// right sub tree hasn't been visited
				cur = cur.right;
			}
		}
		return ans;
	}
}
