package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;

/**
 * Servlet implementation class Delete_Baiviet
 */
@WebServlet("/admin/delete_baiviet")
public class Delete_Baiviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String qid = request.getParameter("qid");
		BlogDAOImpl dao = new BlogDAOImpl();
		dao.deleteBaiviet(qid);
		response.sendRedirect("manager_blog");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
