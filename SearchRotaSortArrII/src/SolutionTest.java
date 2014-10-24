import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearch() {
		Solution test = new Solution();
		int A[] = { 3, 1, 1, 1, 1, 1, 1, 1, 1, 2 };
		System.out.println(test.search(A, 2));
	}

}
