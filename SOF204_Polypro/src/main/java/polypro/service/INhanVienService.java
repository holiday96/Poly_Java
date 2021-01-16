package polypro.service;

import java.util.List;

import polypro.model.NhanVienModel;

public interface INhanVienService {
	List<NhanVienModel> findAll();
	String save(NhanVienModel nhanVienModel);
	void update(NhanVienModel nhanVienModel, String id);
	void delete(NhanVienModel nhanVienModel);
}
