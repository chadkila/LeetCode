/**
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * Follow up: Can you solve it without using extra space?
 * 
 * ANS:
 * 1. Suppose length between head and cycle head is A
 * 2. length between cycle head and two pointers meeting location is B
 * 3. length of cycle is L
 * Slow pointer moves A+B, and fast moves A+B+k*L,
 * and fast's speed is twice as slow, so A+B+k*L = 2(A+B), so A=k*L-B.
 * At this time, let one pointer starts at head, and another starts at meeting
 * location, which is A+B. Let two pointers move at same speed, and they will
 * meet at cycle head. 
 * Because when first pointer moves A steps, second pointer also moves A Steps
 * that is k*L-B steps, started at A+B its distance from head is A+k*L and it
 * means it is at cycle's head now.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		// fast and slow pointers
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		// make one pointer to the head
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
