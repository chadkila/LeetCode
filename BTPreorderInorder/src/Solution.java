/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * ANS
 * Like 'Construct Binary Tree from Inorder and Postorder Traversal'
 * 
 * pre-order: (1) 2 4  5  3 7 6 8
 * in-order:   4  2 5 (1) 6 7 3 8
 * 
 * left child:
 * (2) 4  5
 *  4 (2) 5
 * right child:
 * (3) 7  6  8
 *  6  7 (3) 8
 *  
 *  In pre-order array, the first element is the root. Then like the previous solution, 
 *  solve it recursively.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// start and end index of in-order array
		int inStart = 0, inEnd = inorder.length - 1;
		// start and end index of pre-order array
		int prStart = 0, prEnd = preorder.length - 1;
		// build tree recursively
		return buildTree(preorder, prStart, prEnd, inorder, inStart, inEnd);
	}

	private TreeNode buildTree(int preorder[], int prStart, int prEnd,
			int inorder[], int inStart, int inEnd) {
		if (prStart > prEnd || inStart > inEnd)
			return null;
		int rootVal = preorder[prStart];
		TreeNode root = new TreeNode(rootVal);
		int len = 0;
		// finding root of in-order list
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				break;
			}
			len++;
		}
		// left children starts at prStart+1 with length of len
		root.left = buildTree(preorder, prStart + 1, prStart + len, inorder,
				inStart, inStart + len - 1);
		// right children starts at prStart+len+1 and ends at the end
		root.right = buildTree(preorder, prStart + len + 1, prEnd, inorder,
				inStart + len + 1, inEnd);
		return root;
	}
}
