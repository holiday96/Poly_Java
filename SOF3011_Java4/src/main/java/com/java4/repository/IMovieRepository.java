package com.java4.repository;

import java.util.List;

import com.java4.entity.MovieEntity;

public interface IMovieRepository {

	List<MovieEntity> findAll();
	MovieEntity findOne(Long id);
	Long save(MovieEntity entity);
	void update(MovieEntity entity);
	void delete(Long id);
	List<MovieEntity> findByTitle(String title);
}
