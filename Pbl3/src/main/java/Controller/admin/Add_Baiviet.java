package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BlogDAOImpl;

/**
 * Servlet implementation class Add_Baiviet
 */
@WebServlet("/admin/add_baiviet")
public class Add_Baiviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String pidlocation = request.getParameter("idlocation");
		String ptitle = request.getParameter("title");
		String pbrief = request.getParameter("brief");
		String pnoidung = request.getParameter("noidung");
		String pimg = request.getParameter("img");
		String pimg2 = request.getParameter("img2");
		String pimg3 = request.getParameter("img3");
		String pimg4 = request.getParameter("img4");
		
		BlogDAOImpl dao = new BlogDAOImpl();
		dao.addBaiviet (pidlocation, ptitle, pbrief, pnoidung, pimg, pimg2, pimg3, pimg4);
		response.sendRedirect("manager_blog");
	}

}
