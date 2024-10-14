package model;

import java.util.Date;

public class DonHang {
	private String maDonHang;
	private String diaChjNhanHang;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double soTienDaThanhToan;
	private double soTienConThieu;
	private Date ngayDatHang;
	private Date ngayGiaoHang;
	private KhachHang maKhachHang;
	private ChiTietDonHang maChiTietDonHang;
	public DonHang(String maDonHang, String diaChjNhanHang, String trangThai, String hinhThucThanhToan,
			String trangThaiThanhToan, double soTienDaThanhToan, double soTienConThieu, Date ngayDatHang,
			Date ngayGiaoHang, KhachHang maKhachHang, ChiTietDonHang maChiTietDonHang) {
		super();
		this.maDonHang = maDonHang;
		this.diaChjNhanHang = diaChjNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.maKhachHang = maKhachHang;
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public DonHang(String diaChjNhanHang, String trangThai, String hinhThucThanhToan, String trangThaiThanhToan,
			double soTienDaThanhToan, double soTienConThieu, Date ngayDatHang, Date ngayGiaoHang, KhachHang maKhachHang,
			ChiTietDonHang maChiTietDonHang) {
		super();
		this.diaChjNhanHang = diaChjNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.maKhachHang = maKhachHang;
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public DonHang() {
		super();
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public String getDiaChjNhanHang() {
		return diaChjNhanHang;
	}
	public void setDiaChjNhanHang(String diaChjNhanHang) {
		this.diaChjNhanHang = diaChjNhanHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}
	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}
	public double getSoTienConThieu() {
		return soTienConThieu;
	}
	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}
	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public ChiTietDonHang getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setMaChiTietDonHang(ChiTietDonHang maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", diaChjNhanHang=" + diaChjNhanHang + ", trangThai=" + trangThai
				+ ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThaiThanhToan=" + trangThaiThanhToan
				+ ", soTienDaThanhToan=" + soTienDaThanhToan + ", soTienConThieu=" + soTienConThieu + ", ngayDatHang="
				+ ngayDatHang + ", ngayGiaoHang=" + ngayGiaoHang + ", maKhachHang=" + maKhachHang
				+ ", maChiTietDonHang=" + maChiTietDonHang + "]";
	}
	
}
