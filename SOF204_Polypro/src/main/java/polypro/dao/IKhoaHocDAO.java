package polypro.dao;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface IKhoaHocDAO extends GenericDAO<ChuyenDeModel>{
	List<ChuyenDeModel> findAll();
}
