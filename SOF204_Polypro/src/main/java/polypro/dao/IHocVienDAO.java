package polypro.dao;

import java.util.List;

import polypro.model.HocVienModel;

public interface IHocVienDAO extends GenericDAO<HocVienModel>{
	List<HocVienModel> findByMaKH(int id);
	String save(HocVienModel hocVienModel);
	void update(int id, double diem);
	void delete(HocVienModel hocVienModel);
}
