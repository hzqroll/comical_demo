package com.roll.comical.console.business.mybatis;

import org.apache.ibatis.annotations.Select;

/**
 * Date: 2017/11/23
 *
 * @author zongqiang.hao
 */
public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{id}")
	public UserBean getUser(int id);
}
