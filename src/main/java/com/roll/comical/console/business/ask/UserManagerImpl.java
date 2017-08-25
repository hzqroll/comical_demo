package com.roll.comical.console.business.ask;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午2:02
 *
 * @author zongqiang.hao
 */
public class UserManagerImpl {
	public void addUser(String username, String password) {
		System.out.println("UserManagerImpl.addUser()...");
	}

	public void deleteUser(int id) {
		System.out.println("UserManagerImpl.deleteUser()...");
	}

	public String findUserById(int id) {
		System.out.println("UserManagerImpl.findUserById()...");
		return null;
	}

	public void modifyUser(int id, String username, String password) {
		System.out.println("UserManagerImpl.modifyUser()...");
	}
}
