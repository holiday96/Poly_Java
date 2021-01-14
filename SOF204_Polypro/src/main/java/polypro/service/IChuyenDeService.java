package polypro.service;

import polypro.model.ChuyenDeModel;

public interface IChuyenDeService {
	String save(ChuyenDeModel chuyenDeModel);
	void update(ChuyenDeModel chuyenDeModel, String id);
	void delete(ChuyenDeModel chuyenDeModel);
}
