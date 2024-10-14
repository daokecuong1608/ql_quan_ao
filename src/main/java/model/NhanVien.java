package model;

import java.util.Date;

public class NhanVien {
	private String maNhanVien;
	private String hoVaTen;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String tenDangNhap;
	private String matKhau;
	public NhanVien(String maNhanVien, String hoVaTen, Date ngaySinh, boolean gioiTinh, String tenDangNhap,
			String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public NhanVien(String hoVaTen, Date ngaySinh, boolean gioiTinh, String tenDangNhap, String matKhau) {
		super();
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public NhanVien() {
		super();
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + "]";
	}
	
}
