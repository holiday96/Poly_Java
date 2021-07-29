package com.java4.service;

import java.util.List;

import com.java4.dto.ThemeDTO;

public interface IThemeService {

	List<ThemeDTO> findAll();
	ThemeDTO findOne(Long id);
	ThemeDTO save(ThemeDTO dto);
}
