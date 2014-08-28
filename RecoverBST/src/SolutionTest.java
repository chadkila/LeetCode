import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		Solution test = new Solution();
		test.recoverTree(root);
		System.out.print(root.val + ", " + root.left.val);
	}

}
