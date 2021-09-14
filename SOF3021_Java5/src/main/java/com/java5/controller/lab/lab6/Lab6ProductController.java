package com.java5.controller.lab.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java5.controller.lab.lab4.part1.SessionService;
import com.java5.controller.lab.lab5.converter.Lab5ProductConverter;
import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;
import com.java5.controller.lab.lab5.entity.Lab5ProductEntity;
import com.java5.controller.lab.lab5.repository.Lab5ProductRepository;
import com.java5.controller.lab.lab5.service.ILab5ProductService;

@Controller
public class Lab6ProductController {

	@Autowired
	private SessionService session;

	@Autowired
	private Lab5ProductRepository productRepository;

	@Autowired
	private ILab5ProductService productService;

	@GetMapping(path = { "/lab/lab6", "/lab/lab6/product" })
	public ModelAndView index(@RequestParam(name = "field", required = false) Optional<String> field,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "desc") String direction) {
		Sort sort = null;
		Pageable pageable;
		
		ModelAndView mav = new ModelAndView("lab6search");
		Lab5ProductDTO item = new Lab5ProductDTO();
		item.setPage(page);
		if (!field.isEmpty()) {
			sort = Sort.by(Direction.fromString(direction), field.orElse("price"));
			pageable = PageRequest.of(page - 1, limit, sort);
		} else {
			pageable = PageRequest.of(page - 1, limit);
		}
		item.setListResult(productService.findAll(pageable));
		item.setTotalPage((int) Math.ceil((double) productService.totalItem() / limit));
		mav.addObject("productItem", item);
		return mav;
	}

	@GetMapping(path = { "/lab/lab6/product/search" })
	public ModelAndView search(@RequestParam Optional<Integer> page, @RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(required = false) Double min, @RequestParam(required = false) Double max,
			@RequestParam Optional<String> name) {
		Pageable pageable;
		Page<Lab5ProductEntity> pages = null;
		
		ModelAndView mav = new ModelAndView("lab6search");
		Lab5ProductDTO item = new Lab5ProductDTO();
		item.setPage(page.orElse(1));
		pageable = PageRequest.of(page.orElse(1) - 1, limit);
		if (name != null) {
			session.set("name", name);
			pages = productRepository.findByNameContaining(name.orElse(session.get("name").toString()), pageable);
		}
		if (min != null && max == null) {
			pages = productRepository.findByPriceGreaterThanEqual(min, pageable);
		}
		if (min == null && max != null) {
			pages = productRepository.findByPriceLessThanEqual(max, pageable);
		}
		if (min != null && max != null) {
			pages = productRepository.findByPriceBetween(min, max, pageable);
		}
		List<Lab5ProductDTO> listResult = new ArrayList<>();
		pages.forEach(e -> listResult.add(Lab5ProductConverter.toDto(e)));
		item.setListResult(listResult);

		item.setTotalPage(pages.getTotalPages());
		mav.addObject("productItem", item);
		return mav;
	}

	@GetMapping("/lab/lab6/product/{id}")
	public ModelAndView updateProduct(@PathVariable Long id, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer limit) {
		ModelAndView mav = new ModelAndView("lab5product");
		Pageable pageable = PageRequest.of(page - 1, limit);
		Lab5ProductDTO item = productService.findOne(id);
		item.setPage(page);
		item.setListResult(productService.findAll(pageable));
		item.setTotalPage((int) Math.ceil((double) productService.totalItem() / limit));
		mav.addObject("productItem", item);
		return mav;
	}
}
