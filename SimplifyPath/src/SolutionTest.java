import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSimplifyPath() {
		Solution test = new Solution();
		System.out.println(test.simplifyPath("////a/././/b/../../c///e/./"));
		System.out.println(test.simplifyPath("/"));
	}

}
