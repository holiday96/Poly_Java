package polypro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import polypro.model.ChuyenDeModel;

public class ChuyenDeMapper implements RowMapper<ChuyenDeModel>{

	@Override
	public ChuyenDeModel mapRow(ResultSet resultSet) {
		try {
			ChuyenDeModel chuyenDe = new ChuyenDeModel();
			chuyenDe.setMaCD(resultSet.getString("MaCD"));
			chuyenDe.setTenCD(resultSet.getString("TenCD"));
			chuyenDe.setHocPhi(resultSet.getDouble("HocPhi"));
			chuyenDe.setThoiLuong(resultSet.getInt("ThoiLuong"));
			chuyenDe.setHinh(resultSet.getString("Hinh"));
			chuyenDe.setMoTa(resultSet.getString("MoTa"));
			return chuyenDe;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
