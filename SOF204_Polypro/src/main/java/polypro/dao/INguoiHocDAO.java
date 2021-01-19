package polypro.dao;

import java.util.List;

import polypro.model.NguoiHocModel;

public interface INguoiHocDAO extends GenericDAO<NguoiHocModel>{
	List<NguoiHocModel> findAll();
	String save(NguoiHocModel nguoiHocModel);
	void update(NguoiHocModel nguoiHocModel, String id);
	void delete(NguoiHocModel nguoiHocModel);
	List<NguoiHocModel> findByID(String id);
}
