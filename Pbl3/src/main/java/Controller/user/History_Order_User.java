package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.HistoryDAOlmpl;
import DAO.TourDAOImpl;
import Model.History;
import Model.User;

/**
 * Servlet implementation class History_Order_User
 */
@WebServlet("/history_order_user")
public class History_Order_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourDAOImpl tourDAO = new TourDAOImpl();
	HistoryDAOlmpl historyDAO = new HistoryDAOlmpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.setAttribute("isHistory", "isHistory");
		
		request.getRequestDispatcher("history_user.jsp").forward(request, response);
	}

}
