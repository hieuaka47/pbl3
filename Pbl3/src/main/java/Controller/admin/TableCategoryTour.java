package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Category_tourDAOImpl;
import Model.Category_tour;

/**
 * Servlet implementation class TableCategoryTour
 */
@WebServlet("/admin/tableCategoryTour")
public class TableCategoryTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category_tour> listC = category_tourDAO.getAllCategory();
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("tableCategoryTour.jsp").forward(request, response);
	}

}
