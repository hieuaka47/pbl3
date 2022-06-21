package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.EmailUtils;
import DAO.UserDAOImpl;
import Model.Email;
import Model.User;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emaiAddress = request.getParameter("email");
			User user = userDAO.findUserByEmail(emaiAddress);
			
			if (user == null) {
				request.setAttribute("message", "incorrect");
			} else {
				Email email = new Email();
				email.setFrom("anhtutun@gmail.com");
				email.setFromPassword("gyradpoutpxebniy");
				email.setTo(emaiAddress);
				email.setSubject("Ăn có cái pass thôi cũng không nhớ :v");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(user.getUsername()).append("<br>");
				sb.append("You are used the forgot password function. <br>");
				sb.append("Your password is <b> ").append(user.getPassword()).append("</br>");
				sb.append("<br>");
				sb.append("Admin");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("message", "correct");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
