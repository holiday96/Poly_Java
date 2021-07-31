package com.java4.converter;

import com.java4.dto.EpisodeDTO;
import com.java4.entity.EpisodeEntity;
import com.java4.repository.IMovieRepository;
import com.java4.repository.impl.MovieRepository;

public class EpisodeConverter {

	private static IMovieRepository movieRepository = new MovieRepository();
	
	public static EpisodeDTO toDto(EpisodeEntity entity) {
		EpisodeDTO result = new EpisodeDTO();
		result.setId(entity.getId());
		result.setNumber(entity.getNumber());
		result.setMovieid(entity.getMovie().getId());
		result.setLink(entity.getLink());
		return result;
	}
	
	public static EpisodeEntity toEntity(EpisodeDTO dto) {
		EpisodeEntity result = new EpisodeEntity();
		result.setId(dto.getId());
		result.setNumber(dto.getNumber());
		result.setMovie(movieRepository.findOne(dto.getMovieid()));
		result.setLink(dto.getLink());
		return result;
	}
}
