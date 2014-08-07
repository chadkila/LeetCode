import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCandy() {
		Solution test = new Solution();
		int ratings[] = { 0, 3, 1, 5, 2, 1 };
		System.out.println(test.candy(ratings));
	}

}
