package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;
import Model.Baiviet;
import Model.Diadiem;

/**
 * Servlet implementation class Manager_Baiviet
 */
@WebServlet("/admin/manager_blog")
public class Manager_Baiviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogDAOImpl dao = new BlogDAOImpl();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Baiviet> list = dao.getAllBaiviet();
		List<Diadiem> listc = dao.getAllLocation();
		
		 request.setAttribute("list_baivietMN", list);
		 request.setAttribute("list_diadiemMN", listc);
		 request.getRequestDispatcher("table_blog.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
