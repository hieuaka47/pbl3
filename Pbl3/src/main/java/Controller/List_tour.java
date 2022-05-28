package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category_tourDAOImpl;
import DAO.TourDAOImpl;
import Model.Tour;
import Model.Category_tour;

/**
 * Servlet implementation class List_tour
 */
@WebServlet("/list_tour")
public class List_tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		List<Tour> listT = tourDAO.getAllTour();
		
		request.setAttribute("listC", listC);
		request.setAttribute("listT", listT);
		request.getRequestDispatcher("/list_tour.jsp").forward(request, response);
	}
	


}
