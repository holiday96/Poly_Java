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

	public static CategoryEntity toListEntity(CategoryEntity entity, CategoryDTO dto) {
		dto.getMovies().forEach(i -> entity.getMovies().add(MovieConverter.toEntity(i)));
		return entity;
	}

	public static CategoryDTO toListDTO(CategoryDTO dto, CategoryEntity entity) {
		entity.getMovies().forEach(i -> dto.getMovies().add(MovieConverter.toDto(i)));
		return dto;
	}

	public static CategoryEntity toAllEntity(CategoryDTO dto) {
		CategoryEntity entity = CategoryConverter.toEntity(dto);
		entity = CategoryConverter.toListEntity(entity, dto);
		return entity;
	}

	public static CategoryDTO toAllDTO(CategoryEntity entity) {
		CategoryDTO dto = CategoryConverter.toDto(entity);
		dto = CategoryConverter.toListDTO(dto, entity);
		return dto;
	}
}
