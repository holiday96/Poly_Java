package Lab4;

public class SanPham {
	String maSP;
	String tenSP;
	DonViTinh dvt;
	long donGiaBan;
	String nhaCungCap;
	
	public SanPham() {
		super();
	}
	
	public SanPham(String maSP, String tenSP, DonViTinh dvt, long donGiaBan, String nhaCungCap) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.dvt = dvt;
		this.donGiaBan = donGiaBan;
		this.nhaCungCap = nhaCungCap;
	}

	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public DonViTinh getDvt() {
		return dvt;
	}
	public void setDvt(DonViTinh dvt) {
		this.dvt = dvt;
	}
	public long getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(long donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	
	
}
