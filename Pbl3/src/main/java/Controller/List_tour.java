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
		int count = tourDAO.getTotalTour();
		int endPage = count/9;
		if (count % 9 != 0) {
			endPage++;
		}
		
		String indexPage = request.getParameter("index");
		if (indexPage == null || indexPage.equals("0")) {
			indexPage = "1";
		}
		if (indexPage.equals(String.valueOf(endPage))){
			indexPage = String.valueOf(endPage);
		}
		int index = Integer.parseInt(indexPage);
		
		List<Tour> listT = tourDAO.pagingTour(index);
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		
		request.setAttribute("endPage", endPage);
		request.setAttribute("listC", listC);
		request.setAttribute("listT", listT);
		request.setAttribute("tagP", index);
		request.setAttribute("tagAll", "all");
		request.getRequestDispatcher("/list_tour.jsp").forward(request, response);
	}
	
}
