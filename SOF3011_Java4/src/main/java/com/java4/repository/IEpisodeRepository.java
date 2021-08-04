package com.java4.repository;

import java.util.List;

import com.java4.entity.EpisodeEntity;
import com.java4.entity.MovieEntity;

public interface IEpisodeRepository {

	List<EpisodeEntity> findAll();
	EpisodeEntity findOne(Long id);
	Long save(EpisodeEntity entity);
	void update(EpisodeEntity entity);
	void delete(Long id);
	List<EpisodeEntity> findByMovieID(MovieEntity entity); 
}
