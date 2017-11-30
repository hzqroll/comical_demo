package com.roll.comical.console.business.currenttest.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Date: 2017/11/17
 *
 * @author zongqiang.hao
 */
public class FutureTaskDone extends FutureTask {

	public FutureTaskDone(Callable callable) {
		super(callable);
	}

	@Override
	public void done() {
		System.out.println("线程执行结束！");
	}
}
