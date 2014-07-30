import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAtoi() {
		Solution test = new Solution();
		System.out.println(test.atoi("-100"));
		System.out.println(test.atoi("           10123.0        "));
		System.out.println(test.atoi("   101   0   "));
		System.out.println(test.atoi("  -1007894526123  "));
		System.out.println(test.atoi("  - 1001    "));
		System.out.println(test.atoi(" +1001564897.3515"));
		System.out.println(test.atoi(" -2147483647"));
		System.out.println(test.atoi(" -2147483648"));

	}

}
