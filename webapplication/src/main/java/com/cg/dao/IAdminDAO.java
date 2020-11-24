package com.cg.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;

public interface IAdminDAO {
	public boolean loginValidation(String userName, String password) throws  LoginAndCommonException;
	
	public String getRoleCode(String userName, String password) throws LoginAndCommonException;
	
	public int addUser(UserRole userRole) throws LoginAndCommonException;
	
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws LoginAndCommonException;

	public boolean isUserExists(String userName) throws LoginAndCommonException;
	
	public int accountCreation(Accounts account, String userName) throws LoginAndCommonException;

	
	public String getBusSegId(int accNumber) throws LoginAndCommonException;
	
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws LoginAndCommonException;
	
	public Integer createPolicy(Policy policy) throws LoginAndCommonException;
	
	public Integer getPolicyNumber() throws LoginAndCommonException;
	
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws LoginAndCommonException;
	
	public List<Policy> getPolicies() throws LoginAndCommonException;
	
	public Accounts getAccountDetails(Integer accNumber) throws LoginAndCommonException;
	
	public String getBusSegName(String busSegId) throws LoginAndCommonException;

	public Double getPolicyPremium(Integer polNum) throws LoginAndCommonException;

	public List<String> getSelectedAnswers(int polNum) throws LoginAndCommonException;

	public Integer getPolicyPremiumAmount(Integer sumOfWeightages) throws LoginAndCommonException;

}

