/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 * 
 * For example, Given n = 3, your program should return all 5 unique BST's shown
 * below.
 *     1      3     3     2     1 
 *      \    /     /     / \     \ 
 *       3  2     1     1   3     2 
 *      /  /       \               \
 *     2  1         2               3
 *     
 * ANS
 * Same idea with 'unique binary search trees', we need a nested for-loop to go
 * through every possible combinations of left tree and right tree for a given
 * root. We will do it recursively because it’s the same for the left tree and
 * right tree of root.
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		// from 1 nodes to n nodes
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		// append null
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			// construct left*right numbers of different trees
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}
}
