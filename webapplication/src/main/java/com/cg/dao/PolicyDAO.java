package com.cg.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Policy;
import com.cg.utility.JdbcConstants;
import com.cg.utility.JdbcUtility;

public class PolicyDAO implements IPolicyDAO {

	Connection connection = null;
	Connection connection1 = null;
	PreparedStatement statement=null;
	PreparedStatement statement1=null;
	ResultSet resultset=null;
	ResultSet resultset1=null;

	@Override
	public String findAccount(Long accNum) throws SQLException 
	{
		String seg_name="";
		try {
			connection=JdbcUtility.getConnection();
			statement=connection.prepareStatement(JdbcConstants.FIND_BUSINESS_SEGMENT_QUERY);
			statement.setLong(1, accNum);
			resultset=statement.executeQuery();
			while(resultset.next())
			{
				seg_name=resultset.getString(1);
			}
			
			System.out.println(seg_name);
			
		} catch (SQLException e ) 
		{	
			throw new SQLException("Error in finding businees segment");
		}
		finally
		{
			try
			{
				statement.close();
				resultset.close();
				connection.close();
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		return seg_name;
	
	}

	@Override
	public String findBusinessSegmentId(String busSegName) throws SQLException
	{
		String bus_id="";
		try {
			System.out.println(busSegName);
			connection1=JdbcUtility.getConnection();
			statement1=connection1.prepareStatement(JdbcConstants.FIND_BUSINESS_SEGMENT_ID_QUERY);
		    statement1.setString(1, busSegName);
			resultset1=statement1.executeQuery();
			while(resultset1.next()) {
				bus_id=resultset1.getString(1);
			}
			System.out.println(bus_id);
		} catch (SQLException e) 
		{
			throw new SQLException("Error in finding Business Segment ID");
		}
		return bus_id;
		
	}

	@Override
	public ResultSet findQuestions(String bus_seg_id) throws SQLException 
	{
		try {
			connection=JdbcUtility.getConnection();
			statement=connection.prepareStatement(JdbcConstants.FIND_QUESTIONS_QUERY);
			statement.setString(1, bus_seg_id);
			resultset=statement.executeQuery();
		} 
		catch (SQLException e)
		{
			throw new SQLException("Error in retrieving questions from the database");
		}
		
		return resultset;
	}

	@Override
	public long createPolicy(long accountNumber, String[] questionIds, String[] answers, String insurerName,
			double premium) throws SQLException 
	{
		long policyNumber = 0l;
		
		connection = JdbcUtility.getConnection();
		System.out.println("Insude policy DAO");
		System.out.println("============================================================");
		System.out.println(accountNumber);
		System.out.println("====================================");
		System.out.println(questionIds);
		System.out.println("========================================");
		System.out.println(answers);
		System.out.println("==========================");
		System.out.println(insurerName);
		System.out.println("============================");
		System.out.println(premium);
		System.out.println("==========================================================");
		try 
		{
			statement1 = connection.prepareStatement(JdbcConstants.MAX_POLICYNUMBER_QUERY);
			ResultSet maxPolicy =  statement1.executeQuery();
			while(maxPolicy.next())
			{
				policyNumber = maxPolicy.getLong(1);
			}
			
			System.out.println(policyNumber);
			System.out.println("===============================================");
			
			if(policyNumber==0L)
				policyNumber = 6000000000l;
			
			policyNumber += 1l;
			
			PreparedStatement insertIntoPolicy = connection.prepareStatement(JdbcConstants.ADD_POLICY);
			insertIntoPolicy.setLong(1, policyNumber);
			insertIntoPolicy.setDouble(2, premium);
			insertIntoPolicy.setLong(3, accountNumber);
			insertIntoPolicy.executeUpdate();
			
			PreparedStatement insertIntoPolicyDetails = connection.prepareStatement(JdbcConstants.ADD_POLICYDETAILS);
			
			
			
			for (int i = 0; i < questionIds.length; i++) 
			{
				insertIntoPolicyDetails.setLong(1, policyNumber);
				insertIntoPolicyDetails.setString(2, questionIds[i]);
				insertIntoPolicyDetails.setString(3, answers[i]);
				insertIntoPolicyDetails.executeUpdate();
			}
			
			PreparedStatement insertInsurer = connection.prepareStatement(JdbcConstants.ADD_INSURERDETAILS);
			insertInsurer.setLong(1, policyNumber);
			insertInsurer.setString(2, insurerName);
			insertInsurer.executeUpdate();
			
		} 	
		catch (SQLException e) {
			 throw new SQLException("Error occurred while creating policy");
		}
		
		return policyNumber;
	}

	
	
	
	
	//View Policy
	
	@Override
	public ResultSet viewAllPolicy(long accPolNum) throws SQLException 
	{
		connection1 = JdbcUtility.getConnection();
		char first = (accPolNum+"").charAt(0);
		if(first == '1')
		{
			try 
			{
				statement = connection1.prepareStatement(JdbcConstants.FIND_ALL_POLICIES_OF_ACCOUNT);
				statement.setLong(1, accPolNum);
				resultset = statement.executeQuery();
			}	
			catch (SQLException e) 
			{
				throw new SQLException("Error occured while retrieving policies");
			}	
			return resultset;
		}
		else if(first == '6')
		{
			try 
			{
				statement = connection1.prepareStatement(JdbcConstants.FIND_POLICY);
				statement.setLong(1, accPolNum);
				resultset = statement.executeQuery();
			}	
			catch (SQLException e) 
			{
				throw new SQLException("Error occured while retrieving policies");
			}	
			return resultset;
		}
		else
		{
			try 
			{
				statement = connection1.prepareStatement(JdbcConstants.FIND_ALL_POLICIES);
				resultset = statement.executeQuery();
			}	
			catch (SQLException e) 
			{
				throw new SQLException("Error occured while retrieving policies");
			}	
			return resultset;
		}
	}

	@Override
	public List<Policy> viewAllPolicy(long accPolNum, String insurerName) throws SQLException 
	{
		
		connection = JdbcUtility.getConnection();
		List<Policy> policies = new ArrayList<>();
		try
		{
			statement = connection.prepareStatement(JdbcConstants.FIND_AGENTWISE_POLICIES);
			statement.setString(1, insurerName);
			resultset  = statement.executeQuery();
			
			
			while(resultset.next())
			{
				long polNumber = resultset.getLong(1);
				double premium = resultset.getDouble(2);
				long accNumber = resultset.getLong(3); 
				Policy policy = new Policy(polNumber,accNumber,premium);
				
				policies.add(policy);
			}
			if(accPolNum!=0l)
			{
				List<Policy> filteredList = new ArrayList<>();
				if((accPolNum+"").charAt(0)=='1')
				{
					for(Policy policy : policies)
					{
						if(policy.getAccountNumber() == accPolNum)
						{
							filteredList.add(policy);
						}
					}
				}
				else if((accPolNum+"").charAt(0)=='6')
				{
					for(Policy policy : policies)
					{
						if(policy.getPolicyNumber() == accPolNum)
						{
							filteredList.add(policy);
						}
					}
				}
				return filteredList;
			}
			
		}
		catch (SQLException e) 
		{
			throw new SQLException("Error while retreiving policies");
		}
		
		
		return policies;
	}

	@Override
	public List<Policy> viewAllPolicyOfInsured(long accPolNum, String userName) throws SQLException 
	{
		connection = JdbcUtility.getConnection();
		List<Policy> policies = new ArrayList<>();
		try
		{
			statement = connection.prepareStatement(JdbcConstants.FIND_INSUREDWISE_POLICIES);
			statement.setString(1, userName);
			resultset  = statement.executeQuery();
			
			
			while(resultset.next())
			{
				long polNumber = resultset.getLong(1);
				double premium = resultset.getDouble(2);
				long accNumber = resultset.getLong(3); 
				Policy policy = new Policy(polNumber,accNumber,premium);
				
				policies.add(policy);
			}
			if(accPolNum!=0l)
			{
				List<Policy> filteredList = new ArrayList<>();
				if((accPolNum+"").charAt(0)=='1')
				{
					for(Policy policy : policies)
					{
						if(policy.getAccountNumber() == accPolNum)
						{
							filteredList.add(policy);
						}
					}
				}
				else if((accPolNum+"").charAt(0)=='6')
				{
					for(Policy policy : policies)
					{
						if(policy.getPolicyNumber() == accPolNum)
						{
							filteredList.add(policy);
						}
					}
				}
				return filteredList;
			}
			
		}
		catch (SQLException e) 
		{
			throw new SQLException("Error while retreiving policies");
		}
		
		
		return policies;
	}
    
}
