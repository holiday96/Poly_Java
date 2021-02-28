package polypro.dao.impl;

import java.util.List;

import polypro.dao.IChuyenDeDAO;
import polypro.mapper.ChuyenDeMapper;
import polypro.model.ChuyenDeModel;

public class ChuyenDeDAO extends AbstractDAO<ChuyenDeModel> implements IChuyenDeDAO {

	@Override
	public List<ChuyenDeModel> findAll() {
		String sql = "SELECT * FROM CHUYENDE";
		return query(sql, new ChuyenDeMapper());
	}

	@Override
	public String save(ChuyenDeModel chuyenDeModel) {
		String sql = "INSERT INTO CHUYENDE VALUES (?,?,?,?,?,?)";
		return insert(sql, chuyenDeModel.getMaCD(), chuyenDeModel.getTenCD(), chuyenDeModel.getHocPhi(),
				chuyenDeModel.getThoiLuong(), chuyenDeModel.getHinh(), chuyenDeModel.getMoTa());
	}

	@Override
	public void update(ChuyenDeModel chuyenDeModel, String id) {
		String sql = "UPDATE CHUYENDE SET MaCD = ?, TenCD = ?, HocPhi = ?, ThoiLuong = ?, Hinh = ?, MoTa = ? WHERE MaCD = ?";
		update(sql, chuyenDeModel.getMaCD(), chuyenDeModel.getTenCD(), chuyenDeModel.getHocPhi(),
				chuyenDeModel.getThoiLuong(), chuyenDeModel.getHinh(), chuyenDeModel.getMoTa(), id);
	}

	@Override
	public void delete(ChuyenDeModel chuyenDeModel) {
		String sql = "DELETE FROM CHUYENDE WHERE MaCD = ?";
		delete(sql, chuyenDeModel.getMaCD());
	}

	@Override
	public int countDB() {
		String sql = "SELECT COUNT(*) FROM CHUYENDE";
		return countDB(sql);
	}

	@Override
	public List<ChuyenDeModel> top5(int indexPage) {
		String sql = "SELECT TOP 5 * FROM CHUYENDE WHERE MACD NOT IN (SELECT TOP " + (indexPage * 5 - 5)
				+ " MACD FROM CHUYENDE)";
		return query(sql, new ChuyenDeMapper());
	}

}
