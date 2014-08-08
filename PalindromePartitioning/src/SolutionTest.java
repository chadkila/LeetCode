import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class SolutionTest {

	@Test
	public void testPartition() {
		Solution test = new Solution();
		String s = new String("aab");
		System.out.print(test.partition(s));
	}
}
