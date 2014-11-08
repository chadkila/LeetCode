import org.junit.Test;

public class SolutionTest {

	@Test
	public void testPreorderTraversal() {
		Solution test = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(test.preorderTraversal(root));
	}

}
