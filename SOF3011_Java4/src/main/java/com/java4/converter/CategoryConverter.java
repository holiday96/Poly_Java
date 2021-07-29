package com.java4.converter;

import com.java4.dto.CategoryDTO;
import com.java4.entity.CategoryEntity;

public class CategoryConverter {

	public static CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		return result;
	}

	public static CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setId(dto.getId());
		result.setName(dto.getName());
		return result;
	}
}
