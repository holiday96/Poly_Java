package com.polyweb.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.polyweb.dao.IChiTietSanPhamDAO;
import com.polyweb.dao.impl.ChiTietSanPhamDAO;
import com.polyweb.model.ChiTietSanPhamModel;
import com.polyweb.service.IChiTietSanPhamService;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    private static List<ChiTietSanPhamModel> lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        Collections.reverse(lstChiTietSanPhamModels);
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus()).collect(Collectors.toList());
    }

    @Override
    public ChiTietSanPhamModel getById(Integer id) {
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus() && e.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}
