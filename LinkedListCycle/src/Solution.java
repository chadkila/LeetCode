/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * 
 * ANS:
 * Use chasing pointers to find that whether they will meet at last.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		// fast and slow pointers
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
