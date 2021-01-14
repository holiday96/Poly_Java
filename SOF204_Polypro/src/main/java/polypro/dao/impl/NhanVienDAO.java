package polypro.dao.impl;

import java.util.List;

import polypro.dao.INhanVienDAO;
import polypro.mapper.ChuyenDeMapper;
import polypro.model.ChuyenDeModel;

public class NhanVienDAO extends AbstractDAO<ChuyenDeModel> implements INhanVienDAO{

	@Override
	public List<ChuyenDeModel> findAll() {
		String sql = "SELECT * FROM CHUYENDE";
		return query(sql, new ChuyenDeMapper());
	}
}
