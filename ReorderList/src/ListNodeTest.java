import static org.junit.Assert.*;

import org.junit.Test;

public class ListNodeTest {

	@Test
	public void testListNode() {
		Solution test = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		test.reorderList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
