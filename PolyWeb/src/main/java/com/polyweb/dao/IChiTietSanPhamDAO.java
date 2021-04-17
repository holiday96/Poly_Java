package com.polyweb.dao;

import java.util.List;

import com.polyweb.model.ChiTietSanPhamModel;

public interface IChiTietSanPhamDAO extends GenericDAO<ChiTietSanPhamModel> {
	
    List<ChiTietSanPhamModel> findAll();
    
    List<ChiTietSanPhamModel> findByIdSanPham(Integer id);

}
