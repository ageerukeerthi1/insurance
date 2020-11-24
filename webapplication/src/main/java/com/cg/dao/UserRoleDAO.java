package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.model.User;
import com.cg.utility.JdbcConstants;
import com.cg.utility.JdbcUtility;

public class UserRoleDAO implements IUserRoleDAO 
{
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	@Override
	public String verifyUser(User userRole) throws SQLException 
	{
		String roleCode="";
		
		try
		{
			connection = JdbcUtility.getConnection();
			statement = connection.prepareStatement(JdbcConstants.VERIFY_USER_QUERY);
			statement.setString(1, userRole.getUsername());
			statement.setString(2, userRole.getPassword());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				roleCode = resultSet.getString(3);
			}
		}
		catch (SQLException e) 
		{
			throw new SQLException("Problem occured while executing statement");
		}
		finally {
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException e) 
			{
				throw new SQLException("Problem occured while closing statement");
			}
		}
		return roleCode;
	}
	
	public int addUser(User user) throws SQLException {
		int res = 0;
		try {
			connection = JdbcUtility.getConnection();
			PreparedStatement checkStatement = connection.prepareStatement(JdbcConstants.CHECK_USER_QUERY);
			checkStatement.setString(1, user.getUsername());
			ResultSet resultSet = checkStatement.executeQuery();
			
			System.out.println(resultSet);
			int indication = 0;
			while(resultSet.next())
			{
				String s = resultSet.getString("username");
				System.out.println(s+","+user.getUsername());
				if(user.getUsername().equals(s))
					indication = 1;
			}
			if(indication != 1) {
				statement = connection.prepareStatement(JdbcConstants.ADD_USER_QUERY);
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getRoleCode());
				res = statement.executeUpdate();
			}
		}
		catch (SQLException e) 
		{
			throw new SQLException("Problem occured while executing query");
		} 
		finally
		{
			try {
				if(statement!=null)
				statement.close();
				if(connection!=null)
				connection.close();
			} 
			catch (SQLException e) 
			{
				throw new SQLException("Problem while closing");
			}

		}
		return res;

	}

}
