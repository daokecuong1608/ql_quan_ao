package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	@Override
	public ArrayList<TheLoai> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
		Connection con = JDBCUtils.getConnection();
		try {

			String sql = "select * from theloai";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				String moTa = rs.getString("mota");
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai, moTa);
				ketQua.add(tl);
			}
			JDBCUtils.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		// TODO Auto-generated method stub

		TheLoai theLoai = null;
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select * from theloai where matheloai=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				String moTa = rs.getString("mota");
				theLoai = new TheLoai(maTheLoai, tenTheLoai, moTa);

			}
			JDBCUtils.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return theLoai;

	}

	@Override
	public void insert(TheLoai t) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		try {

			String sql = "insert into theloai (matheloai ,tentheloai ,mota )  values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			ps.setString(2, t.getTenTheLoai());
			ps.setString(3, t.getMoTa());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		JDBCUtils.closeConnection(con);

	}

	@Override
	public void delete(TheLoai t) {
		// TODO Auto-generated method stub

		Connection con = JDBCUtils.getConnection();
		try {

			String sql = "delete from theloai where matheloai=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getMaTheLoai());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		JDBCUtils.closeConnection(con);

	}

	@Override
	public void update(TheLoai t) {
		// TODO Auto-generated method stub

		Connection con = JDBCUtils.getConnection();
		try {

			String sql = "update theloai set tentheloai=? ,mota=? where matheloai=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenTheLoai());
			ps.setString(2, t.getMoTa());
			ps.setString(3, t.getMaTheLoai());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBCUtils.closeConnection(con);
	}
	
	public static void main(String[] args) {
		TheLoaiDAO thuongHieuDAO = new TheLoaiDAO();
//		ArrayList<TheLoai> dsTheLoai = thuongHieuDAO.selectAll();
//		for (TheLoai theLoai : dsTheLoai) {
//			System.out.println(theLoai);
//		}
//		TheLoai [maTheLoai=TL010, tenTheLoai=Thể Loại J, moTa=Mô tả về thể loại J.]	
//	TheLoai theLoai = new TheLoai("TL010", "Thể Loại J", "Mô tả về thể loại J.");
//		thuongHieuDAO.delete(theLoai);
		
//		TheLoai theLoai = new TheLoai("TL010", "Thể Loại J", "Mô tả về thể loại J.");
//		thuongHieuDAO.insert(theLoai);
//		TheLoai theLoai = new TheLoai("TL010", "Thể Loại mmmm", "Mô tả về thể loại J.");
//		thuongHieuDAO.update(theLoai);
		
		TheLoai theLoai = new TheLoai("TL010", "", "");
		TheLoai theLoai2 = thuongHieuDAO.selectById(theLoai);
		System.out.println(theLoai2);
	}
}
