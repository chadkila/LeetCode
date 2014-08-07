/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * use a hash table to store numbers of point at each slope
 * then find maximum one
 */
import java.util.*;

/**
 * @author yu
 * 
 */

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Solution {

	HashMap<Float, Integer> slopes = new HashMap<Float, Integer>();
	int max_points = 0;

	public void addLinePoint(float slope) {
		if (slopes.containsKey(slope)) {
			int tempNum = slopes.get(slope);
			slopes.remove(slope);
			slopes.put(slope, tempNum + 1);
		} else {
			slopes.put(slope, 1);
		}
	}

	public int maxPoints(Point[] points) {
		for (int i = 0; i < points.length; i++) {
			slopes.clear();
			slopes.put(Float.MIN_VALUE, 0);
			// duplicated points
			int duplicate = 1;
			for (int j = i + 1; j < points.length; j++) {
				// finding a duplicated point
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicate++;
					continue;
				}
				// sometimes it may give negative 0, see the println(...)
				// so need to judge if they have same y first
				if (points[i].y == points[j].y) {
					float slope = 0;
					addLinePoint(slope);
					// System.out.println(((float) points[j].y - (float)
					// points[i].y)
					// / ((float) points[j].x - (float) points[i].x));
				} else {
					float slope = (float) (points[i].x == points[j].x ? Float.MAX_VALUE
							: ((float) points[j].y - (float) points[i].y)
									/ ((float) points[j].x - (float) points[i].x));
					addLinePoint(slope);
				}
			}
			for (int tmp : slopes.values()) {
				if (tmp + duplicate > max_points)
					max_points = tmp + duplicate;
			}
		}
		return max_points;

	}
}
