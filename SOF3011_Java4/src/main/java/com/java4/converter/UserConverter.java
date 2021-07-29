package com.java4.converter;

import com.java4.dto.UserDTO;
import com.java4.entity.UserEntity;

public class UserConverter {

	public static UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUsername(entity.getUsername());
		result.setPassword(entity.getPassword());
		result.setFullname(entity.getFullname());
		result.setEmail(entity.getEmail());
		result.setRole(entity.isRole());
		result.setStatus(entity.isStatus());
		result.setVerify(entity.getVerify());
		return result;
	}

	public static UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setId(dto.getId());
		result.setUsername(dto.getUsername());
		result.setPassword(dto.getPassword());
		result.setFullname(dto.getFullname());
		result.setEmail(dto.getEmail());
		result.setRole(dto.isRole());
		result.setStatus(dto.isStatus());
		result.setVerify(dto.getVerify());
		return result;
	}
}
