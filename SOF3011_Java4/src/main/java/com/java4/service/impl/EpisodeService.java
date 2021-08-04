package com.java4.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.java4.converter.EpisodeConverter;
import com.java4.dto.EpisodeDTO;
import com.java4.entity.EpisodeEntity;
import com.java4.repository.IEpisodeRepository;
import com.java4.repository.IMovieRepository;
import com.java4.service.IEpisodeService;

public class EpisodeService implements IEpisodeService {

	@Inject
	private IEpisodeRepository episodeRepository;
	@Inject IMovieRepository movieRepository;

	@Override
	public List<EpisodeDTO> findAll() {
		List<EpisodeDTO> dtos = new ArrayList<EpisodeDTO>();
		List<EpisodeEntity> entities = episodeRepository.findAll();
		for (EpisodeEntity item : entities) {
			EpisodeDTO EpisodeDTO = EpisodeConverter.toDto(item);
			dtos.add(EpisodeDTO);
		}
		return dtos;
	}

	@Override
	public EpisodeDTO findOne(Long id) {
		return EpisodeConverter.toDto(episodeRepository.findOne(id));
	}

	@Override
	public EpisodeDTO save(EpisodeDTO dto) {
		Long id = episodeRepository.save(EpisodeConverter.toEntity(dto));
		return EpisodeConverter.toDto(episodeRepository.findOne(id));
	}

	@Override
	public EpisodeDTO update(EpisodeDTO dto) {
		episodeRepository.update(EpisodeConverter.toEntity(dto));
		return EpisodeConverter.toDto(episodeRepository.findOne(dto.getId()));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			episodeRepository.delete(id);
		}
	}

	@Override
	public List<EpisodeDTO> findByMovieID(Long movieId) {
		List<EpisodeDTO> dtos = new ArrayList<EpisodeDTO>();
		List<EpisodeEntity> entities = episodeRepository.findByMovieID(movieRepository.findOne(movieId));
		for (EpisodeEntity item : entities) {
			EpisodeDTO EpisodeDTO = EpisodeConverter.toDto(item);
			dtos.add(EpisodeDTO);
		}
		return dtos;
	}

}
