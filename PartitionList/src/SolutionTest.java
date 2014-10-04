import org.junit.Test;

public class SolutionTest {

	@Test
	public void testPartition() {
		Solution test = new Solution();
		int arr[] = { 1, 4, 3, 2, 5, 2 };
		int arr1[] = { 1, 2 };
		printList(test.partition(iniList(arr), 3));
		printList(test.partition(iniList(arr1), 0));
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
		System.out.println();
	}
}
