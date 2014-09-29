/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * ANS
 * This problem can be illustrated by using a simple example.
 * 
 * in-order:   4 2 5 (1) 6 7 3  8 
 * post-order: 4 5 2  6  7 8 3 (1)
 * 
 * left child:
 * 4 (2) 5
 * 4  5 (2)
 * right child:
 * 6 7 (3) 8
 * 6 7  8 (3)
 * 
 * From the post-order array, we know that last element is the root. We can find
 * the root in in-order array. Then we can identify the left and right sub-trees
 * of the root from in-order array.
 * 
 * Using the length of left sub-tree, we can identify left and right sub-trees
 * in post-order array. Recursively, we can build up the tree.
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// start and end index of in-order array
		int inStart = 0, inEnd = inorder.length - 1;
		// start and end index of post-order array
		int poStart = 0, poEnd = postorder.length - 1;
		// build tree recursively
		return buildTree(inorder, inStart, inEnd, postorder, poStart, poEnd);
	}

	private TreeNode buildTree(int inorder[], int inStart, int inEnd,
			int postorder[], int poStart, int poEnd) {
		if (inStart > inEnd || poStart > poEnd)
			return null;
		int rootVal = postorder[poEnd];
		TreeNode root = new TreeNode(rootVal);
		int len = 0;
		// finding root of in-order list
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				break;
			}
			len++;
		}
		// left children's length is div of in-order list
		root.left = buildTree(inorder, inStart, inStart + len - 1, postorder,
				poStart, poStart + len - 1);
		// right children's starts at poStart+div of post-order
		root.right = buildTree(inorder, inStart + len + 1, inEnd, postorder,
				poStart + len, poEnd - 1);
		return root;
	}
}
