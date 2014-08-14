import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testEvalRPN() {
		Solution test = new Solution();
		String ops[] = { "2", "1", "+", "3", "*" };
		System.out.println(test.evalRPN(ops));
	}

}
