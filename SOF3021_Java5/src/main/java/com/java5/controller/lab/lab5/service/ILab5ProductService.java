package com.java5.controller.lab.lab5.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;

public interface ILab5ProductService {

	List<Lab5ProductDTO> findAll();
	List<Lab5ProductDTO> findAll(Pageable page);
	Lab5ProductDTO save(Lab5ProductDTO dto);
	void delete(Long id);
	Lab5ProductDTO findOne(Long id);
	int totalItem();
}
