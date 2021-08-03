package com.java4.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.java4.converter.UserConverter;
import com.java4.dto.MovieDTO;
import com.java4.dto.UserDTO;
import com.java4.entity.UserEntity;
import com.java4.repository.IUserRepository;
import com.java4.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserRepository userRepository;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item : entities) {
			UserDTO UserDTO = UserConverter.toAllDTO(item);
			dtos.add(UserDTO);
		}
		return dtos;
	}

	@Override
	public UserDTO findOne(Long id) {
		return UserConverter.toAllDTO(userRepository.findOne(id));
	}

	@Override
	public UserDTO save(UserDTO dto) {
		Long id = userRepository.save(UserConverter.toAllEntity(dto));
		return UserConverter.toAllDTO(userRepository.findOne(id));
	}

	@Override
	public UserDTO update(UserDTO dto) {
		userRepository.update(UserConverter.toAllEntity(dto));
		return UserConverter.toAllDTO(userRepository.findOne(dto.getId()));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			userRepository.delete(id);
		}
	}

	@Override
	public boolean findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Long[] getIdsMovieByUserID(Long id) {
		List<MovieDTO> list = new ArrayList<>();
		findOne(id).getMovies().forEach(i -> list.add(i));
		Long[] idsMovie = new Long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			idsMovie[i] = list.get(i).getId();
		}
		return idsMovie;
	}

}
