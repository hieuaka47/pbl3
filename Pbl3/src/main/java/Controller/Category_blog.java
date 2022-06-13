package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;
import DAO.Category_blogDAOImpl;
import DAO.Category_tourDAOImpl;
import DAO.TourDAOImpl;
import Model.Blog;
import Model.Tour;

@WebServlet("/category_blog")
public class Category_blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDAOImpl blogDAO = new BlogDAOImpl();
	private Category_blogDAOImpl category_blogDAO = new Category_blogDAOImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String id_cate = request.getParameter("id_cate");
		List<Blog> list = blogDAO.getListByCategory(Integer.parseInt(id_cate));
		List<Model.Category_blog> listC = category_blogDAO.getAllCategory();
		
		request.setAttribute("listC", listC);
		request.setAttribute("listB", list);
		request.setAttribute("tag", Integer.parseInt(id_cate));
		request.getRequestDispatcher("/list_blog.jsp").forward(request, response);
	}

}
