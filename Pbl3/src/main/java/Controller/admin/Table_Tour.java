package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category_tourDAOImpl;
import DAO.TourDAOImpl;
import DAO.UserDAOImpl;
import Model.Category_tour;
import Model.Tour;
import Model.User;

/**
 * Servlet implementation class Table_Tour
 */
@WebServlet("/admin/table_tour")
public class Table_Tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		List<Tour> list = tourDAO.getAllTour();
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		
		request.setAttribute("listT", list);
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("tableTour.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
