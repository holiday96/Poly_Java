package polypro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import polypro.model.KhoaHocModel;

public class KhoaHocMapper implements RowMapper<KhoaHocModel>{

	@Override
	public KhoaHocModel mapRow(ResultSet resultSet) {
		try {
			KhoaHocModel khoaHoc = new KhoaHocModel();
			khoaHoc.setMaKH(resultSet.getInt("MaKH"));
			khoaHoc.setHocPhi(resultSet.getDouble("HocPhi"));
			khoaHoc.setThoiLuong(resultSet.getInt("ThoiLuong"));
			khoaHoc.setNgayKG(resultSet.getDate("NgayKG"));
			khoaHoc.setGhiChu(resultSet.getString("GhiChu"));
			khoaHoc.setNgayTao(resultSet.getDate("NgayTao"));
			khoaHoc.setMaCD(resultSet.getString("MaCD"));
			khoaHoc.setMaNV(resultSet.getString("MaNV"));
			return khoaHoc;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
