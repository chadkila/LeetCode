/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 * 			3 
 * 		   / \ 
 * 		   9 20 
 * 			 / \ 
 * 			 15 7
 * return its zigzag level order traversal as:
 * [ 
 * [3], 
 * [20,9], 
 * [15,7] 
 * ]
 * 
 * ANS
 * Same with 'Binary Tree Level Order Traversal', set a flag for whether to 
 * reverse the current level list.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return ans;
		queue.add(root);
		boolean reverse = false;
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
			// reverse current level if flag has been set to true
			if (reverse)
				tmpList = reverse(tmpList);
			ans.add(tmpList);
			// go to next level
			queue = tmpQ;
			// reverse the flag
			reverse = (reverse == true ? false : true);
			if (queue.isEmpty())
				break;
		}
		return ans;
	}

	private List<Integer> reverse(List<Integer> ans) {
		List<Integer> res = new ArrayList<Integer>();
		// reverse the list
		for (int i = ans.size() - 1; i >= 0; i--) {
			res.add(ans.get(i));
		}
		return res;
	}
}
