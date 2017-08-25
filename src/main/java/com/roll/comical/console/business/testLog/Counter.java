package com.roll.comical.console.business.testLog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2017/4/8
 *
 * @author zongqiang.hao
 */
public class Counter {
	private AtomicInteger atomicT = new AtomicInteger(0);
	private int i = 0;

	public static void main(String args[]) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<Thread>(600);
		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						cas.count();
						cas.safeCount();
					}
				}
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicT.get());
	}

	private void safeCount() {
		for (; ; ) {
			int i = atomicT.get();
			boolean suc = atomicT.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}

	private void count() {
		i++;
	}
}
