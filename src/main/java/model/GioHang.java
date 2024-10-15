package model;

import java.util.List;

public class GioHang {
    private String maGioHang ;
    private KhachHang maKhachHang;
    private List<ChiTietGioHang> chiTietGioHangList;
	public GioHang(String maGioHang, KhachHang maKhachHang, List<ChiTietGioHang> chiTietGioHangList) {
		super();
		this.maGioHang = maGioHang;
		this.maKhachHang = maKhachHang;
		this.chiTietGioHangList = chiTietGioHangList;
	}
	public GioHang(KhachHang maKhachHang, List<ChiTietGioHang> chiTietGioHangList) {
		super();
		this.maKhachHang = maKhachHang;
		this.chiTietGioHangList = chiTietGioHangList;
	}
	public GioHang() {
		super();
	}
	public String getMaGioHang() {
		return maGioHang;
	}
	public void setMaGioHang(String maGioHang) {
		this.maGioHang = maGioHang;
	}
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public List<ChiTietGioHang> getChiTietGioHangList() {
		return chiTietGioHangList;
	}
	public void setChiTietGioHangList(List<ChiTietGioHang> chiTietGioHangList) {
		this.chiTietGioHangList = chiTietGioHangList;
	}
	@Override
	public String toString() {
		return "GioHang [maGioHang=" + maGioHang + ", maKhachHang=" + maKhachHang + ", chiTietGioHangList="
				+ chiTietGioHangList + "]";
	}
	
   
    
}