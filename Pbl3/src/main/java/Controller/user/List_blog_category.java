package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Baiviet;
import DAO.BlogDAOImpl;
import DAO.DAO;

import Model.Diadiem;

/**
 * Servlet implementation class Control
 */
@WebServlet("/list_blog_category")
public class List_blog_category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		BlogDAOImpl dao = new BlogDAOImpl();
		String idlocation = request.getParameter("cid");
		List<Baiviet> list = dao.getBaivietLID(idlocation);
		Diadiem d = dao.getLocationById(Integer.parseInt(idlocation));
		// List<Diadiem> listC = dao.getAllLocation();

		int count = dao.getTotalBlogByLID(idlocation);
		int endPage2 = count / 5;
		if (count % 5 != 0) {
			endPage2++;
		}

		String indexPage2 = request.getParameter("index2");
		if (indexPage2 == null || indexPage2.equals("0")) {
			indexPage2 = "1";
		}
		if (indexPage2.equals(String.valueOf(endPage2))) {
			indexPage2 = String.valueOf(endPage2);
		}
		int index2 = Integer.parseInt(indexPage2);

		// List<Baiviet> liste = dao.pagingBaivietByLID(index2);
		List<Diadiem> listC = dao.getAllLocation();

		request.setAttribute("endPage2", endPage2);
		request.setAttribute("list_baiviet", list);
		request.setAttribute("list_diadiem", listC);
		request.setAttribute("tagL", index2);
		request.setAttribute("tag", idlocation);
		request.setAttribute("tagAllB", "allB");
		request.setAttribute("location", d);
		request.getRequestDispatcher("list_blog_category.jsp").forward(request, response);

	}

}
