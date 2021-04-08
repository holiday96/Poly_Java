package com.polyweb.dao;

import java.util.List;

import com.polyweb.model.LoaiSanPhamModel;

public interface ILoaiSanPhamDAO extends GenericDAO<LoaiSanPhamModel> {

	List<LoaiSanPhamModel> findAll();

}
