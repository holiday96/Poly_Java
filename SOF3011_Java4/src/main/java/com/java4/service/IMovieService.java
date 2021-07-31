package com.java4.service;

import java.util.List;

import com.java4.dto.MovieDTO;

public interface IMovieService {

	List<MovieDTO> findAll();
	MovieDTO findOne(Long id);
	MovieDTO save(MovieDTO dto);
	MovieDTO update(MovieDTO dto);
	void delete(Long[] ids);
}
