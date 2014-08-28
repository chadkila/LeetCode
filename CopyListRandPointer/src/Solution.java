/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */
import java.util.HashMap;

/**
 * @author yu
 * 
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		if (head == null)
			return null;
		RandomListNode ans = new RandomListNode(head.label);
		// pointer of answer list
		RandomListNode pre = ans;
		// pointer of original list
		RandomListNode cur = head.next;
		map.put(head, ans);
		while (cur != null) {
			// copy and put into hash map
			RandomListNode node = new RandomListNode(cur.label);
			map.put(cur, node);
			// link previous new node to current new node
			pre.next = node;
			// the current one becomes previous one for the next loop
			pre = node;
			// move original pointer forward
			cur = cur.next;
		}
		// point to the head
		cur = head;
		pre = ans;
		// scan and copy random node
		while (pre != null) {
			pre.random = map.get(cur.random);
			pre = pre.next;
			cur = cur.next;
		}
		return ans;
	}
}
