package com.roll.comical.console.business.ask;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午2:02
 *
 * @author zongqiang.hao
 */
public class SecurityHandler implements InvocationHandler {
	private Object targetObject;

	public Object newProxy(Object targetObject) {
		this.targetObject = targetObject;
		//调用Proxy中的静态方法newProxyInstance()
		/**
		 * loader - 定义代理类的类加载器
		 * interfaces - 代理类要实现的接口列表
		 * h - 指派方法调用的调用处理程序,即SecurityHandler类
		 */
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(), this);
	}

	/**
	 * proxy - 代理实例
	 * method - 对应于在代理实例上调用的接口方法的 Method 实例。
	 * args - 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null。基本类型的参数
	 * 被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		checkSecurity();
		Object ret = null;//接收调用方法的返回值
		try {
			ret = method.invoke(targetObject, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private void checkSecurity() {
		System.out.println("SecurityHandler.checkSecurity()...");
	}
}