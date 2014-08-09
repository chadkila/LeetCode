/**
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 *   1 
 *  / \ 
 * 2   3 
 * 
 * Return 6.
 * 
 * Recursion, like DFS
 * for every node, the path may contain
 * 1. itself and its left child
 * 2. itself and its right child
 * 3. itself and its left and right child
 * 4. itself only
 * for 1 and 2 there would only be one of them, left or right child 
 * may covered
 */

/**
 * 
 * 
 * @author yu
 * 
 */
public class Solution {
	private int max;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		findMax(root);
		return max;
	}

	private int findMax(TreeNode root) {
		if (root == null)
			return 0;
		int left = findMax(root.left);
		int right = findMax(root.right);
		// left and right children are covered
		int all = left + root.val + right;
		int single = Math.max(root.val, Math.max(left, right) + root.val);
		max = Math.max(max, Math.max(single, all));
		// only single condition could cover parent node in the path
		return single;
	}
}
