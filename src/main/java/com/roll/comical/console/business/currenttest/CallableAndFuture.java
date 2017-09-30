package com.roll.comical.console.business.currenttest;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Date: 2017/9/12
 *
 * @author zongqiang.hao
 */
public class CallableAndFuture {
	public static void main(String[] args) {
		Callable<Integer> callable = () -> new Random().nextInt(100);
		FutureTask<Integer> future = new FutureTask<>(callable);
		new Thread(future).start();
		try {
			Thread.sleep(5000);// 可能做一些事情
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
