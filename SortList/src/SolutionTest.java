import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSortList() {
		Solution test = new Solution();
		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		ListNode ans = test.sortList(head);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}

}
