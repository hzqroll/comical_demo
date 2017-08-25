package com.roll.comical.console.business.testLog;

import java.util.HashMap;

/**
 * @author zongqiang.hao
 */
public class TestHashMapSize {
	public static void main(String args[]){
		Integer a = 1;
		long start = 0;
		long end = 0;
		// 先垃圾回收
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		HashMap map = new HashMap();
		for (int i = 0; i < 100000000; i++) {
			map.put(i, a);
		}
		// 快要计算的时,再清理一次
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("一个HashMap对象占内存:" + (end - start));
	}
}
