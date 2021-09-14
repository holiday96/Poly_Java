package com.java5.controller.lab.lab5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java5.controller.lab.lab5.entity.Lab5ProductEntity;
import com.java5.controller.lab.lab5.entity.Lab5ReportEntity;

public interface Lab5ProductRepository extends JpaRepository<Lab5ProductEntity, Long>{

	Page<Lab5ProductEntity> findAll(Pageable pageable);
	Page<Lab5ProductEntity> findByNameContaining(String name, Pageable pageable);
	Page<Lab5ProductEntity> findByPriceGreaterThanEqual(Double price, Pageable pageable);
	Page<Lab5ProductEntity> findByPriceLessThanEqual(Double price, Pageable pageable);
	Page<Lab5ProductEntity> findByPriceBetween(Double min, Double max, Pageable pageable);
	
	@Query("SELECT new Lab5ReportEntity(o.category, sum(o.price), count(o)) " 
	+ "FROM Lab5ProductEntity o "
	+ "GROUP BY o.category "
	+ "ORDER BY sum(o.price) DESC")
	Page<Lab5ReportEntity> getInventoryByCategory(Pageable pageable);
}
