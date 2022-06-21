package Controller.user;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

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
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
	
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getRequestDispatcher("registration.jsp").forward(req, resp);
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
		System.out.println(gioitinh);
		System.out.println(Boolean.valueOf(gioitinh));
		String status = "";
		
		if (username.equals("") || email.equals("") || password.equals("") || sdt.equals("") || diachi.equals("")) {
			status = "nullErro";
		}
		else {
			if (userDAO.checkUser(username) == true) {
				status = "existAcc";
			} 
		}
		if (status == "nullErro") {
			request.setAttribute("status", status);
		} else {
			request.setAttribute("status", status);
		}
		System.out.println(status);
		try {
			if (status.length() == 0) {
				HttpSession session = request.getSession();
//				session.setAttribute("cart", cart);
				session.setAttribute("status","successReg");
				userDAO.addUser(new User(0, username, hoten, email, password, ngaysinh, Boolean.valueOf(gioitinh), sdt, diachi, "2"));
	            response.sendRedirect("index.jsp");
			} 
			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/registration.jsp");
		}
	}

}
