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
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "insert into user value(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getHoten());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setDate(6, u.getNgaysinh());
			ps.setBoolean(7, u.isGioitinh());
			ps.setString(8, u.getSdt());
			ps.setString(9, u.getDiachi());
			ps.setString(10, u.getRole());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkUser(String username) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
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
		System.out.println(dao.findUserByPhone("0915789629"));
	}

	@Override
	public boolean login(String username, String password) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
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
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "update user set hoten=?, email=?, password=?, ngaysinh=?, gioitinh=?, sdt=?, diachi=?, role=? where username=?";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.setString(1, u.getHoten());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setDate(4, u.getNgaysinh());
			ps.setBoolean(5, u.isGioitinh());
			ps.setString(6, u.getSdt());
			ps.setString(7, u.getDiachi());
			ps.setString(8, u.getRole());
			ps.setString(9, u.getUsername());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(String name) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from user where username='" + name + "'";
		User u = new User();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id= rs.getInt("user_id");
				String username = rs.getString("username");
				String hoten = rs.getString("hoten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date ngaysinh = rs.getDate("ngaysinh");
				Boolean gioitinh = rs.getBoolean("gioitinh");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String role = rs.getString("role");
				u = new User(user_id, username, hoten, email, password, ngaysinh, gioitinh, sdt, diachi, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User findUserByPhone(String phone_user) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from user where sdt='" + phone_user + "'";
		User u = new User();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id= rs.getInt("user_id");
				String username = rs.getString("username");
				String hoten = rs.getString("hoten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date ngaysinh = rs.getDate("ngaysinh");
				Boolean gioitinh = rs.getBoolean("gioitinh");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String role = rs.getString("role");
				u = new User(user_id, username, hoten, email, password, ngaysinh, gioitinh, sdt, diachi, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User findUserByEmail(String email_user) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from user where email='" + email_user + "'";
		User u = new User();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id= rs.getInt("user_id");
				String username = rs.getString("username");
				String hoten = rs.getString("hoten");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date ngaysinh = rs.getDate("ngaysinh");
				Boolean gioitinh = rs.getBoolean("gioitinh");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String role = rs.getString("role");
				u = new User(user_id, username, hoten, email, password, ngaysinh, gioitinh, sdt, diachi, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
