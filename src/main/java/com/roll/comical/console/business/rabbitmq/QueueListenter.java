package com.roll.comical.console.business.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
@Component
public class QueueListenter implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("message: " + msg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
