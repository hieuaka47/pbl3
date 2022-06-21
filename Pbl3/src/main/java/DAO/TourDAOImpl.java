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
				listT.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listT;
	}

	@Override
	public void addTour(Tour t) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "insert into tour value(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.setInt(1, t.getId_tour());
			ps.setInt(2, t.getCateID().getId_cate());
			ps.setString(3, t.getName_tour());
			ps.setString(4, t.getImg());
			ps.setDouble(5, t.getPrice());
			ps.setString(6, t.getDuration());
			ps.setDate(7, (java.sql.Date) t.getDate_start());
			ps.setString(8, t.getPickup_locations());
			ps.setInt(9, t.getQuantity_max_people());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateTour(Tour t) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "update tour set id_cate=? ,name_tour=?, img=?, price=?, duration=?, date_start=?, pickup_locations=?, quantity_max_people=? where id_tour=?";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.setInt(1, t.getCateID().getId_cate());
			ps.setString(2, t.getName_tour());
			ps.setString(3, t.getImg());
			ps.setDouble(4, t.getPrice());
			ps.setString(5, t.getDuration());
			ps.setDate(6, (java.sql.Date) t.getDate_start());
			ps.setString(7, t.getPickup_locations());
			ps.setInt(8, t.getQuantity_max_people());
			ps.setInt(9, t.getId_tour());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	@Override
	public void deleteTour(int id) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "delete from tour where tour.id_tour='" + id + "'";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				list.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people));
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
				return new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getTotalTour(String action, String idCate, String search, String modeSort) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "";
		
		switch (action) {
		case "viewAll":
			if (search == null) {
				query = "select count(*) from tour";
			} else {
				query = "select count(*) from tour inner join category_tour on category_tour.id_cate = tour.id_cate where concat(tour.name_tour,tour.price) like '%" + search + "%'";
			}
			break;
			
		case "viewWithCondition":
			if (search == null) {
				query = "select count(*) from tour where tour.id_cate= '"+ idCate +"'";
			} else {
				query = "select count(*) from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.id_cate= '"+ idCate +"' and concat(tour.name_tour,tour.price) like '%" + search + "%'";
			}
			break;
		}
		
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
	
	public List<Tour> pagingTour (int index, String action, String idCate, String search, String modeSort) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();

		String query = "";
		
		switch (action) {
		case "viewAll":
			query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate ";
			if (search != null && modeSort != null) {
				query += "where concat(tour.name_tour,tour.price) like '%" + search + "%' order by tour.price ";
				if (modeSort.equals("asc")) {
					query += "limit ?, ?";
				} else {
					query += "desc limit ?, ?";
					}
			} 
			else if (search != null) {
				query += "where concat(tour.name_tour,tour.price,category_tour.name_cate) like '%" + search + "%' order by tour.id_tour limit ?, ?";
			}
			else if (modeSort != null) {
				if (modeSort.equals("desc")) {
					query += "order by tour.price desc limit ?, ?";
				} else {
					query += "order by tour.price limit ?, ?";
				}
			} 
			else {
				query += "order by tour.id_tour limit ?, ?";
			}
			
			break;
			
		case "viewWithCondition":
			query = "select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.id_cate= '"+ idCate +"' ";
			if (search != null && modeSort != null) {
				query += "and concat(tour.name_tour,tour.price) like '%" + search + "%' order by tour.price ";
				if (modeSort.equals("asc")) {
					query += "limit ?, ?";
				} else {
					query += "desc limit ?, ?";
					}
			} 
			else if (search != null) {
				query += "and concat(tour.name_tour,tour.price,category_tour.name_cate) like '%" + search + "%' order by tour.id_tour limit ?, ?";
			}
			else if (modeSort != null) {
				if (modeSort.equals("desc")) {
					query += "order by tour.price desc limit ?, ?";
				} else {
					query += "order by tour.price limit ?, ?";
				}
			} 
			else {
				query += "order by tour.id_tour limit ?, ?";
			}
			
			break;
		}
		
		List<Tour> list = new ArrayList<Tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			
			ps.setInt(1, (index-1)*9);
			ps.setInt(2, 9);
			
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
				list.add(new Tour(id_tour, cateID, name_tour,
						img, price, duration, date_start,pickup_locations,quantity_max_people));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public static void main(String[] args) {
		TourDAOImpl tourDAO = new TourDAOImpl();
//		List<Tour> list = tourDAO.sortTour("name_tour", "asc");
		List<Tour> list = tourDAO.getAllTour();
//		for(Tour t:list){
//		    System.out.println(t);
//		}
//		tourDAO.deleteTour(2);
//		int count = tourDAO.getTotalTour();
//		System.out.println(count);
	}

}
