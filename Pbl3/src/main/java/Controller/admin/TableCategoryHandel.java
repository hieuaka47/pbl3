package Controller.admin;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Category_tourDAOImpl;
import Model.Category_tour;
import Model.Tour;

/**
 * Servlet implementation class TableCategoryHandel
 */
@WebServlet("/admin/tableCategoryHandel")
public class TableCategoryHandel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int id;
		
		switch (action) {	
		case "addOrUpdate":
			String name = request.getParameter("nameC");
			String cateID = request.getParameter("cateID");
			
			if (cateID == null) {
				Category_tour c = new Category_tour(0, name);
				category_tourDAO.addCategory(c);
			} else {
				Category_tour c = new Category_tour(Integer.parseInt(cateID), name);
				category_tourDAO.updateCategory(c);
			}

			response.sendRedirect("tableCategoryTour");
			
			break;
			
		case "delete":
			id = Integer.parseInt(request.getParameter("cid"));
			category_tourDAO.delCategory(id);
			response.sendRedirect("tableCategoryTour");
			break;	
		case "edit":
			id = Integer.parseInt(request.getParameter("cid"));
			Category_tour cate = category_tourDAO.getCategoryById(id);
			
			request.setAttribute("detailC", cate);
			request.getRequestDispatcher("editCategoryTour.jsp").forward(request, response);
			break;
		}
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
