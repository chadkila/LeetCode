/**
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Use a minimal heap to maintain limited size buffer, and remove heap top 
 * then merge into list. Time complexity is O(nk*log(n)) and space complexity
 * is O(c). While using merge sort is O(n^2*k)
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		// use priority queue to maintain a minimal heap
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(13,
				new nodeComparator());
		ListNode ans = null;
		ListNode pre = ans;
		if (lists.size() == 0)
			return ans;
		// initialize the heap, adding every head node of lists
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				heap.add(node);
			}
		}
		while (heap.size() > 0) {
			ListNode cur = heap.poll();
			// answer list is empty?
			if (ans == null) {
				ans = cur;
				pre = ans;
			} else {
				// connect previous node to current
				pre.next = cur;
			}
			// for the next loop current becomes previous
			pre = cur;
			// remove one ethen add one into heap
			if (cur.next != null)
				heap.add(cur.next);
		}
		return ans;
	}
}

class nodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode o1, ListNode o2) {
		return o1.val - o2.val;
	}

}