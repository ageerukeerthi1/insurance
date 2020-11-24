package com.cg.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.model.Insured;
import com.cg.model.Policy;
import com.cg.model.PolicyDetails;
import com.cg.model.User;

public interface IInsuranceQuoteGenerationService
{
	public int addUser(User userRole) throws SQLException;
	public String verifyUser(User userRole) throws SQLException;
	public String accountExists(String userName) throws SQLException;
	public String accountDetails(Insured insured) throws SQLException;
	public String findAccount(Long accNum) throws SQLException;
	public String findBusinessSegmentId(String bus_seg) throws SQLException;
	public ResultSet findQuestions(String bus_seg_id) throws SQLException;
	public long createPolicy(long accountNumber,String[] questionIds,String[] answers,String insurerName,double premium) throws SQLException;
	public ResultSet viewAllPolicy(long accPolNum) throws SQLException;
	public List<Policy> viewAllPolicy(long accPolNum,String insurerName) throws SQLException;
	public List<Policy> viewAllPolicyOfInsured(long accPolNum,String userName) throws SQLException;
	public PolicyDetails viewDetailedReport(long policyNumber) throws SQLException;
	public String findAccountNumber(String userName) throws SQLException;
}
