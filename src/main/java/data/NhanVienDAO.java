package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.NhanVien;

public class NhanVienDAO implements DAOInterface<NhanVien> {

	@Override
	public ArrayList<NhanVien> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select * from nhanvien";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("manhanvien");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				boolean gioiTinh = rs.getBoolean("gioitinh");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				NhanVien nv = new NhanVien(maNhanVien, hoVaTen, ngaySinh, gioiTinh, tenDangNhap, matKhau);
				ketQua.add(nv);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public NhanVien selectById(NhanVien t) {
		// TODO Auto-generated method stub
		NhanVien nhanVien = null;
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select * from nhanvien where manhanvien=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaNhanVien());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("manhanvien");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				boolean gioiTinh = rs.getBoolean("gioitinh");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				nhanVien = new NhanVien(maNhanVien, hoVaTen, ngaySinh, gioiTinh, tenDangNhap, matKhau);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	@Override
	public void insert(NhanVien t) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "insert into nhanvien(manhanvien, hovaten, ngaysinh, gioitinh, tendangnhap, matkhau) values(?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaNhanVien());
			ps.setString(2, t.getHoVaTen());
			ps.setDate(3, new java.sql.Date(t.getNgaySinh().getTime()));
			ps.setBoolean(4, t.isGioiTinh());
			ps.setString(5, t.getTenDangNhap());
			ps.setString(6, t.getMatKhau());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void delete(NhanVien t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "delete from nhanvien where manhanvien=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaNhanVien());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void update(NhanVien t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();

		try {
			String sql = "update nhanvien set hovaten=?, ngaysinh=?, gioitinh=?, tendangnhap=?, matkhau=? where manhanvien=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getHoVaTen());
			ps.setDate(2, new java.sql.Date(t.getNgaySinh().getTime()));
			ps.setBoolean(3, t.isGioiTinh());
			ps.setString(4, t.getTenDangNhap());
			ps.setString(5, t.getMatKhau());
			ps.setString(6, t.getMaNhanVien());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
