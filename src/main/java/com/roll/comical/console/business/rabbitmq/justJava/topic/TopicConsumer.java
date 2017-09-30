package com.roll.comical.console.business.rabbitmq.justJava.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Date: 2017/9/29
 *
 * @author zongqiang.hao
 */
public class TopicConsumer {
	private static final String EXCHANGE_NAME = "exchange_topic";

	public static void main(String[] argv) throws IOException, TimeoutException {

		new ExchangeTopic("logs.info");
		new ExchangeTopic("logs.*");
		new ExchangeTopic("logs.#");
	}

	static class ExchangeTopic {
		public ExchangeTopic(final String routingKey) throws IOException, TimeoutException {
			ConnectionFactory factory = new ConnectionFactory();
			//rabbitmq监听IP
			factory.setHost("localhost");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			//声明路由名字和类型
			channel.exchangeDeclare(EXCHANGE_NAME, "topic", false, true, null);
			//队列名称
			String queueName = routingKey + ".queue";
			//创建队列
			channel.queueDeclare(queueName, false, false, true, null);
			//把队列绑定到路由上
			channel.queueBind(queueName, EXCHANGE_NAME, routingKey);

			System.out.println(" [routingKey = " + routingKey + "] Waiting for msg....");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
										   AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");

					System.out.println("[routingKey = " + routingKey + "] Received msg is '" + message + "'");
				}
			};
			channel.basicConsume(queueName, true, consumer);
		}

	}

}
