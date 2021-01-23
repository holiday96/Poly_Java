package polypro.dao.impl;

import java.util.List;

import polypro.dao.IKhoaHocDAO;
import polypro.mapper.KhoaHocMapper;
import polypro.model.KhoaHocModel;

public class KhoaHocDAO extends AbstractDAO<KhoaHocModel> implements IKhoaHocDAO {

	@Override
	public List<KhoaHocModel> findByMaCD(String maCD) {
		String sql = "SELECT * FROM KHOAHOC WHERE MaCD = ?";
		return query(sql, new KhoaHocMapper(), maCD);
	}

	@Override
	public String save(KhoaHocModel khoaHocModel) {
		String sql = "INSERT INTO KHOAHOC VALUES (?,?,?,?,?,?,?)";
		return insert(sql, khoaHocModel.getMaCD(), khoaHocModel.getHocPhi(), khoaHocModel.getThoiLuong(), khoaHocModel.getNgayKG(),
				khoaHocModel.getGhiChu(), khoaHocModel.getMaNV(), khoaHocModel.getNgayTao());
	}

	@Override
	public void update(KhoaHocModel khoaHocModel, int id) {
		String sql = "UPDATE KHOAHOC SET NgayKG = ?, GhiChu = ?, NgayTao = ? WHERE MaKH = ?";
		update(sql, khoaHocModel.getNgayKG(), khoaHocModel.getGhiChu(), khoaHocModel.getNgayTao(), id);
	}

	@Override
	public void delete(KhoaHocModel khoaHocModel) {
		String sql = "DELETE FROM KHOAHOC WHERE MaKH = ?";
		delete(sql, khoaHocModel.getMaKH());
	}

	@Override
	public List<KhoaHocModel> findAll() {
		String sql = "SELECT * FROM KHOAHOC";
		return query(sql, new KhoaHocMapper());
	}
}
