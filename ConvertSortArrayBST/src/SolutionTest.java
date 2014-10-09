import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSortedArrayToBST() {
		Solution test = new Solution();
		int num[] = { 1, 2, 3, 4, 5 };
		System.out.print(levelOrder(test.sortedArrayToBST(num)));
	}

	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return ans;
		queue.add(root);
		while (true) {
			// temporary queue for defining next level
			Queue<TreeNode> tmpQ = new LinkedList<TreeNode>();
			// list to store current level nodes
			List<Integer> tmpList = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode cur = queue.poll();
				// put child nodes into next level queue
				if (cur.left != null)
					tmpQ.add(cur.left);
				if (cur.right != null)
					tmpQ.add(cur.right);
				// current level result
				tmpList.add(cur.val);
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
