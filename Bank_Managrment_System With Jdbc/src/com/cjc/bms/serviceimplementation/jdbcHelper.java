package com.cjc.bms.serviceimplementation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class jdbcHelper {
	private static Connection con;
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String Url = "jdbc:mysql://localhost:3306/Bank";
	private static final String username = "root";
	private static final String password = "root";
	
	public static  Connection getData()
	{
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(Url, username, password);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con; 
	}

}
