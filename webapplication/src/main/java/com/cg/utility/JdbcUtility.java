package com.cg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.exceptions.LoginAndCommonException;

import oracle.jdbc.OracleDriver;


public class JdbcUtility 
{
	private static Connection connection = null;

	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static Connection getConnection() throws LoginAndCommonException {
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection(url, "SYSTEM", "SAIRAM");
			System.out.println("Successfully connected to database");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new LoginAndCommonException("Error occurred in connecting to database"+e.getMessage());
		}
		return connection;
	}
}
	
