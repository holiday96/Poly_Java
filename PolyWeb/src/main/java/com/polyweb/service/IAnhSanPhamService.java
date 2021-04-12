package com.polyweb.service;

import java.util.List;

public interface IAnhSanPhamService {
	
	List<String> findByIdCTSP(Integer idCTSP);
	
	List<String> findByIdSP(Integer idSP);
}
