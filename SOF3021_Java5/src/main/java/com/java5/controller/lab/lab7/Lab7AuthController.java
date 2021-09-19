package com.java5.controller.lab.lab7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.java5.controller.lab.lab4.part1.CookieService;
import com.java5.controller.lab.lab4.part1.SessionService;
import com.java5.controller.lab.lab5.entity.Lab5AccountEntity;
import com.java5.controller.lab.lab5.repository.Lab5AccountRepository;

@Controller
@RequestMapping("/lab/lab7")
public class Lab7AuthController {

	@Autowired
	private Lab5AccountRepository accountRepository;

	@Autowired
	private SessionService session;

	@Autowired
	private CookieService cookie;

	@GetMapping(path = { "auth", "account/login" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("lab7auth");
		return mav;
	}

	@PostMapping("account/login")
	public ModelAndView login(Lab5AccountEntity user,
			@RequestParam(name = "remember", required = false) String remember) {
		ModelAndView mav = new ModelAndView("lab7auth");
		List<Lab5AccountEntity> account = new ArrayList<>();
		account = accountRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (!account.isEmpty()) {
			session.set("user", account.get(0));
			mav.addObject("user", account.get(0));

			if (remember != null) {
				cookie.add("username", account.get(0).getUsername(), 72);
				cookie.add("password", account.get(0).getPassword(), 72);
			} else {
				cookie.remove("username");
				cookie.remove("password");
			}
		} else {
			mav.addObject("message", "Username or Password incorrect!");
		}
		return mav;
	}

	@GetMapping("account/{option}")
	public ModelAndView editAccount(@PathVariable String option) {
		ModelAndView mav = new ModelAndView("lab7auth");
		if (option.equals("edit")) {
			mav.addObject("content", "🛠 Edit Account here! 🛠");
		} else if (option.equals("chgpwd")) {
			mav.addObject("content", "🔏 Change Password Account here! 🔏");
		}
		return mav;
	}

	@GetMapping("oder")
	public ModelAndView oder() {
		ModelAndView mav = new ModelAndView("lab7auth");
		mav.addObject("content", "🛒 Oder ready to go! 🛒");
		return mav;
	}

	@GetMapping("admin/**")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("lab7auth");
		mav.addObject("content", "🎨 Admin anything! 🎨");
		return mav;
	}

	@GetMapping("admin/home/index")
	public ModelAndView indexAdmin() {
		ModelAndView mav = new ModelAndView("lab7auth");
		mav.addObject("content", "🏠 Admin Home 🏡");
		return mav;
	}
	
	@GetMapping("logout")
	public RedirectView logout() {
		RedirectView rv = new RedirectView("account/login");
		session.remove("user");
		return rv;
	}
}
