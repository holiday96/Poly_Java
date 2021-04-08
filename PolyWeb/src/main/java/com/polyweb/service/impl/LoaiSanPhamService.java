package com.polyweb.service.impl;

import java.util.List;

import com.polyweb.dao.ILoaiSanPhamDAO;
import com.polyweb.dao.impl.LoaiSanPhamDAO;
import com.polyweb.model.LoaiSanPhamModel;
import com.polyweb.service.ILoaiSanPhamService;

public class LoaiSanPhamService implements ILoaiSanPhamService {

	private static ILoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();

	@Override
	public List<LoaiSanPhamModel> findAll() {
		return loaiSanPhamDAO.findAll();
	}
	
	public static void main(String[] args) {
		new LoaiSanPhamService().findAll().forEach(e->System.out.println(e.getTenLoaiSP()));;
	}
}
