package com.polyweb.model;

public class SanPhamModel extends AbstractModel<SanPhamModel> {
	private Integer idLoaiSP;
	private String tenSP;
	private Long minPrice;
	private Long maxPrice;

	public Long getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Long minPrice) {
		this.minPrice = minPrice;
	}

	public Long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Long maxPrice) {
		this.maxPrice = maxPrice;
	}

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
