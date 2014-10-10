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
 * Assuming i is the value that we choose to be the root. The value in left
 * subtree are from 1 to i – 1, and the values in right subtree are from i + 1
 * to n. For the left tree, there are num[i-1] different BSTs, for the right tree
 * there are num[n-i-1] different BSTs, so there are num[i-1]*num[n-i-1] different
 * BSTs for i. It turns out to be a one-dimension DP problem.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int numTrees(int n) {
		int num[] = new int[n + 1];
		// when there is 0 node, only one empty tree is possible
		num[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				// number left child * right child
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
	}
}
