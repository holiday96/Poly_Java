package com.polyweb.model;

public class SanPhamModel extends AbstractModel<SanPhamModel> {
	private Integer idLoaiSP;
	private String tenSP;

	public Integer getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(Integer idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

}
