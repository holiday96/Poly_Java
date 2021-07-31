package com.java4.converter;

import com.java4.dto.ThemeDTO;
import com.java4.entity.ThemeEntity;

public class ThemeConverter {

	public static ThemeDTO toDto(ThemeEntity entity) {
		ThemeDTO result = new ThemeDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		return result;
	}

	public static ThemeEntity toEntity(ThemeDTO dto) {
		ThemeEntity result = new ThemeEntity();
		result.setId(dto.getId());
		result.setName(dto.getName());
		return result;
	}

	public static ThemeEntity toListEntity(ThemeEntity entity, ThemeDTO dto) {
		dto.getMovies().forEach(i -> entity.getMovies().add(MovieConverter.toEntity(i)));
		return entity;
	}

	public static ThemeDTO toListDTO(ThemeDTO dto, ThemeEntity entity) {
		entity.getMovies().forEach(i -> dto.getMovies().add(MovieConverter.toDto(i)));
		return dto;
	}

	public static ThemeEntity toAllEntity(ThemeDTO dto) {
		ThemeEntity entity = ThemeConverter.toEntity(dto);
		entity = ThemeConverter.toListEntity(entity, dto);
		return entity;
	}

	public static ThemeDTO toAllDTO(ThemeEntity entity) {
		ThemeDTO dto = ThemeConverter.toDto(entity);
		dto = ThemeConverter.toListDTO(dto, entity);
		return dto;
	}
}
