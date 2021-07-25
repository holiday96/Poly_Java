package com.java4.controller.lab.lab6.converter;

import com.java4.controller.lab.lab6.dto.ReportDTO;
import com.java4.controller.lab.lab6.entity.ReportEntity;

public class ReportConverter {

	public static ReportDTO toDto(ReportEntity entity) {
		ReportDTO result = new ReportDTO();
		result.setTitle(entity.getTitle());
		result.setLikes(entity.getLikes());
		result.setNewest(entity.getNewest());
		result.setOldest(entity.getOldest());
		return result;
	}
}
