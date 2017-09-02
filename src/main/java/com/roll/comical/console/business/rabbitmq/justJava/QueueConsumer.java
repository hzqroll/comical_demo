package com.roll.comical.console.business.rabbitmq.justJava;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.utils.SerializationUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * Date: 2017/8/29
 *
 * @author zongqiang.hao
 */
public class QueueConsumer extends EndPoint implements Runnable, Consumer {

	public QueueConsumer(String endpointName) throws IOException {
		super(endpointName);
	}

	@Override
	public void run() {
		try {
			//start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, true, this);
			channel.queueDeclare("", true, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
			channel.basicQos(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer " + consumerTag + " registered");
	}

	@Override
	public void handleCancelOk(String s) {

	}

	@Override
	public void handleCancel(String s) throws IOException {

	}

	@Override
	public void handleShutdownSignal(String s, ShutdownSignalException e) {

	}

	@Override
	public void handleRecoverOk(String s) {

	}

	@Override
	public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
		Map map = (HashMap) SerializationUtils.deserialize(bytes);
		System.out.println("Message Number " + map.get("message number") + " received.");
	}
}
