package com.roll.comical.console.business.ask;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 上午10:52
 *
 * @author zongqiang.hao
 */
public class Son {
	public String sonname;

	public Son(String sonname) {
		this.sonname = sonname;
	}

	public void func(Father father) {
		System.out.println(father.fathername + " is " + sonname + "'s Father.");

		father.walk();
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		Son newson = new Son("WX");
		newson.func(new Father("WHS") {
			public void walk() {
				System.out.println("I fly");
				beat();
			}

			public void beat() {
				System.out.println("I beat");
			}
		});
	}
}
