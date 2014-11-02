/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 * For example, Given the following perfect binary tree,
 * 
 *           1 
 *          /  \ 
 *         2    3 
 *        / \  / \ 
 *       4  5  6  7
 * 
 * After calling your function, the tree should look like:
 * 
 *           1 -> NULL 
 *          /  \ 
 *         2 -> 3 -> NULL 
 *        / \  / \ 
 *       4->5->6->7 -> NULL
 *       
 * ANS:
 * This is very similar with 'Binary Tree Level Order Traversal', but this question
 * requires constant space so it is not appropriate to use a queue to store levels 
 * of nodes then connect them together.
 * So instead of using a queue, use a previous pointer to store last visited child 
 * node, and connect it to the current node's child.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		// current node traversing
		TreeLinkNode parent = root;
		// the head node of next level
		TreeLinkNode nextHead = parent.left;
		// previous node
		TreeLinkNode pre = null;
		// for each layer and loop each node
		while (parent != null && parent.left != null) {
			// loop the new layer
			while (parent != null) {
				// connect left child
				if (pre == null) {
					// this is the most left node
					pre = parent.left;
				} else {
					pre.next = parent.left;
					pre = pre.next;
				}
				// connect left and right child
				pre.next = parent.right;
				pre = pre.next;
				// go to next node of current layer
				parent = parent.next;
			}
			// go to next layer
			parent = nextHead;
			nextHead = parent.left;
			// reset previous node null for new layer
			pre = null;
		}
	}
}
