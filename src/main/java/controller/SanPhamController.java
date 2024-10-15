package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.SanPhamDAO;
import model.SanPham;

@WebServlet("/SanPhamController")
public class SanPhamController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SanPhamController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	
    	  String action = request.getParameter("action");
          String searchQuery = request.getParameter("searchQuery");

          if (searchQuery != null && !searchQuery.isEmpty()) {
              searchSanPham(request, response, searchQuery);
          } else if (action == null) {
              getAllSanPham(request, response);
          } else {
              if (action.equals("listSanPham")) {
                  getAllSanPham(request, response);
              }
          }
    }

    private void searchSanPham(HttpServletRequest request, HttpServletResponse response, String searchQuery)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	 SanPhamDAO spDAO = new SanPhamDAO();
         List<SanPham> sanPhamList = spDAO.findBySanPhamName(searchQuery);

         if (sanPhamList.isEmpty()) {
//             request.setAttribute("message", "Không tìm thấy sản phẩm nào khớp với từ khóa tìm kiếm.");
             response.setContentType("text/html;charset=UTF-8");
             response.getWriter().println("<html><body>");
             response.getWriter().println("<h3>Không tìm thấy sản phẩm nào khớp với từ khóa tìm kiếm.</h3>");
             response.getWriter().println("<a href='SanPhamController'>Quay lại trang chủ</a>");
             response.getWriter().println("</body></html>");
         }else {
         request.setAttribute("listSanPham", sanPhamList);
         request.setAttribute("searchQuery", searchQuery);

         RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
         dispatcher.forward(request, response);
         }
	}

    private void getAllSanPham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pageNumber = 0;
        int pageSize = 4;
        SanPhamDAO spDAO = new SanPhamDAO();
        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }

        List<SanPham> sanPhamList = spDAO.getSanPhamByPage(pageNumber, pageSize);
        int totalProducts = spDAO.soLuongSanPham();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        request.setAttribute("listSanPham", sanPhamList);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("totalPages", totalPages);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    public void findBySanPhamName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	        String tenSanPham = request.getParameter("tenSanPham");
        SanPhamDAO spDAO = new SanPhamDAO();
        List<SanPham> sanPhamList = spDAO.findBySanPhamName(tenSanPham);
        request.setAttribute("listSanPham", sanPhamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}