package com.polyweb.dao.impl;

import java.util.List;

import com.polyweb.dao.ISanPhamDAO;
import com.polyweb.mapper.SanPhamMapper;
import com.polyweb.model.SanPhamModel;

public class SanPhamDAO extends AbstractDAO<SanPhamModel> implements ISanPhamDAO {

	@Override
	public List<SanPhamModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT*FROM SANPHAM");
		return query(sql.toString(), new SanPhamMapper());
	}
}
