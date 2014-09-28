import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLevelOrder() {
		Solution test = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(17);
		System.out.print(test.levelOrder(root));
	}

}
