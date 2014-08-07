/**
 * https://oj.leetcode.com/problems/divide-two-integers/ 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * e.g. 19/3
 * 3<<1<<1<<1=24 > 19 (2 valid left shifts, great value is 12, res+=1<<(3-1), res=4)
 * 19-12=7 (7>3 continue)
 * 3<<1<<1=12 >  7 (1 valid left shift, great value is 6, res+=1<<(2-1), res=6)
 * 7-6=1 (1<3 break)
 * return res=6
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int divide(int dividend, int divisor) {
		// use long for avoiding overflow
		long divid = Math.abs((long) dividend);
		long divis = Math.abs((long) divisor);
		// System.out.println(divid + "," + divis);
		int res = 0;
		while (divid >= divis) {
			long div = divis;
			int i;
			// this multiplying stops ONLY when divs > divid
			for (i = 1; div <= divid; i++) {
				// left shif 1 digit, same as div*=2
				div <<= 1;
			}
			// i was added another one after finding div > divid
			res += 1 << (i - 2);
			divid -= divis << (i - 2);
		}
		// if only one of them is negative, returns negative value
		return (dividend < 0 ^ divisor < 0 ? -res : res);
	}
}
