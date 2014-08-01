import static org.junit.Assert.*;

import org.junit.Test;


public class testSolution {

	@Test
	public void testIsNumber() {
		Solution test = new Solution();
		System.out.println(test.isNumber("7"));
		System.out.println(test.isNumber(" 1.7"));
		System.out.println(test.isNumber(" -2e+7 "));
		System.out.println(test.isNumber("3.17e-7"));
		System.out.println(test.isNumber(""));
		System.out.println(test.isNumber(" 2. 7"));
	}

}
