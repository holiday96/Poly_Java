package com.java4.repository;

import java.util.List;

import com.java4.entity.ThemeEntity;

public interface IThemeRepository {

	List<ThemeEntity> findAll();
	ThemeEntity findOne(Long id);
	Long save(ThemeEntity entity);
	void update(ThemeEntity entity);
	void delete(Long id);
}
