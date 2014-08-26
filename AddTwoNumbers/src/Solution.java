/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * ANS
 * Iteratively adding carry to next node
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		// answer list's head
		ListNode ans = new ListNode(0);
		// a pointer pointed to answer list
		ListNode cur = ans;
		if (l1 == null && l2 == null)
			return null;
		while (l1 != null || l2 != null) {
			// get value from l1
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			// get value from l2
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			// current value
			cur.next = new ListNode(carry % 10);
			cur = cur.next;
			// carry for the next digit
			carry /= 10;
		}
		if (carry == 1)
			cur.next = new ListNode(1);
		return ans.next;
	}
}
