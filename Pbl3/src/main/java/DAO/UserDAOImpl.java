package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User u) {
		Connection con = DBConnect.getConnection();
		String sql = "insert into user value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setDate(5, u.getNgaysinh());
			ps.setString(6, u.getGioitinh());
			ps.setString(7, u.getSdt());
			ps.setString(8, u.getDiachi());
			ps.setString(9, u.getRole());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkUser(String username) {
		Connection con = DBConnect.getConnection();
		String sql = "select * from user where username='" + username + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		// dao.addUser(new User(0, "admin", "12345", "admin", "1"));
//		System.out.println(dao.checkUser("admin"));
//		System.out.println(dao.login("admin", "12345"));
		System.out.println(dao.getUser("Nhat Tan"));
	}

	@Override
	public boolean login(String username, String password) {
		Connection con = DBConnect.getConnection();
		String sql = "select * from user where username='" + username
				+ "' and password='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateUser(User u) {
//		Connection con = DBConnect.getConnecttion();
//		String sql = "update user set user_id=?, password=?, ngaysinh=?, gioitinh=?, email=?, sdt=?, diachi=?, role=? where username=?";
//		try {
//			PreparedStatement ps = (PreparedStatement) con
//					.prepareStatement(sql);
//			ps.setInt(1, u.getUser_id());
//			ps.setString(2, u.getPassword());
//			ps.setDate(3, u.getNgaysinh());
//			ps.setString(4, u.getGioitinh());
//			ps.setString(5, u.getEmail());
//			ps.setString(6, u.getSdt());
//			ps.setString(7, u.getDiachi());
//			ps.setString(8, u.getRole());
//			ps.setString(9, u.getUsername());
//			ps.executeUpdate();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	@Override
	public User getUser(String name) {
		Connection con = DBConnect.getConnection();
		String sql = "select * from user where username='" + name + "'";
		User u = new User();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id= rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gioitinh = rs.getString("gioitinh");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String role = rs.getString("role");
				u = new User(user_id, username, password, email, ngaysinh, gioitinh, sdt, diachi, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


}
