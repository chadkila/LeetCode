import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinPathSum() {
		int grid[][] = { { 3, 1, 2, 4 }, { 6, 7, 8, 0 }, { 3, 3, 3, 3 } };
		System.out.println(new Solution().minPathSum(grid));
	}

}
