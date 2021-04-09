package com.polyweb.service.impl;

import java.util.Comparator;
import java.util.List;

import com.polyweb.dao.IChiTietSanPhamDAO;
import com.polyweb.dao.impl.ChiTietSanPhamDAO;
import com.polyweb.model.ChiTietSanPhamModel;
import com.polyweb.service.IChiTietSanPhamService;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

	private IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();

	@Override
	public List<ChiTietSanPhamModel> findAll() {
		return chiTietSanPhamDAO.findAll();
	}

	@Override
	public List<ChiTietSanPhamModel> findByIdSanPham(Integer id) {
		return chiTietSanPhamDAO.findByIdSanPham(id);
	}

	@Override
	public Long findMinPriceByIdSanPham(Integer id) {
		List<ChiTietSanPhamModel> list = chiTietSanPhamDAO.findByIdSanPham(id);
		Long price = list.stream().min(Comparator.comparingLong(ChiTietSanPhamModel::getGiaBan)).get().getGiaBan();
		return price;
	}

	@Override
	public Long findMaxPriceByIdSanPham(Integer id) {
		List<ChiTietSanPhamModel> list = chiTietSanPhamDAO.findByIdSanPham(id);
		Long price = list.stream().max(Comparator.comparingLong(ChiTietSanPhamModel::getGiaBan)).get().getGiaBan();
		return price;
	}
}
