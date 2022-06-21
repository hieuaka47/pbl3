package Controller.user;

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
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String idCate = request.getParameter("id_cate");
		String search = request.getParameter("search");
		String strSort = request.getParameter("selected");
		String modeSort = "";
		
		int count = 0;
		
		if (strSort.equals("Giá từ thấp đến cao") || strSort.equals("null") || strSort.equals("asc")) {
			modeSort = "asc";
		} else {
			modeSort = "desc";
		}
		
		switch (action) {
		case "viewAll":
			count = tourDAO.getTotalTour(action, idCate, search, modeSort);
			request.setAttribute("tagAll", "all");
			break;
			
		case "viewWithCondition":
			
			count = tourDAO.getTotalTour(action, idCate, search, modeSort);
			request.setAttribute("tag", Integer.parseInt(idCate));
			break;
		
//		case "viewWithCategory":
//			count = tourDAO.getTotalTour(action, idCate, search, modeSort);
//			request.setAttribute("tag", Integer.parseInt(idCate));
//			break;
			
//		case "search":
//			count = tourDAO.getTotalTour(action, idCate, search, modeSort);
//			request.setAttribute("txtSearch", search);
//			request.setAttribute("tagAll", "all");
//			break;	
//			
//		case "sort":
//			count = tourDAO.getTotalTour(action, idCate, search, modeSort);
//			request.setAttribute("mode", modeSort);
//			request.setAttribute("tagAll", "all");
//			break;

		default:
			break;
		}
		
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
		
		List<Tour> listT = tourDAO.pagingTour(index, action, idCate, search, modeSort);
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		
		request.setAttribute("endPage", endPage);
		request.setAttribute("tagP", index);
		request.setAttribute("action", action);
		request.setAttribute("mode", modeSort);
		request.setAttribute("txtSearch", search);
		
		request.setAttribute("listC", listC);
		request.setAttribute("listT", listT);
		request.getRequestDispatcher("/list_tour.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
