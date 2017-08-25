package com.roll.comical.console.business.testLog;

/**
 * @author zongqiang.hao
 */
public class TestMain {
	public static void main(String args[]){
		TestArrayList a1 = new TestArrayList();
		TestArrayList a2 = new TestArrayList();
		TestArrayList a3 = new TestArrayList();
		TestArrayList a4 = new TestArrayList();

		Thread demo1= new Thread(a1);
		Thread demo2= new Thread(a2);
		Thread demo3= new Thread(a3);
		Thread demo4= new Thread(a4);

		demo1.start();
		demo2.start();
		demo3.start();
		demo4.start();

	}
}
