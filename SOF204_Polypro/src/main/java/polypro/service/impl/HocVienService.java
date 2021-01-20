package polypro.service.impl;

import java.util.List;

import polypro.dao.IHocVienDAO;
import polypro.dao.impl.HocVienDAO;
import polypro.model.HocVienModel;
import polypro.service.IHocVienService;

public class HocVienService implements IHocVienService {

	private IHocVienDAO hocVienDAO = new HocVienDAO();

	@Override
	public List<HocVienModel> findByMaKH(int id) {
		return hocVienDAO.findByMaKH(id);
	}

	@Override
	public String save(HocVienModel hocVienModel) {
		return hocVienDAO.save(hocVienModel);
	}

	@Override
	public void update(String id, double diem) {
		hocVienDAO.update(id, diem);
	}

	@Override
	public void delete(HocVienModel hocVienModel) {
		hocVienDAO.delete(hocVienModel);
	}

}
