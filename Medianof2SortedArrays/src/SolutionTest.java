import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindMedianSortedArrays() {
		Solution test = new Solution();
		int[] a = { 1, 3, 7, 11, 13, 15 };
		int[] b = { 2, 4, 8, 10, 16 };
		System.out.println(test.findMedianSortedArrays(a, b));
		int[] a1 = { 1, 1 };
		int[] b1 = { 1, 2 };
		System.out.println(test.findMedianSortedArrays(a1, b1));
		// K is narrowed to 1
		int[] a2 = { 1, 3, 7, 11, 13, 15 };
		int[] b2 = { 2, 4, 5 };
		System.out.println(test.findMedianSortedArrays(a2, b2));
		// B_i is narrowed to 0
		int[] a3 = { 1, 2, 2 };
		int[] b3 = { 1, 2, 3 };
		System.out.println(test.findMedianSortedArrays(a3, b3));
	}

}
