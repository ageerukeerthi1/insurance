package com.cg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.model.Policy;

public interface IPolicyDAO 
{
	//Generate and Creation of Policy
	public String findAccount(Long accNum) throws SQLException;
	public String findBusinessSegmentId(String bus_seg) throws SQLException;
	public ResultSet findQuestions(String bus_seg_id) throws SQLException;
	public long createPolicy(long accountNumber,String[] questionIds,String[] answers,String insurerName,double premium) throws SQLException;
	
	
	//View Policy
	public ResultSet viewAllPolicy(long accPolNum) throws SQLException;
	public List<Policy> viewAllPolicy(long accPolNum,String insurerName) throws SQLException;
	public List<Policy> viewAllPolicyOfInsured(long accPolNum,String userName) throws SQLException;
}
