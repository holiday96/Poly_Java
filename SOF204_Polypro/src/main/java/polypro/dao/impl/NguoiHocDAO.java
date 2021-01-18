package polypro.dao.impl;

import java.util.List;

import polypro.dao.INguoiHocDAO;
import polypro.mapper.ChuyenDeMapper;
import polypro.model.ChuyenDeModel;

public class NguoiHocDAO extends AbstractDAO<ChuyenDeModel> implements INguoiHocDAO{

	@Override
	public List<ChuyenDeModel> findAll() {
		String sql = "SELECT * FROM CHUYENDE";
		return query(sql, new ChuyenDeMapper());
	}
}