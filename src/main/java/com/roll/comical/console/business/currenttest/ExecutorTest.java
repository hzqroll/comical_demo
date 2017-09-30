package com.roll.comical.console.business.currenttest;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2017/9/28
 *
 * @author zongqiang.hao
 */
public class ExecutorTest implements Runnable {

	private CompletionService<Integer> pool = new ExecutorCompletionService<>(Executors.newFixedThreadPool(10));

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			FutureTaskTest futureTaskTest = new FutureTaskTest();
			futureTaskTest.FutureTaskTest(i);
			pool.submit(futureTaskTest);
			try {
				pool.poll(1000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(pool.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ExecutorTest executorTest = new ExecutorTest();
		executorTest.run();
	}
}