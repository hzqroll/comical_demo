package com.roll.comical.console.business.rabbitmq;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
public interface MQProducer {
	/**
	 * 发送消息到指定队列
	 *
	 * @param queueKey
	 * @param object
	 */
	public void sendDataToQueue(String queueKey, Object object);
}
