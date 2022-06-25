package ConnectSQL;

import java.sql.*;

import DAO.DBConnect;

public class BaivietConnect {
	 private static BaivietConnect instance;
	    
	    public static BaivietConnect getInstance() {
			if (instance == null) {
				instance = new BaivietConnect();
			}
			return instance;
		} 
	    
    public static Connection getConnect() {
    	final String url = "jdbc:mysql://localhost:3306/post";
    	final String user = "root";
    	final String password = "2001";
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    	
    }
    
   
    public ResultSet getResult(String sql) {
    	try {
			Statement stm = getConnect().createStatement();
			return stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
      public static void main(String[] args) {
   	Connection connect = getConnect();
   	if (connect != null) {
    		System.out.println("Thanh cong");}
   		else {
   			System.out.println("Khong thanh cong");
    		}
   	
    }
}
