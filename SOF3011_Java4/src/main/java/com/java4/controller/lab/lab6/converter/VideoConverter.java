package com.java4.controller.lab.lab6.converter;

import com.java4.controller.lab.lab6.dto.VideoDTO;
import com.java4.controller.lab.lab6.entity.VideoEntity;

public class VideoConverter {
	
	public static VideoDTO toDto(VideoEntity entity) {
		VideoDTO result = new VideoDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setPoster(entity.getPoster());
		result.setDescription(entity.getDescription());
		result.setActive(entity.isActive());
		result.setViews(entity.getViews());
		return result;
	}
	
	public static VideoEntity toDto(VideoDTO dto) {
		VideoEntity result = new VideoEntity();
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setPoster(dto.getPoster());
		result.setDescription(dto.getDescription());
		result.setActive(dto.isActive());
		result.setViews(dto.getViews());
		return result;
	}
}
