package com.roll.comical.console.business.currenttest.FutureTask;

/**
 * Date: 2017/11/17
 *
 * @author zongqiang.hao
 */
public class FutureTasKTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			CallableTest callableTest = new CallableTest(i);
			FutureTaskDone futureTaskDone = new FutureTaskDone(callableTest);
			futureTaskDone.cancel(true);
			futureTaskDone.run();
		}
	}
}
