package com.java4.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.java4.converter.CategoryConverter;
import com.java4.dto.CategoryDTO;
import com.java4.entity.CategoryEntity;
import com.java4.repository.ICategoryRepository;
import com.java4.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			CategoryDTO CategoryDTO = CategoryConverter.toDto(item);
			dtos.add(CategoryDTO);
		}
		return dtos;
	}

	@Override
	public CategoryDTO findOne(Long id) {
		return CategoryConverter.toDto(categoryRepository.findOne(id));
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		Long id = categoryRepository.save(CategoryConverter.toEntity(dto));
		return CategoryConverter.toDto(categoryRepository.findOne(id));
	}

	@Override
	public CategoryDTO update(CategoryDTO dto) {
		categoryRepository.update(CategoryConverter.toEntity(dto));
		return CategoryConverter.toDto(categoryRepository.findOne(dto.getId()));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			categoryRepository.delete(id);
		}
	}

}
