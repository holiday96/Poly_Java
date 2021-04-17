package com.polyweb.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.polyweb.dao.IChiTietSanPhamDAO;
import com.polyweb.dao.impl.ChiTietSanPhamDAO;
import com.polyweb.model.ChiTietSanPhamModel;
import com.polyweb.service.IChiTietSanPhamService;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

	private List<ChiTietSanPhamModel> list;
	private int amount;

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
		list = chiTietSanPhamDAO.findByIdSanPham(id);
		Long price = list.stream().min(Comparator.comparingLong(ChiTietSanPhamModel::getGiaBan)).get().getGiaBan();
		return price;
	}

	@Override
	public Long findMaxPriceByIdSanPham(Integer id) {
		list = chiTietSanPhamDAO.findByIdSanPham(id);
		Long price = list.stream().max(Comparator.comparingLong(ChiTietSanPhamModel::getGiaBan)).get().getGiaBan();
		return price;
	}

	@Override
	public List<String> getColors(Integer id) {
		List<String> list = new ArrayList<String>();
		chiTietSanPhamDAO.findByIdSanPham(id).forEach(e -> {
			if (!list.contains(e.getMauSac())) {
				list.add(e.getMauSac());
			}
		});
		return list;
	}

	@Override
	public List<String> getSizes(Integer id) {
		List<String> list = new ArrayList<String>();
		chiTietSanPhamDAO.findByIdSanPham(id).forEach(e -> {
			if (!list.contains(e.getSize())) {
				list.add(e.getSize());
			}
		});
		return list;
	}

	@Override
	public Integer getAmount(Integer id) {
		amount = 0;
		chiTietSanPhamDAO.findByIdSanPham(id).forEach(e -> {
			amount = amount + e.getSoLuong().intValue();
		});
		return Integer.valueOf(amount);
	}
}
