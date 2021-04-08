package com.polyweb.service;

import java.util.List;

import com.polyweb.model.AnhSanPhamModel;

public interface IAnhSanPhamService {
	
	List<AnhSanPhamModel> findById(Integer id);
}
