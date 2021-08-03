package com.java4.service;

import java.util.List;

import com.java4.dto.UserDTO;

public interface IUserService {

	List<UserDTO> findAll();
	UserDTO findOne(Long id);
	UserDTO save(UserDTO dto);
	UserDTO update(UserDTO dto);
	void delete(Long[] ids);
	boolean findByEmail(String email);
	boolean findByUsername(String username);
	Long[] getIdsMovieByUserID(Long id);
}
