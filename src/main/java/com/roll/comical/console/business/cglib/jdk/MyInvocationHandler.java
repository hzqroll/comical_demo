package com.roll.comical.console.business.cglib.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Date: 2017/11/10
 *
 * @author zongqiang.hao
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object target;

	MyInvocationHandler() {
		super();
	}

	MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 程序执行前加入逻辑，MethodBeforeAdviceInterceptor
		System.out.println("before-----------------------------");
		// 程序执行
		Object result = method.invoke(target, args);
		// 程序执行后加入逻辑，MethodAfterAdviceInterceptor
		System.out.println("after------------------------------");
		return result;
	}

	/**
	 * 测试类，其中增强的目标对象是由Proxy.newProxyInstance(aService.getClass().getClassLoader(), aService.getClass().getInterfaces(), handler);来生成的。
	 * @param args
	 */
	public static void main(String[] args) {
		Service aService = new ServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(aService);
		// Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
		Service aServiceProxy = (Service) Proxy.newProxyInstance(aService
				.getClass().getClassLoader(), aService.getClass()
				.getInterfaces(), handler);
		// 由动态生成的代理对象来aServiceProxy 代理执行程序，其中aServiceProxy 符合Service接口
		aServiceProxy.add();
		System.out.println();
		aServiceProxy.update();
		// 以下是对B的代理
		// Service bService = new BService();
		// MyInvocationHandler handler = new MyInvocationHandler(bService);
		// Service bServiceProxy = (Service) Proxy.newProxyInstance(bService
		// .getClass().getClassLoader(), bService.getClass()
		// .getInterfaces(), handler);
		// bServiceProxy.add();
		// System.out.println();
		// bServiceProxy.update();
	}

}