/**
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * ANS:
 * This is very similar with finding depth of a binary tree, the only difference
 * is when meeting a null node. Consider
 *      1
 *     / 
 *    2
 * make 1's null right child maximum value, and Math.min(left,right) will choose 2's 
 * value. If 1's null right returns 0, 1 will be regarded as leaf node.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return depth(root);
	}

	private int depth(TreeNode root) {
		// this null node must be a left or right child
		// its parent is not a leaf so return max integer
		if (root == null)
			return Integer.MAX_VALUE;
		// meets a leaf node, return depth 1
		if (root.left == null && root.right == null)
			return 1;
		return Math.min(depth(root.left), depth(root.right)) + 1;
	}
}
