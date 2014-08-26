import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAddTwoNumbers() {
		int arr1[] = { 9, 8, 7 };
		int arr2[] = { 6, 5, 4 };
		ListNode l1 = iniList(arr1);
		ListNode l2 = iniList(arr2);
		Solution test = new Solution();
		printList(test.addTwoNumbers(l1, l2));
	}

	private ListNode iniList(int arr[]) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i = 0; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		return head.next;
	}

	private void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
