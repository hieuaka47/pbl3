package Controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import DAO.TourDAO;
import DAO.TourDAOImpl;
import Model.BillTour;
import Model.Tour;

@WebServlet(urlPatterns = "/add-to-cart") 
public class AddToCart extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TourDAO tourDao = new TourDAOImpl();
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		
		String pId = req.getParameter("id");
		Tour tour = tourDao.getTour(Integer.parseInt(pId));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if(obj ==null) {
			BillTour billtour = new BillTour();
			billtour.setTour(tour);
			billtour.setQuantity(1);
			billtour.setUnitPrice(tour.getPrice());
			Map<String, BillTour> map = new HashMap<>();
			map.put(pId, billtour);
			session.setAttribute("cart", map);
		}else {
			Map<String,BillTour> map = (Map<String,BillTour>) obj;
			
			BillTour billtour = map.get(pId);
			if(billtour == null) {
				billtour = new BillTour();
				billtour.setTour(tour);
				billtour.setQuantity(1);
				billtour.setUnitPrice(tour.getPrice());
				
				map.put(pId, billtour);
			}else {
				billtour.setQuantity(billtour.getQuantity()+1);
			}
			session.setAttribute("cart", map);
		}
		session.setAttribute("cart_status", "succes");
		resp.sendRedirect(req.getContextPath() + "/cart");
	};
}
