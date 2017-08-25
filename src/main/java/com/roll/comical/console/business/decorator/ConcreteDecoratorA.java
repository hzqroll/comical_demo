package com.roll.comical.console.business.decorator;

/**
 * Date: 2017/7/15
 *
 * @author zongqiang.hao
 */
public class ConcreteDecoratorA extends Decorator {

	private String addedState;

	@Override
	public void Operation() {
		this.Operation();
		addedState = "new State";
		System.out.println("具有装饰对象A的操作");
	}
}
