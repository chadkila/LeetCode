/**
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. 
 * The right subtree of a node contains only nodes with keys greater than the 
 * node's key. 
 * Both the left and right subtrees must also be binary search trees.
 * 
 * ANS
 * This is a straight forward recursive solution, every node should be within a 
 * range, and the range is defined by its predecessor.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(TreeNode root, int min, int max) {
		// traced to leaf, upper nodes are valid
		if (root == null)
			return true;
		// invalid
		if (root.val <= min || root.val >= max)
			return false;
		// recursively judge it's valid or not
		return isValid(root.left, min, root.val)
				&& isValid(root.right, root.val, max);
	}
}
