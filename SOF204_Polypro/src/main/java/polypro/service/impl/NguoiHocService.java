package polypro.service.impl;

import java.util.List;

import javax.inject.Inject;

import polypro.dao.INguoiHocDAO;
import polypro.dao.impl.NguoiHocDAO;
import polypro.model.NguoiHocModel;
import polypro.service.INguoiHocService;

public class NguoiHocService implements INguoiHocService {

	@Inject
	private static INguoiHocDAO nguoiHocDAO = new NguoiHocDAO();

	@Override
	public List<NguoiHocModel> findAll() {
		return nguoiHocDAO.findAll();
	}

	@Override
	public List<NguoiHocModel> findByID(String id) {
		return nguoiHocDAO.findByID(id);
	}

	@Override
	public String save(NguoiHocModel nguoiHocModel) {
		return nguoiHocDAO.save(nguoiHocModel);
	}

	@Override
	public void update(NguoiHocModel nguoiHocModel, String id) {
		nguoiHocDAO.update(nguoiHocModel, id);
	}

	@Override
	public void delete(NguoiHocModel nguoiHocModel) {
		nguoiHocDAO.delete(nguoiHocModel);
	}
}
