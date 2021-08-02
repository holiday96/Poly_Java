package com.java4.repository;

import java.util.List;

import com.java4.entity.CategoryEntity;

public interface ICategoryRepository {

	List<CategoryEntity> findAll();
	CategoryEntity findOne(Long id);
	Long save(CategoryEntity entity);
	void update(CategoryEntity entity);
	void delete(Long id);
	List<CategoryEntity> findByIds(String ids);
}
