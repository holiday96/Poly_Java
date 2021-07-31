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
		result.setReleaseYear(entity.getReleaseYear());
		result.setViewCount(entity.getViewCount());
		result.setLikeCount(entity.getLikeCount());
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
		result.setReleaseYear(dto.getReleaseYear());
		result.setViewCount(dto.getViewCount());
		result.setLikeCount(dto.getLikeCount());
		result.setTrailer(dto.getTrailer());
		result.setBanner(dto.getBanner());
		result.setPoster(dto.getPoster());
		return result;
	}

	public static MovieEntity toListEntity(MovieEntity entity, MovieDTO dto) {
		dto.getUsers().forEach(i -> entity.getUsers().add(UserConverter.toEntity(i)));
		dto.getCategories().forEach(i->entity.getCategories().add(CategoryConverter.toEntity(i)));
		dto.getThemes().forEach(i->entity.getThemes().add(ThemeConverter.toEntity(i)));
		return entity;
	}

	public static MovieDTO toListDTO(MovieDTO dto, MovieEntity entity) {
		entity.getUsers().forEach(i -> dto.getUsers().add(UserConverter.toDto(i)));
		entity.getCategories().forEach(i->dto.getCategories().add(CategoryConverter.toDto(i)));
		entity.getThemes().forEach(i->dto.getThemes().add(ThemeConverter.toDto(i)));
		return dto;
	}
	
	public static MovieEntity toAllEntity(MovieDTO dto) {
		MovieEntity entity = MovieConverter.toEntity(dto);
		entity = MovieConverter.toListEntity(entity, dto);
		return entity;
	}
	
	public static MovieDTO toAllDTO(MovieEntity entity) {
		MovieDTO dto = MovieConverter.toDto(entity);
		dto = MovieConverter.toListDTO(dto, entity);
		return dto;
	}
}
