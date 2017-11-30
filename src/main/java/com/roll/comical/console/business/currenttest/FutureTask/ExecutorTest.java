package com.roll.comical.console.business.currenttest.FutureTask;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;

/**
 * Date: 2017/11/18
 *
 * @author zongqiang.hao
 */
public class ExecutorTest {
	CompletionService completionService = new ExecutorCompletionService(new Executor() {
		@Override
		public void execute(Runnable command) {

		}
	});
}
