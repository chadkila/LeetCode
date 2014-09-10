/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, 
 * Given 1->1->2, return 1->2. 
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * ANS
 * Using 2 pointers to cover the sub list of duplicates, then cut them.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// pointer for operations
		ListNode cur = head;
		while (cur != null) {
			// successor of current node
			ListNode succ = cur.next;
			while (succ != null && succ.val == cur.val) {
				ListNode tmp = succ;
				// move successor forward
				succ = succ.next;
				// let GC remove the unused object
				tmp.next = null;
			}
			// link to a not duplicated node
			cur.next = succ;
			cur = cur.next;
		}
		return head;
	}
}
