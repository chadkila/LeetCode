import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSumNumbers() {
		Solution test = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(test.sumNumbers(root));
	}

}
