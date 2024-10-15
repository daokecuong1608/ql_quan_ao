package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select * from khachhang";
		PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
						
				String maKhachHang = rs.getString("makhachhang");
				String hoVaTen = rs.getString("hovaten");
				boolean gioiTinh = rs.getBoolean("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String email = rs.getString("email");
				String soDienThoai = rs.getString("sodienthoai");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtinnhan");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
	

				KhachHang kh = new KhachHang(maKhachHang, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, ngaySinh, email, soDienThoai, dangKyNhanBangTin, tenDangNhap, matKhau);
				ketQua.add(kh);
				System.out.println(kh.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		KhachHang khachHang = null;
		Connection con = JDBCUtils.getConnection();
		try {
            String sql = "select * from khachhang where makhachhang=?;";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaKhachHang());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("makhachhang");
                String hoVaTen = rs.getString("hovaten");
                boolean gioiTinh = rs.getBoolean("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String email = rs.getString("email");
                String soDienThoai = rs.getString("sodienthoai");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtinnhan");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                khachHang = new KhachHang(maKhachHang, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, ngaySinh, email, soDienThoai, dangKyNhanBangTin, tenDangNhap, matKhau);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return khachHang;
		
	}

	@Override
	public void insert(KhachHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
            String sql = "insert into khachhang(makhachhang, hovaten, gioitinh, diachi, diachinhanhang, ngaysinh, email, sodienthoai, dangkynhanbangtin, tendangnhap, matkhau) values(?,?,?,?,?,?,?,?,?,?,?,?);";
            java.sql.PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getMaKhachHang());
            ps.setString(2, t.getHoVaTen());
            ps.setBoolean(3, t.isGioiTinh());
            ps.setString(4, t.getDiaChi());
            ps.setString(5, t.getDiaChiNhanHang());
            ps.setDate(6, new java.sql.Date(t.getNgaySinh().getTime()));
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getSoDienThoai());
            ps.setBoolean(9, t.isDangKyNhanBangTin());
            ps.setString(10, t.getTenDangNhap());
            ps.setString(11, t.getMatKhau());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
        	e.printStackTrace();
        	
        }
	}

	@Override
	public void delete(KhachHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
            String sql = "delete from khachhang where makhachhang = ?;";
            java.sql.PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getMaKhachHang());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	@Override
	public void update(KhachHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "update khachhang set hovaten=?, gioitinh=?, diachi=?, diachinhanhang=?, ngaysinh=?, email=?, sodienthoai=?, dangkynhanbangtin=?, tendangnhap=?, matkhau=? where makhachhang=?;";
			java.sql.PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getHoVaTen());
			ps.setBoolean(2, t.isGioiTinh());
			ps.setString(3, t.getDiaChi());
			ps.setString(4, t.getDiaChiNhanHang());
			ps.setDate(5, new java.sql.Date(t.getNgaySinh().getTime()));
			ps.setString(6, t.getEmail());
			ps.setString(7, t.getSoDienThoai());
			ps.setBoolean(8, t.isDangKyNhanBangTin());
			ps.setString(9, t.getTenDangNhap());
			ps.setString(10, t.getMatKhau());
			ps.setString(11, t.getMaKhachHang());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public KhachHang selectUserAndPassword(String tenDangNhap, String matKhau) {
		KhachHang khachHang = null;
		Connection con = JDBCUtils.getConnection();
		try {
			String sql ="select * from khachhang where tendangnhap=? and matkhau=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,tenDangNhap);
		ps.setString(2, matKhau);
		ResultSet rs = ps.executeQuery();
		System.out.println("Thực thi câu lệnh : " + sql);
		
		while (rs.next()) {
			 String maKhachHang = rs.getString("makhachhang");
             String hoVaTen = rs.getString("hovaten");
             boolean gioiTinh = rs.getBoolean("gioitinh");
             String diaChi = rs.getString("diachi");
             String diaChiNhanHang = rs.getString("diachinhanhang");
             Date ngaySinh = rs.getDate("ngaysinh");
             String email = rs.getString("email");
             String soDienThoai = rs.getString("sodienthoai");
             boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtinnhan");
             String tenDangNhap_1 = rs.getString("tendangnhap");
             String matKhau_1 = rs.getString("matkhau");
             khachHang = new KhachHang(maKhachHang, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, ngaySinh, email, soDienThoai, dangKyNhanBangTin, tenDangNhap_1, matKhau_1);
			System.out.println(khachHang.toString());
		}
		JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return khachHang;
		
	}
}
