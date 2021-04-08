package com.polyweb.dao.impl;

import java.util.List;

import com.polyweb.dao.ILoaiSanPhamDAO;
import com.polyweb.mapper.LoaiSanPhamMapper;
import com.polyweb.model.LoaiSanPhamModel;

public class LoaiSanPhamDAO extends AbstractDAO<LoaiSanPhamModel> implements ILoaiSanPhamDAO {

	@Override
	public List<LoaiSanPhamModel> findAll() {
		String sql = "SELECT * FROM LOAISANPHAM";
		return query(sql, new LoaiSanPhamMapper());
	}
}
