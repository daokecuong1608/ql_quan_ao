package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import model.TheLoai;
import model.ThuongHieu;

public class SanPhamDAO implements DAOInterface<SanPham> {

	@Override
	public ArrayList<SanPham> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
		Connection con = JDBCUtils.getConnection();

		try {
			String sql = "select * from sanpham";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				int namSanXuat = rs.getInt("namsanxuat");
				double giaNhap = rs.getDouble("gianhap");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String moTa = rs.getString("mota");
				String hinhAnh = rs.getString("hinhanh");

				ThuongHieu maThuongHieu = new ThuongHieuDAO()
						.selectById(new ThuongHieu(rs.getString("mathuonghieu"), null, null));
				TheLoai maTheLoai = new TheLoaiDAO().selectById(new TheLoai(rs.getString("matheloai"), null, null));
				SanPham sp = new SanPham(maSanPham, tenSanPham, namSanXuat, giaNhap, giaBan, soLuong, moTa, hinhAnh,
						maThuongHieu, maTheLoai);

				ketQua.add(sp);
				System.out.println(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public SanPham selectById(SanPham t) {
		// TODO Auto-generated method stub
		SanPham sp = null;
		Connection con = JDBCUtils.getConnection();

		try {
			String sql = "select * from sanpham where masanpham=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				int namSanXuat = rs.getInt("namsanxuat");
				double giaNhap = rs.getDouble("gianhap");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String moTa = rs.getString("mota");
				String hinhAnh = rs.getString("hinhanh");

				ThuongHieu maThuongHieu = new ThuongHieuDAO()
						.selectById(new ThuongHieu(rs.getString("mathuonghieu"), null, null));
				TheLoai maTheLoai = new TheLoaiDAO().selectById(new TheLoai(rs.getString("matheloai"), null, null));
				sp = new SanPham(maSanPham, tenSanPham, namSanXuat, giaNhap, giaBan, soLuong, moTa, hinhAnh,
						maThuongHieu, maTheLoai);
			}
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public void insert(SanPham t) {
		// TODO Auto-generated method stub

		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "insert into sanpham(masanpham, tensanpham, namsanxuat, gianhap, giaban, soluong, mota, hinhanh, mathuonghieu, matheloai) values(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setInt(3, t.getNamSanXuat());
			ps.setDouble(4, t.getGiaNhap());
			ps.setDouble(5, t.getGiaBan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getMoTa());
			ps.setString(8, t.getHinhAnh());
			ps.setString(9, t.getMaThuongHieu().getMaThuongHieu());
			ps.setString(10, t.getMaTheLoai().getMaTheLoai());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(SanPham t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();

		try {
			String sql = "delete from sanpham where masanpham=?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SanPham t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "update sanpham set tensanpham=?, namsanxuat=?, gianhap=?, giaban=?, soluong=?, mota=?, hinhanh=?, mathuonghieu=?, matheloai=? where masanpham=?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getTenSanPham());
			ps.setInt(2, t.getNamSanXuat());
			ps.setDouble(3, t.getGiaNhap());
			ps.setDouble(4, t.getGiaBan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getMoTa());
			ps.setString(7, t.getHinhAnh());
			ps.setString(8, t.getMaThuongHieu().getMaThuongHieu());
			ps.setString(9, t.getMaTheLoai().getMaTheLoai());
			ps.setString(10, t.getMaSanPham());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int soLuongSanPham() {
		int soLuong = 0;
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select count(*) from sanpham";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				soLuong = rs.getInt(1);
			}
			JDBCUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soLuong;
	}

	public List<SanPham> getSanPhamByPage(int pageNumber, int pageSize) {
        List<SanPham> ketQua = new ArrayList<>();
        String sql = "SELECT * FROM SanPham ORDER BY masanpham LIMIT ? OFFSET ?";
        try (Connection con = JDBCUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, pageNumber * pageSize);
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				int namSanXuat = rs.getInt("namsanxuat");
				double giaNhap = rs.getDouble("gianhap");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String moTa = rs.getString("mota");
				String hinhAnh = rs.getString("hinhanh");

				ThuongHieu maThuongHieu = new ThuongHieuDAO()
						.selectById(new ThuongHieu(rs.getString("mathuonghieu"), null, null));
				TheLoai maTheLoai = new TheLoaiDAO().selectById(new TheLoai(rs.getString("matheloai"), null, null));
				SanPham sp = new SanPham(maSanPham, tenSanPham, namSanXuat, giaNhap, giaBan, soLuong, moTa, hinhAnh,
						maThuongHieu, maTheLoai);

				ketQua.add(sp);
            }
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
	
	
	
	public static void main(String[] args) {
		SanPhamDAO sp = new SanPhamDAO();
		  int pageNumber = 2; // Trang 3 (0-based index)
	        int pageSize = 2; // Số lượng sản phẩm mỗi trang
//	        List<SanPham> sanPhamList = sp.getSanPhamByPage(pageNumber, pageSize);
	        List<SanPham> sanPhamList = sp.selectAll();
	        sanPhamList.forEach(spa -> System.out.println(spa.getTenSanPham()));
	}
	
}