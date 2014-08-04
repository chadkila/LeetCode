import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author yu
 * 
 */
public class SolutionTest {

	/**
	 * Test method for {@link Solution#merge(java.util.List)}.
	 */
	@Test
	public void testMerge() {
		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(15, 19));
		intervals.add(new Interval(2, 7));
		intervals.add(new Interval(10, 13));
		intervals.add(new Interval(9, 15));
		intervals.add(new Interval(1, 3));
		Solution test = new Solution();
		intervals = test.merge(intervals);
		for (Interval i : intervals) {
			System.out.println(i.start + ", " + i.end);
		}
	}

}
