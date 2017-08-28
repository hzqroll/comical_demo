package com.roll.comical.console.business.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
@Service
public class QueueOneLitener implements MessageListener {
	@Override
	public void onMessage(Message message) {
		System.out.println(" data :" + message.getBody());
	}
}
