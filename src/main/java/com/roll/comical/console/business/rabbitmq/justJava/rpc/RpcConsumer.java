package com.roll.comical.console.business.rabbitmq.justJava.rpc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class RpcConsumer {
	private static final String RPC_QUEUE_NAME = "rpc_queue";

	public static void main(String[] argv) throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		//rabbitmq监听IP
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");

		Connection connection = null;
		try {
			connection = factory.newConnection();
			final Channel channel = connection.createChannel();

			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);


			System.out.println("等待接受producer消息....");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					AMQP.BasicProperties replyProps = new AMQP.BasicProperties
							.Builder()
							.correlationId(properties.getCorrelationId())
							.build();


					String response = "";
					try {
						String message = new String(body, "UTF-8");
						System.out.println("consumer 接收的消息是：" + message);

						response = handleMsg(message);

						System.out.println("consumer 发送的消息是：" + response);
					} catch (RuntimeException e) {
						e.printStackTrace();
					} finally {
						channel.basicPublish("", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}
			};
			channel.basicConsume(RPC_QUEUE_NAME, false, consumer);
		} catch (Exception e) {

			connection.close();
			e.printStackTrace();
		}
	}

	private static String handleMsg(String msg) {

		Date date = new Date();
		String response = "";
		switch (msg) {
			case "时间":
				response = new SimpleDateFormat("HH:mm").format(date);
				break;
			case "日期":
				response = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(date);
				break;
			default:
				response = "未知信息";
				break;
		}
		return response;
	}
}
