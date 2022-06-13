package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BillTour;

@WebServlet(urlPatterns = "/delete-from-cart")
public class DeleteFromCart extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		
		if(obj !=null) {
			Map<String,BillTour> map = (Map<String,BillTour>) obj;
			map.remove(key);
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/cart");
//		resp.sendRedirect("cart");
	}
}
