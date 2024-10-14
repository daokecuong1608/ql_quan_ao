package model;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private int namSanXuat;
	private double giaNhap;
	private double giaBan;
	private int soLuong;
	private String moTa;
	private String hinhAnh;
	private ThuongHieu maThuongHieu;
	private TheLoai maTheLoai;
	public SanPham(String maSanPham, String tenSanPham, int namSanXuat, double giaNhap, double giaBan, int soLuong,
			String moTa, String hinhAnh, ThuongHieu maThuongHieu, TheLoai maTheLoai) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.namSanXuat = namSanXuat;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.maThuongHieu = maThuongHieu;
		this.maTheLoai = maTheLoai;
	}
	public SanPham(String tenSanPham, int namSanXuat, double giaNhap, double giaBan, int soLuong, String moTa,
			String hinhAnh, ThuongHieu maThuongHieu, TheLoai maTheLoai) {
		super();
		this.tenSanPham = tenSanPham;
		this.namSanXuat = namSanXuat;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.maThuongHieu = maThuongHieu;
		this.maTheLoai = maTheLoai;
	}
	public SanPham() {
		super();
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public ThuongHieu getMaThuongHieu() {
		return maThuongHieu;
	}
	public void setMaThuongHieu(ThuongHieu maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}
	public TheLoai getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(TheLoai maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", namSanXuat=" + namSanXuat
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", moTa=" + moTa
				+ ", hinhAnh=" + hinhAnh + ", maThuongHieu=" + maThuongHieu + ", maTheLoai=" + maTheLoai + "]";
	}
	
}
