package com.polyweb.dao.impl;

import java.util.List;

import com.polyweb.dao.IAnhSanPhamDAO;
import com.polyweb.mapper.AnhSanPhamMapper;
import com.polyweb.model.AnhSanPhamModel;

public class AnhSanPhamDAO extends AbstractDAO<AnhSanPhamModel> implements IAnhSanPhamDAO {

	@Override
	public List<AnhSanPhamModel> findById(Integer id) {
		StringBuilder sql = new StringBuilder("SELECT*FROM ANHSANPHAM WHERE ID = ?");
		return query(sql.toString(), new AnhSanPhamMapper(), id);
	}
	
}
