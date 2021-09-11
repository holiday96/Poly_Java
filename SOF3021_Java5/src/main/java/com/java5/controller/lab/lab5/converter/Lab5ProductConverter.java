package com.java5.controller.lab.lab5.converter;

import com.java5.controller.lab.lab5.dto.Lab5ProductDTO;
import com.java5.controller.lab.lab5.entity.Lab5ProductEntity;

public class Lab5ProductConverter {
	
	public static Lab5ProductDTO toDto(Lab5ProductEntity entity) {
		Lab5ProductDTO result = new Lab5ProductDTO();
		result.setId(entity.getId());
		result.setImageURL(entity.getImage());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setCreateDate(entity.getCreateDate());
		result.setCategoryCode(entity.getCategory().getCode());
		result.setAvailable(entity.getAvailable());
		return result;
	}
	
	public static Lab5ProductEntity toEntity(Lab5ProductDTO dto) {
		Lab5ProductEntity result = new Lab5ProductEntity();
		result.setId(dto.getId());
		result.setImage(dto.getImageURL());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setCreateDate(dto.getCreateDate());
		result.setCategory(dto.getCategory());
		result.setAvailable(dto.getAvailable());
		return result;
	}
}
