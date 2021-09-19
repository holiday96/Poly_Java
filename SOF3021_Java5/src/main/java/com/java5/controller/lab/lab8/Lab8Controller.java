package com.java5.controller.lab.lab8;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.java5.controller.lab.lab4.part1.CookieService;

@Controller
public class Lab8Controller {
	
	@Autowired
	private CookieService cookieService;

	@GetMapping(path = { "/lab/lab8", "/lab/lab8/{path}" })
	public ModelAndView index(@PathVariable(required = false) String path) {
		ModelAndView mav = new ModelAndView("lab8");
		ResourceBundle resourceBundle = null;
		String lang = cookieService.getValue(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME);
		if (lang.equals("vi")) {
			resourceBundle = ResourceBundle.getBundle("i18n/home_vi");
		} else if (lang.equals("en")){
			resourceBundle = ResourceBundle.getBundle("i18n/home");
		}
		if (path != null) {
			if (path.contains("about")) {
				mav.addObject("body", resourceBundle.getString("about.title"));
			} else if (path.contains("contact")) {
				mav.addObject("body", resourceBundle.getString("contact.title"));
			} else if (path.contains("feedback")) {
				mav.addObject("body", resourceBundle.getString("feedback.title"));
			} else if (path.contains("q&a")) {
				mav.addObject("body", resourceBundle.getString("qa.title"));
			}
		} else {
			mav.addObject("body", resourceBundle.getString("home.title"));
		}
		return mav;
	}

}
