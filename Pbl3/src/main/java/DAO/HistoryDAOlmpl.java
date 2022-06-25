package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.*;


public class HistoryDAOlmpl implements HistoryDAO{
	
	public void addHistory(Bill bill) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "insert into history value(?,?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, bill.getId());
			ps.setInt(2, bill.getId_user());
			ps.setInt(3, bill.getIdTour());
			ps.setString(4, bill.getBuyDate());
			ps.setInt(5,bill.getAmount_tour());
			ps.setDouble(6, bill.getPrice());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	public List<History> getList(int id) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from history where user_id='"+ id +"' order by ngay_mua desc";
		List<History> list = new ArrayList<History>();
		try {	
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_history = rs.getInt("id_history");
				int user_id = rs.getInt("user_id");
				int id_tour = rs.getInt("id_tour");
				int quantity = rs.getInt("so_luong");
				Timestamp Date_time = rs.getTimestamp("ngay_mua");
				double price = rs.getDouble("thanh_tien");
				list.add(new History(id_history, user_id, id_tour, quantity ,Date_time,price));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<History> getListAll() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from history order by ngay_mua desc";
		List<History> list = new ArrayList<History>();
		try {	
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_history = rs.getInt("id_history");
				int user_id = rs.getInt("user_id");
				int id_tour = rs.getInt("id_tour");
				int quantity = rs.getInt("so_luong");
				Timestamp Date_time = rs.getTimestamp("ngay_mua");
				double price = rs.getDouble("thanh_tien");
				list.add(new History(id_history, user_id, id_tour, quantity ,Date_time,price));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public double getTotalMoneyInCurrenMonth() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		LocalDate currentdate = LocalDate.now();
		int currentMonth = currentdate.getMonthValue();
		
		String query = "select sum(thanh_tien), month(?) from history";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.setInt(1, currentMonth);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double getTotalMoney() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		LocalDate currentdate = LocalDate.now();
		int currentMonth = currentdate.getMonthValue();
		
		String query = "select sum(thanh_tien) from history";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
