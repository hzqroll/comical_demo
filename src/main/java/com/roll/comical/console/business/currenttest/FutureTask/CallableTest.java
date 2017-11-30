package com.roll.comical.console.business.currenttest.FutureTask;

import java.util.concurrent.Callable;

/**
 * Date: 2017/11/17
 *
 * @author zongqiang.hao
 */
public class CallableTest implements Callable {
	public final int result;

	public CallableTest(int result) {
		this.result = result;
	}

	@Override
	public Object call() throws Exception {
		Thread.sleep(100);
		System.out.println("获取返回结果： " + result);
		return result;
	}
}
