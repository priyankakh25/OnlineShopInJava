package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtiil {
	private static Connection conn=null;
	
	public static Connection getConnection() {
		if(conn ==  null) {
			try {
				DriverManager.registerDriver(new Driver());
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myshopDB","root","root");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConection() {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
