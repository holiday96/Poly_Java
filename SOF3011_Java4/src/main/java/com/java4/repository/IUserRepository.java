package com.java4.repository;

import java.util.List;

import com.java4.entity.UserEntity;

public interface IUserRepository {

	List<UserEntity> findAll();
	UserEntity findOne(Long id);
	Long save(UserEntity entity);
	void update(UserEntity entity);
	void delete(Long id);
	boolean findByEmail(String email);
	boolean findByUsername(String username);
	UserEntity findByUserLogin(String username, String password);
}
