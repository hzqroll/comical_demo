package com.roll.comical.console.business.jvm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Date: 2017/11/10
 *
 * @author zongqiang.hao
 */
public class RuntimeConstantPoolTest {
	public static void main(String[] args) {
		/*//无法复现,1.6以后
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}*/

		//while (true) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(OOMObject.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("start");
				Object object = methodProxy.invokeSuper(o, args);
				System.out.println("end");
				return object;
			}
		});
		enhancer.create();
		//}
	}

	static class OOMObject {
		static {
			System.out.println("1");
		}
	}

	private void test() {
		System.out.println("1");
	}
}
