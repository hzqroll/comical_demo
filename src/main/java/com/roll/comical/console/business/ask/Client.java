package com.roll.comical.console.business.ask;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午2:03
 *
 * @author zongqiang.hao
 */
public class Client {
	public static void main(String[] args) {
		/*UserManager userManager = new UserManagerImpl();
		userManager.addUser("zhangsan", "111");*/
		UserManagerImpl userManager = (UserManagerImpl) new SecurityHandler().newProxy(
				new UserManagerImpl());
		userManager.addUser("zhangsan", "111");
	}
}
