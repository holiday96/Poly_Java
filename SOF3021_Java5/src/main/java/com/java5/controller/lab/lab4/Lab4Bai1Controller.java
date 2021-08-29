package com.java5.controller.lab.lab4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab4Bai1Controller {
	
	@GetMapping(path = { "/lab/lab4" })
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab4bai1");
		return mav;
	}
}
