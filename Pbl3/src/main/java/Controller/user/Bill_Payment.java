package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.HistoryDAO;
import DAO.HistoryDAOlmpl;
import Model.Bill;

/**
 * Servlet implementation class Bill
 */
@WebServlet("/bill_payment")
public class Bill_Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HistoryDAO hisdao = new HistoryDAOlmpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Bill bill = (Bill) session.getAttribute("bill");
		hisdao.addHistory(bill);
		session.removeAttribute("cart");
		session.removeAttribute("bill");
		response.sendRedirect("home");
	}


}
