package com.springhb.crms.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = "springstudent", pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		Connection conn = null;
		
		try {
					
			Class.forName(jdbcDriver);
			
			conn = DriverManager.getConnection(jdbcUrl, username, pass);
			
			PrintWriter writer1 = response.getWriter();
			
			writer1.println("[ CONNECTED ]");
			
		} catch (Exception e) {
			
			PrintWriter writer2 = response.getWriter();
			
			writer2.println(e.getMessage());
		
		} finally {
			
			try {
				
				if (conn != null) conn.close();
			
			} catch (SQLException e) {
				
				PrintWriter writer3 = response.getWriter();
				
				writer3.println(e.getMessage());
			}
		}
	}

}
