import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testInsertionSortList() {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		Solution test = new Solution();
		printList(test.insertionSortList(iniList(arr)));
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
