import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindMin() {
		Solution test = new Solution();
		int num[] = { 2, 2, 2, 2, 2, 0, 0, 1, 1 };
		System.out.println(test.findMin(num));
		int num1[] = { 1, 3, 3 };
		System.out.println(test.findMin(num1));
	}

}
