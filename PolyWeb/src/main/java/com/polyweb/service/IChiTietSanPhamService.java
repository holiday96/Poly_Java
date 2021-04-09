package com.polyweb.service;

import java.util.List;

import com.polyweb.model.ChiTietSanPhamModel;

public interface IChiTietSanPhamService {

    List<ChiTietSanPhamModel> findAll();

    List<ChiTietSanPhamModel> findByIdSanPham(Integer id);
    
    Long findMinPriceByIdSanPham(Integer id);
    
    Long findMaxPriceByIdSanPham(Integer id);

}
