package model;

public class ThuongHieu {
	private String maThuongHieu;
	private String tenThuongHieu;
	private String tieuSu;
	public ThuongHieu(String maThuongHieu, String tenThuongHieu, String tieuSu) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.tieuSu = tieuSu;
	}
	public ThuongHieu(String tenThuongHieu, String tieuSu) {
		super();
		this.tenThuongHieu = tenThuongHieu;
		this.tieuSu = tieuSu;
	}
	public ThuongHieu() {
		super();
	}
	public String getMaThuongHieu() {
		return maThuongHieu;
	}
	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}
	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	@Override
	public String toString() {
		return "ThuongHieu [maThuongHieu=" + maThuongHieu + ", tenThuongHieu=" + tenThuongHieu + ", tieuSu=" + tieuSu
				+ "]";
	}
	
}
