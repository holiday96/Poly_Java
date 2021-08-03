package com.java4.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Override
	public Set<MovieDTO> findByIds(Long[] ids) {
		Set<MovieDTO> dtos = new HashSet<MovieDTO>();
		for (Long id : ids) {
			dtos.add(MovieConverter.toAllDTO(movieRepository.findOne(id)));
		}
		return dtos;
	}

}
