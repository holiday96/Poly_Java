package com.java4.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.java4.converter.MovieConverter;
import com.java4.dto.MovieDTO;
import com.java4.entity.MovieEntity;
import com.java4.repository.IMovieRepository;
import com.java4.service.IMovieService;

public class MovieService implements IMovieService {

	@Inject
	private IMovieRepository movieRepository;

	@Override
	public List<MovieDTO> findAll() {
		List<MovieDTO> dtos = new ArrayList<MovieDTO>();
		List<MovieEntity> entities = movieRepository.findAll();
		for (MovieEntity item : entities) {
			MovieDTO MovieDTO = MovieConverter.toAllDTO(item);
			dtos.add(MovieDTO);
		}
		return dtos;
	}

	@Override
	public MovieDTO findOne(Long id) {
		return MovieConverter.toAllDTO(movieRepository.findOne(id));
	}

	@Override
	public MovieDTO save(MovieDTO dto) {
		Long id = movieRepository.save(MovieConverter.toAllEntity(dto));
		return MovieConverter.toAllDTO(movieRepository.findOne(id));
	}

	@Override
	public MovieDTO update(MovieDTO dto) {
		movieRepository.update(MovieConverter.toAllEntity(dto));
		return MovieConverter.toAllDTO(movieRepository.findOne(dto.getId()));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			movieRepository.delete(id);
		}
	}

}
