package model;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private int soLuong;
	private double giaGoc;
	private double giaBan;
	private double giamGia;
	private double thueVAT;
	private double tongTien;
	private NhanVien maNhanVien;
	private SanPham maSanPham;
	public ChiTietDonHang(String maChiTietDonHang, int soLuong, double giaGoc, double giaBan, double giamGia,
			double thueVAT, double tongTien, NhanVien maNhanVien, SanPham maSanPham) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.thueVAT = thueVAT;
		this.tongTien = tongTien;
		this.maNhanVien = maNhanVien;
		this.maSanPham = maSanPham;
	}
	public ChiTietDonHang(int soLuong, double giaGoc, double giaBan, double giamGia, double thueVAT, double tongTien,
			NhanVien maNhanVien, SanPham maSanPham) {
		super();
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.thueVAT = thueVAT;
		this.tongTien = tongTien;
		this.maNhanVien = maNhanVien;
		this.maSanPham = maSanPham;
	}
	public ChiTietDonHang() {
		super();
	}
	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public SanPham getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(SanPham maSanPham) {
		this.maSanPham = maSanPham;
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", soLuong=" + soLuong + ", giaGoc=" + giaGoc
				+ ", giaBan=" + giaBan + ", giamGia=" + giamGia + ", thueVAT=" + thueVAT + ", tongTien=" + tongTien
				+ ", maNhanVien=" + maNhanVien + ", maSanPham=" + maSanPham + "]";
	}
	
}
