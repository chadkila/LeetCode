/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * ANS
 * If it's given an array instead of a list, the solution would be pretty 
 * straight forward recursive solution, which is recursively finding middle 
 * element. But for linked list it would be too time costly, a better solution is 
 * building BST from bottom to top.
 * Recursively 
 * 1. construct the left tree 
 * 2. construct the root node, list pointer +1. 
 * 3. construct the right node
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			len++;
		}
		// java is pass by value
		ListNode headList[] = { head };
		return buildBST(headList, 0, len - 1);
	}

	private TreeNode buildBST(ListNode head[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		// build left sub tree
		TreeNode left = buildBST(head, start, mid - 1);
		// select root node
		TreeNode parent = new TreeNode(head[0].val);
		// move list head forward
		head[0] = head[0].next;
		parent.left = left;
		// build right sub tree
		TreeNode right = buildBST(head, mid + 1, end);
		parent.right = right;
		return parent;
	}
}
