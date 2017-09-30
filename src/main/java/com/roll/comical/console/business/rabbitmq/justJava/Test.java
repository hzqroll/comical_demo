package com.roll.comical.console.business.rabbitmq.justJava;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Date: 2017/8/29
 *
 * @author zongqiang.hao
 */
public class Test {
	public Test() throws Exception {
		QueueConsumer consumer = new QueueConsumer("queue1");
		QueueConsumer consumer2 = new QueueConsumer("queue2");
		QueueConsumer consumer3 = new QueueConsumer("queue3");
		Thread consumerThread1 = new Thread(consumer);
		Thread consumerThread2 = new Thread(consumer2);
		Thread consumerThread3 = new Thread(consumer3);
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();

		Producer producer = new Producer("queue1");
		//for (int i = 0; i < 1000; i++) {
		HashMap message = new HashMap();
		message.put("message number", "queue1 message");
		producer.sendMessage(message);
		System.out.println("Message Number " + 1 + " sent.");
		//}
	}

	/**
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		new Test();
	}
}
