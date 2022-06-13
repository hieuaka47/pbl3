package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static DBConnect instance;
	
	public static DBConnect getInstance() {
		if (instance == null) {
			instance = new DBConnect();
		}
		return instance;
	} 

	public Connection getConnection() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cons = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pbl3", "root", "12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cons;
	}

}
