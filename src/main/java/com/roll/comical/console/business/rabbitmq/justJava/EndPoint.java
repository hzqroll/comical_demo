package com.roll.comical.console.business.rabbitmq.justJava;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Date: 2017/8/29
 *
 * @author zongqiang.hao
 */
public class EndPoint {

	protected Channel channel;
	protected Connection connection;
	protected String endPointName;

	public EndPoint(String endpointName) throws IOException {
		this.endPointName = endpointName;

		//Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		//hostname of your rabbitmq server
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");

		//getting a connection
		connection = factory.newConnection();

		//creating a channel
		channel = connection.createChannel();

		//declaring a queue for this channel. If queue does not exist,
		//it will be created on the server.
		channel.queueDeclare(endpointName, true, false, false, null);
	}


	/**
	 * 关闭channel和connection。并非必须，因为隐含是自动调用的。
	 *
	 * @throws IOException
	 */
	public void close() throws IOException {
		this.channel.close();
		this.connection.close();
	}
}
