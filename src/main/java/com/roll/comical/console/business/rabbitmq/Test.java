package com.roll.comical.console.business.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
public class Test {
	@Autowired
	private AsyncExecutorService asyncExecutorService;

	public static void main(String args[]) {
		double a = 4d;
		double b = 3d;
		System.out.println((a / b));
	}

}
