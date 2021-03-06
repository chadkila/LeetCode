import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFlatten() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		Solution test = new Solution();
		test.flatten(root);
		System.out.print(levelOrder(root));

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
