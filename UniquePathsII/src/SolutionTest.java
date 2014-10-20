import org.junit.Test;

public class SolutionTest {

	@Test
	public void testUniquePathsWithObstacles() {
		int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int obstacleGrid1[][] = { { 1, 0 } };
		Solution test = new Solution();
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid1));
	}

}
