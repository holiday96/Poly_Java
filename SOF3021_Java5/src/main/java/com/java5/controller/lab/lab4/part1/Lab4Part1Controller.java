package com.java5.controller.lab.lab4.part1;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab4Part1Controller {

	@Autowired
	private CookieService cookieService;

	@Autowired
	private ParamService paramService;

	@Autowired
	private SessionService sessionService;

	@GetMapping(path = { "/lab/lab4", "/lab/lab4/part1" })
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab4part1");
		return mav;
	}

	@PostMapping(path = { "/lab/lab4/part1" })
	public ModelAndView login(@RequestParam(name = "photo") MultipartFile multipartFile) {
		ModelAndView mav = new ModelAndView("lab4part1");
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		boolean remember = paramService.getBoolean("remember", false);

		if (username.equals("poly") && password.equals("123")) {
			sessionService.set("username", username);
			if (remember) {
				cookieService.add("user", username, 10 * 24);
			} else {
				cookieService.remove("user");
			}
			File file = paramService.save(multipartFile, "/files");
			mav.addObject("imageURL", "/files/" + file.getName());
			mav.addObject("message", "Login Success!");
			mav.addObject("result", "OK");
		} else {
			mav.addObject("message", "Login Failed!");
		}
		return mav;
	}
}
