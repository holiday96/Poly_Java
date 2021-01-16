package polypro.service.impl;

import java.util.List;

import javax.inject.Inject;

import polypro.dao.INhanVienDAO;
import polypro.dao.impl.NhanVienDAO;
import polypro.model.NhanVienModel;
import polypro.service.INhanVienService;

public class NhanVienService implements INhanVienService{

	/*private IChuyenDeDAO chuyenDeDAO;
	
	public ChuyenDeService() {
		chuyenDeDAO = new ChuyenDeDAO();
	}*/
	
	@Inject
	private static INhanVienDAO nhanVienDAO = new NhanVienDAO();

	//return ID of ChuyenDeModel
	@Override
	public String save(NhanVienModel nhanVienModel) {
		return nhanVienDAO.save(nhanVienModel);
	}

	@Override
	public void update(NhanVienModel nhanVienModel, String id) {
		nhanVienDAO.update(nhanVienModel, id);
	}

	@Override
	public void delete(NhanVienModel nhanVienModel) {
		nhanVienDAO.delete(nhanVienModel);
	}

	@Override
	public List<NhanVienModel> findAll() {
		return nhanVienDAO.findAll();
	}
}
