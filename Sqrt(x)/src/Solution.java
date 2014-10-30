/**
 * https://oj.leetcode.com/problems/sqrtx/
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * Newton's iteration http://en.wikipedia.org/wiki/Newton%27s_method
 * x^2=n, so f(x)=x^2-n, so derivation f'(x)=2x
 * for x at xi's slope is f'(xi)=2xi, so tangent at xi is
 * y=f'(xi)(x-xi)+f(xi)
 * let y=0 and we can get x=xi-f(xi)/f'(xi)
 * then x = 1/2(xi-n/xi)
 * iteratively put x into 1/2(xi+n/xi) until x=xi
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public int sqrt(int x) {
		if (x == 0)
			return 0;
		double x0 = 0;
		double x1 = 1;
		while (x0 != x1) {
			x0 = x1;
			// 1/2(xi-n/xi)
			x1 = (x1 + x / x1) / 2;
		}
		return (int) x1;
	}
}
