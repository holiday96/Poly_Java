package polypro.service.impl;

import java.util.List;

import javax.inject.Inject;

import polypro.dao.IChuyenDeDAO;
import polypro.dao.impl.ChuyenDeDAO;
import polypro.model.ChuyenDeModel;
import polypro.service.IChuyenDeService;

public class ChuyenDeService implements IChuyenDeService{

	/*private IChuyenDeDAO chuyenDeDAO;
	
	public ChuyenDeService() {
		chuyenDeDAO = new ChuyenDeDAO();
	}*/
	
	@Inject
	private static IChuyenDeDAO chuyenDeDAO = new ChuyenDeDAO();

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

	@Override
	public List<ChuyenDeModel> findAll() {
		return chuyenDeDAO.findAll();
	}

	@Override
	public int countDB() {
		return chuyenDeDAO.countDB();
	}

	@Override
	public List<ChuyenDeModel> top5(int indexPage) {
		return chuyenDeDAO.top5(indexPage);
	}
}
