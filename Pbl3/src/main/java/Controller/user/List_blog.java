package Controller.user;

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
import Model.Category_blog;
import Model.Category_tour;
import Model.Tour;

/**
 * Servlet implementation class Blog
 */
@WebServlet("/list_blog")
public class List_blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDAOImpl blogDAO = new BlogDAOImpl();
	private Category_blogDAOImpl category_blogDAO = new Category_blogDAOImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = blogDAO.getTotalBlog();
		int endPage = count/5;
		if (count % 5 != 0) {
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
		
		List<Model.Blog> listB = blogDAO.pagingBlog(index);
		List<Category_blog> listC = category_blogDAO.getAllCategory();
		
		request.setAttribute("endPage", endPage);
		request.setAttribute("listC", listC);
		request.setAttribute("listB", listB);
		request.setAttribute("tagP", index);
		request.setAttribute("tagAllB", "allB");
		request.getRequestDispatcher("list_blog.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
