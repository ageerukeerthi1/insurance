package com.cg.dao;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.model.Insured;

import com.cg.utility.JdbcConstants;
import com.cg.utility.JdbcUtility;
import com.cg.utility.LoggerUtility;

public class LoginAndCommonDAO implements ILoginAndCommonDAO 
{
	Connection connection = null;
	PreparedStatement statement = null;
	//Logger logger = null;
	
	public String accountDetails(Insured insured) throws SQLException 
	{
		int res = 0;
		Long accountNum = new Long(0l);
		//logger = LoggerUtility.getLogger();
		try {
			connection = JdbcUtility.getConnection();
			
			statement = connection.prepareStatement(JdbcConstants.ACCOUNTS_CHECK_QUERY);
			statement.setString(1, insured.getUserName());
			
			ResultSet exists = statement.executeQuery();
			if(exists.next())
			{
				//logger.info("Account already exists");
				System.out.println("Account already exists");
				return "0";
			}
			else
			{
			
			statement = connection.prepareStatement(JdbcConstants.MAX_ACCOUNTNUMBER_QUERY);
			ResultSet result = statement.executeQuery();
			
			
			while(result.next()) 
			{
				accountNum = result.getLong(1);
				System.out.println("max accountnumber "+accountNum);
			}
			
			if(accountNum==0l)
				accountNum=1000000000l;
			
			accountNum++;
			
			statement = connection.prepareStatement(JdbcConstants.ADD_ACCOUNTDETAILS);
			statement.setLong(1, accountNum);
			statement.setString(2, insured.getInsuredName());
			statement.setString(3, insured.getStreet());
			statement.setString(4, insured.getCity());
			statement.setString(5, insured.getState());
			statement.setInt(6, insured.getZip());
			statement.setString(7, insured.getBusinessSegment());
			statement.setString(8, insured.getUserName());
			res = statement.executeUpdate();
			
			//logger.info("Account created with account number "+accountNum);
			System.out.println("Account created with account number "+accountNum);
			}
		} 
		catch (SQLException e) 
		{
			
			//logger.error(e.getMessage());
			e.printStackTrace();
			throw new SQLException("Cannot execute Query");
		} 
		finally 
		{
			try 
			{
				statement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				//logger.error(e.getMessage());
				e.printStackTrace();
				throw new SQLException("Cannot close DB Resources");
			}
		}
		return accountNum+"";
	}
	
	
	public String accountExists(String userName) throws SQLException
	{
		connection = JdbcUtility.getConnection();
		try 
		{
			statement = connection.prepareStatement(JdbcConstants.ACCOUNTS_CHECK_QUERY);
			statement.setString(1, userName);
		
			ResultSet exists = statement.executeQuery();
			if(exists.next())
			{
				return "Yes";
			}
				return "No";
		}
		catch(SQLException e)
		{
//			logger.error(e.getMessage());
			e.printStackTrace();
			throw new SQLException("Cannot fetch account number");
		}
		
	}


	@Override
	public String findAccountNumber(String userName) throws SQLException {
		connection = JdbcUtility.getConnection();
		try 
		{
			statement = connection.prepareStatement(JdbcConstants.FIND_ACCOUNTNUMBER);
			statement.setString(1, userName);
		
			ResultSet exists = statement.executeQuery();
			if(exists.next())
			{
				return exists.getString(1);
			}
			return null;
		}
		catch(SQLException e)
		{
			throw new SQLException("Cannot fetch account number");
		}
	}
}
