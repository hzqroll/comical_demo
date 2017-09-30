package com.roll.comical.console.business.currenttest;

import java.util.concurrent.Callable;

/**
 * Date: 2017/9/28
 *
 * @author zongqiang.hao
 */
public class FutureTaskTest implements Callable {
	private int i = 0;

	public void FutureTaskTest(int i) {
		this.i = i;
	}

	@Override
	public Object call() throws Exception {
		//Thread.sleep(20000);
		System.out.println("call :" + i);
		return i;
	}
}
