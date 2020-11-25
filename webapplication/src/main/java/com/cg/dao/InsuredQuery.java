package com.cg.dao;

public interface InsuredQuery {
	String ACCOUNT_CREATION = "insert into accounts values(?,?,?,?,?,?,?,?)";
	
	String VALIDATE_ACCOUNT_QUERY ="select * from accounts where username = ?";

	String GET_INSURED_POLICY = "select * from policy where accountnumber = ? ";
	
	String GET_LOB_NAME = "select bus_seg_id from businesssegment where bus_seg_name = ?";
	
	String USER_EXISTS = "select * from userrole where username = ?";
	
	String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
	
	String GET_ACCOUNT_NUMBER = "select accountnumber from accounts where username = ? ";
	
	String GET_BUS_SEG_NAME = "select bus_seg_name from businesssegment where bus_seg_id = ?";
	
	String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
	
	String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
}
