import org.junit.Test;

public class SolutionTest {

	@Test
	public void testReverseBetween() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Solution test = new Solution();
		printList(test.reverseBetween(iniList(arr), 3, 6));
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
