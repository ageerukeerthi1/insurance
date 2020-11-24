package com.cg.service;

import java.util.List;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IAgentService {
	public String getLineOfBusinessIdByName(String busSegName) throws LoginAndCommonException;

	public boolean isUserExists(String userName) throws LoginAndCommonException;

	public int accountCreation(Accounts account, String userName) throws LoginAndCommonException;

	public boolean accountValidation(String userName) throws LoginAndCommonException;

	public boolean isAccountExists(int accNumber) throws LoginAndCommonException;

	public String getBusSegId(int accNumber) throws LoginAndCommonException;

	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws LoginAndCommonException;

	public int getPolicyPremiumAmount(int sumOfWeightages) throws LoginAndCommonException;

	public int createPolicy(Policy policy) throws LoginAndCommonException;

	public int getPolicyNumber() throws LoginAndCommonException;

	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws LoginAndCommonException;


	public Accounts getAccountDetails(int accNumber) throws LoginAndCommonException;

	public String getBusSegName(String lineOfBusiness) throws LoginAndCommonException;

	public Double getPolicyPremium(int polNum) throws LoginAndCommonException;
	
	public List<String> getSelectedAnswers(int polNum) throws LoginAndCommonException;

	public void addPolicyCreator(int polNumber, String username) throws LoginAndCommonException;
	
	public List<Policy> getPolicies(String username) throws LoginAndCommonException;
}
