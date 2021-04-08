package com.polyweb.service.impl;

import java.util.List;

import com.polyweb.dao.IAnhSanPhamDAO;
import com.polyweb.dao.impl.AnhSanPhamDAO;
import com.polyweb.model.AnhSanPhamModel;
import com.polyweb.service.IAnhSanPhamService;

public class AnhSanPhamService implements IAnhSanPhamService {

	private IAnhSanPhamDAO anhSanPhamDAO = new AnhSanPhamDAO();
	
	@Override
	public List<AnhSanPhamModel> findById(Integer id) {
		return anhSanPhamDAO.findById(id);
	}
}
