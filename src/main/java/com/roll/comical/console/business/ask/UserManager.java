package com.roll.comical.console.business.ask;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午2:01
 *
 * @author zongqiang.hao
 */
public interface UserManager {
	public void addUser(String username, String password);

	public void deleteUser(int id);

	public void modifyUser(int id, String username, String password);

	public String findUserById(int id);
}
