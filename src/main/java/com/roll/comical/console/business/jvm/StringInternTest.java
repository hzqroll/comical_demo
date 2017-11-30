package com.roll.comical.console.business.jvm;

/**
 * Date: 2017/11/10
 *
 * @author zongqiang.hao
 */
public class StringInternTest {
	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		System.out.println(a == b);

		String c = "d";
		String d = new String("d").intern();
		System.out.println(c == d);

		String s1 = "ab123";
		String s2 = new String("ab123");
		System.out.println(s1 == s2);
		String s3 = s2.intern();
		System.out.println(s1 == s3);

		String str1 = new String("SEU") + new String("Calvin");
		System.out.println(str1.intern() == str1);
		System.out.println(str1 == "SEUCalvin");
	}
}
