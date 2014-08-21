import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListNodeTest {

	@Test
	public void testListNode() {
		int arr[] = { 1, 9, 10 };
		int arr1[] = { 7, 11 };
		int arr2[] = { 8, 13 };
		List<ListNode> lists = new ArrayList<>();
		lists.add(iniList(arr));
		lists.add(iniList(arr1));
		lists.add(iniList(arr2));
		Solution test = new Solution();
		printList(test.mergeKLists(lists));
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
