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
}
