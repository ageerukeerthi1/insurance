package com.cg.service;

import java.util.List;

import com.cg.dao.AgentDAO;
import com.cg.dao.IAgentDAO;
import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public class AgentService implements IAgentService {

	IAgentDAO agentDao = new AgentDAO();
	
	public String getLineOfBusinessIdByName(String busSegName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getLineOfBusinessIdByName(busSegName);
	}

	
	public boolean isUserExists(String userName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.isUserExists(userName);
	}

	
	public int accountCreation(Accounts account, String userName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.accountCreation(account, userName);
	}

	
	public boolean accountValidation(String userName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.accountValidation(userName);
	}

	
	public boolean isAccountExists(int accNumber) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.isAccountExists(accNumber);
	}

	
	public String getBusSegId(int accNumber) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegId(accNumber);
	}

	
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyQuestions(busSegId);
	}

	
	public int getPolicyPremiumAmount(int sumOfWeightages) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremiumAmount(sumOfWeightages);
	}

	
	public int createPolicy(Policy policy) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.createPolicy(policy);
	}

	
	public int getPolicyNumber() throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyNumber();
	}

	
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		agentDao.addPolicyDetails(polNumber,questionIds,selectedAnswers);
	}

	
	public List<Policy> getPolicies(String username) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		
		return agentDao.getPolicies(username);
	}

	
	public Accounts getAccountDetails(int accNumber) throws LoginAndCommonException {
		
		return agentDao.getAccountDetails(accNumber);
	}

	
	public String getBusSegName(String lineOfBusiness) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegName(lineOfBusiness);
	}

	
	public Double getPolicyPremium(int polNum) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremium(polNum);
	}

	
	public List<String> getSelectedAnswers(int polNum) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return agentDao.getSelectedAnswers(polNum);
	}

	
	public void addPolicyCreator(int polNumber, String username) throws LoginAndCommonException {
		// TODO Auto-generated method stub
	     agentDao.addPolicyCreator(polNumber,username);
	}

}