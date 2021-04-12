package com.polyweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.polyweb.dao.IAnhSanPhamDAO;
import com.polyweb.mapper.AnhSanPhamMapper;
import com.polyweb.model.AnhSanPhamModel;

public class AnhSanPhamDAO extends AbstractDAO<AnhSanPhamModel> implements IAnhSanPhamDAO {

	@Override
	public List<AnhSanPhamModel> findByIdCTSP(Integer idCTSP) {
		StringBuilder sql = new StringBuilder("SELECT*FROM ANHSANPHAM WHERE ID = ?");
		return query(sql.toString(), new AnhSanPhamMapper(), idCTSP);
	}

	@Override
	public List<AnhSanPhamModel> findByIdSP(Integer idSP) {
		StringBuilder sql = new StringBuilder("SELECT A.IDCHITIETSANPHAM, A.TENANH FROM CHITIETSANPHAM CTSP JOIN SANPHAM SP ON SP.ID = CTSP.IDSANPHAM");
		sql.append(" JOIN ANHSANPHAM A ON CTSP.ID = A.IDCHITIETSANPHAM");
		sql.append(" WHERE SP.ID = ?");
		return query(sql.toString(), new AnhSanPhamMapper(), idSP);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		new AnhSanPhamDAO().findByIdSP(1).forEach(e->list.add(e.getTenAnh()));
		list.forEach(e->System.out.println(e.toString()));
	}
}
