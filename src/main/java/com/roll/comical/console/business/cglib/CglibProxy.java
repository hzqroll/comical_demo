package com.roll.comical.console.business.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Date: 2017/11/10
 * 实现动态代理类CglibProxy，需要实现MethodInterceptor接口，实现intercept方法。
 * 该代理中在add方法前后加入了自定义的切面逻辑，目标类add方法执行语句为proxy.invokeSuper(object, args);
 *
 * @author zongqiang.hao
 */
public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args,
							MethodProxy proxy) throws Throwable {
		// 添加切面逻辑（advise），此处是在目标类代码执行之前，即为MethodBeforeAdviceInterceptor。
		System.out.println("before-------------");
		// 执行目标类add方法
		proxy.invokeSuper(object, args);
		// 添加切面逻辑（advise），此处是在目标类代码执行之后，即为MethodAfterAdviceInterceptor。
		System.out.println("after--------------");
		return null;
	}

}