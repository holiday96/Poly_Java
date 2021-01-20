package polypro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import polypro.model.HocVienModel;

public class HocVienMapper implements RowMapper<HocVienModel> {

	@Override
	public HocVienModel mapRow(ResultSet resultSet) {
		try {
			HocVienModel hocVien = new HocVienModel();
			hocVien.setMaHV(resultSet.getInt("MaHV"));
			hocVien.setMaKH(resultSet.getInt("MaKH"));
			hocVien.setMaNH(resultSet.getString("MaNH"));
			hocVien.setDiem(resultSet.getDouble("Diem"));
			return hocVien;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
