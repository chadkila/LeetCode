/**
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * Given a binary tree, return the inorder traversal of its nodes' values. For
 * example: Given binary tree {1,#,2,3},
 * 
 *       1 
 *        \ 
 *         2 
 *        / 
 *       3
 * 
 * return [1,3,2]. 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * ANS:
 * It's simpler than 'Binary Tree Postorder Traversal'.
 * Rather than using a system stack, we can use a stack class to simulate what
 * happens in memory. 
 * While stack is not empty or there is unvisited node
 * 1. Iteratively push current node and its left child into stack.
 *    Until current node is null.
 * 2. Pop top out of stack and visit it.
 * 3. Traverse to its right child and repeat to step 1.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return ans;
		// current tree node in stack
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// put all the left nodes into stack first
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// get the top from stack
			cur = stack.pop();
			// visit current node
			ans.add(cur.val);
			// traverse to right sub tree
			cur = cur.right;
		}
		return ans;
	}
}
