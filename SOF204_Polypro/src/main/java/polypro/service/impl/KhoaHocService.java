package polypro.service.impl;

import java.util.List;

import javax.inject.Inject;

import polypro.dao.IKhoaHocDAO;
import polypro.dao.impl.KhoaHocDAO;
import polypro.model.KhoaHocModel;
import polypro.service.IKhoaHocService;

public class KhoaHocService implements IKhoaHocService {

	/*
	 * private IChuyenDeDAO chuyenDeDAO;
	 * 
	 * public ChuyenDeService() { chuyenDeDAO = new ChuyenDeDAO(); }
	 */

	@Inject
	private static IKhoaHocDAO khoaHocDAO = new KhoaHocDAO();

	// return ID of KhoaHocModel
	@Override
	public List<KhoaHocModel> findByMaCD(String maCD) {
		return khoaHocDAO.findByMaCD(maCD);
	}

	@Override
	public String save(KhoaHocModel khoaHocModel) {
		return khoaHocDAO.save(khoaHocModel);
	}

	@Override
	public void update(KhoaHocModel khoaHocModel, int id) {
		khoaHocDAO.update(khoaHocModel, id);
	}

	@Override
	public void delete(KhoaHocModel khoaHocModel) {
		khoaHocDAO.delete(khoaHocModel);
	}
}
