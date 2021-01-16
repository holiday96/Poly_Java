package polypro.dao.impl;

import java.util.List;

import polypro.dao.INhanVienDAO;
import polypro.mapper.NhanVienMapper;
import polypro.model.NhanVienModel;

public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO {

	@Override
	public List<NhanVienModel> findAll() {
		String sql = "SELECT * FROM NHANVIEN";
		return query(sql, new NhanVienMapper());
	}

	@Override
	public String save(NhanVienModel nhanVienModel) {
		String sql = "INSERT INTO NHANVIEN VALUES (?,?,?,?)";
		return insert(sql, nhanVienModel.getMaNV(), nhanVienModel.getMatKhau(), nhanVienModel.getHoTen(),
				nhanVienModel.isVaiTro());
	}

	@Override
	public void update(NhanVienModel nhanVienModel, String id) {
		String sql = "UPDATE NHANVIEN SET MaNV = ?, MatKhau = ?, HoTen = ?, VaiTro = ? WHERE MaNV = ?";
		update(sql, nhanVienModel.getMaNV(), nhanVienModel.getMatKhau(), nhanVienModel.getHoTen(), nhanVienModel.isVaiTro(), id);
	}

	@Override
	public void delete(NhanVienModel nhanVienModel) {
		String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?";
		delete(sql, nhanVienModel.getMaNV());
	}
}
