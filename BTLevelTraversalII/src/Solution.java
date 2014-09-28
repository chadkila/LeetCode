/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
 * 
 * return its bottom-up level order traversal as:
 * [ 
 * [15,7], 
 * [9,20], 
 * [3] 
 * ]
 * 
 * ANS
 * Same with 'Binary Tree Level Order Traversal', get the result and return
 * the reversed one.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
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
		// reverse the list
		for (int i = ans.size() - 1; i >= 0; i--) {
			res.add(ans.get(i));
		}
		return res;
	}
}
