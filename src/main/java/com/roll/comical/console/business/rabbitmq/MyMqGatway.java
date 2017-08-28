package com.roll.comical.console.business.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
public class MyMqGatway {
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendDataToCrQueue(Object obj) {
		amqpTemplate.convertAndSend("queue_one_key", obj);
	}
}
