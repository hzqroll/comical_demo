package com.roll.comical.console.business.rabbitmq.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.rabbitmq.MQProducer;
import com.roll.comical.console.business.rabbitmq.TestQueue;

/**
 * Date: 2017/8/28
 *
 * @author zongqiang.hao
 */
@Service
public class TestQueueImpl implements TestQueue{
	@Autowired
	MQProducer mqProducer;

	private static final String query_key = "queue_one_key";

	@Override
	public void send() {
		Map<String, Object> msg = new HashMap<>();
		msg.put("data", "hello,rabbmitmq!");
		mqProducer.sendDataToQueue(query_key, msg);
	}
}
