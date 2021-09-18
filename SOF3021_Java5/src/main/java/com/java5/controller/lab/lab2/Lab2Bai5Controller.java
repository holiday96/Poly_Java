package com.java5.controller.lab.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lab/lab2")
public class Lab2Bai5Controller {

	@GetMapping("bai5")
	public String showLab() {
		return "lab2bai5";
	}
	
	@RequestMapping("bai5/b")
	public String method2(Model model) {
		model.addAttribute("message", "I come from b");
		return "forward:/lab/lab2/bai5";
	}
	
	@RequestMapping("bai5/c")
	public String method3(RedirectAttributes params) {
		params.addAttribute("message", "I come from c");
		return "redirect:/lab/lab2/bai5";
	}
	
	@ResponseBody
	@RequestMapping("bai5/d")
	public String method4() {
		return "I come from d";
	}
	
}
