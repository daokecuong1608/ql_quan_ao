package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("khachHang");

		// Chuyển hướng về trang chủ
		response.sendRedirect("SanPhamController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");

		// Kiểm tra thông tin đăng nhập
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHang khachHang = khachHangDAO.selectUserAndPassword(tenDangNhap, matKhau);

		if (khachHang != null) {
			// Tạo phiên đăng nhập
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);

			// Chuyển hướng đến SanPhamController để tải danh sách sản phẩm
			response.sendRedirect("SanPhamController");
		} else {
			// Thông tin đăng nhập không đúng, chuyển hướng lại trang đăng nhập với thông
			// báo lỗi
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
			request.getRequestDispatcher("/dangnhap.jsp").forward(request, response);;
			
		}
	}

}
