import org.junit.Test;

public class SolutionTest {

	@Test
	public void testJump() {
		int A1[] = { 2, 3, 1, 1, 4 };
		int A2[] = { 2, 3, 1, 1, 2, 0, 4 };
		Solution test = new Solution();
		System.out.println(test.jump(A1));
		System.out.println(test.jump(A2));
	}

}
