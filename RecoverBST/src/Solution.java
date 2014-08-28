/**
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * ANS
 * Using in-oder traversal
 * 1. Find first wrong number, which is bigger than its successor
 * 2. Find second wrong number, who's successor firstly appers bigger 
 * than the first wrong number, then swap them.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	// the previous node
	private TreeNode pre = null;
	// first wrong node
	private TreeNode first = null;
	// second wrong node
	private TreeNode second = null;

	public void recoverTree(TreeNode root) {
		// in-order traversal
		inOrder(root);
		if (first != null) {
			// if tree has only 2 elements, second will not be covered
			if (second == null)
				second = pre;
			// swapping value
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		// cover left child first
		if (root.left != null)
			inOrder(root.left);
		if (pre != null) {
			// first wrong node, who's successor is smaller
			if (first == null && root.val < pre.val) {
				first = pre;
			} else if (first != null && root.val > first.val) {
				// second wrong node, whose successor firstly appears bigger
				second = pre;
				return;
			}
		}
		// root it self becomes previous node for the next one
		pre = root;
		// cover right child
		if (root.right != null)
			inOrder(root.right);
	}
}
