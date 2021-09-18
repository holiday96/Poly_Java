package com.java5.controller.lab.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lab/lab2")
public class Lab2Bai3Controller {

	@GetMapping("bai3")
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab2bai3");
		return mav;
	}
	
	@PostMapping("bai3/save")
	public ModelAndView createProduct(@RequestParam String name, @RequestParam Long price) {
		ModelAndView mav = new ModelAndView("lab2bai3");
		mav.addObject("product", new Product(name, price));
		return mav;
	}
}
