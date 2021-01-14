package polypro.dao.impl;

import java.util.List;

import polypro.dao.IChuyenDeDAO;
import polypro.mapper.ChuyenDeMapper;
import polypro.model.ChuyenDeModel;

public class HocVienDAO extends AbstractDAO<ChuyenDeModel> implements IChuyenDeDAO{

	@Override
	public List<ChuyenDeModel> findAll() {
		String sql = "SELECT * FROM CHUYENDE";
		return query(sql, new ChuyenDeMapper());
	}
}
