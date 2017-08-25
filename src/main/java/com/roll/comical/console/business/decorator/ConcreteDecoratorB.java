package com.roll.comical.console.business.decorator;

/**
 * Date: 2017/7/15
 *
 * @author zongqiang.hao
 */
public class ConcreteDecoratorB extends Decorator {
	@Override
	public void Operation() {
		this.Operation();
		AddEdBehavior();
		System.out.println("具有装饰对象B的操作");
	}

	private void AddEdBehavior() {

	}
}
