package com.roll.comical.console.business.jvm;

/**
 * Date: 2017/11/7
 *
 * @author zongqiang.hao
 */
public class ReturnAddressTest {
	private Object returnAddress(){
		return null;
	}

	public static void main(String args[]){
		String s = new String("1");
		String s2 = "1";
		//s.intern();
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		String s4 = "11";
		s3.intern();
		System.out.println(s3 == s4);
	}
}
