package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Policy;
import com.cg.model.PolicyDetails;
import com.cg.utility.JdbcUtility;

public class ReportGenerationDAO implements IReportGenerationDAO 
{
	
	Connection connection;
	PreparedStatement statement;
	
	@Override
	public PolicyDetails viewDetailedReport(long policyNumber) throws SQLException 
	{
		PolicyDetails policyDetails = null;
		Policy policy = null;
		connection = JdbcUtility.getConnection();
		try 
		{
			statement = connection.prepareStatement("SELECT *FROM policy WHERE policynumber=?");
			statement.setLong(1, policyNumber);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				long polNumber = resultSet.getLong(1);
				double polPremium = resultSet.getDouble(2);
				long accountNumber = resultSet.getLong(3);
				
				policy = new Policy(polNumber, accountNumber, polPremium);
			}
			
			if(policy!=null)
			{
				statement = connection.prepareStatement("SELECT *FROM policydetails WHERE policynumber=?");
				statement.setLong(1, policyNumber);
				ResultSet polDetailsSet = statement.executeQuery();
				List<String> questionIds = new ArrayList<>();
				List<String> answers = new ArrayList<>();
				while(polDetailsSet.next())
				{
					questionIds.add(polDetailsSet.getString(2));
					answers.add(polDetailsSet.getString(3));
				}
				
				String businessId="";
				
				List<String> questionDescriptions = new ArrayList<>();
				
				statement = connection.prepareStatement("SELECT bus_seg_id, pol_ques_desc from policyquestions WHERE pol_ques_id=?");
				for (int i = 0; i < questionIds.size(); i++) 
				{
					statement.setString(1, questionIds.get(i));
					ResultSet questions = statement.executeQuery();
					while(questions.next())
					{
						businessId = questions.getString(1);
						questionDescriptions.add(questions.getString(2));
					}
				}
				
				String businessSegment = "";
				
				/*statement = connection.prepareStatement("SELECT bus_seg_name FROM businesssegment where bus_seg_id = ?");
				statement.setString(1, businessId);
				ResultSet busiName = statement.executeQuery();
				while(busiName.next())
				{
					businessSegment = busiName.getString(1);
				}
				*/
				String insuredName = "",insuredStreet="",insuredCity="",insuredState="";
				int insuredZip = 0;
				
				statement = connection.prepareStatement("SELECT *FROM accounts WHERE accountnumber = ?");
				statement.setLong(1, policy.getAccountNumber());
				ResultSet accDetails = statement.executeQuery();
				while(accDetails.next())
				{
					insuredName = accDetails.getString(2);
					insuredStreet = accDetails.getString(3);
					insuredCity = accDetails.getString(4);
					insuredState = accDetails.getString(5);
					insuredZip = accDetails.getInt(6);
					businessSegment = accDetails.getString(7);
				}
				
				policyDetails = new PolicyDetails(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, businessSegment, questionDescriptions, answers, policy);
			}
		} 
		catch (SQLException e) 
		{
			throw new SQLException("Error while creating report");
		}
		
		
		return policyDetails;
	}
	
}
