package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ThuongHieu;

public class ThuongHieuDAO implements DAOInterface<ThuongHieu>{

	@Override
	public ArrayList<ThuongHieu> selectAll() {
		// TODO Auto-generated method stub
	
		ArrayList<ThuongHieu> ketQua = new ArrayList<ThuongHieu>();
		Connection con = JDBCUtils.getConnection();
		try {
			String sql = "select * from thuonghieu";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maThuongHieu = rs.getString("mathuonghieu");
				String tenThuongHieu = rs.getString("tenthuonghieu");
				String tieuSu = rs.getString("tieusu");
				ThuongHieu th = new ThuongHieu(maThuongHieu, tenThuongHieu, tieuSu);
				ketQua.add(th);
			}
			JDBCUtils.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ThuongHieu selectById(ThuongHieu t) {
		// TODO Auto-generated method stub
		ThuongHieu thuongHieu = null;
		Connection con = JDBCUtils.getConnection();
		try {
            String sql = "select * from thuonghieu where mathuonghieu=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaThuongHieu());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuongHieu = rs.getString("mathuonghieu");
                String tenThuongHieu = rs.getString("tenthuonghieu");
                String tieuSu = rs.getString("tieusu");
                thuongHieu = new ThuongHieu(maThuongHieu, tenThuongHieu, tieuSu);
            }
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return thuongHieu;
	}

	@Override
	public void insert(ThuongHieu t) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		try {
            String sql = "insert into thuonghieu(mathuonghieu, tenthuonghieu, tieusu) values(?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaThuongHieu());
            ps.setString(2, t.getTenThuongHieu());
            ps.setString(3, t.getTieuSu());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
        	e.printStackTrace();
  	
        }
	}

	@Override
	public void delete(ThuongHieu t) {
		// TODO Auto-generated method stub
		
		Connection connection = JDBCUtils.getConnection();
		try {
            String sql = "delete from thuonghieu where mathuonghieu = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getMaThuongHieu());
            System.out.println("Thực thi câu lệnh : " + ps.toString());
            ps.executeUpdate();
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void update(ThuongHieu t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "update thuonghieu set tenthuonghieu = ?, tieusu = ? where mathuonghieu = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getTenThuongHieu());
			ps.setString(2, t.getTieuSu());
			ps.setString(3, t.getMaThuongHieu());
			System.out.println("Thực thi câu lệnh : " + ps.toString());
			ps.executeUpdate();
			JDBCUtils.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ThuongHieuDAO thuongHieuDAO = new ThuongHieuDAO();
		ArrayList<ThuongHieu> dsThuongHieu = thuongHieuDAO.selectAll();
		for (ThuongHieu th : dsThuongHieu) {
			System.out.println(th);
		}
	}
}
