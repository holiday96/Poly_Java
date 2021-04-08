package com.polyweb.dao;

import java.util.List;

import com.polyweb.model.AnhSanPhamModel;

public interface IAnhSanPhamDAO extends GenericDAO<AnhSanPhamModel> {
	List<AnhSanPhamModel> findById(Integer id);
}
