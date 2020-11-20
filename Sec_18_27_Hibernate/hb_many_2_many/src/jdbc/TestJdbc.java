package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_many_to_many?useSSL=false";
		
		String user = "hbstudent";
		
		String pass = "hbstudent";
		
		try {
			
			System.out.println("\nconnecting to database: " + jdbcUrl);
			
			@SuppressWarnings("unused")
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("\nconnection successful");
		
		} catch (Exception e) {e.printStackTrace();}
	}

}
