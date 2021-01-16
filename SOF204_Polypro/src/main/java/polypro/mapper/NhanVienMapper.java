package polypro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import polypro.model.NhanVienModel;

public class NhanVienMapper implements RowMapper<NhanVienModel>{

	@Override
	public NhanVienModel mapRow(ResultSet resultSet) {
		try {
			NhanVienModel nhanVien = new NhanVienModel();
			nhanVien.setMaNV(resultSet.getString("MaNV"));
			nhanVien.setMatKhau(resultSet.getString("MatKhau"));
			nhanVien.setHoTen(resultSet.getString("HoTen"));
			nhanVien.setVaiTro(resultSet.getBoolean("VaiTro"));
			return nhanVien;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
