package com.polyweb.dao;

import java.util.List;

import com.polyweb.model.SanPhamModel;

public interface ISanPhamDAO extends GenericDAO<SanPhamModel>{
	
	List<SanPhamModel> findAll();
	
	SanPhamModel findOne(Integer id);
}