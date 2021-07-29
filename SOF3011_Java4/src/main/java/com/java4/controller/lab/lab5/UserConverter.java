package com.java4.controller.lab.lab5;

import com.java4.controller.lab.lab6.entity.UserrEntity;

public class UserConverter {

	public static UserDTO toDto(UserrEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setPassword(entity.getPassword());
		result.setFullname(entity.getFullname());
		result.setEmail(entity.getEmail());
		result.setAdmin(entity.isAdmin());
		return result;
	}
	
	public static UserrEntity toEntity(UserDTO dto) {
		UserrEntity result = new UserrEntity();
		result.setId(dto.getId());
		result.setPassword(dto.getPassword());
		result.setFullname(dto.getFullname());
		result.setEmail(dto.getEmail());
		result.setAdmin(dto.isAdmin());
		return result;
	}
}
