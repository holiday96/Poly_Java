package com.java4.repository;

import java.util.List;

import com.java4.entity.ThemeEntity;

public interface IThemeRepository {

	List<ThemeEntity> findAll();
	Long save(ThemeEntity entity);
	ThemeEntity findOne(Long id);
}
