package com.polyweb.service.impl;

import java.util.List;

import com.polyweb.dao.ISanPhamDAO;
import com.polyweb.dao.impl.SanPhamDAO;
import com.polyweb.model.SanPhamModel;
import com.polyweb.service.ISanPhamService;

public class SanPhamService implements ISanPhamService {

	private ISanPhamDAO sanPhamDAO = new SanPhamDAO();

	@Override
	public List<SanPhamModel> findAll() {
		return sanPhamDAO.findAll();
	}
}
