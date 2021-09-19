package com.java5.controller.lab.lab5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java5.controller.lab.lab5.entity.Lab5AccountEntity;

public interface Lab5AccountRepository extends JpaRepository<Lab5AccountEntity, Long> {

	List<Lab5AccountEntity> findByUsernameAndPassword(String username, String password);
}
