import org.junit.Test;

public class SolutionTest {

	@Test
	public void testDetectCycle() {
		int arr[] = { 1, 2, 3, 4, 5 };
		Solution test = new Solution();
		ListNode head = iniCircle(arr);
		ListNode h2 = iniList(arr);
		System.out.println(test.detectCycle(head).val);
		System.out.println(test.detectCycle(h2).val);
	}

	private ListNode iniCircle(int arr[]) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i = 0; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		// circle
		node.next = new ListNode(6);
		node.next.next = head.next.next.next.next;
		return head.next;
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
}
