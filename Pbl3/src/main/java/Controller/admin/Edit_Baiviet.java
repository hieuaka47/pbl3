package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;

/**
 * Servlet implementation class Edit_Baiviet
 */
@WebServlet("/admin/edit_Baiviet")
public class Edit_Baiviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String pid = request.getParameter("idbaiviet");
		String pidlocation = request.getParameter("idlocation");
		String ptitle = request.getParameter("title");
		String pbrief = request.getParameter("brief");
		String pnoidung = request.getParameter("noidung");
		String pimg = request.getParameter("img");
		String pimg2 = request.getParameter("img2");
		String pimg3 = request.getParameter("img3");
		String pimg4 = request.getParameter("img4");
		
		
		
		BlogDAOImpl dao = new BlogDAOImpl();
		dao.editBaiviet (pidlocation, ptitle, pbrief, pnoidung, pimg, pimg2, pimg3, pimg4,pid);
		response.sendRedirect("manager_blog");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
