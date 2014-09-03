import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCanJump() {
		int A1[] = { 2, 3, 1, 1, 4 };
		int A2[] = { 3, 2, 1, 0, 4 };
		Solution test = new Solution();
		System.out.println(test.canJump(A1));
		System.out.println(test.canJump(A2));
	}

}
