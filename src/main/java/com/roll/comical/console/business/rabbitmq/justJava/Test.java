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
		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		Producer producer = new Producer("queue");
		for (int i = 0; i < 1000000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
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
