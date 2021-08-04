package com.java4.service;

import java.util.List;

import com.java4.dto.EpisodeDTO;

public interface IEpisodeService {

	List<EpisodeDTO> findAll();
	EpisodeDTO findOne(Long id);
	EpisodeDTO save(EpisodeDTO dto);
	EpisodeDTO update(EpisodeDTO dto);
	void delete(Long[] ids);
	List<EpisodeDTO> findByMovieID(Long movieId);
}
