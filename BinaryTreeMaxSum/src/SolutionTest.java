import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxPathSum() {
		Solution test = new Solution();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-8);
		root.right = new TreeNode(1);
		root.left.right = new TreeNode(20);
		root.left.left = new TreeNode(-5);
		root.left.right.left = new TreeNode(-3);
		System.out.println(test.maxPathSum(root));
	}

}
