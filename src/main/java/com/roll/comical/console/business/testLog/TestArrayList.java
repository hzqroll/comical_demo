package com.roll.comical.console.business.testLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zongqiang.hao
 */
public class TestArrayList implements Runnable {
	private static List list = new ArrayList();

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			list.add(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
