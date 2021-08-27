package com.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeController {
	
	@GetMapping("/")
	public ModelAndView showAdminHome() {
		ModelAndView mav = new ModelAndView("/layouts/me.jsp");
		return mav;
	}
	
}
