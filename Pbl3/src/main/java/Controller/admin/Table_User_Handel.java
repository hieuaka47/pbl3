package Controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class Table_User_Handel
 */
@WebServlet("/table_user_handel")
public class Table_User_Handel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String col = request.getParameter("col");
		String mode = request.getParameter("mode");
		
		List<User> list = userDAO.sortUser(col, mode);
		PrintWriter out = response.getWriter();
		for (User u : list) {
			out.println("		<tr>\r\n"
					+ "			<td>"+u.getUser_id()+"</td>\r\n"
					+ "			<td>"+u.getUsername()+"</td>\r\n"
					+ "			<td>"+u.getHoten()+"</td>\r\n"
					+ "			<td>"+u.getEmail()+"</td>\r\n"
					+ "			<td>"+u.getNgaysinh()+"</td>\r\n"
					+ "			<td>"+u.isGioitinh()+"</td>\r\n"
					+ "			<td>"+u.getSdt()+"</td>\r\n"
					+ "			<td>"+u.getDiachi()+"</td>\r\n"
					+ "			<td>"+u.getRole()+"</td>\r\n"
					+ "		</tr>");
		}
	}

}
