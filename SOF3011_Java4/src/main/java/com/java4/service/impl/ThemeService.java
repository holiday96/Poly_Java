package com.java4.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.java4.converter.ThemeConverter;
import com.java4.dto.ThemeDTO;
import com.java4.entity.ThemeEntity;
import com.java4.repository.IThemeRepository;
import com.java4.service.IThemeService;

public class ThemeService implements IThemeService {

	@Inject
	private IThemeRepository themeRepository;

	@Override
	public List<ThemeDTO> findAll() {
		List<ThemeDTO> dtos = new ArrayList<ThemeDTO>();
		List<ThemeEntity> entities = themeRepository.findAll();
		for (ThemeEntity item : entities) {
			ThemeDTO themeDTO = ThemeConverter.toAllDTO(item);
			dtos.add(themeDTO);
		}
		return dtos;
	}

	@Override
	public ThemeDTO findOne(Long id) {
		return ThemeConverter.toAllDTO(themeRepository.findOne(id));
	}

	@Override
	public ThemeDTO save(ThemeDTO dto) {
		Long id = themeRepository.save(ThemeConverter.toAllEntity(dto));
		return ThemeConverter.toAllDTO(themeRepository.findOne(id));
	}

	@Override
	public ThemeDTO update(ThemeDTO dto) {
		themeRepository.update(ThemeConverter.toAllEntity(dto));
		return ThemeConverter.toAllDTO(themeRepository.findOne(dto.getId()));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			themeRepository.delete(id);
		}
	}

}
