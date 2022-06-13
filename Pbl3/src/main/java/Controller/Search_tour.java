package Controller;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category_tourDAOImpl;
import DAO.TourDAOImpl;
import Model.Category_tour;
import Model.Tour;

/**
 * Servlet implementation class Search_tour
 */
@WebServlet("/search_tour")
public class Search_tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String a = (String) request.getParameter("txt_search");
		String txtSearch = java.net.URLDecoder.decode(a, "UTF-8");
		System.out.println(txtSearch);
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		List<Tour> list = tourDAO.searchTour(txtSearch);
		request.setAttribute("listT", list);
		request.setAttribute("listC", listC);
		request.setAttribute("tagAll", "all");
		request.setAttribute("txt_search_value", txtSearch);
		request.getRequestDispatcher("/list_tour.jsp").forward(request, response);
	}

}
