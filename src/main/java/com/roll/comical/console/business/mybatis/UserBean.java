package com.roll.comical.console.business.mybatis;

/**
 * Date: 2017/11/22
 *
 * @author zongqiang.hao
 */
public class UserBean {
	/**
	 * id
	 */
	private int id;
	/**
	 * 性别：male female
	 */
	private int sex;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserBean [" +
				"id=" + id +
				", sex=" + sex +
				", name='" + name + '\'' +
				", age=" + age +
				"]";
	}
}
