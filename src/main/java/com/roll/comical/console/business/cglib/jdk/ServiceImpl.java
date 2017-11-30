package com.roll.comical.console.business.cglib.jdk;

/**
 * Date: 2017/11/10
 * 被代理类，即目标类target
 * 目标类AService，我们的实验目标就是在AService中add和update方法的前后实现拦截，加入自定义切面逻辑advise
 *
 * @author zongqiang.hao
 */
public class ServiceImpl implements Service {
	/*
	 * (non-Javadoc)
	 *
	 * @see jdkproxy.Service#add()
	 */
	@Override
	public void add() {
		System.out.println("AService add>>>>>>>>>>>>>>>>>>");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see jdkproxy.Service#update()
	 */
	@Override
	public void update() {
		System.out.println("AService update>>>>>>>>>>>>>>>");
	}
}