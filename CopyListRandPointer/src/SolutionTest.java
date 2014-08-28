import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCopyRandomList() {
		int arr[] = { 9, 8, 7, 6, 5 };
		RandomListNode l = iniList(arr);
		Solution test = new Solution();
		printList(test.copyRandomList(l));
	}

	private RandomListNode iniList(int arr[]) {
		RandomListNode head = new RandomListNode(0);
		RandomListNode node = head;
		for (int i = 0; i < arr.length; i++) {
			node.next = new RandomListNode(arr[i]);
			node.random = null;
			node = node.next;
		}
		return head.next;
	}

	private void printList(RandomListNode node) {
		while (node != null) {
			System.out.print(node.label + " ");
			node = node.next;
		}
	}

}
