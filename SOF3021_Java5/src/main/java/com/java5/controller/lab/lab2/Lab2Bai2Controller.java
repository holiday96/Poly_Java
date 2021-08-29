package com.java5.controller.lab.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab2Bai2Controller {

	@GetMapping("/lab/lab2/bai2")
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab2bai2");
		return mav;
	}
	
	@PostMapping("/lab/lab2/bai2/{y}")
	public ModelAndView result(@RequestParam String x, @PathVariable String y) {
		ModelAndView mav = new ModelAndView("lab2bai2");
		mav.addObject("x", x);
		mav.addObject("y", y);
		return mav;
	}
	
}
