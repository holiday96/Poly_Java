package com.java5.controller.lab.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;
import com.java5.controller.lab.lab5.entity.Lab5ReportEntity;
import com.java5.controller.lab.lab5.repository.Lab5ProductRepository;

@Controller
public class Lab6ReportController {

	@Autowired
	private Lab5ProductRepository productRepository;

	@GetMapping(path = { "/lab/lab6/product/report" })
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page,
							  @RequestParam(defaultValue = "5") Integer limit) {
		ModelAndView mav = new ModelAndView("lab6report");
		Pageable pageable = PageRequest.of(page - 1, limit);
		Page<Lab5ReportEntity> pages = productRepository.getInventoryByCategory(pageable);
		Lab5ProductDTO item = new Lab5ProductDTO();
		item.setPage(page);
		item.setTotalPage(pages.getTotalPages());
		mav.addObject("list", pages.getContent());
		mav.addObject("item", item);
		return mav;
	}
}
