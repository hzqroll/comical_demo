package com.roll.comical.console.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author micah.shi
 */
@Controller
@RequestMapping("/index")
public class IndexController extends AbstractController {
	@RequestMapping
	public String info(
			Model model,
			@RequestParam(value = "day", required = false, defaultValue = "7") int day,
			@RequestParam(value = "provinceId", required = false, defaultValue = "110000") int provinceId
	) {
		return "index";
	}
}
