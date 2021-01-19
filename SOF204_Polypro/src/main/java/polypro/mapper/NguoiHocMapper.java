package polypro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import polypro.model.NguoiHocModel;

public class NguoiHocMapper implements RowMapper<NguoiHocModel> {

	@Override
	public NguoiHocModel mapRow(ResultSet resultSet) {
		try {
			NguoiHocModel nguoiHoc = new NguoiHocModel();
			nguoiHoc.setMaNH(resultSet.getString("MaNH"));
			nguoiHoc.setHoTen(resultSet.getString("HoTen"));
			nguoiHoc.setGioiTinh(resultSet.getBoolean("GioiTinh"));
			nguoiHoc.setNgaySinh(resultSet.getDate("NgaySinh"));
			nguoiHoc.setDienThoai(resultSet.getString("DienThoai"));
			nguoiHoc.setEmail(resultSet.getString("Email"));
			nguoiHoc.setGhiChu(resultSet.getString("GhiChu"));
			nguoiHoc.setMaNV(resultSet.getString("MaNV"));
			nguoiHoc.setNgayDK(resultSet.getDate("NgayDK"));
			return nguoiHoc;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
