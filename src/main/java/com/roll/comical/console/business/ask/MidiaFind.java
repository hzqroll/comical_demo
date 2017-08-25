package com.roll.comical.console.business.ask;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午2:51
 *
 * @author zongqiang.hao
 */
public class MidiaFind {
	private Queue<Long> small = new PriorityQueue(),
			large = new PriorityQueue();

	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	public double findMedian() {
		return large.size() > small.size()
				? large.peek()
				: (large.peek() - small.peek()) / 2.0;
	}

	public static void main(String args[]){
		Queue<Integer> a = new PriorityQueue();
		Queue<Integer> b = new PriorityQueue();
		a.add(1);
		a.add(2);
		b.add(-a.peek());
		System.out.println(a);
		System.out.println(b);
	}
}
