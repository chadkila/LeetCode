/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum. 
 * For example: Given the below binary tree and sum = 22,
 * 				5 
 * 			   / \ 
 * 			  4   8 
 * 			 /   / \ 
 * 			11 13   4 
 * 		   / \     / \ 
 * 		  7   2   5   1
 * 
 * return
 * [ 
 * [5,4,11,2], 
 * [5,8,4,5] 
 * ]
 * 
 * ANS
 * Like 'Path Sum', this problem still is recursively solved, but ArrayList will be 
 * tracked.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		if (root == null)
			return ans;
		getPath(root, sum, path, ans);
		return ans;
	}

	private void getPath(TreeNode root, int sum, List<Integer> path,
			List<List<Integer>> ans) {
		// add into path
		path.add(root.val);
		// true path found, add into result
		if (root.left == null && root.right == null && root.val == sum) {
			// a copy of path, otherwise 'path' is a pointer
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		// left sub tree
		if (root.left != null) {
			getPath(root.left, sum - root.val, path, ans);
			path.remove(path.size() - 1);
		}
		// right sub tree
		if (root.right != null) {
			getPath(root.right, sum - root.val, path, ans);
			path.remove(path.size() - 1);
		}
	}
}
