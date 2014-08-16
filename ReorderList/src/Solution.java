/**
 * https://oj.leetcode.com/problems/reorder-list/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * e.g 1,2,3,4,5,6
 * 1. find median
 * 2. 1,2,3,4,5,6 -> 1,2,3 | 6,5,4
 * 3. 1,2,3,6,5,4 -> 1,6,2,5,3,4
 */

/**
 * 
 * 
 * @author yu
 * 
 */
public class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		// use slow/fast pointers to get middle
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			fast = fast.next;
			if (fast == null)
				break;
			fast = fast.next;
			if (fast == null)
				break;
			slow = slow.next;
		}
		// reverse the last half part
		// two lists are broken at last
		ListNode cur = slow;
		ListNode pos = slow.next;
		cur.next = null;
		while (pos != null) {
			ListNode temp = pos.next;
			pos.next = cur;
			cur = pos;
			pos = temp;
		}
		// merge two parts
		ListNode first = head;
		ListNode second = cur;
		while (first != null && second != null && first != second) {
			ListNode temp = second.next;
			second.next = first.next;
			first.next = second;
			first = second.next;
			second = temp;
		}
	}
}
