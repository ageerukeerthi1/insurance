package com.cg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtility 
{
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plp_project","SYSTEM","SAIRAM");
			
		}
		catch(SQLException  | ClassNotFoundException e)
		{
			throw new SQLException("Connection error occured");
		}
		return connection;
	}
	
}
