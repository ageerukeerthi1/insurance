package com.cg.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.dao.ILoginAndCommonDAO;
import com.cg.dao.IPolicyDAO;
import com.cg.dao.IReportGenerationDAO;
import com.cg.dao.IUserRoleDAO;
import com.cg.dao.LoginAndCommonDAO;
import com.cg.dao.PolicyDAO;
import com.cg.dao.ReportGenerationDAO;
import com.cg.dao.UserRoleDAO;

import com.cg.model.Insured;
import com.cg.model.Policy;
import com.cg.model.PolicyDetails;
import com.cg.model.User;

public class InsuranceQuoteGenerationService implements IInsuranceQuoteGenerationService
{
	ILoginAndCommonDAO iLoginAndCommonDAO = new LoginAndCommonDAO();
	IPolicyDAO iPolicyDAO = new PolicyDAO();
	IReportGenerationDAO iReportGenerationDAO = new ReportGenerationDAO();
	IUserRoleDAO iUserRoleDAO = new UserRoleDAO();
	
	public int addUser(User userRole) throws SQLException
	{
		return iUserRoleDAO.addUser(userRole);
	}
	
	public String verifyUser(User userRole) throws SQLException
	{
		return iUserRoleDAO.verifyUser(userRole);
	}
	
	public String accountExists(String userName) throws SQLException
	{
		return iLoginAndCommonDAO.accountExists(userName);
	}
	
	public String accountDetails(Insured insured) throws SQLException
	{
		return iLoginAndCommonDAO.accountDetails(insured);
	}
	
	public String findAccount(Long accNum) throws SQLException
	{
		return iPolicyDAO.findAccount(accNum);
	}
	
	public String findBusinessSegmentId(String bus_seg) throws SQLException
	{
		return iPolicyDAO.findBusinessSegmentId(bus_seg);
	}
	
	public ResultSet findQuestions(String bus_seg_id) throws SQLException
	{
		return iPolicyDAO.findQuestions(bus_seg_id);
	}
	
	public long createPolicy(long accountNumber,String[] questionIds,String[] answers,String insurerName,double premium) throws SQLException
	{
		return iPolicyDAO.createPolicy(accountNumber, questionIds, answers, insurerName, premium);
	}
	
	public ResultSet viewAllPolicy(long accPolNum) throws SQLException
	{
		return iPolicyDAO.viewAllPolicy(accPolNum);
	}
	
	public List<Policy> viewAllPolicy(long accPolNum,String insurerName) throws SQLException
	{
		return iPolicyDAO.viewAllPolicy(accPolNum, insurerName);
	}
	
	public List<Policy> viewAllPolicyOfInsured(long accPolNum,String userName) throws SQLException
	{
		return iPolicyDAO.viewAllPolicyOfInsured(accPolNum, userName);
	}
	
	public PolicyDetails viewDetailedReport(long policyNumber) throws SQLException
	{
		return iReportGenerationDAO.viewDetailedReport(policyNumber);
	}
	
	public String findAccountNumber(String userName) throws SQLException {
		return iLoginAndCommonDAO.findAccountNumber(userName);
	}
	
}
