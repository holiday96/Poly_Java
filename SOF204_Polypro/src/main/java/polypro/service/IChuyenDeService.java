package polypro.service;

import java.util.List;

import polypro.model.ChuyenDeModel;

public interface IChuyenDeService {
	List<ChuyenDeModel> findAll();
	String save(ChuyenDeModel chuyenDeModel);
	void update(ChuyenDeModel chuyenDeModel, String id);
	void delete(ChuyenDeModel chuyenDeModel);
	int countDB();
	List<ChuyenDeModel> top5(int indexPage);
}
