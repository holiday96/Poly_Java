package com.polyweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polyweb.model.LoaiSanPhamModel;

public class LoaiSanPhamMapper implements RowMapper<LoaiSanPhamModel> {
	@Override
	public LoaiSanPhamModel mapRow(ResultSet rs) {
		try {
			LoaiSanPhamModel loaiSanPhamModel = new LoaiSanPhamModel();
			loaiSanPhamModel.setId(rs.getInt("ID"));
			loaiSanPhamModel.setTenLoaiSP(rs.getString("TEN"));
			return loaiSanPhamModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
