package model;

public class ChiTietGioHang {
    private String maChiTietGioHang;
    private GioHang maGioHang;
    private SanPham maSanPham;
    private int soLuong;
	public ChiTietGioHang(String maChiTietGioHang, GioHang maGioHang, SanPham maSanPham, int soLuong) {
		super();
		this.maChiTietGioHang = maChiTietGioHang;
		this.maGioHang = maGioHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}
	public ChiTietGioHang(GioHang maGioHang, SanPham maSanPham, int soLuong) {
		super();
		this.maGioHang = maGioHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}
	public ChiTietGioHang() {
		super();
	}
	public String getMaChiTietGioHang() {
		return maChiTietGioHang;
	}
	public void setMaChiTietGioHang(String maChiTietGioHang) {
		this.maChiTietGioHang = maChiTietGioHang;
	}
	public GioHang getMaGioHang() {
		return maGioHang;
	}
	public void setMaGioHang(GioHang maGioHang) {
		this.maGioHang = maGioHang;
	}
	public SanPham getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(SanPham maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietGioHang [maChiTietGioHang=" + maChiTietGioHang + ", maGioHang=" + maGioHang + ", maSanPham="
				+ maSanPham + ", soLuong=" + soLuong + "]";
	}

    
    
}