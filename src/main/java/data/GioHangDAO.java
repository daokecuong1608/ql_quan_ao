package data;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import model.GioHang;
import model.KhachHang;

public class GioHangDAO {

	 private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final int LENGTH = 10; // Độ dài của chuỗi ngẫu nhiên

	    public static String generateRandomString() {
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder(LENGTH);
	        for (int i = 0; i < LENGTH; i++) {
	            int index = random.nextInt(CHARACTERS.length());
	            sb.append(CHARACTERS.charAt(index));
	        }
	        return sb.toString();
	    }

	
	public GioHang getGioHangByKhachHangId(Connection conn, String khachHangId) throws SQLException {
        String sql = "SELECT * FROM gio_hang WHERE makhachhang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, khachHangId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    GioHang gioHang = new GioHang();
                    gioHang.setMaGioHang(rs.getString("ma_gio_hang"));
                    KhachHang maKhachHang = new KhachHangDAO().selectById(new KhachHang(rs.getString("makhachhang")));
                 gioHang.setMaKhachHang(maKhachHang);
                    return gioHang;
                }
            }
        }
        return null;
    }
	
	
	  public GioHang createGioHang(Connection conn, String khachHangId) throws SQLException {
	        String sql = "INSERT INTO gio_hang (ma_gio_hang, ma_khach_hang) VALUES (?, ?)";
	        String id = generateRandomString();
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, id);
	            stmt.setString(2, khachHangId);
	            stmt.executeUpdate();
	            GioHang gioHang = new GioHang();
	            gioHang.setMaGioHang(id);
                KhachHang maKhachHang = new KhachHangDAO().selectById(new KhachHang(khachHangId));
	            gioHang.setMaKhachHang(maKhachHang);
	            return gioHang;
	        }
	    }
	  
	   public void addChiTietGioHang(Connection conn, String gioHangId, String maSanPham) throws SQLException {
	        String sql = "INSERT INTO chi_tiet_gio_hang (ma_chi_tiet_gio_hang, ma_gio_hang, masanpham, so_luong) VALUES (?, ?, ?, 1) " +
	                     "ON DUPLICATE KEY UPDATE so_luong = so_luong + 1";
	        String id = generateRandomString();
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, id);
	            stmt.setString(2, gioHangId);
	            stmt.setString(3, maSanPham);
	            stmt.executeUpdate();
	        }
	    }
	   public static void main(String[] args) {
		GioHangDAO gioHangDAO = new GioHangDAO();
		Connection conn = JDBCUtils.getConnection();
		try {
			GioHang gioHang = gioHangDAO.getGioHangByKhachHangId(conn, "KH001");
			System.out.println(gioHang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
