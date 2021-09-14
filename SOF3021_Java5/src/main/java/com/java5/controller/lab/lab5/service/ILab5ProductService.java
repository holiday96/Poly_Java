package com.java5.controller.lab.lab5.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;

public interface ILab5ProductService {

	List<Lab5ProductDTO> findAll();
	List<Lab5ProductDTO> findAll(Pageable page);
	List<Lab5ProductDTO> findByNameContaining(String name, Pageable pageable);
	List<Lab5ProductDTO> findByPriceGreaterThanEqual(Double price, Pageable pageable);
	List<Lab5ProductDTO> findByPriceLessThanEqual(Double price, Pageable pageable);
	List<Lab5ProductDTO> findByPriceBetween(Double min, Double max, Pageable pageable);
	Lab5ProductDTO save(Lab5ProductDTO dto);
	void delete(Long id);
	Lab5ProductDTO findOne(Long id);
	int totalItem();
}
