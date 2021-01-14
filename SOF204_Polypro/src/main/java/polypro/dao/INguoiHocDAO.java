package polypro.dao;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface INguoiHocDAO extends GenericDAO<ChuyenDeModel>{
	List<ChuyenDeModel> findAll();
}
