package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Blog;
import Model.Category_blog;
import Model.Category_tour;
import Model.Tour;

public class BlogDAOImpl implements BlogDAO {
	@Override
	public List<Blog> getAllBlog() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from blog inner join category_blog on category_blog.id_cate = blog.id_cate order by id_blog";
		List<Blog> listB = new ArrayList<Blog>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_blog = rs.getInt("id_blog");
				String name_blog = rs.getString("name_blog");
				String description = rs.getString("description");
				Date dataSubmit = rs.getDate("dataSubmit");
				Category_blog cateID = new Category_blog(rs.getInt("id_cate"), rs.getString("name_cate"));
				String link = rs.getString("link");
				String img = rs.getString("img");
				listB.add(new Blog(id_blog,name_blog,description,dataSubmit,cateID,link,img));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listB;
	}

	@Override
	public void addBlog(Blog b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Blog> getListByCategory(int id_category) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from blog inner join category_blog on category_blog.id_cate = blog.id_cate where blog.id_cate='" + id_category + "' order by id_blog";
		List<Blog> listB = new ArrayList<Blog>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_blog = rs.getInt("id_blog");
				String name_blog = rs.getString("name_blog");
				String description = rs.getString("description");
				Date dataSubmit = rs.getDate("dataSubmit");
				Category_blog cateID = new Category_blog(rs.getInt("id_cate"), rs.getString("name_cate"));
				String link = rs.getString("link");
				String img = rs.getString("img");
				listB.add(new Blog(id_blog,name_blog,description,dataSubmit,cateID,link,img));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listB;
	}

	@Override
	public Blog getBlog(int id) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from blog inner join category_blog on category_blog.id_cate = blog.id_cate where blog.id_blog='" + id + "'";
		
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_blog = rs.getInt("id_blog");
				String name_blog = rs.getString("name_blog");
				String description = rs.getString("description");
				Date dataSubmit = rs.getDate("dataSubmit");
				Category_blog cateID = new Category_blog(rs.getInt("id_cate"), rs.getString("name_cate"));
				String link = rs.getString("link");
				String img = rs.getString("img");
				return new Blog(id_blog,name_blog,description,dataSubmit,cateID,link,img);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Blog> searchBlog(String blog_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Blog> pagingBlog (int index) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select * from blog inner join category_blog on category_blog.id_cate = blog.id_cate order by blog.id_blog limit ?, 5";
		List<Blog> list = new ArrayList<Blog>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(query);
			ps.setInt(1, (index-1)*5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_blog = rs.getInt("id_blog");
				String name_blog = rs.getString("name_blog");
				String description = rs.getString("description");
				Date dataSubmit = rs.getDate("dataSubmit");
				Category_blog cateID = new Category_blog(rs.getInt("id_cate"), rs.getString("name_cate"));
				String link = rs.getString("link");
				String img = rs.getString("img");
				list.add(new Blog(id_blog,name_blog,description,dataSubmit,cateID,link,img));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public int getTotalBlog() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select count(*) from blog";
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
		BlogDAOImpl blogDAO = new BlogDAOImpl();
//		List<Blog> list = blogDAO.getListByCategory(1);
//		for(Blog b:list){
//		    System.out.println(b);
//		}
		Blog a = new Blog();
		a = blogDAO.getBlog(9);
		System.out.println(a);
	}
	
}
