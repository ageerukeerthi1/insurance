package com.cg.service;

import java.util.List;

import com.cg.dao.IInsuredDAO;
import com.cg.dao.InsuredDAO;
import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public class InsuredService implements IInsuredService {
	IInsuredDAO insuredDao = new InsuredDAO();
	
	public String getLineOfBusinessIdByName(String busSegName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getLineOfBusinessIdByName(busSegName);
	}

	
	
	public boolean isUserExists(String userName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.isUserExists(userName);
	}

	
	public int accountCreation(Accounts account, String userName) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.accountCreation(account, userName);
	}


	
	public boolean accountValidation(String username) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.accountValidation(username);
	}


	
	public int getAccountNumber(String username) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountNumber(username);
	}


	
	public List<Policy> getInsuredPolicies(int accNo) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getInsuredPolicies(accNo);
	}


	
	public Accounts getAccountDetails(int accNo) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountDetails(accNo);
	}


	
	public String getBusSegName(String lineOfBusiness) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getBusSegName(lineOfBusiness);
	}


	
	public Double getPolicyPremium(int polNum) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getPolicyPremium(polNum);
	}


	
	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getPolicyQuestions(lineOfBusiness);
	}


	
	public List<String> getSelectedAnswers(int polNum) throws LoginAndCommonException {
		// TODO Auto-generated method stub
		return insuredDao.getSelectedAnswers(polNum);
	}


	

}
