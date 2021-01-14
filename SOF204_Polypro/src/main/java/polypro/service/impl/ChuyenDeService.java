package polypro.service.impl;

import javax.inject.Inject;

import polypro.dao.IChuyenDeDAO;
import polypro.model.ChuyenDeModel;
import polypro.service.IChuyenDeService;

public class ChuyenDeService implements IChuyenDeService{

	/*private IChuyenDeDAO chuyenDeDAO;
	
	public ChuyenDeService() {
		chuyenDeDAO = new ChuyenDeDAO();
	}*/
	
	@Inject
	private IChuyenDeDAO chuyenDeDAO;

	//return ID of ChuyenDeModel
	@Override
	public String save(ChuyenDeModel chuyenDeModel) {
		return chuyenDeDAO.save(chuyenDeModel);
	}

	@Override
	public void update(ChuyenDeModel chuyenDeModel, String id) {
		chuyenDeDAO.update(chuyenDeModel, id);
	}

	@Override
	public void delete(ChuyenDeModel chuyenDeModel) {
		chuyenDeDAO.delete(chuyenDeModel);
	}
	
}
