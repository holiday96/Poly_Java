package polypro.service;

import java.util.List;

import polypro.model.KhoaHocModel;

public interface IKhoaHocService {
	List<KhoaHocModel> findByMaCD(String maCD);
	String save(KhoaHocModel khoaHocModel);
	void update(KhoaHocModel khoaHocModel, int id);
	void delete(KhoaHocModel khoaHocModel);
}
