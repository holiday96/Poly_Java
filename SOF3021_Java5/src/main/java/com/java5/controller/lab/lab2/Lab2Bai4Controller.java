package com.java5.controller.lab.lab2;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bai4Controller {

	@GetMapping("/lab/lab2/bai4")
	public ModelAndView showLab() {
		ModelAndView mav = new ModelAndView("lab2bai4");
		Product p = new Product("iPhone XXS", 10000l);
		mav.addObject("p", p);
		return mav;
	}
	
	@PostMapping("/lab/lab2/bai4")
	public ModelAndView createProduct(Product product) {
		ModelAndView mav = new ModelAndView("lab2bai4");
		mav.addObject("product", new Product(product.getName(), product.getPrice()));
		return mav;
	}
	
	@ModelAttribute("list")
	public List<Product> getProducts(){
		return Arrays.asList(new Product("A", 1l), new Product("B", 12l));
	}
}
