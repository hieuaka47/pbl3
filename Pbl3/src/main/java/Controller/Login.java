package Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String status = "";
		if (username.equals("") || password.equals("")) {
			status = "nullErro";
		} else {
			if (userDAO.login(username, password) == false) {
				status = "failedAcc";
			}
		}

		if (status == "nullErro") {
			request.setAttribute("status", status);
		} else {
			request.setAttribute("status", status);
		}

		String url = "/login.jsp";
		try {
			if (status.length() == 0) {
				HttpSession session = request.getSession();
				User acc = userDAO.getUser(username);
				session.setAttribute("acc", acc);
//				session.setAttribute("cart", cart);
				session.setAttribute("status","successLogin");
	            response.sendRedirect("index.jsp");
			} else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login.jsp");
		}
	}

}
