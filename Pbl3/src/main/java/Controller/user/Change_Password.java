package Controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAOImpl;
import Model.User;


/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/change_password")
public class Change_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//	    response.setCharacterEncoding("UTF-8");
		
		String oldP = request.getParameter("oldP");
		String newP = request.getParameter("newP");
		String reNewP = request.getParameter("reNewP");
		
		HttpSession session = request.getSession(false);
		User acc = (User) session.getAttribute("acc");
		String mess = "";
		
		if (!acc.getPassword().equals(oldP)) {
			mess = "Current password is incorrect";
		} else {
			if (!newP.equals(reNewP)) {
				mess = "New password and Confirm password no match";
			} else {
				userDAO.changePassword(acc.getUser_id(), newP);
				acc.setPassword(newP);
				session.setAttribute("acc", acc);
				mess = "Change password successful";
			}
		}
		PrintWriter out = response.getWriter();
		out.write(mess);
	}

}
