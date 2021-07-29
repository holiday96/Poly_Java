package com.java4.converter;

import com.java4.dto.EpisodeDTO;
import com.java4.entity.EpisodeEntity;

public class EpisodeConverter {

	public static EpisodeDTO toDto(EpisodeEntity entity) {
		EpisodeDTO result = new EpisodeDTO();
		result.setNumber(entity.getNumber());
		result.setMovieid(entity.getMovie().getId());
		result.setLink(entity.getLink());
		return result;
	}
	
	public static EpisodeEntity toEntity(EpisodeDTO dto) {
		EpisodeEntity result = new EpisodeEntity();
		result.setNumber(dto.getNumber());
		result.setLink(dto.getLink());
		return result;
	}
}
