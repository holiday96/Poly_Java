package com.java5.controller.lab.lab7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lab/lab7")
public class Lab7LinkController {

	@GetMapping(path = { "link" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("lab7link");
		return mav;
	}
}
