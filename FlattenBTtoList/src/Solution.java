/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, Given
 * 
 *        1 
 *       / \ 
 *      2   5 
 *     / \   \ 
 *    3   4   6
 * 
 * The flattened tree should look like:
 * 
 *    1 
 *     \ 
 *      2 
 *       \ 
 *        3 
 *         \ 
 *          4 
 *           \ 
 *            5 
 *             \ 
 *              6
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points
 * to the next node of a pre-order traversal.
 * 
 * ANS:
 * Recursively move left child to the right, and keep the record of right child 
 * for being grafted in the future.
 * e.g.
 * recursion 1:
 *        1 <-lastVisit        5 <-curRight1
 *         \                    \
 *          2  <-root            6
 *         / \ 
 *        3   4
 * recursion 2:
 *        1            4 <-curRight2  5 <-curRight1
 *         \                           \
 *          2  <-lastVisit              6
 *           \
 *            3  <-root
 */

/**
 * @author yu
 * 
 */
public class Solution {
	// upper level root node
	private TreeNode lastVisit = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		// flag the current right child, because left child will be moved to
		// right
		TreeNode curRight = root.right;
		if (lastVisit != null) {
			// move left child to right
			lastVisit.left = null;
			lastVisit.right = root;
		}
		// go to next level
		lastVisit = root;
		// pre-order traversal
		flatten(root.left);
		flatten(curRight);
	}

}
