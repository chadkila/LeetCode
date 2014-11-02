import java.util.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testConnect() {
		Solution test = new Solution();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		test.connect(root);
		System.out.print(levelOrder(root));
	}

	private List<List<Integer>> levelOrder(TreeLinkNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root == null)
			return ans;
		queue.add(root);
		while (true) {
			// temporary queue for defining next level
			Queue<TreeLinkNode> tmpQ = new LinkedList<TreeLinkNode>();
			// list to store current level nodes
			List<Integer> tmpList = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeLinkNode cur = queue.poll();
				// put child nodes into next level queue
				if (cur.left != null)
					tmpQ.add(cur.left);
				if (cur.right != null)
					tmpQ.add(cur.right);
				// current level result
				int val = cur.next == null ? -1 : cur.next.val;
				tmpList.add(val);
			}
			ans.add(tmpList);
			// go to next level
			queue = tmpQ;
			if (queue.isEmpty())
				break;
		}
		return ans;
	}

}
