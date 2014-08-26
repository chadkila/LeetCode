/**
 * https://oj.leetcode.com/problems/rotate-list/
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: 
 * Given 1->2->3->4->5->NULL and k = 2, 
 * return 4->5->1->2->3->NULL.
 * 
 * Run over the whole list and get the length len, then link tail and 
 * head, then run to len - k%len and break the list.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		int len = 1;
		if (head == null || n == 0 || len - n % len == 0)
			return head;
		ListNode node = head;
		// get length
		while (node.next != null) {
			len++;
			node = node.next;
		}
		// link together
		node.next = head;
		n = len - n % len;
		// go to break point
		for (int i = 0; i < n; i++) {
			node = node.next;
		}
		// get new head
		head = node.next;
		// break list
		node.next = null;
		return head;
	}

}
