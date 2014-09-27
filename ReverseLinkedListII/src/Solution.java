/**
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * ANS
 * A straight forward solution is firstly go to position m, and then reverse 
 * n-m nodes.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// a dummy head for the convenience of further operations
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		// go to position m
		for (int i = 1; i < m; i++)
			pre = pre.next;
		// pre's location will not be moved as a head pointer
		// but cur will be moved all the time for reversing
		ListNode cur = pre.next;
		// reverse n-m times
		for (; m < n; m++) {
			// the node after current
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			// points to the latest reversed
			pre.next = tmp;
		}
		return dummy.next;
	}
}
