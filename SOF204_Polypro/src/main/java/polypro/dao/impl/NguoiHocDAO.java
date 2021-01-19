package polypro.dao.impl;

import java.util.List;

import polypro.dao.INguoiHocDAO;
import polypro.mapper.NguoiHocMapper;
import polypro.model.NguoiHocModel;

public class NguoiHocDAO extends AbstractDAO<NguoiHocModel> implements INguoiHocDAO {

	@Override
	public List<NguoiHocModel> findAll() {
		String sql = "SELECT * FROM NGUOIHOC";
		return query(sql, new NguoiHocMapper());
	}

	@Override
	public String save(NguoiHocModel nguoiHocModel) {
		String sql = "INSERT INTO NGUOIHOC VALUES (?,?,?,?,?,?,?,?,?)";
		return insert(sql, nguoiHocModel.getMaNV(), nguoiHocModel.getHoTen(), nguoiHocModel.isGioiTinh(),
				nguoiHocModel.getNgaySinh(), nguoiHocModel.getDienThoai(), nguoiHocModel.getEmail(),
				nguoiHocModel.getGhiChu(), nguoiHocModel.getMaNV(), nguoiHocModel.getNgayDK());
	}

	@Override
	public void update(NguoiHocModel nguoiHocModel, String id) {
		String sql = "UPDATE NGUOIHOC SET MaNH = ?, HoTen = ?, GioiTinh = ?, NgaySinh = ?, DienThoai = ?, Email = ?, GhiChu = ?, MaNV = ?, NgayDK = ? WHERE MaNH = ?";
		update(sql, nguoiHocModel.getMaNH(), nguoiHocModel.getHoTen(), nguoiHocModel.isGioiTinh(),
				nguoiHocModel.getNgaySinh(), nguoiHocModel.getDienThoai(), nguoiHocModel.getEmail(),
				nguoiHocModel.getGhiChu(), nguoiHocModel.getMaNV(), nguoiHocModel.getNgayDK(), id);
	}

	@Override
	public void delete(NguoiHocModel nguoiHocModel) {
		String sql = "DELETE FROM NGUOIHOC WHERE MaNH = ?";
		delete(sql, nguoiHocModel.getMaNH());
	}

	@Override
	public List<NguoiHocModel> findByID(String id) {
		String sql = "SELECT * FROM NGUOIHOC WHERE MaNH LIKE ?";
		return query(sql, new NguoiHocMapper(), "%" + id + "%");
	}

}
