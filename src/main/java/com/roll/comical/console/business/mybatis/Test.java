package com.roll.comical.console.business.mybatis;

import org.junit.BeforeClass;

import com.roll.comical.console.business.mybatis.impl.UserMapperImpl;

/**
 * Date: 2017/11/22
 *
 * @author zongqiang.hao
 */
public class Test {

	private static UserDao userDao;

	@BeforeClass
	public static void beforeClass() {
		userDao = new UserDaoImpl();
	}

	@org.junit.Test
	public void testGetAllBookTypes() {
		UserMapperImpl userMapper = new UserMapperImpl();
		UserBean userBeans = userMapper.doSomeBusinessStuff(1);

		System.out.println(userBeans);
		//assertNotNull(userBeans);
	}

}
