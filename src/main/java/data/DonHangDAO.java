package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>{

	@Override
	public ArrayList<DonHang> selectAll() {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		try {
            String sql = "select * from donhang";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("madonhang");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String trangThai = rs.getString("trangthai");
                String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
                String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
                double soTienDaThanhToan = rs.getDouble("sotiendathanhtoan");
                double soTienConThieu = rs.getDouble("sotienconthieu");
                Date ngayDatHang = rs.getDate("ngaydathang");
                Date ngayGiaoHang = rs.getDate("ngaygiaohang");
                KhachHang maKhachHang = new KhachHangDAO().selectById(new KhachHang(rs.getString("makhachhang"), null, false, null, null, null, null, null, false, null, null));
ChiTietDonHang maChiTietDonHang = new ChiTietDonHangDAO().selectById(new ChiTietDonHang(rs.getString("machitietdonhang"), 0, 0, 0, 0, 0, 0, null, null));
                DonHang dh = new DonHang(maDonHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang, maKhachHang, maChiTietDonHang);
                ketQua.add(dh);
            }
            JDBCUtils.closeConnection(con);
            } catch (Exception e) {
            	e.printStackTrace();
            }
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		// TODO Auto-generated method stub
		DonHang donHang = null;
		Connection con = JDBCUtils.getConnection();
		String sql = "select * from donhang where madonhang=?;";
		try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaDonHang());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("madonhang");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String trangThai = rs.getString("trangthai");
                String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
                String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
                double soTienDaThanhToan = rs.getDouble("sotiendathanhtoan");
                double soTienConThieu = rs.getDouble("sotienconthieu");
                Date ngayDatHang = rs.getDate("ngaydathang");
                Date ngayGiaoHang = rs.getDate("ngaygiaohang");
                
                
                KhachHang maKhachHang = new KhachHangDAO().selectById(new KhachHang(rs.getString("makhachhang"), null, false, null, null, null, null, null, false, null, null));
                ChiTietDonHang maChiTietDonHang = new ChiTietDonHangDAO().selectById(new ChiTietDonHang(rs.getString("machitietdonhang"), 0, 0, 0, 0, 0, 0, null, null));
                donHang = new DonHang(maDonHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang, maKhachHang, maChiTietDonHang);
            }
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
        	e.printStackTrace();
        	}
		return donHang;
	}

	@Override
	public void insert(DonHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "insert into donhang(madonhang, diachinhanhang, trangthai, hinhthucthanhtoan, trangthaithanhtoan, sotiendathanhtoan, sotienconthieu, ngaydathang, ngaygiaohang, makhachhang, machitietdonhang) values(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaDonHang());
			ps.setString(2, t.getDiaChjNhanHang());
			ps.setString(3, t.getTrangThai());
			ps.setString(4, t.getHinhThucThanhToan());
			ps.setString(5, t.getTrangThaiThanhToan());
			ps.setDouble(6, t.getSoTienDaThanhToan());
			ps.setDouble(7, t.getSoTienConThieu());
			ps.setDate(8, new java.sql.Date(t.getNgayDatHang().getTime()));
			ps.setDate(9, new java.sql.Date(t.getNgayGiaoHang().getTime()));
			ps.setString(10, t.getMaKhachHang().getMaKhachHang());
			ps.setString(11, t.getMaChiTietDonHang().getMaChiTietDonHang());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}

	@Override
	public void delete(DonHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
            String sql = "delete from donhang where madonhang=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getMaDonHang());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(DonHang t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		String sql = "update donhang set diachinhanhang=?, trangthai=?, hinhthucthanhtoan=?, trangthaithanhtoan=?, sotiendathanhtoan=?, sotienconthieu=?, ngaydathang=?, ngaygiaohang=?, makhachhang=?, machitietdonhang=? where madonhang=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getDiaChjNhanHang());
			ps.setString(2, t.getTrangThai());
			ps.setString(3, t.getHinhThucThanhToan());
			ps.setString(4, t.getTrangThaiThanhToan());
			ps.setDouble(5, t.getSoTienDaThanhToan());
			ps.setDouble(6, t.getSoTienConThieu());
			ps.setDate(7, new java.sql.Date(t.getNgayDatHang().getTime()));
			ps.setDate(8, new java.sql.Date(t.getNgayGiaoHang().getTime()));
			ps.setString(9, t.getMaKhachHang().getMaKhachHang());
			ps.setString(10, t.getMaChiTietDonHang().getMaChiTietDonHang());
			ps.setString(11, t.getMaDonHang());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
