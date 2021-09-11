package com.java5.controller.lab.lab5.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java5.controller.lab.lab5.converter.Lab5ProductConverter;
import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;
import com.java5.controller.lab.lab5.entity.Lab5ProductEntity;
import com.java5.controller.lab.lab5.repository.Lab5ProductRepository;
import com.java5.controller.lab.lab5.service.ILab5ProductService;

@Service
public class Lab5ProductService implements ILab5ProductService {

	@Autowired
	private Lab5ProductRepository lab5ProductRepository;

	@Override
	public List<Lab5ProductDTO> findAll() {
		List<Lab5ProductDTO> list = new ArrayList<>();
		for (Lab5ProductEntity i : lab5ProductRepository.findAll()) {
			list.add(Lab5ProductConverter.toDto(i));
		}
		return list;
	}

	@Override
	public List<Lab5ProductDTO> findAll(Pageable pageable) {
		List<Lab5ProductDTO> list = new ArrayList<>();
		lab5ProductRepository.findAll(pageable).getContent()
				.forEach(item -> list.add(Lab5ProductConverter.toDto(item)));
		return list;
	}

	@Override
	public Lab5ProductDTO save(Lab5ProductDTO dto) {
		Lab5ProductEntity entity = lab5ProductRepository.save(Lab5ProductConverter.toEntity(dto));
		return Lab5ProductConverter.toDto(entity);
	}

	@Override
	public void delete(Long id) {
		lab5ProductRepository.deleteById(id);
	}

	@Override
	public Lab5ProductDTO findOne(Long id) {
		return Lab5ProductConverter.toDto(lab5ProductRepository.getById(id));
	}

	@Override
	public int totalItem() {
		return (int) lab5ProductRepository.count();
	}

}
