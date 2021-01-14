package polypro.dao;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface IChuyenDeDAO extends GenericDAO<ChuyenDeModel>{
	List<ChuyenDeModel> findAll();
	String save(ChuyenDeModel chuyenDeModel);
	void update(ChuyenDeModel chuyenDeModel, String id);
	void delete(ChuyenDeModel chuyenDeModel);
}
