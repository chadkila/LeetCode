import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxProduct() {
		Solution test = new Solution();
		int A[] = { -1, 1, -2, 3, -2, 4 };
		System.out.println(test.maxProduct(A));
	}

}
