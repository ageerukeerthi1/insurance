package com.cg.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IInsuredDAO {
	public boolean accountValidation(String username) throws LoginAndCommonException;
	
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws LoginAndCommonException;

	public boolean isUserExists(String userName) throws LoginAndCommonException;
	
	public int accountCreation(Accounts account, String userName) throws LoginAndCommonException;
	
	public List<Policy> getInsuredPolicies(int accNo) throws LoginAndCommonException;
	
	public int getAccountNumber(String username) throws LoginAndCommonException;
	
	public Accounts getAccountDetails(Integer accNo) throws LoginAndCommonException;
	
	public String getBusSegName(String lineOfBusiness) throws LoginAndCommonException;
	
	public Double getPolicyPremium(Integer polNum) throws LoginAndCommonException;
	
	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws LoginAndCommonException;
	
	public List<String> getSelectedAnswers(Integer polNum) throws LoginAndCommonException;

}
