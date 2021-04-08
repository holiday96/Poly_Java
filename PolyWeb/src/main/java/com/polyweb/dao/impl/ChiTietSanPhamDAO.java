package com.polyweb.dao.impl;

import java.util.List;

import com.polyweb.dao.IChiTietSanPhamDAO;
import com.polyweb.mapper.ChiTietSanPhamMapper;
import com.polyweb.model.ChiTietSanPhamModel;

public class ChiTietSanPhamDAO extends AbstractDAO<ChiTietSanPhamModel> implements IChiTietSanPhamDAO {

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        String sql = "SELECT * FROM CHITIETSANPHAM WHERE TRANGTHAI = 1";
        return query(sql, new ChiTietSanPhamMapper());
    }
}
