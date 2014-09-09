/**
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * For example, Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * ANS:
 * Count current covered nodes first, if it has reached k, then reverse them.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		// dummy head node
		ListNode pre = new ListNode(0);
		pre.next = head;
		// the pointer
		ListNode cur = head;
		// avoid head pointer being changed
		head = pre;
		int count = 0;
		while (cur != null) {
			count++;
			ListNode end = cur;
			if (count == k) {
				pre = reverse(pre, end);
				count = 0;
				// current element reversed to last
				cur = pre;
			}
			cur = cur.next;
		}
		return head.next;
	}

	private ListNode reverse(ListNode head, ListNode end) {
		ListNode cur = head.next;
		// the first element will be the last one
		ListNode tail = cur;
		// reverse list
		while (end != head.next) {
			ListNode next = cur.next;
			// insert the first one into end's next
			head.next = cur.next;
			cur.next = end.next;
			end.next = cur;
			// move to the next element
			cur = next;
		}
		// the new pre for the next round
		return tail;
	}
}
