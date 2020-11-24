package com.cg.utility;

public interface JdbcConstants 
{
	/*public String URL="jdbc:mysql://localhost:3306/webapplication";
	public String USERNAME = "SYSTEM";
	public String PASSWORD = "SAIRAM";*/
	
	//LOGIN::
	public String VERIFY_USER_QUERY = "SELECT *FROM userrole WHERE username=? AND password=?";
	
	//PROFILE CREATION
	public String CHECK_USER_QUERY = "SELECT USERNAME FROM userrole WHERE USERNAME=?";
	public String ADD_USER_QUERY = "INSERT INTO userrole VALUES(?,?,?)";
	
	//ACCOUNT CREATION
	public String ACCOUNTS_CHECK_QUERY = "SELECT *FROM accounts WHERE username = ?";
	public String MAX_ACCOUNTNUMBER_QUERY = "SELECT MAX(accountnumber) FROM accounts";
	public String ADD_ACCOUNTDETAILS = "INSERT INTO accounts values(?,?,?,?,?,?,?,?)";
	public String FIND_ACCOUNTNUMBER = "SELECT accountnumber FROM accounts WHERE username = ?";
	
	//POLICY CREATION:::
	public String FIND_BUSINESS_SEGMENT_QUERY="SELECT BUSINESSSEGMENT FROM ACCOUNTS WHERE ACCOUNTNUMBER=? ";
	public String FIND_BUSINESS_SEGMENT_ID_QUERY="SELECT BUS_SEG_ID FROM businesssegment WHERE BUS_SEG_NAME=?";
	public String FIND_QUESTIONS_QUERY="SELECT * FROM POLICYQUESTIONS WHERE BUS_SEG_ID=?";
	
	public String MAX_POLICYNUMBER_QUERY = "SELECT MAX(policynumber) FROM policy";
	public String ADD_POLICY= "INSERT INTO policy VALUES(?,?,?)";
	public String ADD_POLICYDETAILS = "INSERT INTO policydetails VALUES(?,?,?)";
	public String ADD_INSURERDETAILS = "INSERT INTO insurer VALUES(?,?)";
	
	
	//VIEW POLICY
	public String FIND_ALL_POLICIES_OF_ACCOUNT = "SELECT *FROM policy where accountnumber=?";
	public String FIND_POLICY = "SELECT *FROM policy where policynumber=?";
	public String FIND_ALL_POLICIES = "SELECT *FROM policy";
	
	public String FIND_AGENTWISE_POLICIES = "SELECT * FROM policy where policynumber in (SELECT policynumber from insurer where insureruname=?)";
	public String FIND_INSUREDWISE_POLICIES = "SELECT * FROM policy where accountnumber = (SELECT accountnumber from accounts where username=?)";
	
	
	//REPORT GENERATION
	
}
