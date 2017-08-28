package com.roll.comical.console.business.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
public class Test {
	@Autowired
	private AsyncExecutorService asyncExecutorService;

	/*public void startTask() {
		asyncExecutorService.execute(() -> {
			//syso("run");
		});
	}*/

}
