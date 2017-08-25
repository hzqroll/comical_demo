package com.roll.comical.console.business.video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: roll
 * Date: 2017/2/7
 * Time: 下午2:12
 *
 * @author zongqiang.hao
 */
public class TestComparable {

	public static void main(String args[]){
		List<User> userList = new ArrayList<>();
		userList.add(new User(15,"dfs"));
		userList.add(new User(12,"dgds"));
		userList.add(new User(31,"vds"));
		userList.add(new User(17,"rgd"));

		System.out.println(userList);

		Collections.sort(userList);

		System.out.println(userList);

	}
}
