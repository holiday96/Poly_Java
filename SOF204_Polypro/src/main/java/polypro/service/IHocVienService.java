package polypro.service;

import java.util.List;

import polypro.model.HocVienModel;

public interface IHocVienService {
	List<HocVienModel> findByMaKH(int id);
	String save(HocVienModel hocVienModel);
	void update(String id, double diem);
	void delete(HocVienModel hocVienModel);
}
