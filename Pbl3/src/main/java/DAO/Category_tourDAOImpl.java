package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Category_tour;
import Model.Tour;

public class Category_tourDAOImpl implements Category_tourDAO {

	@Override
	public List<Category_tour> getAllCategory() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from category_tour";
		List<Category_tour> list = new ArrayList<Category_tour>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_cate = rs.getInt("id_cate");
				String name_cate = rs.getString("name_cate");
				list.add(new Category_tour(id_cate, name_cate));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addCategory(Category_tour c) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "insert into category_tour value(?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, c.getId_cate());
			ps.setString(2, c.getName_cate());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Category_tourDAOImpl dao = new Category_tourDAOImpl();
//		Category_tour c = new Category_tour(4, "Đại gia");
		// dao.addCategory(c);
		// System.out.println(dao.getList());
		// dao.delCategory(10);
		List<Category_tour> list = new ArrayList<Category_tour>();
		list = dao.getAllCategory();
		for(Category_tour c:list){
		    System.out.println(c);
		}
	}

	@Override
	public void delCategory(int id_cate) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "delete from category_tour where id_cate='" + id_cate
				+ "'";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Category_tour getCategoryById(int id) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "select * from category_tour where id_cate='" + id + "'";
		Category_tour c = new Category_tour();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_cate = rs.getInt("id_cate");
				String name_cate = rs.getString("name_cate");
				c = new Category_tour(id_cate, name_cate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateCategory(Category_tour c) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String sql = "update category_tour set name_cate=? where id_cate=?";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.setString(1, c.getName_cate());
			ps.setInt(2, c.getId_cate());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
