package polypro.dao;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface INhanVienDAO extends GenericDAO<ChuyenDeModel>{
	List<ChuyenDeModel> findAll();
}
