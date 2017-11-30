package com.roll.comical.console.business.jvm;

/**
 * Date: 2017/11/8
 *
 * @author zongqiang.hao
 */
public class JVMStackTest {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JVMStackTest jvmStackTest = new JVMStackTest();
		try {
			jvmStackTest.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + jvmStackTest.stackLength);
			e.printStackTrace();
		}
	}
}
