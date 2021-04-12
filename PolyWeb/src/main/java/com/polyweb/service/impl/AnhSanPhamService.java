package com.polyweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.polyweb.dao.IAnhSanPhamDAO;
import com.polyweb.dao.impl.AnhSanPhamDAO;
import com.polyweb.service.IAnhSanPhamService;

public class AnhSanPhamService implements IAnhSanPhamService {

	private static IAnhSanPhamDAO anhSanPhamDAO = new AnhSanPhamDAO();

	@Override
	public List<String> findByIdCTSP(Integer idCTSP) {
		List<String> list = new ArrayList<String>();
		anhSanPhamDAO.findByIdCTSP(idCTSP).forEach(e -> list.add(e.getTenAnh()));
		return list;
	}

	@Override
	public List<String> findByIdSP(Integer idSP) {
		List<String> list = new ArrayList<String>();
		anhSanPhamDAO.findByIdSP(idSP).forEach(e -> list.add(e.getTenAnh()));
		return list;
	}
	
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
		new AnhSanPhamService().findByIdSP(1).forEach(e->System.out.println(e.toString()));
	}
}
