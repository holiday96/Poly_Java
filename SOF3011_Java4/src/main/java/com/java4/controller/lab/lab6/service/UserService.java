package com.java4.controller.lab.lab6.service;

import java.util.ArrayList;
import java.util.List;

import com.java4.controller.lab.lab6.converter.UserConverter;
import com.java4.controller.lab.lab6.dto.UserDTO;
import com.java4.controller.lab.lab6.entity.UserEntity;
import com.java4.controller.lab.lab6.repository.UserRepository;

public class UserService {

	private UserRepository userRepository = new UserRepository();
	
	public String save(UserDTO dto) {
		return userRepository.save(UserConverter.toEntity(dto));
	}
	
	public void update(UserDTO dto) {
		userRepository.update(UserConverter.toEntity(dto));
	}
	
	public void delete(String id) {
		userRepository.delete(id);
	}
	
	public List<UserDTO> findAll() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity i : userRepository.findAll()) {
			list.add(UserConverter.toDto(i));
		}
		return list;
	}
	
	public List<UserDTO> findByRole(boolean role) {
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity i : userRepository.findByRole(role)) {
			list.add(UserConverter.toDto(i));
		}
		return list;
	}
	
	public List<UserDTO> findByName(String fullname) {
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity i : userRepository.findByName(fullname)) {
			list.add(UserConverter.toDto(i));
		}
		return list;
	}
	
	public UserDTO findById(String id) {
		return UserConverter.toDto(userRepository.findById(id)); 
	}
	
	public UserDTO findByEmail(String email) {
		return UserConverter.toDto(userRepository.findByEmail(email));
	}
	
	public List<UserDTO> findUsersLikeMovie(String id) {
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity i : userRepository.findUsersLikeMovie(id)) {
			list.add(UserConverter.toDto(i));
		}
		return list;
	}
}
