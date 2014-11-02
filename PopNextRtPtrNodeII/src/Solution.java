/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * You may only use constant extra space.
 * For example, Given the following binary tree,
 * 
 *           1 
 *          / \ 
 *         2   3 
 *        / \   \ 
 *       4  5    7
 *       
 * After calling your function, the tree should look like:
 * 
 *           1 -> NULL 
 *          /  \ 
 *         2 -> 3 -> NULL 
 *        / \    \ 
 *       4-> 5 -> 7 -> NULL
 * 
 * ANS:
 * Like previous question, adding justifications of left and right children
 * are null or not. Most judgments are determining child node is a head node
 * or not. And head node needs to be reset to null after going to next layer,
 * or it will trapped in a dead loop.
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
		TreeLinkNode nextHead = null;
		// previous node
		TreeLinkNode pre = null;
		// for each layer and loop each node
		while (parent != null) {
			// loop the new layer
			while (parent != null) {
				// if left child exists
				if (parent.left != null) {
					if (pre == null) {
						// left child is head node
						nextHead = parent.left;
						pre = parent.left;
					} else {
						pre.next = parent.left;
						pre = pre.next;
					}
				}
				// if right child exists
				if (parent.right != null) {
					if (pre == null) {
						// right child is head node
						nextHead = parent.right;
						pre = parent.right;
					} else {
						pre.next = parent.right;
						pre = pre.next;
					}
				}
				parent = parent.next;
			}
			// go to next layer
			parent = nextHead;
			// reset next head to be null, or at last round iteration
			// parent will not be empty and go to dead loop
			nextHead = null;
			// reset previous node null for new layer
			pre = null;
		}
	}
}
