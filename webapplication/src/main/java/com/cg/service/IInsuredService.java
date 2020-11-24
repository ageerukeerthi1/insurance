package com.cg.service;

import java.util.List;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IInsuredService {
	public String getLineOfBusinessIdByName(String busSegName) throws LoginAndCommonException;

	boolean isUserExists(String userName) throws LoginAndCommonException;

	int accountCreation(Accounts account, String userName) throws LoginAndCommonException;

	public boolean accountValidation(String username) throws LoginAndCommonException;

	public int getAccountNumber(String username) throws LoginAndCommonException;

	public List<Policy> getInsuredPolicies(int accNo) throws LoginAndCommonException;

	public Accounts getAccountDetails(int accNo) throws LoginAndCommonException;

	public String getBusSegName(String lineOfBusiness) throws LoginAndCommonException;

	public Double getPolicyPremium(int polNum) throws LoginAndCommonException;

	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws LoginAndCommonException;

	public List<String> getSelectedAnswers(int polNum) throws LoginAndCommonException;

}
