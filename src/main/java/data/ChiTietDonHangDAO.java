package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.NhanVien;
import model.SanPham;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{

	

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();
		try {
			String sql = "select * from chitietdonhang";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("Thực thi câu lệnh : " + ps.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maChiTietDonHang = rs.getString("machitietdonhang");
			int soLuong = rs.getInt("soluong");
			double giaGoc = rs.getDouble("giagoc");
			double giaBan = rs.getDouble("giaban");
			double giamGia = rs.getDouble("giamgia");
			double thueVAT = rs.getDouble("thuevat");
			double tongTien = rs.getDouble("tongtien");
			NhanVien maNhanVien = new NhanVienDAO().selectById(new NhanVien(rs.getString("manhanvien"), null, null, false, null, null));
			SanPham maSanPham = new SanPhamDAO().selectById(new SanPham(rs.getString("masanpham"), null, 0, 0, 0, 0, null, null, null, null));
			ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, soLuong, giaGoc, giaBan, giamGia, thueVAT, tongTien, maNhanVien, maSanPham);
			ketQua.add(ctdh);
		}
		JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		// TODO Auto-generated method stub
	ChiTietDonHang ctdh = null;
	Connection con = JDBCUtils.getConnection();
	try {
        String sql = "select * from chitietdonhang where machitietdonhang=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, t.getMaChiTietDonHang());
        System.out.println("Thực thi câu lệnh : " + ps.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String maChiTietDonHang = rs.getString("machitietdonhang");
            int soLuong = rs.getInt("soluong");
            double giaGoc = rs.getDouble("giagoc");
            double giaBan = rs.getDouble("giaban");
            double giamGia = rs.getDouble("giamgia");
            double thueVAT = rs.getDouble("thuevat");
            double tongTien = rs.getDouble("tongtien");
            NhanVien maNhanVien = new NhanVienDAO().selectById(new NhanVien(rs.getString("manhanvien"), null, null, false, null, null));
            SanPham maSanPham = new SanPhamDAO().selectById(new SanPham(rs.getString("masanpham"), null, 0, 0, 0, 0, null, null, null, null));
            ctdh = new ChiTietDonHang(maChiTietDonHang, soLuong, giaGoc, giaBan, giamGia, thueVAT, tongTien, maNhanVien, maSanPham);
        }
        JDBCUtils.closeConnection(con);
    } catch (Exception e) {
		e.printStackTrace();
	}
	return ctdh;
    }
	

	@Override
	public void insert(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		try {
            String sql = "insert into chitietdonhang(machitietdonhang, soluong, giagoc, giaban, giamgia, thuevat, tongtien, manhanvien, masanpham) values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaChiTietDonHang());
            ps.setInt(2, t.getSoLuong());
            ps.setDouble(3, t.getGiaGoc());
            ps.setDouble(4, t.getGiaBan());
            ps.setDouble(5, t.getGiamGia());
            ps.setDouble(6, t.getThueVAT());
            ps.setDouble(7, t.getTongTien());
            ps.setString(8, t.getMaNhanVien().getMaNhanVien());
            ps.setString(9, t.getMaSanPham().getMaSanPham());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void delete(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "delete from chitietdonhang where machitietdonhang = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaChiTietDonHang());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "update chitietdonhang set soluong = ?, giagoc = ?, giaban = ?, giamgia = ?, thuevat = ?, tongtien = ?, manhanvien = ?, masanpham = ? where machitietdonhang = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getSoLuong());
			ps.setDouble(2, t.getGiaGoc());
			ps.setDouble(3, t.getGiaBan());
			ps.setDouble(4, t.getGiamGia());
			ps.setDouble(5, t.getThueVAT());
			ps.setDouble(6, t.getTongTien());
			ps.setString(7, t.getMaNhanVien().getMaNhanVien());
			ps.setString(8, t.getMaSanPham().getMaSanPham());
			ps.setString(9, t.getMaChiTietDonHang());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
