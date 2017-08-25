package com.roll.comical.console.business.ask;

import java.util.Date;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 上午10:01
 *
 * @author zongqiang.hao
 */
public class Ask {
	private static boolean b;
	private static int count = 0;

	public static void main(String[] args) {
		new Thread(() -> {
			while (true) {
				count++;

				if (b == !b) {
					System.out.println("1b:" + b);
					System.out.println(new Date() + ":" + count);
				}
			}
		}).start();
		new Thread(() -> {
			while (true) {
				b = !b;
				//System.out.println("2b:" + b);
			}
		}
		).start();
	}
}
	/*上面这段代码，第一个线程比较b和!b，第二个线程不断改变b的值，
	讲道理的话，如果“取出第一个b”和“取出第二个b”这两个行为发生
	在第二个线程改变b之前和之后，这时候b==!b条件是成立的。
	这个程序会不断地输出count的值，
	但是事实上，这段代码在输出一段时间之后，就不会输出了，
	也就意味着这段代码只有一开始的时候会发生 b==!b这样的事情，
	后来这件事情就再也不发生了，
	本人对此感到不解，请各位大佬解惑。
	另外，如果把b修饰为volatile ，那么就会一直输出下去。*/

