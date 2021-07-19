package com.java4.controller.lab.lab5;

import java.util.ArrayList;
import java.util.List;

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
	
	public UserDTO findOne(String username, String password) {
		return UserConverter.toDto(userRepository.findOne(username, password));
	}
	
	public UserDTO findById(String id) {
		return UserConverter.toDto(userRepository.findById(id)); 
	}
	
	public List<UserDTO> findPage(int page, int size) {
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity i : userRepository.findPage(page, size)) {
			list.add(UserConverter.toDto(i));
		}
		return list;
	}
}
