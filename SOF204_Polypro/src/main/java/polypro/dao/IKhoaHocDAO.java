package polypro.dao;

import java.util.List;

import polypro.model.KhoaHocModel;

public interface IKhoaHocDAO extends GenericDAO<KhoaHocModel>{
	List<KhoaHocModel> findAll();
	List<KhoaHocModel> findByMaCD(String maCD);
	String save(KhoaHocModel khoaHocModel);
	void update(KhoaHocModel khoaHocModel, int id);
	void delete(KhoaHocModel khoaHocModel);
}
