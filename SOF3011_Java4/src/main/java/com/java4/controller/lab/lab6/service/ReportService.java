package com.java4.controller.lab.lab6.service;

import java.util.ArrayList;
import java.util.List;

import com.java4.controller.lab.lab6.converter.ReportConverter;
import com.java4.controller.lab.lab6.dto.ReportDTO;
import com.java4.controller.lab.lab6.entity.ReportEntity;
import com.java4.controller.lab.lab6.repository.ReportRepository;

public class ReportService {

	private ReportRepository reportRepository = new ReportRepository();

	public List<ReportDTO> findAll() {
		List<ReportDTO> list = new ArrayList<>();
		for (ReportEntity i : reportRepository.findAll()) {
			list.add(ReportConverter.toDto(i));
		}
		return list;
	}
	
	public List<ReportDTO> findFavorByYear(Integer year) {
		List<ReportDTO> list = new ArrayList<>();
		for (ReportEntity i : reportRepository.findFavorByYear(year)) {
			list.add(ReportConverter.toDto(i));
		}
		return list;
	}
}
