package com.roll.comical.console.business.video;

/**
 * @author zongqiang.hao
 */
public class User implements Comparable<User> {

	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//实现compareTo，可以被sort排序
	@Override
	public int compareTo(User user) {
		return name.compareTo(user.getName());
	}
}
