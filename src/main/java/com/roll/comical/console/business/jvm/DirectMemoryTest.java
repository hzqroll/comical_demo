package com.roll.comical.console.business.jvm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Date: 2017/11/10
 *
 * @author zongqiang.hao
 */
public class DirectMemoryTest {
	private static final int _1MB = 1024 * 1024;

	//代码清淡超过了DirectByteBuffer类,直接通过反射获取unsafe示例进行内存分配
	//
	public static void main(String[] args) throws IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}
}
