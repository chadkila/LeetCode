/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3},
 * 
 *       1 
 *        \ 
 *         2 
 *        / 
 *       3
 * 
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * ANS:
 * It's simpler than 'Binary Tree Postorder Traversal'.
 * Rather than using a system stack, we can use a stack class to simulate what
 * happens in memory. 
 * While stack is not empty or there is unvisited node
 * 1. Visit current node first,
 *    iteratively push current node into stack, then traverse to its left child,
 *    Until it is null
 * 2. Pop the top of stack and traverse to its right child,
 *    Repeat to step 1
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return ans;
		// current tree node in stack
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				// visit current node firstly
				ans.add(cur.val);
				stack.add(cur);
				// go to left node first
				cur = cur.left;
			}
			// traverse to last visited's right and repeat last step
			cur = stack.pop();
			cur = cur.right;
		}
		return ans;
	}
}
