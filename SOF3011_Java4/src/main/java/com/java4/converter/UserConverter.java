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

	public static UserEntity toListEntity(UserEntity entity, UserDTO dto) {
		dto.getMovies().forEach(i -> entity.getMovies().add(MovieConverter.toEntity(i)));
		return entity;
	}

	public static UserDTO toListDTO(UserDTO dto, UserEntity entity) {
		entity.getMovies().forEach(i -> dto.getMovies().add(MovieConverter.toDto(i)));
		return dto;
	}

	public static UserEntity toAllEntity(UserDTO dto) {
		UserEntity entity = UserConverter.toEntity(dto);
		entity = UserConverter.toListEntity(entity, dto);
		return entity;
	}

	public static UserDTO toAllDTO(UserEntity entity) {
		UserDTO dto = UserConverter.toDto(entity);
		dto = UserConverter.toListDTO(dto, entity);
		return dto;
	}
}
