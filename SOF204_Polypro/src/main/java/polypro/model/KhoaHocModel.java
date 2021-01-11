package polypro.model;

import java.util.Date;

public class KhoaHocModel {
	private int maKH;
	private double hocPhi;
	private int thoiLuong;
	private Date ngayKG;
	private String ghiChu;
	private Date ngayTao;
	
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public double getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(double hocPhi) {
		this.hocPhi = hocPhi;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public Date getNgayKG() {
		return ngayKG;
	}
	public void setNgayKG(Date ngayKG) {
		this.ngayKG = ngayKG;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
}
