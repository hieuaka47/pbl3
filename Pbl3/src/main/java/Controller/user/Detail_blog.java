package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BlogDAOImpl;
import Model.Baiviet;
import Model.Diadiem;

/**
 * Servlet implementation class Detail
 */
@WebServlet(urlPatterns={"/detail_blog"})
public class Detail_blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("pid");
		BlogDAOImpl dao = new BlogDAOImpl();
		Baiviet b = dao.getBaiviet(id);
		List<Baiviet> list = dao.getAllBaiviet();
		List<Diadiem> listC = dao.getAllLocation();
		
		request.setAttribute("detail", b);
		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.getRequestDispatcher("detail_blog.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
