/**
 * http://oj.leetcode.com/problems/valid-number/ Validate if a given string is
 * numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true
 * 
 * @author yu
 */
public class Solution {

	public Solution(){
		
	}
	/**
	 * [-+] 匹配方括号中任意
	 * ？ 重复0或1次，等于{0,1}
	 * \d 数字，等于[0-9]
	 * \. 小数点
	 * + 重复一次及多次，等于{1,}
	 * x|y 匹配x或y
	 * (pattern) pattern是子表达式
	 * * 重复0次或多次，等于{0,}
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {
		if (s.trim().isEmpty())
			return false;
		String regex = "[-+]?(\\d+\\.?\\d*|\\.\\d+)(e[-+]?\\d+)?";
		if (s.trim().matches(regex))
			return true;
		else
			return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
