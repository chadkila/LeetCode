import java.util.*;

/**
 * https://oj.leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18], 
 * return [1,6],[8,10],[15,18].
 * 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 0)
			return intervals;
		// answers list
		List<Interval> answer = new ArrayList<Interval>();
		// sort the list first
		Collections.sort(intervals, new IntervalComparator());
		Interval current = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval next = intervals.get(i);
			// interval or not
			if (current.end >= next.start) {
				int start = Math.min(current.start, next.start);
				int end = Math.max(current.end, next.end);
				current = new Interval(start, end);
			} else {
				answer.add(current);
				// current element moves to next
				current = intervals.get(i);
			}
		}
		// don't forget the last element
		answer.add(current);
		return answer;
	}
}

/*
 * Don't forget how to write a comparator helper class implements Comparator<>
 * or to use Collections.sort(intervals, new Comparator(){ ... });
 */
class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		return o1.start - o2.start;
	}

}
