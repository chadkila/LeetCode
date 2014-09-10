/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example, 
 * Given 1->2->3->3->4->4->5, return 1->2->5. 
 * Given 1->1->1->2->3, return 2->3.
 * 
 * ANS
 * The same with 'Remove Duplicates from Sorted List', adding a dummy head and 
 * using a pre pointer to delete all the duplicate parts.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// dummy head
		ListNode pre = new ListNode(0);
		pre.next = head;
		head = pre;
		// pointer for operations
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && pre.next.val == cur.next.val) {
				// move successor forward
				cur = cur.next;
			}
			// no duplicate element found
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				// link pre's next to a not duplicate element
				pre.next = cur.next;
			}
			// move forward
			cur = cur.next;
		}
		return head.next;
	}
}
