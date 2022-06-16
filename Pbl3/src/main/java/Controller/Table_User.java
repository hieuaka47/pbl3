package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class Table_User
 */
@WebServlet("/table_user")
public class Table_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = userDAO.getAllUser();
		request.setAttribute("listU", list);
		request.getRequestDispatcher("admin/tableUser.jsp").forward(request, response);
	}

}
