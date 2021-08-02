package com.java4.service;

import java.util.List;
import java.util.Set;

import com.java4.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll();
	CategoryDTO findOne(Long id);
	CategoryDTO save(CategoryDTO dto);
	CategoryDTO update(CategoryDTO dto);
	void delete(Long[] ids);
	Set<CategoryDTO> findByIds(Long[] ids);
}
