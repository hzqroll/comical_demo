package com.roll.comical.console.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author micah.shi
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/index")
	public String play(
	) {
		return "test";
	}
}
