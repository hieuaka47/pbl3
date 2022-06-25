package Controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;
import DAO.DAO;
import Model.Baiviet;
import Model.Diadiem;

/**
 * Servlet implementation class Post
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		BlogDAOImpl dao = new BlogDAOImpl();
		Diadiem d = new Diadiem();

	   	int count = dao.getTotalBlog();
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
		
		List<Baiviet> list = dao.pagingBaiviet(index);
	   	 //List<Baiviet> list = dao.getAllBaiviet() ;
	   	 List<Diadiem> listC = dao.getAllLocation();
	   	 
	   	request.setAttribute("endPage", endPage);
	   	 request.setAttribute("list_baiviet", list);
	   	 request.setAttribute("list_diadiem", listC);
	   	request.setAttribute("tagP", index);
		request.setAttribute("tagAllB", "allB");
	   	 request.getRequestDispatcher("list_blog.jsp").forward(request, response);
	 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
