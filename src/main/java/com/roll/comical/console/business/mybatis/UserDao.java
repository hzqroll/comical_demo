package com.roll.comical.console.business.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * Date: 2017/11/22
 *
 * @author zongqiang.hao
 */
public interface UserDao {
	public List<UserBean> getList();

	@Select("SELECT * FROM comical.user WHERE id = #{id}")
	public UserBean getUser(int id);
}
