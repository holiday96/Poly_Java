package com.java5.controller.lab.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lab/lab2")
public class Lab2Bai1Controller {

	@GetMapping(path = { "", "bai1" })
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		return mav;
	}

	@PostMapping("bai1/ok")
	public ModelAndView method1() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 1");
		return mav;
	}

	@GetMapping("bai1/ok")
	public ModelAndView method2() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 2");
		return mav;
	}

	@PostMapping("bai1/ok3")
	public ModelAndView method3() {
		ModelAndView mav = new ModelAndView("lab2bai1");
		mav.addObject("method", "Method 3");
		return mav;
	}
}
