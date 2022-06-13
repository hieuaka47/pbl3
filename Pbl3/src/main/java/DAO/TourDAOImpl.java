package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Category_tour;
import Model.Tour;

public class TourDAOImpl implements TourDAO {

	@Override
	public List<Tour> getAllTour() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate order by id_tour";
		List<Tour> listT = new ArrayList<Tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_tour = rs.getInt("id_tour");
				Category_tour cateID = new Category_tour(rs.getInt("id_cate"), rs.getString("name_cate"));
				String name_tour = rs.getString("name_tour");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String duration = rs.getString("duration");
				Date date_start = rs.getDate("date_start");
				String pickup_locations = rs.getString("pickup_locations");
				int quantity_max_people = rs.getInt("quantity_max_people");
				int quantity_max_tour = rs.getInt("quantity_max_tour");
				String describe = rs.getString("describe");
				String schedule = rs.getString("schedule");
				listT.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people,
						quantity_max_tour,describe,schedule));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listT;
	}

	@Override
	public void addTour(Tour t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Tour> getListByCategory(int id_category) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.id_cate='" + id_category + "' order by id_tour";
		List<Tour> list = new ArrayList<Tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_tour = rs.getInt("id_tour");
				Category_tour cateID = new Category_tour(rs.getInt("id_cate"), rs.getString("name_cate"));
				String name_tour = rs.getString("name_tour");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String duration = rs.getString("duration");
				Date date_start = rs.getDate("date_start");
				String pickup_locations = rs.getString("pickup_locations");
				int quantity_max_people = rs.getInt("quantity_max_people");
				int quantity_max_tour = rs.getInt("quantity_max_tour");
				String describe = rs.getString("describe");
				String schedule = rs.getString("schedule");
				list.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people,
						quantity_max_tour,describe,schedule));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Tour getTour(int id) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.id_tour='" + id + "'";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_tour = rs.getInt("id_tour");
				Category_tour cateID = new Category_tour(rs.getInt("id_cate"), rs.getString("name_cate"));
				String name_tour = rs.getString("name_tour");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String duration = rs.getString("duration");
				Date date_start = rs.getDate("date_start");
				String pickup_locations = rs.getString("pickup_locations");
				int quantity_max_people = rs.getInt("quantity_max_people");
				int quantity_max_tour = rs.getInt("quantity_max_tour");
				String describe = rs.getString("describe");
				String schedule = rs.getString("schedule");
				return new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people,
						quantity_max_tour,describe,schedule);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tour> searchTour(String tour_name) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.name_tour like '%" + tour_name + "%'";
		List<Tour> list = new ArrayList<Tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_tour = rs.getInt("id_tour");
				Category_tour cateID = new Category_tour(rs.getInt("id_cate"), rs.getString("name_cate"));
				String name_tour = rs.getString("name_tour");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String duration = rs.getString("duration");
				Date date_start = rs.getDate("date_start");
				String pickup_locations = rs.getString("pickup_locations");
				int quantity_max_people = rs.getInt("quantity_max_people");
				int quantity_max_tour = rs.getInt("quantity_max_tour");
				String describe = rs.getString("describe");
				String schedule = rs.getString("schedule");
				list.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people,
						quantity_max_tour,describe,schedule));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public List<Tour> pagingTour (int index) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate order by tour.id_tour limit ?, 9";
		
		List<Tour> list = new ArrayList<Tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.setInt(1, (index-1)*3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_tour = rs.getInt("id_tour");
				Category_tour cateID = new Category_tour(rs.getInt("id_cate"), rs.getString("name_cate"));
				String name_tour = rs.getString("name_tour");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String duration = rs.getString("duration");
				Date date_start = rs.getDate("date_start");
				String pickup_locations = rs.getString("pickup_locations");
				int quantity_max_people = rs.getInt("quantity_max_people");
				int quantity_max_tour = rs.getInt("quantity_max_tour");
				String describe = rs.getString("describe");
				String schedule = rs.getString("schedule");
				list.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people,
						quantity_max_tour,describe,schedule));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public int getTotalTour() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select count(*) from tour";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		TourDAOImpl tourDAO = new TourDAOImpl();
		List<Tour> list = tourDAO.pagingTour(1);
		for(Tour t:list){
		    System.out.println(t);
		}
//		int count = tourDAO.getTotalTour();
//		System.out.println(count);
	}

}
