/**
 * https://oj.leetcode.com/problems/sort-list/
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * merge sort will not spend too much time on loacting and inserting
 * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * http://www.princeton.edu/~achaney/tmve/wiki100k/docs/Merge_sort.html
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode sortList(ListNode head) {

		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		// find middle by chasing pointers
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		// break list
		slow.next = null;
		slow = mergeSort(head);
		mid = mergeSort(mid);
		return merge(slow, mid);
	}

	private ListNode merge(ListNode low, ListNode high) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (low != null || high != null) {
			if (low != null && high != null) {
				// merge the same length
				if (low.val < high.val) {
					cur.next = low;
					low = low.next;
				} else {
					cur.next = high;
					high = high.next;
				}
				cur = cur.next;
			} else if (low != null) {
				// merge rest of low
				cur.next = low;
				low = low.next;
				cur = cur.next;
			} else if (high != null) {
				// merge rest of high
				cur.next = high;
				high = high.next;
				cur = cur.next;
			}

		}
		return head.next;
	}
}
