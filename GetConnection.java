package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	private static Connection con;
	
	public static Connection getConnection() {

    	try {
    		if(con==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/details";
			String username = "root";
			String passward = "111075";
	
			con = DriverManager.getConnection(url,username,passward);
    	}
	}
    	catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
