package com.roll.comical.console.business.mybatis.impl;

import com.roll.comical.console.business.mybatis.UserBean;
import com.roll.comical.console.business.mybatis.UserMapper;

/**
 * Date: 2017/11/23
 *
 * @author zongqiang.hao
 */
public class UserMapperImpl implements UserMapper {

	public UserBean doSomeBusinessStuff(int userId) {
		UserMapper userMapper = new UserMapperImpl();
		return userMapper.getUser(1);
	}

	@Override
	public UserBean getUser(int id) {
		return new UserBean();
	}
}
