import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNextPermutation() {
		Solution test = new Solution();
		int num[] = { 1, 2, 5, 4, 3 };
		test.nextPermutation(num);
		System.out.print(Arrays.toString(num));
	}

}
