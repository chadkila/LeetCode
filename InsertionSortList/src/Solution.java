/**
 * https://oj.leetcode.com/problems/insertion-sort-list/
 * Sort a linked list using insertion sort.
 * 
 * ANS
 * This problem is just a justification of basic linked list operations,
 * like delete and insertion
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// pointer for the current node
		ListNode cur = head;
		// pointer for the previous node before current
		ListNode pre = dummy;
		while (cur != null) {
			ListNode next = cur.next;
			ListNode start = dummy;
			// scan from head node until next node is larger than current
			while (start.next != null && start.next.val < cur.val) {
				start = start.next;
			}
			// delete current node
			pre.next = cur.next;
			// insert after start node
			cur.next = start.next;
			start.next = cur;
			// move current and pre pointer forward
			cur = next;
			if (pre.next != cur)
				pre = pre.next;
		}
		return dummy.next;
	}
}
