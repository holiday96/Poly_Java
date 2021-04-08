package com.polyweb.service;

import java.util.List;

import com.polyweb.model.ChiTietSanPhamModel;

public interface IChiTietSanPhamService {

    List<ChiTietSanPhamModel> findAll();

    ChiTietSanPhamModel getById(Integer id);

}
