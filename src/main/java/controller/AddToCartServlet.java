package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.GioHangDAO;
import data.JDBCUtils;
import model.GioHang;
import model.KhachHang;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
	        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

	        if (khachHang == null) {
	            response.sendRedirect(request.getContextPath() + "/index.jsp?message=Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng.");
	            return;
	        }

	        String maSanPham = request.getParameter("maSanPham");
	        String khachHangId = khachHang.getMaKhachHang();

	        try (Connection conn = JDBCUtils.getConnection()) {
	            GioHangDAO gioHangDAO = new GioHangDAO();

	            // Kiểm tra xem giỏ hàng đã tồn tại chưa
	            GioHang gioHang = gioHangDAO.getGioHangByKhachHangId(conn, khachHangId);
	            if (gioHang == null) {
	                // Tạo giỏ hàng mới
	                gioHang = gioHangDAO.createGioHang(conn, khachHangId);
	            }

	            // Thêm sản phẩm vào chi tiết giỏ hàng
	            gioHangDAO.addChiTietGioHang(conn, gioHang.getMaGioHang(), maSanPham);

	            String message = URLEncoder.encode("Sản phẩm đã được thêm vào giỏ hàng.", StandardCharsets.UTF_8.toString());
	            response.sendRedirect(request.getContextPath() + "/thongbao.jsp?message=" + message);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            String message = URLEncoder.encode("Đã xảy ra lỗi khi thêm sản phẩm vào giỏ hàng.", StandardCharsets.UTF_8.toString());
	            response.sendRedirect(request.getContextPath() + "/thongbao.jsp?message=" + message);
	        }
	    }

}
