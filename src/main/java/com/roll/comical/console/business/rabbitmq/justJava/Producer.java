package com.roll.comical.console.business.rabbitmq.justJava;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.amqp.utils.SerializationUtils;

/**
 * Date: 2017/8/29
 *
 * @author zongqiang.hao
 */
public class Producer extends EndPoint {
	public Producer(String endpointName) throws IOException {
		super(endpointName);
	}

	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
	}
}
