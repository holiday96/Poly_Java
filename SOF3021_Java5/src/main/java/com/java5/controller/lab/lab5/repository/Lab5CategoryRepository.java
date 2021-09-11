package com.java5.controller.lab.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java5.controller.lab.lab5.entity.Lab5CategoryEntity;

public interface Lab5CategoryRepository extends JpaRepository<Lab5CategoryEntity, Long>{

	Lab5CategoryEntity findOneByCode(String code);
}
