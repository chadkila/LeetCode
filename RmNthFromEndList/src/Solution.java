/**
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 * ANS:
 * This is very similar with finding middle node of a linked list. Still using
 * chasing pointers, first points moves n steps then q will move.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// a dummy head, handles head node being removed
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, q = dummy;
		int count = 0;
		while (p.next != null) {
			// q is one node before the Nth node
			if (count >= n)
				q = q.next;
			p = p.next;
			count++;
		}
		// delete Nth node, which is after q
		q.next = q.next.next;
		return dummy.next;
	}
}
