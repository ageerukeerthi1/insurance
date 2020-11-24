package com.cg.dao;

public interface AgentQuery {
	String AGENT_VERIFY_USER="SELECT ROLECODE FROM USERROLE WHERE USERNAME=?";
	 
	 String USER_EXISTS_IN_ACCOUNT = "select username from accounts where username = ?";
	 
	 String ACCOUNT_CREATION = "insert into accounts values(?,?,?,?,?,?,?,?)";
	 
	 String VALIDATE_ACCOUNT_QUERY ="select * from accounts where username = ?";
	 
	 String GET_LOB_NAME = "select bus_seg_id from businesssegment where bus_seg_name = ?";
		
	 String AGENT_VERIFY_ACCOUNT="SELECT BUSINESSSEGMENTID FROM ACCOUNTS WHERE ACCOUNTNUMBER=?";
	 
	 //String AGENT_POLICY_QUESTIONS="SELECT * FROM POLICYQUESTIONS WHERE BUS_SEG_ID=?";
	 
	 String INSERT_POLICY="INSERT INTO POLICY VALUES(policyNumberSeq.nextval,?,?)";
	 
	 String INSERT_POLICYDETAILS="INSERT INTO POLICYDETAILS VALUES((SELECT MAX(POLICYNUMBER) FROM POLICY),?,?)";
	 
	 String INSERT_POLICYCREATOR="INSERT INTO POLICYCREATOR VALUES((SELECT MAX(POLICYNUMBER) FROM POLICY),?)";

	String VALIDATE_ACCOUNT = "select * from accounts where accountnumber = ?";

	String GET_BUS_SEG_ID = "select businesssegmentid from accounts where accountnumber = ?";

	String GET_POLICY_QUESTIONS = "select * from policyquestions where bus_seg_id = ?";

	String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? between pre_ans_weightage_min and pre_ans_weightage_max";

	String CREATE_POLICY = "insert into policy values(policy_number.nextval, ?, ?)";
	 
	String GET_POLICY_NUMBER = "select max(policynumber) from policy";
	
	String ADD_POLICY_DETAILS = "insert into policydetails values(?,?,?)";

	String GET_POLICIES = "select * from policy";

	String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
	
   String GET_BUS_SEG_NAME = "select bus_seg_name from businesssegment where bus_seg_id = ?";
	
	String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
	
	String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
	
	String ADD_POLICY_CREATOR = "insert into policycreator values(?,?)";
	
	String VIEW_POLICY="SELECT  * FROM POLICY WHERE POLICYNUMBER IN (SELECT POLICYNUMBER FROM POLICYCREATOR WHERE USERNAME=?)";

}

