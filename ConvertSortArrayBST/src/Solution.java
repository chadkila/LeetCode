/**
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * ANS
 * This is a straight forward recursive solution, that is recursively finding 
 * middle element of the array.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
		return buildTree(num, 0, num.length - 1);
	}

	private TreeNode buildTree(int num[], int start, int end) {
		if (start > end)
			return null;
		// value for root
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		// build left sub tree
		root.left = buildTree(num, start, mid - 1);
		// build right sub tree
		root.right = buildTree(num, mid + 1, end);
		return root;
	}
}
