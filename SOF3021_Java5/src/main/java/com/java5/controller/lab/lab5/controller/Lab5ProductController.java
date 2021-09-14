package com.java5.controller.lab.lab5.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java5.controller.lab.lab4.part1.ParamService;
import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;
import com.java5.controller.lab.lab5.repository.Lab5CategoryRepository;
import com.java5.controller.lab.lab5.service.ILab5ProductService;

@Controller
public class Lab5ProductController {

	@Autowired
	private ParamService paramService;

	@Autowired
	private ILab5ProductService productService;

	@Autowired
	private Lab5CategoryRepository categoryRepository;

	@GetMapping(path = { "/lab/lab5/product" })
	public ModelAndView index(@RequestParam(name = "field", required = false) Optional<String> field,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "desc") String direction) {
		ModelAndView mav = new ModelAndView("lab5product");
		Lab5ProductDTO item = new Lab5ProductDTO();
		item.setPage(page);
		Sort sort = null;
		Pageable pageable;
		if (!field.isEmpty()) {
			sort = Sort.by(Direction.fromString(direction), field.orElse("price"));
			pageable = PageRequest.of(page - 1, limit, sort);
		} else {
			pageable = PageRequest.of(page - 1, limit);
		}
		item.setListResult(productService.findAll(pageable));
		item.setTotalPage((int) Math.ceil((double) productService.totalItem() / limit));
		mav.addObject("productItem", item);
		mav.addObject("categories", categoryRepository.findAll());
		return mav;
	}

	@ResponseBody
	@PostMapping("/lab/lab5/product")
	public Lab5ProductDTO createProduct(@RequestBody Lab5ProductDTO item) {
		List<Lab5ProductDTO> list = productService.findAll();
		for (Lab5ProductDTO i : list) {
			if (item.getName().equals(i.getName())) {
				return null;
			}
		}
		item.setCategory(categoryRepository.findOneByCode(item.getCategoryCode()));
		if (!item.getImageURL().isBlank()) {
			File file = paramService.save(item.getImageURL(), "/files", item.getName());
			item.setImageURL("/files/" + file.getName());
		}
		return productService.save(item);
	}

	@GetMapping("/lab/lab5/product/{id}")
	public ModelAndView updateProduct(@PathVariable Long id, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer limit) {
		ModelAndView mav = new ModelAndView("lab5product");
		Pageable pageable = PageRequest.of(page - 1, limit);
		Lab5ProductDTO item = productService.findOne(id);
		item.setPage(page);
		item.setListResult(productService.findAll(pageable));
		item.setTotalPage((int) Math.ceil((double) productService.totalItem() / limit));
		mav.addObject("productItem", item);
		mav.addObject("categories", categoryRepository.findAll());
		return mav;
	}

	@ResponseBody
	@PutMapping("/lab/lab5/product")
	public Lab5ProductDTO editProduct(@RequestBody Lab5ProductDTO item) {
		item.setCategory(categoryRepository.findOneByCode(item.getCategoryCode()));
		if (item.getImageURL() != null && item.getImageURL().contains("base64")) {
			File file = paramService.save(item.getImageURL(), "/files", item.getName());
			item.setImageURL("/files/" + file.getName());
		}
		return productService.save(item);
	}

	@ResponseBody
	@DeleteMapping("/lab/lab5/product")
	public void deleteProduct(@RequestBody Long id) {
		productService.delete(id);
	}
}
