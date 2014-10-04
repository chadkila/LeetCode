/**
 * https://oj.leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, 
 * Given 1->4->3->2->5->2 and x = 3, 
 * return 1->2->2->4->3->5.
 * 
 * ANS
 * 1. Get the last element and the length of the list (1 while loop) 
 * 2. Scan the whole list, if current node value < x, then go to the next node. 
 * 3. If current node value >=x, then move this node to the end of the list. until
 * meet the length of the original list.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int len = 0;

		if (head == null || head.next == null) {
			return head;
		}
		// pointer of the last node
		ListNode end = head;
		// get length
		while (end.next != null) {
			end = end.next;
			len++;
		}
		// pointer for operations, use previous node for convenience
		ListNode cur = dummy;
		for (int i = 0; i <= len; i++) {
			if (cur.next.val < x) {
				// go to next
				cur = cur.next;
			} else {
				// end node's next becomes current
				end.next = cur.next;
				// current node go to tail
				cur.next = cur.next.next;
				// update end node
				end = end.next;
				end.next = null;
			}
		}
		return dummy.next;
	}
}
