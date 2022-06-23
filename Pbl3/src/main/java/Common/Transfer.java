package Common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location");
		if (location.equals("list_tour")) {
			response.sendRedirect(request.getContextPath()+"/list_tour?action=viewAll&selected=null");
		} else {
			response.sendRedirect(request.getContextPath()+"/" + location);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
