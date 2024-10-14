package model;

import java.util.Date;

public class KhachHang {
	private String maKhachHang;
	private String hoVaTen;
	private boolean gioiTinh;
	private String diaChi;
	private String diaChiNhanHang;
	private Date ngaySinh;
	private String email;
	private String soDienThoai;
	private boolean dangKyNhanBangTin;
	private String tenDangNhap;
	private String matKhau;
	public KhachHang(String maKhachHang, String hoVaTen, boolean gioiTinh, String diaChi, String diaChiNhanHang,
			Date ngaySinh, String email, String soDienThoai, boolean dangKyNhanBangTin, String tenDangNhap,
			String matKhau) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public KhachHang(String hoVaTen, boolean gioiTinh, String diaChi, String diaChiNhanHang, Date ngaySinh,
			String email, String soDienThoai, boolean dangKyNhanBangTin, String tenDangNhap, String matKhau) {
		super();
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public KhachHang() {
		super();
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public boolean isDangKyNhanBangTin() {
		return dangKyNhanBangTin;
	}
	public void setDangKyNhanBangTin(boolean dangKyNhanBangTin) {
		this.dangKyNhanBangTin = dangKyNhanBangTin;
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
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", diaChi="
				+ diaChi + ", diaChiNhanHang=" + diaChiNhanHang + ", ngaySinh=" + ngaySinh + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + ", dangKyNhanBangTin=" + dangKyNhanBangTin + ", tenDangNhap="
				+ tenDangNhap + ", matKhau=" + matKhau + "]";
	}
	
}
