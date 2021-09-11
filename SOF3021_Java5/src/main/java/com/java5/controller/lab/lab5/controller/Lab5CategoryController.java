package com.java5.controller.lab.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.java5.controller.lab.lab5.entity.Lab5CategoryEntity;
import com.java5.controller.lab.lab5.repository.Lab5CategoryRepository;

@Controller
public class Lab5CategoryController {

	@Autowired
	private Lab5CategoryRepository categoryRepository;

	@GetMapping(path = { "/lab/lab5", "/lab/lab5/category" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("lab5category");
		Lab5CategoryEntity item = new Lab5CategoryEntity();
		mav.addObject("categoryItem", item);
		mav.addObject("list", categoryRepository.findAll());
		return mav;
	}

	@PostMapping("/lab/lab5/category/create")
	public RedirectView createCategory(@Validated Lab5CategoryEntity item, BindingResult result) {
		RedirectView rv = new RedirectView("/lab/lab5/category");
		if (!result.hasErrors()) {
			categoryRepository.save(item);
			rv.addStaticAttribute("success", "Success!");
		} else {
			rv.addStaticAttribute("error", "Some fields are missing!");
		}
		return rv;
	}

	@PostMapping("/lab/lab5/category")
	public RedirectView updateCategory(@Validated Lab5CategoryEntity item, BindingResult result) {
		RedirectView rv = new RedirectView("/lab/lab5/category");
		if (!result.hasErrors()) {
			categoryRepository.save(item);
			rv.addStaticAttribute("success", "Success!");
		} else {
			rv.addStaticAttribute("error", "Some fields are missing!");
		}
		return rv;
	}

	@ResponseBody
	@DeleteMapping("/lab/lab5/category")
	public void deleteCategory(@RequestBody Long id) {
		categoryRepository.deleteById(id);
	}
}
