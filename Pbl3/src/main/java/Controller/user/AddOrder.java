package Controller.user;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import java.util.Map.Entry;
import java.util.Map;
import DAO.*;	
import Model.*;

@WebServlet(urlPatterns = "/add-order") 
public class AddOrder extends HttpServlet{
	private static final long serialVersionUID = 1L;
	HistoryDAO hisdao = new HistoryDAOlmpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doc tu session ra gio hang truoc
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session
		if(obj!=null) {		//kiem tra xem san pham co trong gio hang khong
			@SuppressWarnings("unchecked")
			Map<String, BillTour> map = (Map<String, BillTour>) obj;
			//tao hoa don truoc
			Bill bill = new Bill();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			bill.setBuyDate(dtf.format(now));
			Tour tour = (Tour) session.getAttribute("tour");
			User buyer = (User) session.getAttribute("loginUser");
			bill.setUsername(buyer.getHoten());									
			bill.setBuyer(buyer);
			bill.setTour(tour);
			bill.setId_user(buyer.getUser_id());
			bill.setIdTour(tour.getId_tour());
			int total = 0;
			int Amount_tour = 0;
			String name_tour ="";
			// lay cac phan tu trong map
			
			for(Entry<String,BillTour> entry :map.entrySet()) {
				BillTour billtour = entry.getValue();
				billtour.setList_name_tour(tour.getName_tour());
				total+= billtour.getUnitPrice();
				Amount_tour+= billtour.getQuantity();
				name_tour = name_tour+billtour.getList_name_tour()+"  ,  ";
			}
			
			bill.setName_tour(name_tour);
			bill.setAmount_tour(Amount_tour);
			bill.setPrice(total);
			System.out.println("aaa");
//			hisdao.addHistory(bill);
			req.setAttribute("bill", bill);
			session.setAttribute("bill", bill);
//			session.removeAttribute("cart");
			req.getRequestDispatcher("bill.jsp").forward(req, resp);
			// chuyen ve trang thanh cong
			// xoa session gio hang vi da tao don hang thanh cong, giai phong bo nho
			
//			session.removeAttribute("cart");
//			resp.sendRedirect(req.getContextPath() + "/Bill.jsp");
		}
		else {
			// tra ve trang chu neu gio hang rong
			resp.sendRedirect(req.getContextPath() + "/list_tour");
			JOptionPane.showMessageDialog(null,"Vui lòng đặt tour để tiến hành thanh toán !!");
		}
	}
}
