package polypro.service;

import java.util.List;

import polypro.model.NguoiHocModel;

public interface INguoiHocService {
	List<NguoiHocModel> findAll();
	List<NguoiHocModel> findByID(String id);
	String save(NguoiHocModel nguoiHocModel);
	void update(NguoiHocModel nguoiHocModel, String id);
	void delete(NguoiHocModel nguoiHocModel);
}
