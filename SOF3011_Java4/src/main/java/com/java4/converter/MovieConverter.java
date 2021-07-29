package com.java4.converter;

import com.java4.dto.MovieDTO;
import com.java4.entity.MovieEntity;

public class MovieConverter {

	public static MovieDTO toDto(MovieEntity entity) {
		MovieDTO result = new MovieDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setDescription(entity.getDescription());
		result.setDirector(entity.getDirector());
		result.setActors(entity.getActors());
		result.setProducer(entity.getProducer());
		result.setCountry(entity.getCountry());
		result.setRuntime(entity.getRuntime());
		result.setRelease(entity.getRelease());
		result.setView(entity.getView());
		result.setLike(entity.getLike());
		result.setTrailer(entity.getTrailer());
		result.setBanner(entity.getBanner());
		result.setPoster(entity.getPoster());
		return result;
	}

	public static MovieEntity toEntity(MovieDTO dto) {
		MovieEntity result = new MovieEntity();
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		result.setDirector(dto.getDirector());
		result.setActors(dto.getActors());
		result.setProducer(dto.getProducer());
		result.setCountry(dto.getCountry());
		result.setRuntime(dto.getRuntime());
		result.setRelease(dto.getRelease());
		result.setView(dto.getView());
		result.setLike(dto.getLike());
		result.setTrailer(dto.getTrailer());
		result.setBanner(dto.getBanner());
		result.setPoster(dto.getPoster());
		return result;
	}
}
