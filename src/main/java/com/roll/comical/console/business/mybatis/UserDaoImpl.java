package com.roll.comical.console.business.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**
 * Date: 2017/11/22
 *
 * @author zongqiang.hao
 */
public class UserDaoImpl implements UserDao {
	@Override
	public List<UserBean> getList() {
		//获得会话对象
		SqlSession session = MyBatisTest.getSession();
		try {
			//通过MyBatis实现接口BookTypeDAO，返回实例
			UserDao userDao = session.getMapper(UserDao.class);
			return userDao.getList();
		} finally {
			session.close();
		}
	}

	@Override
	public UserBean getUser(int id) {
		return null;
	}

	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserBean doSomeBusinessStuff(int userId) {
		return this.userMapper.getUser(userId);
	}
}
