import java.util.*;

/**
 * https://oj.leetcode.com/problems/insert-interval/
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> answer = new ArrayList<Interval>();
		int i = 0;
		// begin scanning from left to right
		// until finding new interval's start is smaller an end
		while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
			answer.add(intervals.get(i));
			i++;
		}
		// finding intersection
		while (i < intervals.size()
				&& newInterval.end >= intervals.get(i).start) {
			newInterval.start = Math.min(newInterval.start,
					intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		// adding intersection into answer list
		answer.add(newInterval);
		// adding the rest
		while (i < intervals.size()) {
			answer.add(intervals.get(i));
			i++;
		}
		return answer;
	}
}
