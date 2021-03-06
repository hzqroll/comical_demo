package com.roll.comical.console.business.rabbitmq.justJava.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Date: 2017/9/29
 *
 * @author zongqiang.hao
 */
public class TopicProducer {

	private static final String EXCHANGE_NAME = "exchange_topic";

	public static void main(String[] argv) throws Exception {
		TopicConsumer topicConsumer = new TopicConsumer();
		topicConsumer.start();
		new ExchangeTopic("logs.info", "logs Info test ！！");
		new ExchangeTopic("logs.error", "logs error test ！！");
		new ExchangeTopic("logs.error.toc", "logs error toc test ！！");
	}

	static class ExchangeTopic {
		public ExchangeTopic(String routingKey, String message) throws IOException, TimeoutException {
			ConnectionFactory factory = new ConnectionFactory();
			//rabbitmq监听IP
			factory.setHost("localhost");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			//声明路由名字和类型
			channel.exchangeDeclare(EXCHANGE_NAME, "topic", false, false, null);

			channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
			System.out.println("[routingKey = " + routingKey + "] Sent msg is '" + message + "'");

			channel.close();
			connection.close();

		}
	}

}
