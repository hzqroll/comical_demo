package com.roll.comical.console.business.decorator;

/**
 * Date: 2017/7/15
 *
 * @author zongqiang.hao
 */
public class TestMain {
	public static void main(String args[]) {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA d1 = new ConcreteDecoratorA();
		ConcreteDecoratorB d2 = new ConcreteDecoratorB();
		d1.setComponent(c);
		d2.setComponent(d1);
		d2.Operation();
	}
}
