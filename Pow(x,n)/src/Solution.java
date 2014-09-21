/**
 * https://oj.leetcode.com/problems/powx-n/
 * Implement pow(x, n).
 * 
 * ANS
 * Use binary search to reduce time cost to log(n)
 * x^n= 
 * 1.0 if n==0, 
 * x^(n/2)*x^(n/2) if n!=0 and n is even, 
 * x^(n/2)*x^(n/2)*x if n>0 and n is odd, 
 * x^(n/2)*x^(n/2)*1/x if n<0 and n is odd 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public double pow(double x, int n) {
		if (n == 0)
			return 1d;
		double half = pow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else if (n > 0) {
			return half * half * x;
		} else {
			return half * half * (1 / x);
		}
	}
}
