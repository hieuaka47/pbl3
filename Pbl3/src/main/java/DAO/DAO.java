package DAO;

import Model.Baiviet;
import Model.Category_tour;
import Model.Diadiem;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.lang.*;

import DAO.DBConnect;
import Controller.user.*;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Baiviet> pagingBaiviet(int index) {
		DBConnect db = DBConnect.getInstance();
		Connection conn = db.getConnection();
		String query = "select * from pbl3.baiviet order by baiviet.idbaiviet limit ?, 5";
		List<Baiviet> list = new ArrayList<Baiviet>();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Baiviet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)

				));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
// public List<Baiviet> pagingBaivietByLID (int index2) {
//		BaivietConnect db = BaivietConnect.getInstance();
//		Connection conn = db.getConnect();
//		String query = "select * from post.baiviet order by baiviet.idlocation limit ?, 5";
//		List<Baiviet> list = new ArrayList<Baiviet>();
//		try {
//			 ps =  conn.prepareStatement(query);
//			ps.setInt(1, (index2-1)*5);
//			ResultSet rs = ps.executeQuery();
//			 while(rs.next()) {
//				 list.add(new Baiviet(
//						 rs.getInt(1),
//						 rs.getInt(2),
//						 rs.getString(3),
//						 rs.getString(4),
//						 rs.getString(5),
//						 rs.getString(6),
//						 rs.getString(7),
//						 rs.getString(8),
//						 rs.getString(9)
//						 
//						 ));
//				 
//				 
//			 }
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	
//	}

	public int getTotalBlog() {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select count(*) from pbl3.baiviet";
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int getTotalBlogByLID(String idlocation) {
		DBConnect db = DBConnect.getInstance();
		Connection con = db.getConnection();
		String query = "select count(*) from pbl3.baiviet where idlocation = ?";
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getInt(2));
				return rs.getInt(2);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Baiviet> getAllBaiviet() {
		List<Baiviet> list = new ArrayList<>();
		String query = "select * from baiviet";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Baiviet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)

				));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Diadiem> getAllLocation() {
		List<Diadiem> list = new ArrayList<>();
		String query = "select * from diadiem";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Diadiem(rs.getInt(1),

						rs.getString(2)

				));
			}
		} catch (Exception e) {

		}
		return list;
	}
	
	public Diadiem getLocationById(int id) {
		String query = "select * from diadiem where idlocation='" + id + "'";
		Diadiem d = new Diadiem();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idlocation = rs.getInt("idlocation");
				String diadiem = rs.getString("diadiem");
				d = new Diadiem(idlocation, diadiem);
			}
		} catch (Exception e) {

		}
		return d;
	}

	public List<Baiviet> getBaivietLID(String idlocation) {
		List<Baiviet> list = new ArrayList<>();
		String query = "select * from baiviet\n" + "where idlocation = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idlocation);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Baiviet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)

				));
				// System.out.println(rs.getInt(1)+"
				// "+rs.getInt(2)+""+rs.getString(3)+""+rs.getString(4)+""+ rs.getString(5));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public Baiviet getBaiviet(String id) {

		String query = "SELECT * FROM pbl3.baiviet\r\n" + "where idbaiviet = '" + id + "'";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				return new Baiviet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)

				);
				// System.out.println(rs.getInt(1)+"
				// "+rs.getInt(2)+""+rs.getString(3)+""+rs.getString(4)+""+ rs.getString(5));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

//  public List<Baiviet> SearchByTitle(String txtsearch){
//	  List<Baiviet> list = new ArrayList<>();
//	  String query = "SELECT * FROM post.baiviet \r\n"
//	  		+ "where title like '%"+txtsearch+"'%";
//	  try {
//		  conn = new BaivietConnect().getConnect();
//		  
//		  ps = conn.prepareStatement(query);
//		  //ps.setString(1,"%"+txtsearch+"%");
//		  
//		  rs = ps.executeQuery(); 
//			  while (rs.next()) {
//				  list.add(new Baiviet(
//							 rs.getInt(1),
//							 rs.getInt(2),
//							 rs.getString(3),
//							 rs.getString(4),
//							 rs.getString(5),
//							 rs.getString(6),
//							 rs.getString(7),
//							 rs.getString(8),
//							 rs.getString(9)
//							
//							 ));
//			  }
//		  
//	  }catch (Exception e) {
//		  
//	  }
//	  return list;
	// }
	public void addBaiviet(String idlocation, String title, String brief, String noidung, String img, String img2,
			String img3, String img4) {
		String query = "insert into pbl3.baiviet (idlocation,title,brief,noidung,img,img2,img3,img4) values(?,?,?,?,?,?,?,?) ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, idlocation);
			ps.setString(2, title);
			ps.setString(3, brief);
			ps.setString(4, noidung);
			ps.setString(5, img);
			ps.setString(6, img2);
			ps.setString(7, img3);
			ps.setString(8, img4);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void deleteBaiviet(String qid) {
		String query = "delete from pbl3.baiviet where idbaiviet = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, qid);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void editBaiviet(String idlocation, String title, String brief, String noidung, String img, String img2,
			String img3, String img4, String pid) {
		String query = "update pbl3.baiviet set idlocation = ?, title = ?, brief = ?, noidung = ?, img = ?, img2 = ?, img3 = ?, img4 = ? where idbaiviet = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, idlocation);
			ps.setString(2, title);
			ps.setString(3, brief);
			ps.setString(4, noidung);
			ps.setString(5, img);
			ps.setString(6, img2);
			ps.setString(7, img3);
			ps.setString(8, img4);
			ps.setString(9, pid);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		DAO dao = new DAO();
		int i = 1;
		String s = String.valueOf(i);
		System.out.println(dao.getLocationById(1));
	}

}
