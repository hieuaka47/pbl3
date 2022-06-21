package Controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Category_tourDAOImpl;
import DAO.TourDAOImpl;
import DAO.UserDAOImpl;
import Model.Category_tour;
import Model.Tour;
import Model.User;

/**
 * Servlet implementation class Table_Tour_Handel
 */
@MultipartConfig
@WebServlet("/admin/table_tour_handel")
public class Table_Tour_Handel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDAOImpl tourDAO = new TourDAOImpl();
	private Category_tourDAOImpl category_tourDAO = new Category_tourDAOImpl();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int id;
		
		switch (action) {	
		case "addOrUpdate":
			String tourId = request.getParameter("idTour");
			int id_cate = Integer.parseInt(request.getParameter("category"));
			String name = request.getParameter("name");
			
			String pathImg = "";
			if (tourId == null) {
				Part part = request.getPart("img-upload");
				String fileNameImg = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				System.out.println(fileNameImg);
				String dg = "assets/img/tour";
				pathImg = dg + "/" + fileNameImg;
				part.write("C:\\Users\\FPTSHOP 206THD\\git\\repository\\Pbl3\\src\\main\\webapp\\assets\\img\\tour" + "/" + fileNameImg);
			} else {
				pathImg = request.getParameter("img-tour");
			}
			
			Double price =	Double.parseDouble(request.getParameter("price"));
			String duration	= request.getParameter("duration");
			java.sql.Date start = null;
			try {
				start = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start"))).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String pickup = request.getParameter("pickup");
			int people = Integer.parseInt(request.getParameter("people"));
			
			if (tourId == null) {
				Tour tour = new Tour (0,new Category_tour(id_cate, ""),name,pathImg,price,duration,start,pickup,people);
				tourDAO.addTour(tour);
			} else {
				Tour tour = new Tour (Integer.parseInt(tourId),new Category_tour(id_cate, ""),name,pathImg,price,duration,start,pickup,people);
				tourDAO.updateTour(tour);
			}
		
			response.sendRedirect("table_tour");
			
			break;
			
		case "delete":
			id = Integer.parseInt(request.getParameter("tid"));
			tourDAO.deleteTour(id);
			response.sendRedirect("table_tour");
			break;	
		case "edit":
			id = Integer.parseInt(request.getParameter("tid"));
			Tour t = tourDAO.getTour(id);
			List<Category_tour> listC = category_tourDAO.getAllCategory();
			
			request.setAttribute("detail", t);
			request.setAttribute("listC", listC);
			request.getRequestDispatcher("editTour.jsp").forward(request, response);
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
