package com.java5.controller.lab.lab4.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Lab4Part2Controller {

	@Autowired
	private ShoppingCartService service;
	
	//Show Items
	@GetMapping(path = {"/lab/lab4/part2", "/lab/lab4/part2/items"})
	public ModelAndView showItem() {
		ModelAndView mav = new ModelAndView("lab4part2items");
		mav.addObject("items", DB.items.values());
		return mav;
	}
	
	//Show Cart
	@GetMapping("/lab/lab4/part2/cart")
	public ModelAndView showCart() {
		ModelAndView mav = new ModelAndView("lab4part2cart");
		mav.addObject("cart", service);
		return mav;
	}
	
	/**
	 *	Funtions 
	 */
	@GetMapping("/lab/lab4/part2/clear")
	public RedirectView clear() {
		RedirectView rv = new RedirectView("/lab/lab4/part2/cart");
		service.clear();
		return rv;
	}
	
	@GetMapping("/lab/lab4/part2/{id}")
	public RedirectView add(@PathVariable Integer id) {
		RedirectView rv = new RedirectView("/lab/lab4/part2/cart");
		service.add(id);
		return rv;
	}
	
	@GetMapping("/lab/lab4/part2/remove/{id}")
	public RedirectView remove(@PathVariable Integer id) {
		RedirectView rv = new RedirectView("/lab/lab4/part2/cart");
		service.remove(id);
		return rv;
	}
	
	@PostMapping("/lab/lab4/part2/update/{id}")
	public RedirectView update(@PathVariable Integer id, @RequestParam Integer quantity) {
		RedirectView rv = new RedirectView("/lab/lab4/part2/cart");
		service.update(id, quantity);
		return rv;
	}

}
