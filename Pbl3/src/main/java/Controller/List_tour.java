package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TourDAOImpl;
import Model.Tour;

/**
 * Servlet implementation class List_tour
 */
@WebServlet("/list_tour")
public class List_tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		List<Tour> list = tourDAO.getAllTour();
		request.setAttribute("a", "a");
		request.setAttribute("listT", list);
		request.getRequestDispatcher("/list_tour.jsp").forward(request, response);
	}

}
