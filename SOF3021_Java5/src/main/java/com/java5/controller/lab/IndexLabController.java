package com.java5.controller.lab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexLabController {

	@GetMapping("/lab")
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab");
		return mav;
	}
}
