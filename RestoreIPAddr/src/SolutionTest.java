import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testRestoreIpAddresses() {
		Solution test = new Solution();
		System.out.println(test.restoreIpAddresses("25525511135"));
		System.out.println(test.restoreIpAddresses("2552"));
		System.out.println(test.restoreIpAddresses("25"));
	}

}
