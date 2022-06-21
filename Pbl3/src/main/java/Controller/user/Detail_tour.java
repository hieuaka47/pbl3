package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TourDAOImpl;
import Model.Tour;

/**
 * Servlet implementation class Detail_tour
 */
@WebServlet("/detail_tour")
public class Detail_tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id_tour");
		
		Tour t = tourDAO.getTour(Integer.parseInt(id));
		request.setAttribute("detail_tour", t);
		request.getRequestDispatcher("detail_tour.jsp").forward(request,response);
	}
	

}
