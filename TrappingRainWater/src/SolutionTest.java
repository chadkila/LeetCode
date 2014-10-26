import org.junit.Test;

public class SolutionTest {

	@Test
	public void testTrap() {
		Solution test = new Solution();
		int A[] = { 4, 1, 2, 5 };
		int A1[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(test.trap(A));
		System.out.println(test.trap(A1));
	}

}
