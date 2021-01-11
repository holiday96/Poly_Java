package polypro.dao;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface IChuyenDeDAO extends GenericDAO<ChuyenDeModel>{
	List<ChuyenDeModel> findAll();
}
