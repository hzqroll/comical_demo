package com.roll.comical.console.business.jvm;

/**
 * Date: 2017/11/4
 *
 * @author zongqiang.hao
 */
public class ReferenceCountingGC {
	public Object instance = null;

	private static final int _1MB = 1024 * 1024;

	public static void main(String args[]) {
		byte[] a1,a2,a3,a4;

		a1 = new byte[4 * _1MB];

		//System.gc();
	}
}
