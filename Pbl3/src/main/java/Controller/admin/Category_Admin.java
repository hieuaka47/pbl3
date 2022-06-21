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
import Model.Category_tour;
import Model.Tour;

/**
 * Servlet implementation class Category_selected
 */
@WebServlet("/admin/category_admin")
public class Category_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id_cate = request.getParameter("id_cate");
		
		List<Tour> list = tourDAO.getListByCategory(Integer.parseInt(id_cate));
		Category_tour cate = category_tourDAO.getCategoryById(Integer.parseInt(id_cate));
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		
		request.setAttribute("listC", listC);
		request.setAttribute("listT", list);
		request.setAttribute("cate", cate);
		request.getRequestDispatcher("tableTour.jsp").forward(request, response);

	}

}
