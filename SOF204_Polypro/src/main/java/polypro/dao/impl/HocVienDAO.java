package polypro.dao.impl;

import java.util.List;

import polypro.dao.IHocVienDAO;
import polypro.mapper.HocVienMapper;
import polypro.model.HocVienModel;

public class HocVienDAO extends AbstractDAO<HocVienModel> implements IHocVienDAO {

	@Override
	public List<HocVienModel> findByMaKH(int id) {
		String sql = "SELECT * FROM HOCVIEN WHERE MaKH = ?";
		return query(sql, new HocVienMapper(), id);
	}

	@Override
	public String save(HocVienModel hocVienModel) {
		String sql = "INSERT INTO HOCVIEN (MaKH, MaNH) VALUES (?,?)";
		return insert(sql, hocVienModel.getMaKH(), hocVienModel.getMaNH());
	}

	@Override
	public void update(int id, double diem) {
		String sql = "UPDATE HOCVIEN SET Diem = ? WHERE MaHV = ?";
		update(sql, diem, id);
	}

	@Override
	public void delete(HocVienModel hocVienModel) {
		String sql = "DELETE FROM HOCVIEN WHERE MaHV = ?";
		delete(sql, hocVienModel.getMaHV());
	}
}
