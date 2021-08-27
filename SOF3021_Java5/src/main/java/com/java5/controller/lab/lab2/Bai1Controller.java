package com.java5.controller.lab.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bai1Controller {

	@GetMapping(path = {"/lab/lab2", "/lab/lab2/bai1"})
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		return mav;
	}
	
	@PostMapping("/lab/lab2/bai1/ok")
	public ModelAndView method1() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 1");
		return mav;
	}
	
	@GetMapping("/lab/lab2/bai1/ok")
	public ModelAndView method2() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 2");
		return mav;
	}
	
	@PostMapping("/lab/lab2/bai1/ok3")
	public ModelAndView method3() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 3");
		return mav;
	}
}
