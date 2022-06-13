package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

import DAO.UserDAOImpl;
import Model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/update_user")
public class Update_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("profile_user.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String hoten = request.getParameter("yourname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		java.sql.Date ngaysinh= null;
		
		try {
			ngaysinh = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"))).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String gioitinh = request.getParameter("gender");
		String sdt = request.getParameter("number");
		String diachi = request.getParameter("address");
		String status = "";
		if (hoten.equals("") || email.equals("") || sdt.equals("") || diachi.equals("")) {
			status = "nullErro";
		}

		if (status == "nullErro") {
			request.setAttribute("status", status);
		}
		System.out.println(status);
		try {
			if (status.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("status","successUp");
				userDAO.updateUser(new User(0, username, hoten, email, password, ngaysinh, Boolean.parseBoolean(gioitinh), sdt, diachi, "2"));
			
				User acc = userDAO.getUser(username);
				session.setAttribute("acc", acc);
	            response.sendRedirect("profile_user.jsp");
	            
			} 
			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/profile_user.jsp");
				rd.forward(request, response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/profile_user.jsp");
		}
	}

}
