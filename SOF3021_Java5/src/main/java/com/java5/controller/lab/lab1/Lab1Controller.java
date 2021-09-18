package com.java5.controller.lab.lab1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java5.utils.CookieUtils;

@Controller
@RequestMapping("/lab/lab1")
public class Lab1Controller {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@GetMapping
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab1");
		return mav;
	}

	@PostMapping
	public ModelAndView result() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		ModelAndView mav = new ModelAndView("lab1");
		UserDTO model = new UserDTO();
		model.setUsername(username);
		model.setPassword(password);
		if (remember != null && remember.equals("on")) {
			model.setRemember(true);
		} else {
			model.setRemember(false);
		}
		request.setAttribute("model", model);

		CookieUtils.add("user", model.getUsername(), 1, response);
		System.out.println("Username: " + CookieUtils.get("user", request));
		return mav;
	}
}
