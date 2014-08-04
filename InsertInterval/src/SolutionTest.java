import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	 * Test method for {@link Solution#insert(java.util.List, Interval)}.
	 */
	@Test
	public void testInsert() {
		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(9, 10));
		intervals.add(new Interval(12, 16));
		Solution test = new Solution();
		Interval newInterval = new Interval(4, 9);
		intervals = test.insert(intervals, newInterval);
		for (Interval i : intervals) {
			System.out.println(i.start + ", " + i.end);
		}
	}

}
