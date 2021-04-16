package com.polyweb.model;

import java.util.List;

public class SanPhamModel extends AbstractModel<SanPhamModel> {
	private Integer idLoaiSP;
	private String tenSP;
	private String moTa;
	private Long minPrice;
	private Long maxPrice;
	private List<String> images;

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

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
