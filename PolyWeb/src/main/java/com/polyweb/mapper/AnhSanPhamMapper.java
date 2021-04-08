package com.polyweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polyweb.model.AnhSanPhamModel;

public class AnhSanPhamMapper implements RowMapper<AnhSanPhamModel> {
	@Override
	public AnhSanPhamModel mapRow(ResultSet rs) {
		try {
			AnhSanPhamModel anhSanPhamModel = new AnhSanPhamModel();
			anhSanPhamModel.setIdSanPham(rs.getInt("IDCHITIETSANPHAM"));
			anhSanPhamModel.setTenAnh(rs.getString("TENANH"));
			return anhSanPhamModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
