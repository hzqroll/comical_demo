package com.roll.comical.console.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roll.comical.console.business.rabbitmq.TestQueue;

/**
 * @author micah.shi
 */

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestQueue testQueue;

	@RequestMapping(value = "/pets")
	public String findPet(@RequestBody String id) {
		//List<ListJobResponse.Job> a = aliYunService.listJobResponse(new Date());
		testQueue.send();
		return "index";
	}

	private Environment environment;

	@RequestMapping("/")
	public void setEnvironment(Environment enviroment1) {
		this.environment = enviroment1;
	}

}
